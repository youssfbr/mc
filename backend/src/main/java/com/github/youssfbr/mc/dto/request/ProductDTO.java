package com.github.youssfbr.mc.dto.request;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.github.youssfbr.mc.entities.Category;
import com.github.youssfbr.mc.entities.OrderItem;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import java.util.Set;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ProductDTO {

    private Long id;

    @NotEmpty
    @Size(min = 2, max = 40)
    private String name;

    private Double price;

    @JsonIgnore
    private Set<Category> categories;

    @JsonIgnore
    private Set<OrderItem> orderItems;

}
