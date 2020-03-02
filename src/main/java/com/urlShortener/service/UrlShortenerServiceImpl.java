package com.urlShortener.service;

import java.time.LocalDateTime;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.urlShortener.model.UrlShortenerModel;
import com.urlShortener.repository.UrlShortRepository;
import com.urlShortner.Exception.Exception;
import com.urlShortner.Exception.InvalidUrlException;

@Service
public class UrlShortenerServiceImpl implements UrlShortenerService {

	@Value("${base.url}")
	private String BASE_URL;
	
	@Value("${shorten.url.prefix}")
	private String SHORTEN_URL_PRIFIX;
	
	@Autowired
	private UrlShortRepository urlShortRepo;
	
	@Autowired
	private IdConverterService idConverterService;
	
	
	@Override
	public String shortenUrl(String originalUrl) {
		if("" == originalUrl) {throw new Exception();}
		if(originalUrl.length() > 2048) {throw new InvalidUrlException();}
		  String shortUrl = saveAndShorten(originalUrl).getShortenUrl();
		    return shortUrl;
      }
	
	
	private UrlShortenerModel saveAndShorten(String originalUrl) {
		if(urlShortRepo.existsByOriginalUrl(originalUrl)) {
            UrlShortenerModel originalURLExists = urlShortRepo.findByOriginalUrl(originalUrl);
            return originalURLExists;
        }
		UrlShortenerModel url = urlShortRepo.save(new UrlShortenerModel(originalUrl));
		String shortenKey = idConverterService.encode(url.getId());
		url.setShortenUrl(BASE_URL.concat(SHORTEN_URL_PRIFIX).concat(shortenKey));
		url.setTimeStampValue(LocalDateTime.now());
		urlShortRepo.save(url);

		return url;
	}

	@Override
	public Optional<UrlShortenerModel> getOriginalUrl(String shortenUrl) {
		return urlShortRepo.findById(idConverterService.decode(shortenUrl));
		
		
	}
	
	
}
