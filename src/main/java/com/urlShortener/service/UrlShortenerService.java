package com.urlShortener.service;

import java.util.Optional;

import com.urlShortener.model.UrlShortenerModel;

public interface UrlShortenerService {

	String shortenUrl(String originalUrl);
	
	Optional<UrlShortenerModel> getOriginalUrl(String shortenUrl);

}
