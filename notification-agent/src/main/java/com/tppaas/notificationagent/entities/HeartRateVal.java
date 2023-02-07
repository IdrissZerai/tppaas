package com.tppaas.notificationagent.entities;

import lombok.Data;

import java.io.Serializable;

@Data
public class HeartRateVal implements Serializable {
    private String id;
    private String BPM;
    private String user_id;
    private boolean emergency;
}
