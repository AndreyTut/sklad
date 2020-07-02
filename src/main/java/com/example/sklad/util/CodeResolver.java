package com.example.sklad.util;

import org.apache.commons.lang3.StringUtils;


public class CodeResolver {

    public static String resolve(String code) {
        code = StringUtils.deleteWhitespace(code);
        if (StringUtils.isNumericSpace(code) || code.length() < 9) {
            return code;
        }
        return code.substring(0, 8);
    }
}
