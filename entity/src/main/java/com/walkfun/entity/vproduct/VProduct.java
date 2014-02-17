package com.walkfun.entity.vproduct;

import com.walkfun.common.lib.CustomDateDeserializer;
import com.walkfun.common.lib.CustomDateSerializer;
import org.codehaus.jackson.map.annotate.JsonDeserialize;
import org.codehaus.jackson.map.annotate.JsonSerialize;

import java.util.Date;

/**
 * Created with IntelliJ IDEA.
 * User: p
 * Date: 14-2-13
 * Time: 下午3:23
 * To change this template use File | Settings | File Templates.
 */
public class VProduct {

    private Integer productId;
    private String productName;
    private String productDescription;
    private Integer virtualPrice;
    private Integer dropFlag;
    private String picLink;
    private Date updateTime;

    public Integer getProductId() {
        return productId;
    }

    public void setProductId(Integer productId) {
        this.productId = productId;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getProductDescription() {
        return productDescription;
    }

    public void setProductDescription(String productDescription) {
        this.productDescription = productDescription;
    }

    public Integer getVirtualPrice() {
        return virtualPrice;
    }

    public void setVirtualPrice(Integer virtualPrice) {
        this.virtualPrice = virtualPrice;
    }

    public Integer getDropFlag() {
        return dropFlag;
    }

    public void setDropFlag(Integer dropFlag) {
        this.dropFlag = dropFlag;
    }

    @JsonSerialize(using = CustomDateSerializer.class)
    public Date getUpdateTime() {
        return updateTime;
    }

    @JsonDeserialize(using = CustomDateDeserializer.class)
    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public String getPicLink() {
        return picLink;
    }

    public void setPicLink(String picLink) {
        this.picLink = picLink;
    }
}
