package com.bj58.lego.onlinedebug.web.controller;

import com.alibaba.fastjson.JSONObject;
import com.bj58.lego.onlinedebug.builder.impl.BaseChainBuilder;
import com.bj58.lego.onlinedebug.handler.model.RequestInfo;
import com.bj58.lego.onlinedebug.handler.model.ResponseInfo;
import com.bj58.lego.onlinedebug.web.vo.ResponseVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author:dingshuangen
 * @Date: 2019/2/21 17:43
 */
@RestController
@RequestMapping("/show/jz")
public class JZShowController {

    @Autowired
    private BaseChainBuilder baseChainBuilder;

    @RequestMapping("/test")
    public ResponseVo testChainHandler(){

        RequestInfo requestInfo = new RequestInfo();
        requestInfo.setChainKey("jz_show");
        ResponseInfo responseInfo = new ResponseInfo();
        baseChainBuilder.handle(requestInfo,responseInfo);

        System.out.println(JSONObject.toJSONString(requestInfo));
        System.out.println(JSONObject.toJSONString(responseInfo));
        return responseInfo.getResponseVo();
    }
}
