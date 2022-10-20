package com.github.youssfbr.mc.dto.response;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class MessageResponseDTO {

    private Long id;
    private String message;

}
