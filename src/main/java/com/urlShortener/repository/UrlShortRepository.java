package com.urlShortener.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.urlShortener.model.UrlShortenerModel;

public interface UrlShortRepository extends JpaRepository<UrlShortenerModel, Long> {

	UrlShortenerModel findByOriginalUrl(String originalUrl);
	Boolean existsByOriginalUrl(String originalUrl);
	Optional<UrlShortenerModel> findByShortenKey(String shortenUrl);

	
}
