package com.admin.common.validation;

import org.springframework.validation.BindingResult;


public interface Validator<T> {

	void validate(T target, BindingResult result);

}
