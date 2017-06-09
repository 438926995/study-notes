package com.github.huwenwen.crawler;

import com.alibaba.fastjson.JSON;
import java.io.BufferedReader;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.URL;
import java.net.URLConnection;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author huwenwen
 * @since 2017/2/24
 */
public class SampleCrawler {

  private static final Logger logger = LoggerFactory.getLogger(SampleCrawler.class);

  public void spider(String url) throws IOException {
    URL u = new URL(url);
    URLConnection urlConnection = u.openConnection();
    urlConnection.setRequestProperty("User-Agent", "Mozilla/4.0 (compatible; MSIE 7.0; Windows NT 5.1)");
    InputStream inputStream = urlConnection.getInputStream();
    BufferedReader br = new BufferedReader(new InputStreamReader(inputStream, "utf-8"));
    StringBuffer sb=new StringBuffer(); // 把内容提取出来
    String lines="";
    while((lines=br.readLine())!=null){
      sb.append(lines+"\n");
    }
    OutputStreamWriter ops=new OutputStreamWriter(new FileOutputStream("/Users/huwenwen/Downloads/webmagic/test.html",true),"utf-8"); // 写入到本地的W盘中，命名为qiubai.html
    ops.write(sb.toString());
  }

  public static void main(String[] args) {
    try {
      new SampleCrawler().spider("");
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

}
