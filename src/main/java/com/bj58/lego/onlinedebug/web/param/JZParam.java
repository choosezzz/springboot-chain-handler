package com.bj58.lego.onlinedebug.web.param;

import javax.validation.constraints.NotBlank;

/**
 * @Author:dingshuangen
 * @Date: 2019/2/21 18:17
 */
public class JZParam extends Param {

    @NotBlank(message = "平台信息不能为空")
    private String platform;
    @NotBlank(message = "问题链接不能为空")
    private String url;

    public String getPlatform() {
        return platform;
    }

    public void setPlatform(String platform) {
        this.platform = platform;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

}
