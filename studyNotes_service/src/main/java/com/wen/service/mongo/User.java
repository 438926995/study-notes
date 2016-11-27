package com.wen.service.mongo;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 * @author huwenwen
 * @since 16/11/27
 */
@Document
@Data
public class User {

  @Id
  private String id;

  private String name;
  private String value;

}
