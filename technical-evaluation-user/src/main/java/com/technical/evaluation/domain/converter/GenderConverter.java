package com.technical.evaluation.domain.converter;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;

import com.technical.evaluation.domain.Gender;

@Converter
public class GenderConverter implements AttributeConverter<Gender, String> {

	@Override
	public String convertToDatabaseColumn(Gender gender) {
		if(Gender.MALE.equals(gender)) {
			return Gender.MALE.getValue();
		} else if (Gender.FEMALE.equals(gender)) {
			return Gender.FEMALE.getValue();
		}
		throw new IllegalArgumentException("Unknown" + gender);
	}

	@Override
	public Gender convertToEntityAttribute(String genderValue) {
		if(Gender.MALE.getValue().equals(genderValue)) {
			return Gender.MALE;
		} else if (Gender.FEMALE.getValue().equals(genderValue)) {
			return Gender.FEMALE;
		}
		throw new IllegalArgumentException("Unknown" + genderValue);
	}

}
