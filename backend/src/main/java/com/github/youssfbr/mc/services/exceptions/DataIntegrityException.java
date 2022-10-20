package com.github.youssfbr.mc.services.exceptions;

import java.io.Serial;

public class DataIntegrityException extends RuntimeException {

    @Serial
    private static final long serialVersionUID = 1L;

    public DataIntegrityException(String message) {
        super(message);
    }

}
