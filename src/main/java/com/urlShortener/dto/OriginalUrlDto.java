package com.urlShortener.dto;

public class OriginalUrlDto {

	private String OriginalUrl;

	public OriginalUrlDto() {
		super();
	}

	public OriginalUrlDto(String originalUrl) {
		super();
		OriginalUrl = originalUrl;
	}

	public String getOriginalUrl() {
		return OriginalUrl;
	}

	public void setOriginalUrl(String originalUrl) {
		OriginalUrl = originalUrl;
	}

}
