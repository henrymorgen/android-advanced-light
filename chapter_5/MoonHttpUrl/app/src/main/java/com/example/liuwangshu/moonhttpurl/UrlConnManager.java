package com.example.liuwangshu.moonhttpurl;

import android.text.TextUtils;

import org.apache.http.NameValuePair;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.util.List;

/**
 * Created by Administrator on 2016/4/1.
 */
public class UrlConnManager {

    /**
     * 配置默认参数
     * @param url
     * @return HttpURLConnection
     */
    public static HttpURLConnection getHttpURLConnection(String url){
        HttpURLConnection mHttpURLConnection=null;
        try {
            URL mUrl=new URL(url);
            mHttpURLConnection=(HttpURLConnection)mUrl.openConnection();
            //设置链接超时时间
            mHttpURLConnection.setConnectTimeout(15000);
            //设置读取超时时间
            mHttpURLConnection.setReadTimeout(15000);
            //设置请求参数
            mHttpURLConnection.setRequestMethod("POST");
            //添加Header
            mHttpURLConnection.setRequestProperty("Connection","Keep-Alive");
            //接收输入流
            mHttpURLConnection.setDoInput(true);
            //传递参数时需要开启
            mHttpURLConnection.setDoOutput(true);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return mHttpURLConnection ;
    }

    /**
     * 组织请求参数,并将参数写入到输出流
     */
   public static void postParams(OutputStream output,List<NameValuePair>paramsList) throws IOException{
       StringBuilder mStringBuilder=new StringBuilder();
       for (NameValuePair pair:paramsList){
           if(!TextUtils.isEmpty(mStringBuilder)){
               mStringBuilder.append("&");
           }
           mStringBuilder.append(URLEncoder.encode(pair.getName(),"UTF-8"));
           mStringBuilder.append("=");
           mStringBuilder.append(URLEncoder.encode(pair.getValue(),"UTF-8"));
       }
       BufferedWriter writer=new BufferedWriter(new OutputStreamWriter(output,"UTF-8"));
       writer.write(mStringBuilder.toString());
       writer.flush();
       writer.close();
   }

}