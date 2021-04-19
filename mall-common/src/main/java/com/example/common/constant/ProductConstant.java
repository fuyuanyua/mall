package com.example.common.constant;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * @Description: ProductConstant
 * @Author: lhb
 * @Date: 2021/4/18 21:01
 */

public class ProductConstant {

    @Getter
    @AllArgsConstructor
    public enum AttrEnum {

        ATTR_TYPE_BASE(1, "基本属性"),
        ATTR_TYPE_SALE(0, "销售属性");

        private Integer code;

        private String message;
    }
}
