package com.lengbingkeji.common.exception;

/**
 * ClassName: CommonException
 * Package: com.lengbingkeji.common.exception
 * Description:
 *
 * @Author lengbingkeji
 * @Create 2024/1/8 10:44
 * @Version 1.0
 */
import lombok.Getter;

@Getter
public class CommonException extends RuntimeException{
    private int code;

    public CommonException(String message, int code) {
        super(message);
        this.code = code;
    }

    public CommonException(String message, Throwable cause, int code) {
        super(message, cause);
        this.code = code;
    }

    public CommonException(Throwable cause, int code) {
        super(cause);
        this.code = code;
    }
}
