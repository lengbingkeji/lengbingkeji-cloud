package com.lengbingkeji.common.exception;

/**
 * ClassName: UnauthorizedException
 * Package: com.lengbingkeji.common.exception
 * Description:
 *
 * @Author lengbingkeji
 * @Create 2024/1/8 10:46
 * @Version 1.0
 */
public class UnauthorizedException extends CommonException{

    public UnauthorizedException(String message) {
        super(message, 401);
    }

    public UnauthorizedException(String message, Throwable cause) {
        super(message, cause, 401);
    }

    public UnauthorizedException(Throwable cause) {
        super(cause, 401);
    }
}
