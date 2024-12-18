package org.api.productcatalogservice.controller.apiFakeStore;


import org.api.productcatalogservice.exceptions.IdNotFoundException;
import org.api.productcatalogservice.model.Product;
import org.api.productcatalogservice.repo.ProductRepo;
import org.api.productcatalogservice.service.IProductService;
import org.api.productcatalogservice.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@RequestMapping("products")
public class ProductController {

    ProductRepo repo = new ProductRepo();
    ArrayList<Product> list = repo.add();
    @Autowired
    private ProductService productService;


    @GetMapping  ("/log")
    public String logPrinting() {
        return "All products";
    }

    @GetMapping  ("/all_products")
    public ArrayList<Product> getAllProducts() {
        return list;
    }

    @GetMapping("{product_id}")
    public Product getProduct(@PathVariable("product_id") Long id) {
        for(Product p : list){
            if(p.getId() == id){
                return p;
            }
        }
        return null;
    }

    @PostMapping("/add_new_product")
    public Product addNewProduct(@RequestBody Product p) {
        ProductRepo repo = new ProductRepo();
        repo.addNewProduct(p);
        return p;
    }


    @Autowired
    IProductService service;
    /**
     * Integration 3rd party api into our app
     * here we use fakestoreapi apis
     */
    MultiValueMap<String, String> headers = null;

    @GetMapping("/product_by_id/{id}")
    public ResponseEntity<Product> getProductById(@PathVariable("id") Long id) throws IdNotFoundException {
        headers = new LinkedMultiValueMap<>();
        try{
            if(id <= 0){
                headers.add("Its not allowed", "Due to invalid id");
                throw new IdNotFoundException("Your Id is invalid or Not_Found");
              //  return new ResponseEntity<>(null,headers, HttpStatus.NOT_FOUND);
            }else if(id > 20){
                headers.add("Its not allowed", "Due to invalid id");
                throw new IdNotFoundException("Your Product ID is More then our product total list count!");
            }

            Product  product = productService.getProductById(id);

            if(product == null){
                headers.add("Its not allowed", "Due to invalid id");
                throw new IdNotFoundException("OOPS! Product not found");
            }
            return new ResponseEntity<>(product, headers, HttpStatus.OK);

        }catch (IdNotFoundException e){
            throw e;
        }

    }


    @PutMapping("/update/{id}")
    public ResponseEntity<Product> updateProduct(@PathVariable("id") Long id, @RequestBody Product p) {
        if(id <= 0){
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }else if(service.isProductExist(id,p)){
           return new ResponseEntity<>(p, HttpStatus.OK);
        }
        return new ResponseEntity<>(null, HttpStatus.NOT_ACCEPTABLE);
    }

}
