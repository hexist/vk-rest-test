package com.gusev.vkresttest.api.domain;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class User {

    private Integer id;

    @JsonProperty
    private String firstName;

    @JsonProperty
    private String lastName;

    private String domain;
    private City city;
    private String online;

}

