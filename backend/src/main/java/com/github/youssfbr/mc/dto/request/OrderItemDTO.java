package com.github.youssfbr.mc.dto.request;

import com.github.youssfbr.mc.entities.OrderItemPK;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class OrderItemDTO {

    private OrderItemPK id;

    private Double discount;

    private Integer quantity;

    private Double price;

}
