package top.dearan.chain.handler.impl;


import top.dearan.chain.handler.ChainHandler;
import top.dearan.chain.handler.model.RequestInfo;
import top.dearan.chain.handler.model.ResponseInfo;
import top.dearan.chain.utils.OkHttpUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * @Author:dingshuangen
 * @Date: 2019/2/22 11:08
 */
public class ParamHandler extends ChainHandler {

    private static final Logger logger = LoggerFactory.getLogger(ParamHandler.class);

    @Override
    public ResponseInfo handleDebugRequest(RequestInfo requestInfo, ResponseInfo responseInfo) {

        String url = requestInfo.getUrl();
        Map<String,String> traceMap = new HashMap<>(1);

        traceMap.put("trace", new SimpleDateFormat("yyyyMMdd").format(new Date()));
        String result = OkHttpUtil.get(url, traceMap);
        logger.info(result);
        return responseInfo;
    }
}

