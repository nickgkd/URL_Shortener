package com.urlShortener.service;

import java.util.Random;

import org.springframework.stereotype.Service;

@Service
public class IdConverterServiceImpl implements IdConverterService {

	private static final String POSSIBLE_ALPHABET = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyx0123456789";
	private static final int BASE = POSSIBLE_ALPHABET.length();

	@Override
	public String encode() {
		Random random = new Random();
		StringBuilder shortenKey = new StringBuilder();
		for(int i=0;i<7;i++) {
			shortenKey.append(POSSIBLE_ALPHABET.charAt(random.nextInt(BASE)));
		}

		return shortenKey.toString();
	}

	


}
