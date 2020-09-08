package com.imust.newckbk.dao;

import com.imust.newckbk.domain.Zyfxb;
import com.imust.newckbk.base.BaseDao;
import com.imust.newckbk.domain.Zyfxxxb;
import com.imust.newckbk.domain.excel.ZyfxbExcel;
import com.imust.newckbk.domain.report.ZyfxbReportExt;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;


/**
* @date 2020-08-23
* @author zzk
* 
*/
public interface ZyfxbDao extends BaseDao<Zyfxb, String>{

    /**
     * 根据学号查询辅修报考信息
     *
     * @param xh
     * @return
     */
    List<Zyfxb> getByXh(String xh);

    /**
     * 分页查询
     *
     * @param data
     * @return
     */
    List<Zyfxb> getExtByPage(Map data);

    /**
     * 批量删除
     *
     * @param ids
     * @return
     */
    int deleteByIdArr(String[] ids);

    /**
     * 导出查询
     *
     * @param zxjxjhh
     * @return
     */
    List<ZyfxbExcel> getMakeupExcle(String zxjxjhh);

    /**
     * 获取辅修打印数据
     *
     * @param xh
     * @return
     */
    ZyfxbReportExt getReportByXh(String xh);
}