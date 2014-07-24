package com.example.jacksondemo;

import org.codehaus.jackson.annotate.JsonIgnoreProperties;
import org.codehaus.jackson.annotate.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown=true)
public class TestEntry {
	String birthday;
	
	int gscore;
	
	@JsonProperty("sex")
	int gender;
	
	int weight;
	
	@JsonProperty("accesstoken")
	String token;

	public String getBirthday() {
		return birthday;
	}

	public void setBirthday(String birthday) {
		this.birthday = birthday;
	}

	public int getGscore() {
		return gscore;
	}

	public void setGscore(int gscore) {
		this.gscore = gscore;
	}

	public int getGender() {
		return gender;
	}

	public void setGender(int gender) {
		this.gender = gender;
	}

	public int getWeight() {
		return weight;
	}

	public void setWeight(int weight) {
		this.weight = weight;
	}

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}
	
	@Override
	public String toString() {
		return "TestEntry" + "\nbirthday:"+getBirthday() + "\nGender:" + getGender() + "\nscore:" + getGscore() + "\ntoken:" + getToken() + "\nweight:" + getWeight();
	}
}
