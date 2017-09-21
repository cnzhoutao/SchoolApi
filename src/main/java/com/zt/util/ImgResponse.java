package com.zt.util;

/**
 * 图片上传的回调
 */
public class ImgResponse {



    private int code;//0表示成功，其他表示失败

    /** 返回消息 */
    private String msg;


    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    /** 返回数据 */
    private Object data = new Object();

    private ImgResponse() {
    }

    /**
     * AJAX请求的 JSON类型的返回值
     *
     * @param code
     *            状态码
     * @param msg
     *            返回消息
     * @param data
     *            返回数据
     */
    private ImgResponse(int code, String msg, Object data) {
        this.code = code;
        this.msg = msg;
        this.data = data;
    }

    /**
     * 成功
     * @param msg
     * @param data
     * @return
     */
    public static ImgResponse success(String msg,Object data){
        return new ImgResponse(0,msg,data);
    }

    /**
     * 上传图片失败
     * @param msg
     * @param data
     * @return
     */
    public static ImgResponse failure(String msg,Object data){
        return new ImgResponse(1,msg,data);
    }


}
