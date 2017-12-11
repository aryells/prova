package com.technical.evaluation.domain.converter;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;

import com.technical.evaluation.domain.Status;

@Converter
public class StatusConverter implements AttributeConverter<Status, String> {

	@Override
	public String convertToDatabaseColumn(Status status) {
		if(Status.UNMARRIED.equals(status)) {
			return Status.UNMARRIED.getValue();
		} else if(Status.MARRIED.equals(status)) {
			return Status.MARRIED.getValue();
		} else if(Status.DIVORCED.equals(status)) {
			return Status.DIVORCED.getValue();
		} else if(Status.WIDOW.equals(status)) {
			return Status.WIDOW.getValue();
		}
		throw new IllegalArgumentException("Unknown" + status);
	}

	@Override
	public Status convertToEntityAttribute(String statusValue) {
		if(Status.UNMARRIED.getValue().equals(statusValue)) {
			return Status.UNMARRIED;
		} else if(Status.MARRIED.getValue().equals(statusValue)) {
			return Status.MARRIED;
		} else if(Status.DIVORCED.getValue().equals(statusValue)) {
			return Status.DIVORCED;
		} else if(Status.WIDOW.getValue().equals(statusValue)) {
			return Status.WIDOW;
		}
		throw new IllegalArgumentException("Unknown" + statusValue);
	}
	
}
