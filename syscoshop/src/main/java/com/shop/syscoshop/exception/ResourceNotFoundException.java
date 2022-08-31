package com.shop.syscoshop.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.util.UUID;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class ResourceNotFoundException extends RuntimeException{
    private final String resourceName;
    private final String fieldName;
    private final UUID fieldValue;

    public ResourceNotFoundException(String resourceName, String fieldName, UUID fieldValue){
        super(String.format("%s not found with %s: %s", resourceName, fieldName, fieldValue));
        this.resourceName = resourceName;
        this.fieldName = fieldName;
        this.fieldValue = fieldValue;
    }

    public String getResoureField() {
        return resourceName;
    }

    public String getFieldName() {
        return fieldName;
    }

    public UUID getFieldValue() {
        return fieldValue;
    }
}
