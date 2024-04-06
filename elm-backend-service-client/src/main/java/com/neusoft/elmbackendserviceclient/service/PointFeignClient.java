package com.neusoft.elmbackendserviceclient.service;


import com.neusoft.elmbackendmodel.model.bo.Point;
import com.neusoft.elmbackendmodel.model.bo.PointTurnover;
import com.neusoft.elmbackendmodel.model.vo.PointTurnoverVo;
import org.springframework.cloud.openfeign.FeignClient;

import java.util.List;
@FeignClient(name = "elm-backend-point-service", path = "/api/point/inner")
public interface PointFeignClient {
    List<PointTurnover> checkDate(List<PointTurnover> pointTurnoverList);

    List<PointTurnover> getUsefulPointTurnover(String userID);

    List<PointTurnover> usePoint(List<PointTurnover> pointTurnoverList, Integer amount);

    Integer LogUsePointTurnover(String userId, Integer amount);

    List<PointTurnoverVo> getPointTurnoverVoList(String userId);

    Point getPoint(String userId);

    Integer savePointTurnover(String userId, Integer amount);
}
