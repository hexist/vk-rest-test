package com.gusev.vkresttest.api.domain;

import lombok.Data;

import java.io.Serializable;
import java.util.List;

@Data
public class MutualListResponseData implements Serializable {
    List<Mutual> response;
}
