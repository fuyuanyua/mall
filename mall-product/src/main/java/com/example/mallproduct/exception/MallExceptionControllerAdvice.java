package com.example.mallproduct.exception;

import com.example.common.utils.R;
import lombok.extern.slf4j.Slf4j;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.HashMap;
import java.util.Map;

/**
 * @Description: MallExceptionControllerAdvice 统一处理异常
 * @Author: lhb
 * @Date: 2021/4/15 12:20
 */

@Slf4j
@RestControllerAdvice(basePackages = "com.example.mallproduct.controller")
public class MallExceptionControllerAdvice {

    /**
     * 处理入参错误异常
     * @param e
     * @return
     */
    @ExceptionHandler(value = MethodArgumentNotValidException.class)
    public R handleValidException(MethodArgumentNotValidException e) {
        Map<String, String> errorMap = new HashMap<>(16);
        e.printStackTrace();
        log.error("入参错误");
        BindingResult bindingResult = e.getBindingResult();
        bindingResult.getFieldErrors().forEach(item -> errorMap.put(item.getField(), item.getDefaultMessage()));
        return R.error(400, "入参错误").put("data", errorMap);
    }
}
