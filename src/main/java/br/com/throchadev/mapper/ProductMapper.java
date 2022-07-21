package br.com.throchadev.mapper;

import br.com.throchadev.dto.ProductDto;
import br.com.throchadev.entity.Product;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValuePropertyMappingStrategy;

@Mapper(
        componentModel = "cdi",
        nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
public interface ProductMapper {
    ProductDto toProductDto(Product product);
    Product toProduct(ProductDto productDto);
    @Mapping(target = "id", ignore = true)
    void merge(@MappingTarget Product target, Product source);
}
