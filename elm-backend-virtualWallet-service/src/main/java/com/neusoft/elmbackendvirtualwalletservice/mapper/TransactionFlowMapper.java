package com.neusoft.elmbackendvirtualwalletservice.mapper;


import com.neusoft.elmbackendmodel.model.bo.TransactionFlow;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.sql.SQLException;
import java.util.List;

@Mapper
public interface TransactionFlowMapper {
    @Insert("insert into transactionFlow values (?,#{virtualWalletId},#{userId},#{state},#{amount},#{createTime})")
    public int saveTransactionFlow(String userId, Long virtualWalletId, String state, Integer amount, String createTime) throws SQLException;

    @Select("select id,state,amount,createTime from transactionFlow where userId = #{userId} and virtualWalletId = #{virtualWalletId}")
    public List<TransactionFlow> getTransactionFlow(String userId, Long virtualWalletId) throws SQLException;
}
