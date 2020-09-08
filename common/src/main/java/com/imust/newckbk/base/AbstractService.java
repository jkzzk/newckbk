package com.imust.newckbk.base;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.imust.newckbk.page.Page;
import com.imust.newckbk.utils.StringUtil;

/**
 * ����������
 * @author jkzzk
 *
 * @param <T>
 * @param <ID>
 */
public abstract class AbstractService<T, ID> implements BaseService<T, ID> {
    private BaseDao<T, ID> baseDao;

    public int deleteByEntity(T t) {
        return baseDao.deleteByEntity(t);
    }

    /** ********************************ɾ������*********************************** */
    public int deleteById(ID id) {
        return baseDao.deleteById(id);
    }

    public int deleteByMap(Map<String, Object> params) {
        return baseDao.deleteByMap(params);
    }

    /** ********************************����*********************************** */
    public T insert(T record) {
        baseDao.insert(record);

        return record;
    }

    /** ********************************����*********************************** */
    public int updateById(T record) {
        return baseDao.updateById(record);
    }

    public int updateByMap(Map<String, Object> params) {
        return baseDao.updateByMap(params);
    }

    /**
     * ��ѯ��������
     */
    public List<T> getAll() {
        return baseDao.getByMap(new HashMap<String, Object>());
    }

    public void setBaseDao(BaseDao<T, ID> baseDao) {
        this.baseDao = baseDao;
    }

    /**
     * ����ʵ�ഫ����ز���
     */
    public List<T> getByEntity(T t) {
        return baseDao.getByEntity(t);
    }

    /** ********************************��ѯ��������*********************************** */

    /**
     * ����ID��ѯ
     */
    public T getById(ID id) {
        return baseDao.getById(id);
    }

    /**
     * �����ѯ��������mybatis
     */
    public List<T> getByMap(Map<String, Object> params) {
        return baseDao.getByMap(params);
    }

    /**
     * ��ҳ��ѯ
     * @param params
     * @return
     */
    public Page<T> getByPage(Map<String, Object> params) {
        Page<T> page = new Page<T>();

        page.setP(params);
        page.setDefaultPageSize(10);
        page.setPageSize(StringUtil.toInt(params.get("pageSize")));
        page.setCurrentPage(StringUtil.toInt(params.get("pn") + "", 1));

        List<T> list = baseDao.getByPage(page);

        page.setResults(list);

        return page;
    }

    public int getCount() {
        return baseDao.getCount();
    }

    /** ********************************��ѯ����*********************************** */
    public int getCountByEntity(T t) {
        return baseDao.getCountByEntity(t);
    }

    public int getCountByMap(Map<String, Object> params) {
        return baseDao.getCountByMap(params);
    }

    /**
     * ��ѯĳһ������
     */
    public T getOneByEntity(T t) {
        List<T> list = baseDao.getByEntity(t);

        if ((list != null) && (list.size() > 0)) {
            return list.get(0);
        }

        return null;
    }

    /**
     * ��ѯĳһ������
     */
    public T getOneByMap(Map<String, Object> params) {
        List<T> list = baseDao.getByMap(params);

        if ((list != null) && (list.size() > 0)) {
            return list.get(0);
        }

        return null;
    }
}



