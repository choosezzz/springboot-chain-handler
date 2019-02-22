package top.dearan.chain.handler.model;

import top.dearan.chain.web.vo.ResponseVo;

/**
 * @Author:dingshuangen
 * @Date: 2019/2/21 19:02
 */
public class ResponseInfo {

    private boolean fastOver;

    private ResponseVo responseVo;

    public ResponseVo getResponseVo() {
        return responseVo;
    }

    public void setResponseVo(ResponseVo responseVo) {
        this.responseVo = responseVo;
    }

    public boolean isFastOver() {
        return fastOver;
    }

    public void setFastOver(boolean fastOver) {
        this.fastOver = fastOver;
    }
}
