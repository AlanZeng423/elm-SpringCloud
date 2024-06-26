package com.neusoft.elmbackendbusinessservice.mapper;


import com.neusoft.elmbackendmodel.model.bo.Business;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.sql.SQLException;
import java.util.List;

@Mapper
public interface BusinessMapper {
    @Select("select * from business where orderTypeId=#{orderTypeId} order by businessId")
    public List<Business> listBusinessByOrderTypeId(Integer orderTypeId) throws SQLException;

    @Select("select * from business where businessId=#{businessId}")
    public Business getBusinessById(Integer businessId) throws SQLException;

    @Select("SELECT * FROM business WHERE businessName LIKE CONCAT('%', #{businessName}, '%')")
    List<Business> listBusinessByBusinessName(String businessName) throws SQLException;
}
