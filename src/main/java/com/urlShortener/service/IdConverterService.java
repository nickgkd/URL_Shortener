package com.urlShortener.service;

public interface IdConverterService {
	
	String encode(long num);
	long decode(long num);
}
