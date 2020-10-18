package com.bankaccount.annotations;

import java.time.LocalDate;
import java.time.ZoneId;
import java.time.temporal.ChronoUnit;
import java.util.Date;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class MinAgeConstraintValidator implements ConstraintValidator<MinAge, Date> {

	private int annotationYear;

	@Override
	public void initialize(MinAge year) {
		this.annotationYear = year.value();
	}

	@Override
	public boolean isValid(Date target, ConstraintValidatorContext cxt) {
		if (target == null) {
			return true;
		}

		LocalDate start = target.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
		LocalDate end = LocalDate.now();

		long age = ChronoUnit.YEARS.between(start, end);

		if (age < this.annotationYear) {
			return false;
		}

		return true;
	}

}