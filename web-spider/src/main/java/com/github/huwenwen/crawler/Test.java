package com.github.huwenwen.crawler;


import java.io.IOException;
import org.apache.http.HttpHost;
import org.apache.http.HttpRequest;
import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.ResponseHandler;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.conn.ClientConnectionManager;
import org.apache.http.params.HttpParams;
import org.apache.http.protocol.HttpContext;

/**
 * @author huwenwen
 * @since 2017/2/23
 */
public class Test {

  public static void main(String[] args) {

    HttpClient httpClient = new HttpClient() {
      public HttpParams getParams() {
        return null;
      }

      public ClientConnectionManager getConnectionManager() {
        return null;
      }

      public HttpResponse execute(HttpUriRequest httpUriRequest)
          throws IOException, ClientProtocolException {
        return null;
      }

      public HttpResponse execute(HttpUriRequest httpUriRequest, HttpContext httpContext)
          throws IOException, ClientProtocolException {
        return null;
      }

      public HttpResponse execute(HttpHost httpHost, HttpRequest httpRequest)
          throws IOException, ClientProtocolException {
        return null;
      }

      public HttpResponse execute(HttpHost httpHost, HttpRequest httpRequest,
          HttpContext httpContext)
          throws IOException, ClientProtocolException {
        return null;
      }

      public <T> T execute(HttpUriRequest httpUriRequest,
          ResponseHandler<? extends T> responseHandler)
          throws IOException, ClientProtocolException {
        return null;
      }

      public <T> T execute(HttpUriRequest httpUriRequest,
          ResponseHandler<? extends T> responseHandler,
          HttpContext httpContext) throws IOException, ClientProtocolException {
        return null;
      }

      public <T> T execute(HttpHost httpHost, HttpRequest httpRequest,
          ResponseHandler<? extends T> responseHandler)
          throws IOException, ClientProtocolException {
        return null;
      }

      public <T> T execute(HttpHost httpHost, HttpRequest httpRequest,
          ResponseHandler<? extends T> responseHandler, HttpContext httpContext)
          throws IOException, ClientProtocolException {
        return null;
      }
    };

  }

}
