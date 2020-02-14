package com.zx.util;

/**
 * Controller层返回JSON格式数据的工具类
 * <p/>
 * Created by zhangxin on 2015-08-10.
 */
public class JsonData {
    private boolean state;
    private String msg;
    private Object result;

    public JsonData() {
        this.state = false;//默认：失败
    }

    public boolean isState() {
        return state;
    }

    public void setState(boolean state) {
        this.state = state;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public Object getResult() {
        return result;
    }

    public void setResult(Object result) {
        this.result = result;
    }
}
