package com.wen.bean;

/**
 * 百度ip查询接口返回默认结果
 *
 * @author huwenwen
 * @since 16/8/29
 */
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

  public String getAddress() {
    return address;
  }

  public void setAddress(String address) {
    this.address = address;
  }

  public Content getContent() {
    return content;
  }

  public void setContent(Content content) {
    this.content = content;
  }

  public int getStatus() {
    return status;
  }

  public void setStatus(int status) {
    this.status = status;
  }

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

    public AddressDetail getAddress_detail() {
      return address_detail;
    }

    public void setAddress_detail(AddressDetail address_detail) {
      this.address_detail = address_detail;
    }

    public String getAddress() {
      return address;
    }

    public void setAddress(String address) {
      this.address = address;
    }

    public Point getPoint() {
      return point;
    }

    public void setPoint(Point point) {
      this.point = point;
    }

    public static class AddressDetail {
      private String province;
      private String city;
      private String district;
      private String street;
      private String street_number;
      private int city_code;

      public String getProvince() {
        return province;
      }

      public void setProvince(String province) {
        this.province = province;
      }

      public String getCity() {
        return city;
      }

      public void setCity(String city) {
        this.city = city;
      }

      public String getDistrict() {
        return district;
      }

      public void setDistrict(String district) {
        this.district = district;
      }

      public String getStreet() {
        return street;
      }

      public void setStreet(String street) {
        this.street = street;
      }

      public String getStreet_number() {
        return street_number;
      }

      public void setStreet_number(String street_number) {
        this.street_number = street_number;
      }

      public int getCity_code() {
        return city_code;
      }

      public void setCity_code(int city_code) {
        this.city_code = city_code;
      }
    }


    public static class Point {
      private String y;
      private String x;

      public String getY() {
        return y;
      }

      public void setY(String y) {
        this.y = y;
      }

      public String getX() {
        return x;
      }

      public void setX(String x) {
        this.x = x;
      }
    }
  }
}


