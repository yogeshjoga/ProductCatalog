package org.api.productcatalogservice.demo.controller;


import org.api.productcatalogservice.demo.model.Product;
import org.api.productcatalogservice.demo.repo.ProductRepo;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@RequestMapping("products")
public class ProductController {

    ProductRepo repo = new ProductRepo();
    ArrayList<Product> list = repo.add();



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

}
