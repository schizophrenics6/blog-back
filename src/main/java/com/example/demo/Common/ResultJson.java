package com.example.demo.Common;
import com.alibaba.fastjson2.JSONObject;
import com.alibaba.fastjson2.JSONWriter;
import lombok.Data;
@Data
public class ResultJson<T> {
    private static final String SUCCESS_CODE = "200";
    /**
     * 成功失败的状态值，true：成功；false：失败
     * 这里返回编码为：“0000”，系统就认为接口成功；其他值，代表失败
     */

    /**
     * 状态码 正确为0000
     */
    private String code;
    /**
     * 返回数据
     */
    private Object data;
    /**
     * 返回提示信息
     */
    private String msg;

    public ResultJson() {

    }

    public static <T> ResultJson<T> success(T data)
    {
    ResultJson<T> r=new ResultJson<T> ();
    r.setCode(SUCCESS_CODE);
    r.setData(data);
    r.setMsg("成功");
    return r;
    }

//    public ResultJson(Object data)
//    {
//
//        this.code = SUCCESS_CODE;
//        this.data = data;
//        this.msg = "成功";
//
//    }
public static <T> ResultJson<T> error(String msg)
{
    ResultJson  r=new ResultJson ();
    r.msg=msg;
    r.setCode("404");
    return r;
}
    public static <T> ResultJson<T> error(String msg,String code)
    {
        ResultJson  r=new ResultJson ();
        r.msg=msg;
        r.code=code;
        return r;
    }

    public String asJonString() {
    return JSONObject.toJSONString(this, JSONWriter.Feature.WriteNulls);
    }


//    public ResultJson(String code, String msg) {
//
//        this.code = code;
//        this.msg = msg;
//    }

}