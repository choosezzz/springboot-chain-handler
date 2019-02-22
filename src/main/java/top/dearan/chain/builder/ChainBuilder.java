package top.dearan.chain.builder;

import top.dearan.chain.handler.ChainHandler;
import top.dearan.chain.handler.model.RequestInfo;
import top.dearan.chain.handler.model.ResponseInfo;

/**
 * @Author:dingshuangen
 * @Date: 2019/2/21 19:40
 */
public interface ChainBuilder {

    ChainHandler builderChain(RequestInfo var1);

    void handle(RequestInfo var1, ResponseInfo var2);
}
