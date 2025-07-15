package com.chen.heartMagic.model.enums;

import cn.hutool.core.util.ObjectUtil;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * App 应用类型枚举
 * @author 尘小风
 */
public enum AppTypeEnum {

    SCORE("得分类", 0),
    TEST("测评类", 1);

    private final String text;

    private final int value;


    // 构造函数，用于初始化AppTypeEnum类的实例
    AppTypeEnum(String text, int value) {
        // 将传入的text参数赋值给text属性
        this.text = text;
        // 将传入的value参数赋值给value属性
        this.value = value;
    }



    /**
     * 根据 value 获取枚举
     * @param value
     * @return
     */
    public static AppTypeEnum getEnumByValue(Integer value) {
        // 判断 value 是否为空
        if (ObjectUtil.isEmpty(value)) {
            return null;
        }
        // 遍历枚举值
        for (AppTypeEnum anEnum : AppTypeEnum.values()) {
            // 判断枚举值是否与 value 相等
            if (anEnum.value == value) {
                return anEnum;
            }
        }
        return null;
    }



    /**
     * 获取所有枚举值列表
     * @return
     */
    public static List<Integer> getValues() {
        return Arrays.stream(values()).map(item -> item.value).collect(Collectors.toList());
    }


    public int getValue() {
        return value;
    }

    public String getText() {
        return text;
    }
}
