package com.iweb.test2;

import lombok.Data;

/**
 * @author Min
 * @date 2023/11/25 10:43
 */
@Data
public class Product {
    private Integer id;
    private String name;
    private Float price;
    public void sell(){
        System.out.println(name+"清仓大甩卖，原价"+price+"现在只要998就能带回家");
    }
}
