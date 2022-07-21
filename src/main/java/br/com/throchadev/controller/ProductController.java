package br.com.throchadev.controller;

import br.com.throchadev.dto.ProductDto;
import br.com.throchadev.service.ProductService;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;
import java.util.Optional;

@Path("/v1/product")
@ApplicationScoped
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class ProductController {

    @Inject
    private ProductService productService;

    @GET
    public List<ProductDto> getAllProducts() {
        return productService.getAllProducts();
    }

    @POST
    public void createProduct(ProductDto productDto){
        productService.createProduct(productDto);
    }

    @PUT
    @Path("{id}")
    public Optional<ProductDto> updateProduct(@PathParam("id") Long id, ProductDto productDto){
        Optional<ProductDto> product = productService.updateProduct(id, productDto);
        if (product.isPresent()){
            return product;
        } else {
            throw new NotFoundException();
        }
    }

    @DELETE
    @Path("{id}")
    public Optional<String> deleteProduct(@PathParam("id") Long id){
        Optional<String> optional = productService.deleteProduct(id);
        if (optional.isPresent()){
            return optional;
        } else {
            throw new NotFoundException();
        }
    }
}
