package com.laki.gymdemo.entity;

import lombok.Data;
import org.apache.logging.log4j.message.Message;
import org.jetbrains.annotations.NotNull;

import java.io.Serializable;

@Data
public class UserLogin implements Serializable {

    private String username;
    private String password;


}
