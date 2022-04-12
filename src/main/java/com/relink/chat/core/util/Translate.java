package com.relink.chat.core.util;

import com.alibaba.fastjson.JSONObject;
import com.relink.chat.core.translate.TransApi;

/**
 * 翻译通用接口
 */
public class Translate {

    private static final String APP_ID = "20220402001155869";
    private static final String SECURITY_KEY = "3Gk5NeErZ9JVbfsjkVBD";

    public static String toEnglish(String query, String from, String to) {
        TransApi api = new TransApi(APP_ID, SECURITY_KEY);
        // 转换为JSON处理
        String str_result = api.getTransResult(query, from, to);
        JSONObject json_result = JSONObject.parseObject(str_result);
        String result = json_result.getJSONArray("trans_result").getJSONObject(0).getString("dst");
        return result;
    }
}
