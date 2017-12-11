package com.technical.evaluation.domain;

import java.util.Arrays;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonValue;
@JsonFormat(shape = JsonFormat.Shape.OBJECT)
public enum Gender {
	MALE("M"),FEMALE("F");
	
	private String value;

	Gender(String value) {
		this.setValue(value);
	}

	@JsonValue
	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}
	
	public static Gender fromValue(String value) {
		for (Gender gender : values()) {
			if (gender.value.equalsIgnoreCase(value)) {
				return gender;
			}
		}
		throw new IllegalArgumentException(
				"Unknown enum type " + value + ", Allowed values are " + Arrays.toString(values()));
	}
	
}
