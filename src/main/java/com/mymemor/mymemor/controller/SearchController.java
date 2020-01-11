package com.mymemor.mymemor.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class SearchController {

    @PostMapping("/search")
    public String getSearchResultViaAjax() {
        return "";
    }

}
