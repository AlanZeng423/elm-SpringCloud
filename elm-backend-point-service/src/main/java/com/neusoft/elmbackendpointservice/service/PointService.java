package com.neusoft.elmbackendpointservice.service;


import com.neusoft.elmbackendmodel.model.bo.Point;
import com.neusoft.elmbackendmodel.model.bo.PointTurnover;
import com.neusoft.elmbackendmodel.model.vo.PointTurnoverVo;

import java.util.List;

public interface PointService {
    List<PointTurnover> checkDate(List<PointTurnover> pointTurnoverList);

    List<PointTurnover> getUsefulPointTurnover(String userID);

    List<PointTurnover> usePoint(List<PointTurnover> pointTurnoverList, Integer amount);

    Integer LogUsePointTurnover(String userId, Integer amount);

    List<PointTurnoverVo> getPointTurnoverVoList(String userId);

    Point getPoint(String userId);

    Integer savePointTurnover(String userId, Integer amount);
}
