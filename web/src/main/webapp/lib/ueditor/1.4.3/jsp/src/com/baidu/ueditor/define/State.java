package com.baidu.ueditor.define;

/**
 * ����״̬�ӿ�
 * @author hancong03@baidu.com
 *
 */
public interface State {
    public void putInfo(String name, long val);

    public void putInfo(String name, String val);

    public String toJSONString();

    public boolean isSuccess();
}



