package com.github.youssfbr.mc.dto.request;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import java.io.Serial;
import java.io.Serializable;
import java.util.Set;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ProductDTO implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    private Long id;

    @NotEmpty
    @Size(min = 2, max = 40)
    private String name;

    private Double price;

    @JsonIgnore
    private Set<CategoryDTO> categories;

    @JsonIgnore
    private transient Set<OrderItemDTO> orderItems;

}
