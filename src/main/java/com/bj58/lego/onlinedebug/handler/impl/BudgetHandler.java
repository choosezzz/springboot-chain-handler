package com.bj58.lego.onlinedebug.handler.impl;

import com.bj58.lego.onlinedebug.handler.ChainHandler;
import com.bj58.lego.onlinedebug.handler.model.RequestInfo;
import com.bj58.lego.onlinedebug.handler.model.ResponseInfo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @Author:dingshuangen
 * @Date: 2019/2/22 14:38
 */
public class BudgetHandler extends ChainHandler {

    private static final Logger logger = LoggerFactory.getLogger(BudgetHandler.class);

    @Override
    public ResponseInfo handleDebugRequest(RequestInfo requestInfo, ResponseInfo responseInfo) {

        logger.info("帖子预算信息正常，需要下一步验证");
        return responseInfo;
    }
}
