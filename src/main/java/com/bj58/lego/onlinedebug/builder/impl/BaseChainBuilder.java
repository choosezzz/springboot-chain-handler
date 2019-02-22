package com.bj58.lego.onlinedebug.builder.impl;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.bj58.lego.onlinedebug.builder.ChainBuilder;
import com.bj58.lego.onlinedebug.handler.ChainHandler;
import com.bj58.lego.onlinedebug.handler.Handler;
import com.bj58.lego.onlinedebug.handler.model.RequestInfo;
import com.bj58.lego.onlinedebug.handler.model.ResponseInfo;
import com.bj58.lego.onlinedebug.utils.PathUtil;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * @Author:dingshuangen
 * @Date: 2019/2/21 19:41
 */
public class BaseChainBuilder implements ChainBuilder {

    private static final Logger logger = LoggerFactory.getLogger(BaseChainBuilder.class);

    private static Map<String, String> handlerClassMap = new HashMap<>();
    private static Map<String, String> chainMap = new HashMap<>();
    private static Map<String, Map<String, ChainHandler>> handlersMap = new HashMap<>();

    private static final String PATH = PathUtil.getCurrentPath() + "/config/chain.json";

    public BaseChainBuilder(String path) {
        this.init(path);
    }

    @Override
    public ChainHandler builderChain(RequestInfo var1) {

        Map<String, ChainHandler> chainHandlerMap = handlersMap.get(var1.getChainKey());
        String[] keys = chainMap.get(var1.getChainKey()).split(",");

        if (keys == null || keys.length <= 0) {
            logger.error(">>>>>>>>>>获取指定chain链表配置信息失败>>>>>>>>>>>>");
            return null;
        }
        if (chainHandlerMap == null || chainHandlerMap.size() <= 0) {
            try {

                Map<String, ChainHandler> handlerMap = new HashMap<>(keys.length);
                for (int i = 0; i < keys.length; i++) {
                    String className = handlerClassMap.get(keys[i]);
                    ChainHandler handler = (ChainHandler) Class.forName(className).newInstance();
                    handlerMap.put(keys[i], handler);
                }

                if (handlerMap.size() <= 0) {
                    logger.error(">>>>>>>>>>获取指定chainHandler 对象失败>>>>>>>>>>>>");
                    return null;
                }
                ChainHandler current = null;
                ChainHandler next = null;
                for (int i = 0; i < handlerMap.size() - 1; i++) {
                    current = handlerMap.get(keys[i]);
                    if (i + 1 < handlerMap.size()) {
                        next = handlerMap.get(keys[i + 1]);
                    }
                    current.setNextHandler(next);
                }
                handlersMap.put(var1.getChainKey(), handlerMap);
            } catch (ClassNotFoundException e) {
                logger.error("builderChain-->key:{}>>>>", var1.getChainKey(), e);
            } catch (IllegalAccessException e) {
                logger.error("builderChain-->key:{}>>>>", var1.getChainKey(), e);
            } catch (InstantiationException e) {
                logger.error("builderChain-->key:{}>>>>", var1.getChainKey(), e);
            }
        }
        return handlersMap.get(var1.getChainKey()).get(keys[0]);
    }

    @Override
    public void handle(RequestInfo var1, ResponseInfo var2) {
        ChainHandler chainHandler = this.builderChain(var1);
        this.chainHandle(var1, var2, chainHandler);
    }

    private void chainHandle(RequestInfo adRequest, ResponseInfo adResponse, Handler handler) {
        if (!adResponse.isFastOver() && handler != null) {
            handler.handleDebugRequest(adRequest, adResponse);
            if (handler.hasNextHandler()) {
                this.chainHandle(adRequest, adResponse, handler.getNextHandler());
            }

        }
    }

    private void init(String path) {

        if (StringUtils.isEmpty(path)) {
            path = PATH;
        }

        logger.info("初始化chain handler配置文件，path:{}", path);
        String jsonProperties = null;
        try {
            jsonProperties = readFileToString(path);
            JSONObject config = JSONObject.parseObject(jsonProperties);
            JSONArray handler_list = config.getJSONArray("handler_list");
            JSONObject handler;
            for (int i = 0; i < handler_list.size(); i++) {
                handler = handler_list.getJSONObject(i);
                String id = handler.getString("id");
                String className = handler.getString("class_name");
                handlerClassMap.put(id, className);
            }

            JSONArray chain_list = config.getJSONArray("chain_list");
            JSONObject chainObj;
            for (int i = 0; i < chain_list.size(); i++) {
                chainObj = chain_list.getJSONObject(i);
                String key = chainObj.getString("chain_key");
                String chain = chainObj.getString("chain");
                chainMap.put(key, chain);
            }

        } catch (Exception e) {
            logger.error("初始化chain handler配置文件失败>>>>>>", e);
            System.exit(1);
        }

    }

    private String readFileToString(String fileName) {

        File file = new File(fileName);
        BufferedReader reader = null;
        StringBuilder sb = new StringBuilder();

        try {
            reader = new BufferedReader(new FileReader(file));
            String tempString = null;

            while ((tempString = reader.readLine()) != null) {
                sb.append(tempString);
            }

            reader.close();
        } catch (IOException var13) {
            var13.printStackTrace();
        } finally {
            if (reader != null) {
                try {
                    reader.close();
                } catch (IOException var12) {
                }
            }
        }
        return sb.toString();
    }

}
