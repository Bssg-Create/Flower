package com.flower.exception;

import com.flower.base.ResponseResult;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
@Slf4j
public class GlobalExceptionHandler {

    @ExceptionHandler(BaseException.class)
    public ResponseResult<Void> handleBaseException(BaseException e) {
        log.error("业务异常: {}", e.getMessage());
        return ResponseResult.error(e.getMessage());
    }

    @ExceptionHandler(Exception.class)
    public ResponseResult<Void> handleException(Exception e) {
        log.error("系统异常", e);
        return ResponseResult.error("服务器内部错误");
    }
}
