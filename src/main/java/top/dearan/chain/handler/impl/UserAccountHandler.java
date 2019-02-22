package top.dearan.chain.handler.impl;

import top.dearan.chain.handler.ChainHandler;
import top.dearan.chain.handler.model.RequestInfo;
import top.dearan.chain.handler.model.ResponseInfo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @Author:dingshuangen
 * @Date: 2019/2/22 14:34
 */
public class UserAccountHandler extends ChainHandler {

    private static final Logger logger = LoggerFactory.getLogger(UserAccountHandler.class);

    @Override
    public ResponseInfo handleDebugRequest(RequestInfo requestInfo, ResponseInfo responseInfo) {

        logger.info("用户账号状态正常，需要进一步判断");
        return responseInfo;
    }
}
