package com.imust.newckbk.base;

import java.util.List;
import java.util.Map;

import com.imust.newckbk.page.Page;

/**
 * ����service
 * @author jkzzk
 *
 * @param <T>
 * @param <ID>
 */
public interface BaseService<T, ID> {
    int deleteByEntity(T t);

    /** ******************************ɾ��********************************************* */
    int deleteById(ID id);

    int deleteByMap(Map<String, Object> params);

    /** ******************************����********************************************* */
    T insert(T record);

    /** *****************************��������********************************************* */
    int updateById(T record);

    int updateByMap(Map<String, Object> params);

    List<T> getAll();

    void setBaseDao();

    List<T> getByEntity(T t);

    /** ******************************��ѯ********************************************* */
    T getById(ID id);

    List<T> getByMap(Map<String, Object> params);

    Page<T> getByPage(Map<String, Object> params);

    int getCount();

    int getCountByEntity(T t);

    /** ******************************��ѯ����********************************************* */
    int getCountByMap(Map<String, Object> params);

    T getOneByEntity(T t);

    T getOneByMap(Map<String, Object> params);
}



