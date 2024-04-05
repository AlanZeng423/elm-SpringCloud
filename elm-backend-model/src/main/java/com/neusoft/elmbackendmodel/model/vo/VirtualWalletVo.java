package com.neusoft.elmbackendmodel.model.vo;

import lombok.Data;

@Data
public class VirtualWalletVo {
    private Long id;
    private String createTime;
    private Integer balance;

    private String userId;
}
