package com.urlShortener.dto;

public class ShortUrlDto {

	private String ShortenUrl;

	public ShortUrlDto() {

	}

	public ShortUrlDto(String shortenUrl) {
		ShortenUrl = shortenUrl;
	}

	public String getShortenUrl() {
		return ShortenUrl;
	}

	public void setShortenUrl(String shortenUrl) {
		ShortenUrl = shortenUrl;
	}

}
