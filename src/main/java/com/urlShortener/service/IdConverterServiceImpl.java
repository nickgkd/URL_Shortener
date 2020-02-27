package com.urlShortener.service;

import org.springframework.stereotype.Service;

@Service
public class IdConverterServiceImpl implements IdConverterService {

	private static final String POSSIBLE_ALPHABET = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyx0123456789";
	private static final int BASE = POSSIBLE_ALPHABET.length();

	@Override
	public String encode(long id) {
		StringBuilder shortenKey = new StringBuilder();
		while (id > 0) {
			shortenKey.insert(0, POSSIBLE_ALPHABET.charAt((int) (id % BASE)));
			id = id / BASE;
		}

		return shortenKey.toString();
	}

	@Override
	public long decode(String shortenKey) {
		 int num = 0;
	        for ( int i = 0; i < shortenKey.length(); i++ )
	            num = num * BASE + POSSIBLE_ALPHABET.indexOf(shortenKey.charAt(i));
	        return num;
		
		
	}


}
