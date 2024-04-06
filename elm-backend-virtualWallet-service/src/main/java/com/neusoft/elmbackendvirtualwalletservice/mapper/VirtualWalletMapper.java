package com.neusoft.elmbackendvirtualwalletservice.mapper;


import com.neusoft.elmbackendmodel.model.bo.VirtualWallet;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.sql.SQLException;

@Mapper
public interface VirtualWalletMapper {
    @Insert("insert into virtualwallet(userId, balance, createTime, isDelete) values (#{userId},0,#{createTime},0);")
    public int saveVirtualWallet(String userId, String createTime) throws SQLException;

    @Select("select * from virtualwallet where userId = #{userId}")
    VirtualWallet getVirtualWallet(String userId) throws SQLException;

    @Update("update virtualwallet set balance = #{balance} where userId = #{userId}")
    public int updateVirtualWallet(String userId, Integer balance) throws SQLException;
}
