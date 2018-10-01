package com.gusev.vkresttest.services;

import com.gusev.vkresttest.api.domain.Mutual;
import com.gusev.vkresttest.util.structures.UndirectedGraph;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

@Service
public class SocialServiceImpl implements SocialService {

    private RestTemplate restTemplate;
    private ApiService apiService;
    private UndirectedGraph graph;

    public SocialServiceImpl(RestTemplate restTemplate, ApiService apiService, UndirectedGraph graph) {
        this.restTemplate = restTemplate;
        this.apiService = apiService;
        this.graph = graph;
    }

    private final Queue<Integer> queue = new LinkedList<>();
    private final Queue<Integer> searched = new LinkedList<>();

    /**
     * Поиск в ширину - наработки
     */
//    @Override
//    public Boolean searchConnection(Integer yourId, Integer targetId) {
//        final List<Integer> friends = apiService.friends(yourId);
//        queue.addAll(friends);
//
//        while(!queue.isEmpty()) {
//            final Integer head = queue.peek();
//            if (head != null && head.equals(targetId)) {
//                return true;
//            } else if (!searched.contains(head)) {
//                queue.addAll(apiService.getFriends(head));
//                searched.add(head);
//            }
//        }
//
//
//        return false;
//    }

    @Override
    public UndirectedGraph searchConnection(Integer sourceId, Integer targetId) {
        final List<Mutual> mutualFriends = apiService.getMutualFriends(sourceId, targetId);
        final Mutual mutual = mutualFriends.get(0);

        if (mutual.getCommon_count() > 0){
            final List<Integer> common_friends = mutual.getCommon_friends();
            graph.addEdges(sourceId, common_friends);
            graph.addEdges(targetId, common_friends);
            return graph;
        }

        apiService.getMutualWithTargetFriends(sourceId, targetId);


        return graph;
    }
}
