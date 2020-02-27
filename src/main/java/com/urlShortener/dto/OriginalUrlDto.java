package com.urlShortener.dto;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;



public class OriginalUrlDto {

	
	@NotNull
	@NotBlank
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
