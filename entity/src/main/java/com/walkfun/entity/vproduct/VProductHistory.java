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
 * Time: 下午3:21
 * To change this template use File | Settings | File Templates.
 */
public class VProductHistory {

    private Integer userId;
    private Integer productId;
    private Integer numbers;
    private Date buyTime;

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getProductId() {
        return productId;
    }

    public void setProductId(Integer productId) {
        this.productId = productId;
    }

    public Integer getNumbers() {
        return numbers;
    }

    public void setNumbers(Integer numbers) {
        this.numbers = numbers;
    }

    @JsonSerialize(using = CustomDateSerializer.class)
    public Date getBuyTime() {
        return buyTime;
    }

    @JsonDeserialize(using = CustomDateDeserializer.class)
    public void setBuyTime(Date buyTime) {
        this.buyTime = buyTime;
    }
}
