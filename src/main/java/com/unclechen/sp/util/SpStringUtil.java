package com.unclechen.sp.util;

import org.apache.commons.lang.StringEscapeUtils;
import org.apache.commons.lang.StringUtils;

public class SpStringUtil {
    /**
     * 字符串转义
     * 
     * @param input
     *            输入
     * @param escapeHTML
     *            html转义
     * @param escapeJavaScript
     *            JavaScript转义
     * @param escapeXML
     *            xml转义
     * @return
     */
    public static String parseString(String input, boolean escapeHTML, boolean escapeJavaScript, boolean escapeXML) {
        if(StringUtils.isBlank(input)){
            return "";
        }
        String output = input.trim();
        if (escapeHTML) {
            output = StringEscapeUtils.escapeHtml(output);
        }
        if (escapeJavaScript) {
            output = StringEscapeUtils.escapeJavaScript(output);
        }
        if (escapeXML) {
            output = StringEscapeUtils.escapeXml(output);
        }
        return output;
    }
    
    public static String parseString(String input) {
        return parseString(input, true, true, true);
    }
}
