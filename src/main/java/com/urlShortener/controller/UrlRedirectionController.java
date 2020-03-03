package com.urlShortener.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;


import com.urlShortener.service.UrlShortenerService;

@RestController
public class UrlRedirectionController {
	
	@Autowired
	private UrlShortenerService urlShortenerService;
	
	@GetMapping("/{shortenStr}")
    public ModelAndView redirectToOriginalUrl(@PathVariable("shortenStr") String shortenStr) {
		return urlShortenerService.getOriginalUrl(shortenStr)
                .map(shortenUrl -> new ModelAndView("redirect:" + shortenUrl.getOriginalUrl()))
                .orElseGet(() -> new ModelAndView("tiny_not_found"));
	}
}
