package com.tppaas.notificationmanager.entities;

import lombok.Data;
import org.springframework.data.redis.core.RedisHash;

import java.io.Serializable;

@Data
@RedisHash("Coach")
public class Coach implements Serializable {

    private Long id;
    private String firstname;
    private String lastname;
    private String speciality;
    private boolean available;
}
