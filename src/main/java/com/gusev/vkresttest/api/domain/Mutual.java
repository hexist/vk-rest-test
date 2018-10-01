package com.gusev.vkresttest.api.domain;

import lombok.Data;

import java.io.Serializable;
import java.util.List;

@Data
public class Mutual implements Serializable {
    private Integer id;
    private List<Integer> common_friends;
    private Integer common_count;
}
