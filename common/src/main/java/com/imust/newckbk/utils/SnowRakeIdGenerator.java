package com.imust.newckbk.utils;

/**
 * @author Twitter
 * Twitter_Snowflake<br>
 * SnowFlake�Ľṹ����(ÿ������-�ֿ�):<br>
 * 0 - 0000000000 0000000000 0000000000 0000000000 0 - 00000 - 00000 - 000000000000 <br>
 * 1λ��ʶ������long����������Java���Ǵ����ŵģ����λ�Ƿ���λ��������0��������1������idһ�������������λ��0<br>
 * 41λʱ���(���뼶)��ע�⣬41λʱ��ز��Ǵ洢��ǰʱ���ʱ��أ����Ǵ洢ʱ��صĲ�ֵ����ǰʱ��� - ��ʼʱ���)
 * �õ���ֵ��������ĵĿ�ʼʱ��أ�һ�������ǵ�id��������ʼʹ�õ�ʱ�䣬�����ǳ�����ָ���ģ������������IdWorker���startTime���ԣ���41λ��ʱ��أ�����ʹ��69�꣬��T = (1L << 41) / (1000L * 60 * 60 * 24 * 365) = 69<br>
 * 10λ�����ݻ���λ�����Բ�����1024���ڵ㣬����5λdatacenterId��5λworkerId<br>
 * 12λ���У������ڵļ�����12λ�ļ���˳���֧��ÿ���ڵ�ÿ����(ͬһ������ͬһʱ���)����4096��ID���<br>
 * �������պ�64λ��Ϊһ��Long�͡�<br>
 * SnowFlake���ŵ��ǣ������ϰ���ʱ���������򣬲��������ֲ�ʽϵͳ�ڲ������ID��ײ(����������ID�ͻ���ID������)������Ч�ʽϸߣ������ԣ�SnowFlakeÿ���ܹ�����26��ID���ҡ�
 */
public class SnowRakeIdGenerator {

    // ==============================Fields===========================================

    /** ��ʼʱ��� (2019-03-29) */
    private final long startTime = 1553863849495L;

    /** ����id��ռ��λ�� */
    private final long workerIdBits = 5L;

    /** ���ݱ�ʶid��ռ��λ�� */
    private final long dataCenterIdBits = 5L;

    /** ֧�ֵ�������id�������31 (�����λ�㷨���Ժܿ�ļ������λ�����������ܱ�ʾ�����ʮ������) */
    private final long maxWorkerId = -1L ^ (-1L << workerIdBits);

    /** ֧�ֵ�������ݱ�ʶid�������31 */
    private final long maxDataCenterId = -1L ^ (-1L << dataCenterIdBits);

    /** ������id��ռ��λ�� */
    private final long sequenceBits = 12L;

    /** ����ID������12λ */
    private final long workerIdShift = sequenceBits;

    /** ���ݱ�ʶid������17λ(12+5) */
    private final long dataCenterIdShift = sequenceBits + workerIdBits;

    /** ʱ���������22λ(5+5+12) */
    private final long timestampLeftShift = sequenceBits + workerIdBits + dataCenterIdBits;

    /** �������е����룬����Ϊ4095 (0b111111111111=0xfff=4095) */
    private final long sequenceMask = -1L ^ (-1L << sequenceBits);

    /** ����������(0~4095) */
    private long sequence = 0L;

    /** �ϴ�����ID��ʱ��� */
    private long lastTimestamp = -1L;

    /** ��������ID(0~31) */
    private long workerId;

    /** ��������ID(0~31) */
    private long dataCenterId;

    // ==============================Constructors=====================================

    /**
     * ���캯��
     * @param workerId ����ID (0~31)
     * @param dataCenterId ��������ID (0~31)
     */
    public SnowRakeIdGenerator(long workerId, long dataCenterId) {
        if ((workerId > maxWorkerId) || (workerId < 0)) {
            throw new IllegalArgumentException(String.format("worker Id can't be greater than %d or less than 0",
                                                             maxWorkerId));
        }

        if ((dataCenterId > maxDataCenterId) || (dataCenterId < 0)) {
            throw new IllegalArgumentException(String.format("datacenter Id can't be greater than %d or less than 0",
                                                             maxDataCenterId));
        }

        this.workerId     = workerId;
        this.dataCenterId = dataCenterId;
    }

    // ==============================Test=============================================

    /** ���� */
    public static void main(String[] args) {
        SnowRakeIdGenerator idWorker = new SnowRakeIdGenerator(0, 0);

        for (int i = 0; i < 15; i++) {
            long id = idWorker.nextId();

            System.out.println(Long.toBinaryString(id));
            System.out.println(id);
        }
    }

    // ==============================Methods==========================================

    /**
     * �����һ��ID (�÷������̰߳�ȫ��)
     * @return SnowflakeId
     */
    public synchronized Long nextId() {
        long timestamp = timeGen();

        // �����ǰʱ��С����һ��ID���ɵ�ʱ�����˵��ϵͳʱ�ӻ��˹����ʱ��Ӧ���׳��쳣
        if (timestamp < lastTimestamp) {
            throw new RuntimeException(
                String.format("Clock moved backwards.  Refusing to generate id for %d milliseconds",
                              lastTimestamp - timestamp));
        }

        // �����ͬһʱ�����ɵģ�����к���������
        if (lastTimestamp == timestamp) {
            sequence = (sequence + 1) & sequenceMask;

            // �������������
            if (sequence == 0) {

                // ��������һ������,����µ�ʱ���
                timestamp = tilNextMillis(lastTimestamp);
            }
        }

        // ʱ����ı䣬��������������
        else {
            sequence = 0L;
        }

        // �ϴ�����ID��ʱ���
        lastTimestamp = timestamp;

        // ��λ��ͨ��������ƴ��һ�����64λ��ID
        return ((timestamp - startTime) << timestampLeftShift) | (dataCenterId << dataCenterIdShift)
               | (workerId << workerIdShift) | sequence;
    }

    /**
     * ��������һ�����룬ֱ������µ�ʱ���
     * @param lastTimestamp �ϴ�����ID��ʱ���
     * @return ��ǰʱ���
     */
    protected long tilNextMillis(long lastTimestamp) {
        long timestamp = timeGen();

        while (timestamp <= lastTimestamp) {
            timestamp = timeGen();
        }

        return timestamp;
    }

    /**
     * �����Ժ���Ϊ��λ�ĵ�ǰʱ��
     * @return ��ǰʱ��(����)
     */
    protected long timeGen() {
        return System.currentTimeMillis();
    }
}



