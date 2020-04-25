package com.fwtai.config;

import com.alibaba.fastjson.JSONObject;

/**
 * @作者 田应平
 * @版本 v1.0
 * @创建时间 2020-04-25 10:51
 * @QQ号码 444141300
 * @Email service@dwlai.com
 * @官网 http://www.fwtai.com
 */
public final class ResultJson extends JSONObject{

    private String msg;

    private Integer code;// 200,201,202,203

    public ResultJson(final Integer code){
        switch (code){
            case 200:
                this.msg = "操作成功";
                break;
            case 201:
                this.msg = "操作失败";
                break;
            case 202:
                this.msg = "暂无数据";
                break;
            case 203:
                this.msg = "系统错误";
                break;
            default:
                break;
        }
        this.code = code;
        put("code",code);
        put("msg",this.msg);
    }

    public ResultJson(final Integer code,final String msg){
        this.code = code;
        this.msg = msg;
        put("code",code);
        put("msg",msg);
    }

    @Override
    public Object put(String key,Object value){
        return super.put(key,value);
    }

    public String getMsg(){
        return msg;
    }

    public void setMsg(String msg){
        this.msg = msg;
    }

    public Integer getCode(){
        return code;
    }

    public void setCode(Integer code){
        this.code = code;
    }
}