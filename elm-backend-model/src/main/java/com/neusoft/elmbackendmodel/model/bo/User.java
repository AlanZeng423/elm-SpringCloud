package com.neusoft.elmbackendmodel.model.bo;

import lombok.Data;

@Data
public class User {
    private String userId;
    private String password;
    private String userName;
    private Integer userSex;
    private String userImg;
    private Integer delTag;
    private Integer isDelete;
}
