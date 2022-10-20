package com.github.youssfbr.mc.mappers;

import com.github.youssfbr.mc.dto.request.CategoryAllDTO;
import com.github.youssfbr.mc.dto.request.CategoryDTO;
import com.github.youssfbr.mc.entities.Category;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface CategoryMapper {

    CategoryMapper INSTANCE = Mappers.getMapper(CategoryMapper.class);

    Category toModel(CategoryDTO categoryDto);

    CategoryDTO toDto(Category category);

    CategoryAllDTO allToDto(Category category);

}
