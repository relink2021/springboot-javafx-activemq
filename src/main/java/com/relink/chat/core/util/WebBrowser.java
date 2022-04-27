package com.relink.chat.core.util;

import java.io.IOException;
import java.io.InputStream;
import  java.net.URISyntaxException;
import java.net.URI;
import java.net.URL;
import java.net.HttpURLConnection;
import java.net.URLConnection;
import java.net.URISyntaxException;
import java.awt.Desktop;
public class WebBrowser {

    public static int webstart(String uri)
    {
        int status = 404;
        try {

            URL url = new URL(uri);
            HttpURLConnection oc = (HttpURLConnection) url.openConnection();
            oc.setUseCaches(false);
            oc.setConnectTimeout(3000); // 设置超时时间
            status = oc.getResponseCode();// 请求状态
            if (200 == status) {
                // 200是请求地址顺利连通。
                System.out.println("连接可用");
                return 1;
            }
            System.out.println("连接打不开!");
            return 0;

        } catch (Exception e1) {
            System.out.println("连接打不开!");
            return 0;
        }
}}
