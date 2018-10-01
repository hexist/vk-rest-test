package com.gusev.vkresttest.services;

import com.gusev.vkresttest.api.domain.Mutual;
import com.gusev.vkresttest.api.domain.Photo;

import java.util.List;

public interface ApiService {

    List<Photo> getPhotos(Double lat, Double lOng, Integer radius);

    List<Mutual> getMutualFriends(Integer sourceId, Integer targetId);

    List<Mutual> getMutualWithTargetFriends(Integer sourceId, Integer targetId);
}
