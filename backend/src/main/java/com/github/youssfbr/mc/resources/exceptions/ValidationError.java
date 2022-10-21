package com.github.youssfbr.mc.resources.exceptions;

import lombok.*;

import java.io.Serial;
import java.io.Serializable;
import java.time.Instant;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
public class ValidationError extends StandardError implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    private final List<FieldMessage> errors = new ArrayList<>();

    public ValidationError(Instant timeStamp, Integer status, String error, String message, String path) {
        super(timeStamp, status, error, message, path);
    }

    public void addError(String fieldName, String message) {
        errors.add(new FieldMessage(fieldName, message));
    }

}
