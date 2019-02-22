package top.dearan.chain.handler;

import top.dearan.chain.handler.model.RequestInfo;
import top.dearan.chain.handler.model.ResponseInfo;

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
