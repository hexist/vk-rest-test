package com.gusev.vkresttest.services;

import com.gusev.vkresttest.api.domain.*;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.List;

@Service
public class ApiServiceImpl implements ApiService {

    private RestTemplate restTemplate;

    private final String search_url;
    private final String mutual_url;
    private final String three_hands_mutual_url;
    private final String api_version;
    private final String access_token;

    public ApiServiceImpl(RestTemplate restTemplate,
            @Value("${search.url}") String search_url,
            @Value("${friends.mutual.url}") String mutual_url,
            @Value("${execute.get3HandsMutual}") String three_hands_mutual_url,
            @Value("${api.version}") String api_version,
            @Value("${access.token}") String access_token) {
        this.restTemplate = restTemplate;
        this.search_url = search_url;
        this.mutual_url = mutual_url;
        this.three_hands_mutual_url = three_hands_mutual_url;
        this.api_version = api_version;
        this.access_token = access_token;
    }

    @Override
    public List<Photo> getPhotos(Double lat, Double lOng, Integer radius) {
        UriComponentsBuilder uriBuilder = UriComponentsBuilder
                .fromUriString(search_url)
                .queryParam("v", api_version)
                .queryParam("access_token", access_token)
                .queryParam("lat", lat)
                .queryParam("long", lOng)
                .queryParam("radius", radius);

        PhotoResponseData responseData = restTemplate.getForObject(uriBuilder.toUriString(), PhotoResponseData.class);
        return responseData.getResponse().getItems();
    }

    @Override
    public List<Mutual> getMutualFriends(Integer sourceId, Integer targetId){
        UriComponentsBuilder uriBuilder = UriComponentsBuilder
                .fromUriString(mutual_url)
                .queryParam("v", api_version)
                .queryParam("access_token", access_token)
                .queryParam("source_uid", sourceId)
                .queryParam("target_uids", targetId);

        MutualListResponseData responseData = restTemplate.getForObject(uriBuilder.toUriString(), MutualListResponseData.class);
        return responseData.getResponse();
    }

    @Override
    public List<Mutual> getMutualWithTargetFriends(Integer sourceId, Integer targetId) {
        UriComponentsBuilder uriBuilder = UriComponentsBuilder
                .fromUriString(three_hands_mutual_url)
                .queryParam("v", api_version)
                .queryParam("access_token", access_token)
                .queryParam("source_uid", sourceId)
                .queryParam("target_uids", targetId);

        MutualListResponseData responseData = restTemplate.getForObject(uriBuilder.toUriString(), MutualListResponseData.class);
        return responseData.getResponse();
    }

}
