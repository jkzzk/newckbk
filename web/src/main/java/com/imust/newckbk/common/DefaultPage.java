package com.imust.newckbk.common;

import java.util.Map;
import java.util.Set;

import com.imust.newckbk.base.PageEntity;

public class DefaultPage {
    public static PageEntity<Map> setDefaultPage(Map<String,String> params) {
        PageEntity<Map> pageEntity = new PageEntity<Map>();

        if (params.size() == 0) {
            pageEntity.setPageNumber(1);
            pageEntity.setPageSize(10);
            pageEntity.setSearchType("");
            pageEntity.setSearchContent("");
            pageEntity.setData(params);
        } else {
            pageEntity.setPageNumber(Integer.valueOf(String.valueOf(params.get("pageNumber"))));
            pageEntity.setPageSize(Integer.valueOf(String.valueOf(params.get("pageSize"))));
            Set<String> key = params.keySet();
            for (String s : key) {
                if(!s.equals("pageNumber") && !s.equals("pageSize")) {
                    pageEntity.setSearchType(params.get(s));
                    break;
                }
            }
            String param = params.get(pageEntity.getSearchType()) == null ? "" : params.get(pageEntity.getSearchType());
            pageEntity.setSearchContent(param);
            pageEntity.setData(params);
        }

        return pageEntity;
    }
}



