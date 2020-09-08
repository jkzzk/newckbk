package com.imust.newckbk.utils;

import java.math.BigDecimal;

public class NumberToCNUtil {

    /**
     * ���������ִ�д
     */
    private static final String[] CN_UPPER_NUMBER = {
        "��", "Ҽ", "��", "��", "��", "��", "½", "��", "��", "��"
    };

    /**
     * �����л��ҵ�λ��д�����������������ռλ��
     */
    private static final String[] CN_UPPER_MONETRAY_UNIT = {
        "��", "��", "Ԫ", "ʰ", "��", "Ǫ", "��", "ʰ", "��", "Ǫ", "��", "ʰ", "��", "Ǫ", "��", "ʰ", "��", "Ǫ"
    };

    /**
     * �����ַ�����
     */
    private static final String CN_FULL = "��";

    /**
     * �����ַ�����
     */
    private static final String CN_NEGATIVE = "��";

    /**
     * ���ľ��ȣ�Ĭ��ֵΪ2
     */
    private static final int MONEY_PRECISION = 2;

    /**
     * �����ַ�����Ԫ��
     */
    private static final String CN_ZEOR_FULL = "��Ԫ" + CN_FULL;

    public static void main(String[] args) {
        double     money         = 911111111.01d;
        BigDecimal numberOfMoney = new BigDecimal(money);
        String     s             = NumberToCNUtil.number2CNMontrayUnit(numberOfMoney);

        System.out.println("������Ľ��Ϊ����" + money + "��   #--# [" + s + "]");
    }

    /**
     * ������Ľ��ת��Ϊ����������ҵĴ�д
     *
     * @param numberOfMoney ����Ľ��
     * @return ��Ӧ�ĺ����д
     */
    public static String number2CNMontrayUnit(BigDecimal numberOfMoney) {
        StringBuffer sb = new StringBuffer();

        // -1, 0, or 1 as the value of this BigDecimal is negative, zero, or
        // positive.
        int signum = numberOfMoney.signum();

        // ��Ԫ�������
        if (signum == 0) {
            return CN_ZEOR_FULL;
        }

        // �������н�����������
        long number = numberOfMoney.movePointRight(MONEY_PRECISION).setScale(0, 4).abs().longValue();

        // �õ�С�������λֵ
        long    scale    = number % 100;
        int     numUnit  = 0;
        int     numIndex = 0;
        boolean getZero  = false;

        // �ж������λ����һ�������������00 = 0, 01 = 1, 10, 11
        if (!(scale > 0)) {
            numIndex = 2;
            number   = number / 100;
            getZero  = true;
        }

        if ((scale > 0) && (!(scale % 10 > 0))) {
            numIndex = 1;
            number   = number / 10;
            getZero  = true;
        }

        int zeroSize = 0;

        while (true) {
            if (number <= 0) {
                break;
            }

            // ÿ�λ�ȡ�����һ����
            numUnit = (int) (number % 10);

            if (numUnit > 0) {
                if ((numIndex == 9) && (zeroSize >= 3)) {
                    sb.insert(0, CN_UPPER_MONETRAY_UNIT[6]);
                }

                if ((numIndex == 13) && (zeroSize >= 3)) {
                    sb.insert(0, CN_UPPER_MONETRAY_UNIT[10]);
                }

                sb.insert(0, CN_UPPER_MONETRAY_UNIT[numIndex]);
                sb.insert(0, CN_UPPER_NUMBER[numUnit]);
                getZero  = false;
                zeroSize = 0;
            } else {
                ++zeroSize;

                if (!(getZero)) {
                    sb.insert(0, CN_UPPER_NUMBER[numUnit]);
                }

                if (numIndex == 2) {
                    if (number > 0) {
                        sb.insert(0, CN_UPPER_MONETRAY_UNIT[numIndex]);
                    }
                } else if (((numIndex - 2) % 4 == 0) && (number % 1000 > 0)) {
                    sb.insert(0, CN_UPPER_MONETRAY_UNIT[numIndex]);
                }

                getZero = true;
            }

            // ��numberÿ�ζ�ȥ�����һ����
            number = number / 10;
            ++numIndex;
        }

        // ���signum == -1����˵�����������Ϊ������������ǰ��׷�������ַ�����
        if (signum == -1) {
            sb.insert(0, CN_NEGATIVE);
        }

        // ���������С�������λΪ"00"���������Ҫ�����׷�������ַ�����
        if (!(scale > 0)) {
            sb.append(CN_FULL);
        }

        String       tt = sb.toString();
        StringBuffer tb = new StringBuffer();

        for (int i = 0; i < tt.length(); i++) {
            tb.append(tt.charAt(i));
        }

        return tb.toString();
    }
}



