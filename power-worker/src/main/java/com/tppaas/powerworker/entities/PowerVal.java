package com.tppaas.powerworker.entities;

import lombok.Data;

import java.io.Serializable;

@Data
public class PowerVal implements Serializable {
    private String id;
    private String val;
    private String user_id;
}
