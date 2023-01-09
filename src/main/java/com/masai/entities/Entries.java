package com.masai.entities;

import com.fasterxml.jackson.annotation.JsonProperty;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

@Entity
@Data
public class Entries {

	@Id
	@JsonProperty("API")
	private String api;
	@JsonProperty("Description")
	private String description;
	@JsonProperty("Auth")
	private String auth;
	@JsonProperty("HTTPS")
	private boolean https;
	@JsonProperty("Cors")
	private String cors;
	@JsonProperty("Link")
	private String link;
	@JsonProperty("Category")
	private String category;
}
