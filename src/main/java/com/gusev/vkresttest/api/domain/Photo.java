package com.gusev.vkresttest.api.domain;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.io.Serializable;

@Data
public class Photo implements Serializable {

    private Integer id;
    private Integer album_id;

    @JsonProperty("owner_id")
    private Integer ownerId;

//    private String photo_75;
//    private String photo_130;
    private String photo_604;
//    private String photo_807;
//    private String photo_1280;
//    private String photo_2560;
//
//    private Integer width;
//    private Integer height;
    private String text;
    private Long date;
    private Double lat;
    private Double lOng;
    private Integer post_id;
}
