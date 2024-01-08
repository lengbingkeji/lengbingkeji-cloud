package com.lengbingkeji.common.exception;

/**
 * ClassName: DbException
 * Package: com.lengbingkeji.common.exception
 * Description:
 *
 * @Author lengbingkeji
 * @Create 2024/1/8 10:45
 * @Version 1.0
 */
public class DbException extends CommonException{

    public DbException(String message) {
        super(message, 500);
    }

    public DbException(String message, Throwable cause) {
        super(message, cause, 500);
    }

    public DbException(Throwable cause) {
        super(cause, 500);
    }
}