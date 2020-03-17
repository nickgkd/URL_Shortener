package com.urlShortener.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.urlShortener.dto.OriginalUrlDto;
import com.urlShortener.dto.ShortUrlDto;
import com.urlShortener.service.UrlShortenerService;

@RestController
@RequestMapping("/api/v1/url")
@CrossOrigin("*")
public class UrlShortController {

	@Autowired
	UrlShortenerService urlShortenerService;

	@PostMapping("/shorten")
	public ResponseEntity<ShortUrlDto> getShortenUrl(@RequestBody @Valid OriginalUrlDto originalUrlDto) {
				
		return ResponseEntity.ok(new ShortUrlDto(urlShortenerService.shortenUrl(originalUrlDto.getOriginalUrl())));
		
	}

}
