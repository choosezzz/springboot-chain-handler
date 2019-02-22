package com.bj58.lego.onlinedebug.handler.impl;

import com.bj58.lego.onlinedebug.constents.ResultConstent;
import com.bj58.lego.onlinedebug.handler.ChainHandler;
import com.bj58.lego.onlinedebug.handler.model.RequestInfo;
import com.bj58.lego.onlinedebug.handler.model.ResponseInfo;
import com.bj58.lego.onlinedebug.web.vo.ResponseVo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @Author:dingshuangen
 * @Date: 2019/2/22 14:42
 */
public class PromotionHandler extends ChainHandler {

    private static final Logger logger = LoggerFactory.getLogger(PromotionHandler.class);

    @Override
    public ResponseInfo handleDebugRequest(RequestInfo requestInfo, ResponseInfo responseInfo) {

        logger.info("帖子不在推广时间内，结束！");
        responseInfo.setFastOver(true);
        ResponseVo<String> responseVo = new ResponseVo<>(200,"ok",ResultConstent.NOT_IN_PROMOTION_TIME);
        responseInfo.setResponseVo(responseVo);
        return responseInfo;
    }
}
