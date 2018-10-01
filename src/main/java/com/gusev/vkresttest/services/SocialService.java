package com.gusev.vkresttest.services;

import com.gusev.vkresttest.util.structures.UndirectedGraph;

public interface SocialService {

    UndirectedGraph searchConnection(Integer yourId, Integer targetId);
}
