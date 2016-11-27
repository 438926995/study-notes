package com.wen.dao.bigTable.impl;

import com.wen.dao.BaseDao;
import com.wen.dao.bigTable.BigTableDao;
import com.wen.entity.BigTable;
import org.springframework.stereotype.Repository;

/**
 * @author huwenwen
 * @since 16/11/27
 */
@Repository
public class BigTableDaoImpl extends BaseDao implements BigTableDao {

  @Override
  public void insert(BigTable bt) {
    save(bt);
  }
}
