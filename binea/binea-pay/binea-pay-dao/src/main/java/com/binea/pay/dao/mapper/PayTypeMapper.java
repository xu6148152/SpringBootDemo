package com.binea.pay.dao.mapper;

import com.binea.pay.dao.model.PayType;
import com.binea.pay.dao.model.PayTypeExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface PayTypeMapper {
    long countByExample(PayTypeExample example);

    int deleteByExample(PayTypeExample example);

    int deleteByPrimaryKey(Integer payTypeId);

    int insert(PayType record);

    int insertSelective(PayType record);

    List<PayType> selectByExample(PayTypeExample example);

    PayType selectByPrimaryKey(Integer payTypeId);

    int updateByExampleSelective(@Param("record") PayType record, @Param("example") PayTypeExample example);

    int updateByExample(@Param("record") PayType record, @Param("example") PayTypeExample example);

    int updateByPrimaryKeySelective(PayType record);

    int updateByPrimaryKey(PayType record);
}