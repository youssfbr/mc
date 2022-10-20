package com.github.youssfbr.mc.resources.exceptions;

import lombok.*;
import org.springframework.http.HttpStatus;

import java.io.Serial;
import java.io.Serializable;
import java.time.Instant;
import java.util.Arrays;
import java.util.List;

@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ValidationMessageError implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    private Instant timeStamp = Instant.now();
    private Integer statusCod = HttpStatus.BAD_REQUEST.value();
    private HttpStatus status = HttpStatus.BAD_REQUEST;
    private List<String> errors;

    public ValidationMessageError(List<String> errors) {
        this.errors = errors;
    }

    public ValidationMessageError(String message) {
        this.errors = Arrays.asList(message);
    }

}
