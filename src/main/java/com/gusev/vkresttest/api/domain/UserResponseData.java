package com.gusev.vkresttest.api.domain;

import lombok.Data;

import java.io.Serializable;

@Data
public class UserResponseData implements Serializable {

    Response<Integer> response;
}
