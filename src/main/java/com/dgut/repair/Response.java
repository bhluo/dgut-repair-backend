package com.dgut.repair;

public class Response{
    private Object data;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    private int code;
    private String errorMsg;

    public static Response newSuccess(Object data) {
        Response response = new Response();
        response.setData(data);
        response.setCode(200);
        return response;
    }

    public static Response newFail(String errorMsg){
        Response response = new Response();
        response.setErrorMsg(errorMsg);
        response.setCode(500);
        return response;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }



    public String getErrorMsg() {
        return errorMsg;
    }

    public void setErrorMsg(String errorMsg) {
        this.errorMsg = errorMsg;
    }

}
