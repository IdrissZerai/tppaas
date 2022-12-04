package com.tppaas.heartrate.rabbit;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.io.Serializable;

public record CustomMessage(@JsonProperty("id") String id,
                            @JsonProperty("value") String value,
                            @JsonProperty("user_id") String userid) implements Serializable {
}

