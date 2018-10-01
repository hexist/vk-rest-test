package com.gusev.vkresttest.api.domain;

import lombok.Data;

import java.io.Serializable;

@Data
public class City implements Serializable {

    private Integer id;
    private String title;
}
