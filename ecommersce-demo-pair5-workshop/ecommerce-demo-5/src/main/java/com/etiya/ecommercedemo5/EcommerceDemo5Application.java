package com.etiya.ecommercedemo5;

import com.etiya.ecommercedemo5.business.constants.Messages;
import com.etiya.ecommercedemo5.core.util.exceptions.BusinessException;
import com.etiya.ecommercedemo5.core.util.results.DataResult;
import com.etiya.ecommercedemo5.core.util.results.ErrorDataResult;
import com.etiya.ecommercedemo5.core.util.results.ErrorResult;
import com.etiya.ecommercedemo5.core.util.results.Result;
import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.http.HttpStatus;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.HashMap;
import java.util.Map;
import java.util.NoSuchElementException;

@SpringBootApplication
@RestControllerAdvice
public class EcommerceDemo5Application {

	public static void main(String[] args) {
		SpringApplication.run(EcommerceDemo5Application.class, args);
	}

	@Bean
	public ModelMapper getModelMapper(){
		return new ModelMapper();
	}


	@ExceptionHandler //400
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	public DataResult handleValidationException(MethodArgumentNotValidException exception) {
		//TODO: ErrorDataResult olarak ilgili hataları döndür.
		Map<String, String> errors = new HashMap<>();
		for (FieldError fieldError : exception.getBindingResult().getFieldErrors()) {
			errors.put(fieldError.getField(), fieldError.getDefaultMessage());
		}
		return new ErrorDataResult(errors, Messages.Exception.validationException);
	}
	@ExceptionHandler //500 hatası
	@ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
	public ErrorDataResult<Object> handleBusinessException(BusinessException exception) {
		return  new ErrorDataResult<>(exception.getMessage(),exception.getLocalizedMessage());
	}

	@ExceptionHandler  //400
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	public Result HttpMessagesNotReadableException(HttpMessageNotReadableException exception){
		return new ErrorResult(Messages.Exception.badRequest);
	}

	@ExceptionHandler //500
	@ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
	public Result HttpMessagesNotReadableException(NoSuchElementException exception){
		return new ErrorResult(Messages.Exception.badRequest);
	}

	@ExceptionHandler //500
	@ResponseStatus(HttpStatus.NOT_FOUND)
	public Result NotFoundException(ChangeSetPersister.NotFoundException exception){
		return new ErrorResult(Messages.Exception.noSuchException);
	}

	// fonksiyon oluştur => @ExeptionHandler ile handler olduğunu söyle
	// =>Parametre olarak yakalayacağı exeption türünü ver.
}


