package top.dearan.chain.web.param;

import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotBlank;

/**
 * @Author:dingshuangen
 * @Date: 2019/2/21 18:15
 */
public class Param {

    @NotBlank(message = "")
    @Length( max = 20,message = "帖子id长度不能超过20")
    private String entityid;

    public String getEntityid() {
        return entityid;
    }

    public void setEntityid(String entityid) {
        this.entityid = entityid;
    }
}
