package com.gusev.vkresttest.controllers;

import com.gusev.vkresttest.services.ApiService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.support.AbstractMultipartHttpServletRequest;
import org.springframework.web.server.ServerWebExchange;

import javax.servlet.http.HttpServletRequest;

@Slf4j
@Controller
public class PhotosController {

    private ApiService apiService;

    public PhotosController(ApiService apiService) {
        this.apiService = apiService;
    }

    @GetMapping({"", "/", "/index"})
    public String index() {
        return "index";
    }

    @PostMapping("/photos")
    public String formPost(Model model, HttpServletRequest request) {

        final Double lat = new Double(request.getParameter("lat"));
        final Double lOng = new Double(request.getParameter("long"));
        Integer radius = new Integer(request.getParameter("radius"));


        log.debug("Received lat value: " + lat);
        log.debug("Received long value: " + lOng);
        log.debug("Received radius value: " + radius);

        if ( radius == null || radius == 0) {
            log.debug("Setting radius to default of 1000");
            radius = 1000;
        }

        model.addAttribute("photos", apiService.getPhotos(lat, lOng, radius));

//        System.out.println(apiService.getFriends(135947364));

        return "photolist";
    }
}

