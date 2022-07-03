package com.laki.gymdemo.common;

import com.laki.gymdemo.entity.Result;
import lombok.Data;

import java.io.Serializable;

/**
 * 结果封装
 */
@Data
public class ResultCom implements Serializable {
    private Integer code;
    private String msg;
    private Object data;
    public static ResultCom success(Object data){
        ResultCom r = new ResultCom();
        r.setCode(200);
        r.setMsg("操作成功");
        r.setData(data);
        return r;
    }
    public static ResultCom fail(String msg){
        return fail(400,msg,null);
    }
    public static ResultCom fail(String msg,Object data){
        return fail(400,msg,data);
    }
    public static ResultCom fail(Integer code,String msg,Object data){
        ResultCom r = new ResultCom();
        r.setCode(code);
        r.setMsg(msg);
        r.setData(data);
        return r;
    }
}
