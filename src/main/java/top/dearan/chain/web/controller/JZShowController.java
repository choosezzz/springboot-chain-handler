package top.dearan.chain.web.controller;

import com.alibaba.fastjson.JSONObject;
import top.dearan.chain.builder.impl.BaseChainBuilder;
import top.dearan.chain.handler.model.RequestInfo;
import top.dearan.chain.handler.model.ResponseInfo;
import top.dearan.chain.web.vo.ResponseVo;
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
