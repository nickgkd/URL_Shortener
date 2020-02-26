package com.urlShortener.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.urlShortener.model.UrlShortenerModel;
import com.urlShortener.repository.UrlShortRepository;

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
		if(null != urlShortRepo.findByOriginalUrl(originalUrl)) {
			UrlShortenerModel shortenUrl = urlShortRepo.findByOriginalUrl(originalUrl);
			return shortenUrl.getShortenUrl();
		}
		else {
		return BASE_URL.concat(SHORTEN_URL_PRIFIX).concat(saveAndShorten(originalUrl).getShortenUrl());
		}
	}
	
	
	private UrlShortenerModel saveAndShorten(String originalUrl) {
		UrlShortenerModel url = urlShortRepo.save(new UrlShortenerModel(originalUrl));
       // System.out.println("Saved entity is "+ urlShortnerRepository.save(new ShortenUrl(originalUrl)));
       // System.out.println("URL id is"+url.getId());
        String shortenKey = idConverterService.encode(url.getId());
        
      //  urlShortnerRepository.findByOriginalUrl(originalUrl)originalUrl;
        url.setShortenUrl(shortenKey);

        return url;
    }

	
	
}
