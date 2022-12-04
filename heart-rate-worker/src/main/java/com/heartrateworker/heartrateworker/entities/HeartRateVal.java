package com.heartrateworker.heartrateworker.entities;

import lombok.Data;

import java.io.Serializable;

@Data
public class HeartRateVal implements Serializable {
    private String id;
    private String val;
    private String user_id;
}
