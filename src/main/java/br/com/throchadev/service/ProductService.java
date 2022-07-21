package br.com.throchadev.service;

import br.com.throchadev.dto.ProductDto;
import br.com.throchadev.entity.Product;
import br.com.throchadev.mapper.ProductMapper;
import br.com.throchadev.repository.ProductRepository;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@ApplicationScoped
public class ProductService {

    @Inject
    private ProductRepository productRepository;
    @Inject
    private ProductMapper productMapper;

    public List<ProductDto> getAllProducts(){
        return productRepository
                .listAll()
                .stream()
                .map(product -> productMapper.toProductDto(product))
                .collect(Collectors.toList());
    }

    @Transactional
    public void createProduct(ProductDto productDto) {
        Product product = productMapper.toProduct(productDto);
        productRepository.persist(product);
    }

    @Transactional
    public Optional<ProductDto> updateProduct(Long id, ProductDto productDto) {

        return productRepository
                .findByIdOptional(id)
                .map(productUpdate -> {
                    Product product = productMapper.toProduct(productDto);
                    productMapper.merge(productUpdate, product);
                    return productMapper.toProductDto(product);
                });
    }

    @Transactional
    public Optional<String> deleteProduct(Long id) {
        return productRepository.findByIdOptional(id)
                .map(product -> {
                    productRepository.deleteById(id);
                    return "Product deleted!";
                });
    }
}
