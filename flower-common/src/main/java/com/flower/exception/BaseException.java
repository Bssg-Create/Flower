package com.flower.exception;

import com.flower.enums.BasicEnum;
import lombok.Getter;

@Getter
public class BaseException extends RuntimeException {

    private final int code;

    public BaseException(int code, String message) {
        super(message);
        this.code = code;
    }

    public BaseException(BasicEnum basicEnum) {
        super(basicEnum.getMsg());
        this.code = basicEnum.getCode();
    }

    public BaseException(String message) {
        super(message);
        this.code = 500;
    }
}
