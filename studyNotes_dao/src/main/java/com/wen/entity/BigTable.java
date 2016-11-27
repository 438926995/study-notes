package com.wen.entity;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import java.math.BigDecimal;
import java.util.Date;

import static javax.persistence.GenerationType.IDENTITY;

/**
 * @author huwenwen
 * @since 16/11/27
 */
@Entity
@Table(name = "t_big_table")
@Data
public class BigTable {

  @Id
  @GeneratedValue(strategy = IDENTITY)
  @Column(name = "id")
  private Long id;

  @Column(name = "name")
  private String name;

  @Column(name = "value")
  private BigDecimal value;

  @Column(name = "date")
  private Date date;
}
