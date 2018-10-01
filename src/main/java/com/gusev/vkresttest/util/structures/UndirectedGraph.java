package com.gusev.vkresttest.util.structures;

import org.springframework.stereotype.Component;

import java.util.*;

@Component
public class UndirectedGraph {

    private HashMap<Integer, List<Integer>> vertexMap = new HashMap<>();

    public void addVertex(Integer vertexName) {
        if (!hasVertex(vertexName)) {
            vertexMap.put(vertexName, new ArrayList<>());
        }
    }

    public boolean hasVertex(Integer vertex) {
        return vertexMap.containsKey(vertex);
    }

    public boolean hasEdge(Integer vertex1, Integer vertex2) {
        if (!hasVertex(vertex1)) return false;
        List<Integer> edges = vertexMap.get(vertex1);
        return Collections.binarySearch(edges, vertex2) != -1;
    }

    public void addEdge(Integer vertex1, Integer vertex2) {
        if (!hasVertex(vertex1)) addVertex(vertex1);
        if (!hasVertex(vertex2)) addVertex(vertex2);
        List<Integer> edges1 = vertexMap.get(vertex1);
        List<Integer> edges2 = vertexMap.get(vertex2);
        edges1.add(vertex2);
        edges2.add(vertex1);
        Collections.sort(edges1);
        Collections.sort(edges2);
    }

    public void addEdges(Integer vertex, Collection<Integer> vertices){
        vertices.forEach(v -> addEdge(vertex, v));
    }

    public Map<Integer, List<Integer>> getVertexMap() {
        return vertexMap;
    }
}
