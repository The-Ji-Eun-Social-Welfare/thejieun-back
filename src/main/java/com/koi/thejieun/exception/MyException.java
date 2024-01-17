package com.koi.thejieun.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class MyException extends RuntimeException {
    private final ErrorCode errorCode;
}
