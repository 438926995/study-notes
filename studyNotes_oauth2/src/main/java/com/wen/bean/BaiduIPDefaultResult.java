package com.wen.bean;

import lombok.Data;

/**
 * 百度ip查询接口返回默认结果
 *
 * @author huwenwen
 * @since 16/8/29
 */
@Data
public class BaiduIPDefaultResult {

  /**
   * address : CN|上海|上海|None|CHINANET|0|0
   * content : {"address_detail":{"province":"上海市","city":"上海市","district":"","street":"","street_number":"","city_code":289},"address":"上海市","point":{"y":"3642780.37","x":"13524118.26"}}
   * status : 0
   */

  private String address;
  /**
   * address_detail : {"province":"上海市","city":"上海市","district":"","street":"","street_number":"","city_code":289}
   * address : 上海市
   * point : {"y":"3642780.37","x":"13524118.26"}
   */

  private Content content;
  private int status;

  @Data
  public static class Content {
    /**
     * province : 上海市
     * city : 上海市
     * district :
     * street :
     * street_number :
     * city_code : 289
     */

    private AddressDetail address_detail;
    private String address;
    /**
     * y : 3642780.37
     * x : 13524118.26
     */

    private Point point;

    @Data
    public static class AddressDetail {
      private String province;
      private String city;
      private String district;
      private String street;
      private String street_number;
      private int city_code;
    }


    @Data
    public static class Point {
      private String y;
      private String x;
    }
  }
}


