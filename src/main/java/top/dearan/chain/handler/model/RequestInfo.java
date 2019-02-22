package top.dearan.chain.handler.model;

import java.util.Map;

/**
 * @Author:dingshuangen
 * @Date: 2019/2/21 19:02
 */
public class RequestInfo {

    private String chainKey;
    private String url;
    private String entityid;
    private String platform;
    private Map<String,Object> reqParam;

    public String getChainKey() {
        return chainKey;
    }

    public void setChainKey(String chainKey) {
        this.chainKey = chainKey;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getEntityid() {
        return entityid;
    }

    public void setEntityid(String entityid) {
        this.entityid = entityid;
    }

    public String getPlatform() {
        return platform;
    }

    public void setPlatform(String platform) {
        this.platform = platform;
    }

    public Map<String, Object> getReqParam() {
        return reqParam;
    }

    public void setReqParam(Map<String, Object> reqParam) {
        this.reqParam = reqParam;
    }

}
