package com.imust.newckbk.base;

import java.util.List;
import java.util.Map;

import com.imust.newckbk.page.Page;

public interface BaseDao<T, ID> {
    int deleteByEntity(T t);

    /**
     * ɾ��
     * @param id
     * @return
     */
    int deleteById(ID id);

    int deleteByMap(Map<String, Object> params);

    /**
     * ����
     * @param record
     * @return
     */
    int insert(T record);

    /**
     * ����
     * @param record
     * @return
     */
    int updateById(T record);

    int updateByMap(Map<String, Object> params);

    List<T> getByEntity(T t);

    /**
     * ��ѯ
     * @param id
     * @return
     */
    T getById(ID id);

    List<T> getByMap(Map<String, Object> params);

    /**
     * ��ҳ��ѯ
     * @param t
     * @return
     */
    List<T> getByPage(Page t);

    int getCount();

    int getCountByEntity(T t);

    int getCountByMap(Map<String, Object> params);
}



