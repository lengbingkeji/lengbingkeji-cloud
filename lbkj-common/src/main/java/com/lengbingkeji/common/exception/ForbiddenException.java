package com.lengbingkeji.common.exception;

/**
 * ClassName: ForbiddenException
 * Package: com.lengbingkeji.common.exception
 * Description:
 *
 * @Author lengbingkeji
 * @Create 2024/1/8 10:45
 * @Version 1.0
 */
public class ForbiddenException extends CommonException{

    public ForbiddenException(String message) {
        super(message, 403);
    }

    public ForbiddenException(String message, Throwable cause) {
        super(message, cause, 403);
    }

    public ForbiddenException(Throwable cause) {
        super(cause, 403);
    }
}

