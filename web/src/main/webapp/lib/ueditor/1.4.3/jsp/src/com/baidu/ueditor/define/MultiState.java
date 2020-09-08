package com.baidu.ueditor.define;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import com.baidu.ueditor.Encoder;

/**
 * ��״̬����״̬
 * ������˶��״̬�ļ���, �䱾���Լ�Ҳ��һ��״̬
 * @author hancong03@baidu.com
 *
 */
public class MultiState implements State {
    private boolean             state     = false;
    private String              info      = null;
    private Map<String, Long>   intMap    = new HashMap<String, Long>();
    private Map<String, String> infoMap   = new HashMap<String, String>();
    private List<String>        stateList = new ArrayList<String>();

    public MultiState(boolean state) {
        this.state = state;
    }

    public MultiState(boolean state, int infoKey) {
        this.state = state;
        this.info  = AppInfo.getStateInfo(infoKey);
    }

    public MultiState(boolean state, String info) {
        this.state = state;
        this.info  = info;
    }

    public void addState(State state) {
        stateList.add(state.toJSONString());
    }

    @Override
    public void putInfo(String name, long val) {
        this.intMap.put(name, val);
    }

    /**
     * �÷���������Ч��
     */
    @Override
    public void putInfo(String name, String val) {
        this.infoMap.put(name, val);
    }

    @Override
    public String toJSONString() {
        String        stateVal = this.isSuccess()
                                 ? AppInfo.getStateInfo(AppInfo.SUCCESS)
                                 : this.info;
        StringBuilder builder  = new StringBuilder();

        builder.append("{\"state\": \"" + stateVal + "\"");

        // ����ת��
        Iterator<String> iterator = this.intMap.keySet().iterator();

        while (iterator.hasNext()) {
            stateVal = iterator.next();
            builder.append(",\"" + stateVal + "\": " + this.intMap.get(stateVal));
        }

        iterator = this.infoMap.keySet().iterator();

        while (iterator.hasNext()) {
            stateVal = iterator.next();
            builder.append(",\"" + stateVal + "\": \"" + this.infoMap.get(stateVal) + "\"");
        }

        builder.append(", list: [");
        iterator = this.stateList.iterator();

        while (iterator.hasNext()) {
            builder.append(iterator.next() + ",");
        }

        if (this.stateList.size() > 0) {
            builder.deleteCharAt(builder.length() - 1);
        }

        builder.append(" ]}");

        return Encoder.toUnicode(builder.toString());
    }

    @Override
    public boolean isSuccess() {
        return this.state;
    }
}



