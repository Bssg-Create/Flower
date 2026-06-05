package com.flower.base;

import com.flower.constant.HttpStatus;
import com.flower.enums.BasicEnum;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@NoArgsConstructor
public class ResponseResult<T> implements Serializable {

    private int code;
    private String msg;
    private T data;

    public ResponseResult(int code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public ResponseResult(int code, String msg, T data) {
        this.code = code;
        this.msg = msg;
        this.data = data;
    }

    public static <T> ResponseResult<T> success() {
        return new ResponseResult<>(HttpStatus.SUCCESS, "操作成功");
    }

    public static <T> ResponseResult<T> success(T data) {
        return new ResponseResult<>(HttpStatus.SUCCESS, "操作成功", data);
    }

    public static <T> ResponseResult<T> error(String msg) {
        return new ResponseResult<>(HttpStatus.ERROR, msg);
    }

    public static <T> ResponseResult<T> error(BasicEnum basicEnum) {
        return new ResponseResult<>(basicEnum.getCode(), basicEnum.getMsg());
    }
}
