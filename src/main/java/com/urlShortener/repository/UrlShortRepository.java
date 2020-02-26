package com.urlShortener.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.urlShortener.model.UrlShortenerModel;

public interface UrlShortRepository extends JpaRepository<UrlShortenerModel, Long> {

	UrlShortenerModel findByOriginalUrl(String originalUrl);
	
}
