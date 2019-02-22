package top.dearan.chain.handler.impl;

import top.dearan.chain.handler.ChainHandler;
import top.dearan.chain.handler.model.RequestInfo;
import top.dearan.chain.handler.model.ResponseInfo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @Author:dingshuangen
 * @Date: 2019/2/22 14:31
 */
public class JZShowHandler extends ChainHandler {
    private static final Logger logger = LoggerFactory.getLogger(JZShowHandler.class);
    @Override
    public ResponseInfo handleDebugRequest(RequestInfo requestInfo, ResponseInfo responseInfo) {

        logger.info("查询帖子{}不展示，需要下一步进行判断",requestInfo.getEntityid());
        return responseInfo;
    }
}
