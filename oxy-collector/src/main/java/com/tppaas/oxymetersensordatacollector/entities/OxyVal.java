package com.tppaas.oxymetersensordatacollector.entities;

import lombok.Data;

import java.io.Serializable;

@Data
public class OxyVal implements Serializable {
    private String id;
    private String val;
    private String user_id;
}
