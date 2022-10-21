package com.github.youssfbr.mc.resources.exceptions;

import lombok.*;

import java.io.Serial;
import java.io.Serializable;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class FieldMessage implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    private String fieldName;
    private String message;

}
