
package com.foodordering.demo.dto.order.detail;

import java.io.Serializable;
import javax.annotation.Generated;


public class ProductDetail implements Serializable
{

    private String productName;
    private String quantity;
    private final static long serialVersionUID = -3664221597955382665L;

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getQuantity() {
        return quantity;
    }

    public void setQuantity(String quantity) {
        this.quantity = quantity;
    }

}
