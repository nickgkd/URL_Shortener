package com.urlShortener.model;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Table;
import javax.persistence.Id;

import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "urlshortener")
@EntityListeners(AuditingEntityListener.class)
@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
public class UrlShortenerModel {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column
	private Long id;

	@Column(name = "ORIGINAL_URL")
	private String originalUrl;

	@Column(name = "SHORTEN_URL")
	private String shortenUrl;

	@Column(name = "CREATE_TIME_STAMP")
	private LocalDate timeStampValue;

	public UrlShortenerModel() {

	}

	public UrlShortenerModel(String originalUrl) {
		this.originalUrl = originalUrl;
	}

	public UrlShortenerModel(String originalUrl, String shortenUrl) {
		this.originalUrl = originalUrl;
		this.shortenUrl = shortenUrl;
	}

	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getOriginalUrl() {
		return originalUrl;
	}

	public void setOriginalUrl(String originalUrl) {
		this.originalUrl = originalUrl;
	}

	public String getShortenUrl() {
		return shortenUrl;
	}

	public void setShortenUrl(String shortenUrl) {
		this.shortenUrl = shortenUrl;
	}

	public LocalDate getTimeStampValue() {
		return timeStampValue;
	}

	public void setTimeStampValue(LocalDate timeStampValue) {
		this.timeStampValue = timeStampValue;
	}

	@Override
	public String toString() {
		return "UrlShortenerModel [Id=" + id + ", OriginalUrl=" + originalUrl + ", ShortenUrl=" + shortenUrl
				+ ", Entrydate=" + timeStampValue + "]";
	}

}
