package com.github.youssfbr.mc.dto.request;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CategoryAllDTO {

    private Long id;

    @NotEmpty
    @Size(min = 2, max = 40)
    private String name;

    @JsonIgnore
    private List<ProductDTO> products;

}
