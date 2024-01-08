package com.lengbingkeji.common.exception;

/**
 * ClassName: BadRequestException
 * Package: com.lengbingkeji.common.exception
 * Description:
 *
 * @Author lengbingkeji
 * @Create 2024/1/8 10:43
 * @Version 1.0
 */
public class BadRequestException extends CommonException{

    public BadRequestException(String message) {
        super(message, 400);
    }

    public BadRequestException(String message, Throwable cause) {
        super(message, cause, 400);
    }

    public BadRequestException(Throwable cause) {
        super(cause, 400);
    }
}