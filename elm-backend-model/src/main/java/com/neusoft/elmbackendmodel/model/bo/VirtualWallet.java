package com.neusoft.elmbackendmodel.model.bo;

import lombok.Data;

@Data
public class VirtualWallet {
    private Long id;
    private String createTime;
    private Integer balance;
    private String userId;
}
