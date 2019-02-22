package com.bj58.lego.onlinedebug.handler;

import com.bj58.lego.onlinedebug.handler.model.RequestInfo;
import com.bj58.lego.onlinedebug.handler.model.ResponseInfo;

/**
 * @Author:dingshuangen
 * @Date: 2019/2/21 17:44
 */
public interface Handler {

    Handler getNextHandler();
    boolean hasNextHandler();
    boolean setNextHandler(Handler next);
    ResponseInfo handleDebugRequest(RequestInfo requestInfo, ResponseInfo responseInfo);

}
