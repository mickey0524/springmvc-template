package com.my.common;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.text.DateFormat;
import java.text.SimpleDateFormat;

public class CustomObjectMapper extends ObjectMapper {

    private String dateFormatPattern;

    /**
     * 定制日期格式化
     *
     * @param dateFormatPattern
     */
    public void setDateFormatPattern(String dateFormatPattern) {
        this.dateFormatPattern = dateFormatPattern;
    }

    public void init() {
        // 序列化时排除值为空属性
        setSerializationInclusion(JsonInclude.Include.NON_NULL);
        // 进行缩进输出
//        configure(SerializationFeature.INDENT_OUTPUT, true);
        //反序列化时 忽略java中未定义的属性
        configure(DeserializationFeature.FAIL_ON_IGNORED_PROPERTIES, false);
        configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        // 进行日期格式化
        DateFormat dateFormat = new SimpleDateFormat(dateFormatPattern);
        setDateFormat(dateFormat);
    }

}