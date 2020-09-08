package com.imust.newckbk.page;

import java.util.List;
import java.util.Map;

/**
 * ��ҳ��������
 * @author funds.assume
 */
public class Page<T> implements java.io.Serializable {
    private int                 defaultPageSize = 15;     // ȱʡÿҳ��¼��
    private int                 maxPageCount    = 999;    // ȱʡ���ҳ��
    private int                 pageSize;                 // ÿҳ��¼��
    private int                 currentPage;              // ��ǰҳ
    private int                 pageCount;                // ��ҳ��
    private int                 totalCount;               // �ܼ�¼��
    private List<T>             results;                  // ��Ӧ�ĵ�ǰҳ��¼
    private Map<String, Object> p;                        // �����Ĳ������ǰ�����װ��һ��Map����

    public Page() {
        pageSize    = defaultPageSize;
        currentPage = 1;
        pageCount   = 0;
        totalCount  = 0;
    }

    public int getCurrentPage() {
        return currentPage;
    }

    public void setCurrentPage(int currentPage) {
        if (currentPage <= 0) {
            currentPage = 1;
        }

        this.currentPage = currentPage;
    }

    public int getDefaultPageSize() {
        return defaultPageSize;
    }

    public void setDefaultPageSize(int defaultPageSize) {
        this.defaultPageSize = defaultPageSize;
    }

    public Map<String, Object> getP() {
        return p;
    }

    public void setP(Map<String, Object> p) {
        this.p = p;
    }

    public int getPageCount() {
        if (pageCount == 0) {
            this.pageCount = (totalCount - 1) / pageSize + 1;

            if (currentPage > pageCount) {
                this.currentPage = pageCount;
            }
        }

        if (pageCount > maxPageCount) {
            pageCount = maxPageCount;
        }

        return pageCount;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        if (pageSize <= 0) {
            pageSize = defaultPageSize;
        }

        this.pageSize = pageSize;
    }

    public List<T> getResults() {
        return results;
    }

    public void setResults(List<T> results) {
        getPageCount();
        this.results = results;
    }

    public int getTotalCount() {
        return totalCount;
    }

    public void setTotalCount(int totalCount) {
        if (totalCount <= 0) {
            totalCount = 0;
        }

        this.totalCount = totalCount;
    }
}



