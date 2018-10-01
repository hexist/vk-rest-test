package com.gusev.vkresttest.api.domain;

import lombok.Data;

import java.io.Serializable;

@Data
public class PhotoResponseData implements Serializable {

    Response<Photo> response;
}
