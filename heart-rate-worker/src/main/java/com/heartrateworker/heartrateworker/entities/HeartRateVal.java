package com.heartrateworker.heartrateworker.entities;

import lombok.Data;

import java.io.Serializable;

@Data
public class HeartRateVal implements Serializable {
    private String id;
    private int BPM;
    private String user_id;
    private boolean emergency;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public int getBPM() {
        return BPM;
    }

    public void setBPM(int BPM) {
        this.BPM = BPM;
    }

    public String getUser_id() {
        return user_id;
    }

    public void setUser_id(String user_id) {
        this.user_id = user_id;
    }

    public boolean isEmergency() {
        return emergency;
    }

    public void setEmergency(boolean emergency) {
        this.emergency = emergency;
    }
}
