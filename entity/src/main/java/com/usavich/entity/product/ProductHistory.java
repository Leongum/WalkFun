package com.usavich.entity.product;

import com.usavich.common.lib.CustomDateDeserializer;
import com.usavich.common.lib.CustomDateSerializer;
import org.codehaus.jackson.map.annotate.JsonDeserialize;
import org.codehaus.jackson.map.annotate.JsonSerialize;

import java.util.Date;

/**
 * Created with IntelliJ IDEA.
 * User: LeonLu
 * Date: 6/21/13
 * Time: 6:44 PM
 * To change this template use File | Settings | File Templates.
 */
public class ProductHistory {
    private Integer userId;
    private Integer productId;
    private double scores;
    private double money;
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

    public double getScores() {
        return scores;
    }

    public void setScores(double scores) {
        this.scores = scores;
    }

    public double getMoney() {
        return money;
    }

    public void setMoney(double money) {
        this.money = money;
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
