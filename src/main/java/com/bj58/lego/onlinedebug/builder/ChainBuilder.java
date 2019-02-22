package com.bj58.lego.onlinedebug.builder;

import com.bj58.lego.onlinedebug.handler.ChainHandler;
import com.bj58.lego.onlinedebug.handler.model.RequestInfo;
import com.bj58.lego.onlinedebug.handler.model.ResponseInfo;

/**
 * @Author:dingshuangen
 * @Date: 2019/2/21 19:40
 */
public interface ChainBuilder {

    ChainHandler builderChain(RequestInfo var1);

    void handle(RequestInfo var1, ResponseInfo var2);
}
