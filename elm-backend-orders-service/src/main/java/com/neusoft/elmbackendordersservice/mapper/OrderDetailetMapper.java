package com.neusoft.elmbackendordersservice.mapper;


import com.neusoft.elmbackendmodel.model.bo.OrderDetailet;
import org.apache.ibatis.annotations.Mapper;

import java.sql.SQLException;
import java.util.List;

@Mapper
public interface OrderDetailetMapper {
    public void saveOrderDetailetBatch(List<OrderDetailet> list) throws SQLException;

    public List<OrderDetailet> listOrderDetailetByOrderId(Integer orderOd) throws SQLException;
}