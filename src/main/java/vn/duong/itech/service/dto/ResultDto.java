package vn.duong.itech.service.dto;

public class ResultDto {

    private String message;
    private String code;
    private boolean status = false;
    private Object data;

    public ResultDto() {}

    public ResultDto(String message, String code, boolean status) {
        this.message = message;
        this.code = code;
        this.status = status;
    }

    public ResultDto(String message, String code, boolean status, Object data) {
        this.message = message;
        this.code = code;
        this.status = status;
        this.data = data;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }
}
