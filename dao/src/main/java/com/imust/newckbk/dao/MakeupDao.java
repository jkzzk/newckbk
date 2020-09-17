package com.imust.newckbk.dao;

import com.imust.newckbk.domain.Bkkcxxb;
import com.imust.newckbk.domain.Makeup;
import com.imust.newckbk.base.BaseDao;
import com.imust.newckbk.domain.excel.MakeUPExcel;
import com.imust.newckbk.domain.ext.BkkcxxbExt;
import com.imust.newckbk.domain.ext.MakeupExt;
import com.imust.newckbk.domain.report.MakeUpReportList;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;


/**
* @date 2020-05-06
* @author zzk
* 
*/
public interface MakeupDao extends BaseDao<Makeup, String>{

    /**
     * ��ѯѧ�������γ�
     * @param xh
     * @return
     */
    List<Makeup> getMakeupCourse(@Param("xh") String xh,@Param("zxjxjhh") String zxjxjhh,@Param("bkfs") Byte bkfs);

    /**
     * ��ѯ���������γ�
     *
     * @param xh
     * @param zxjxjhh
     * @return
     */
    List<MakeupExt> getByExt(@Param("xh") String xh, @Param("zxjxjhh") String zxjxjhh);

    /**
     * ���¿γ�Ϊ����
     *
     * @param ids
     * @param makeupFlag
     * @return
     */
    int updateMakeUPByIdArr(@Param("ids") String[] ids,@Param("makeupFlag") byte makeupFlag);

    /**
     * ��̨��ҳ��ѯ
     *
     * @param data
     * @return
     */
    List<MakeupExt> getExtByPage(Map data);

    /**
     * ����ɾ��
     *
     * @param ids
     * @return
     */
    int deleteByIdArr(String[] ids);

    /**
     * ��ȡexcel��������
     *
     * @param zxjxjhh
     * @return
     */
    List<MakeUPExcel> getMakeupExcle(@Param("zxjxjhh") String zxjxjhh);

    /**
     * ��ȡ����γ�
     *
     * @param xh
     * @return
     */
    List<MakeUpReportList> getMakeupReportList(String xh);

    /**
     * ���½ɷ�����
     *
     * @param ids
     * @param payFlag
     * @return
     */
    int updatePayByIdArr(@Param("ids") String[] ids,@Param("payFlag") byte payFlag);

    /**
     * 获取额外的补考课程
     *
     * @param xh
     * @return
     */
    List<BkkcxxbExt> getExtraCourse(@Param("xh") String xh);

    /**
     * 存根课程列表获取
     *
     * @param xh
     * @return
     */
    List<MakeUpReportList> getMakeupReportSaveList(String xh);

    /**
     * 查询未插入补考表数据
     *
     * @param xh
     * @param bkfs
     * @return
     */
    List<MakeupExt> getNoInsertData(@Param("xh") String xh, @Param("bkfs") Byte bkfs);

    /**
     * 删除全部数据
     *
     * @return
     */
    int deleteAll();
}