package com.urlShortener.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.urlShortener.dto.OriginalUrlDto;
import com.urlShortener.dto.ShortUrlDto;
import com.urlShortener.service.UrlShortenerService;

@RestController
@RequestMapping("/api/v1/url")
public class UrlShortController {

	@Autowired
	UrlShortenerService urlShortenerService;

	@PostMapping("/shorten")
	public ResponseEntity<ShortUrlDto> getShortenUrl(@RequestBody OriginalUrlDto originalUrlDto) {
		System.out.println("Inside COntoller");
		return ResponseEntity.ok(new ShortUrlDto(urlShortenerService.shortenUrl(originalUrlDto.getOriginalUrl())));
	}

}
