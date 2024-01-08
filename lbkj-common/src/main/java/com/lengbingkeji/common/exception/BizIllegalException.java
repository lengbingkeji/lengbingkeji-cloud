package com.lengbingkeji.common.exception;

/**
 * ClassName: BizIllegalException
 * Package: com.lengbingkeji.common.exception
 * Description:
 *
 * @Author lengbingkeji
 * @Create 2024/1/8 10:43
 * @Version 1.0
 */
public class BizIllegalException extends CommonException{

    public BizIllegalException(String message) {
        super(message, 500);
    }

    public BizIllegalException(String message, Throwable cause) {
        super(message, cause, 500);
    }

    public BizIllegalException(Throwable cause) {
        super(cause, 500);
    }
}
