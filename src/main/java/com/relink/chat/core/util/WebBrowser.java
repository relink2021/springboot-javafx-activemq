package com.relink.chat.core.util;

import java.io.IOException;
import java.io.InputStream;
import  java.net.URISyntaxException;
import java.net.URI;
import java.net.URL;
import java.net.URISyntaxException;
import java.awt.Desktop;
public class WebBrowser {

    public static int webstart(String uri)
    {
        int checkurl=1;
        Desktop desktop=Desktop.getDesktop();
        try{
            desktop.browse(new URI(uri));
        } catch (IOException e){
            e.printStackTrace();
        } catch (URISyntaxException e){

          checkurl=0;}
        return checkurl;
    }
}
