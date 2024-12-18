package org.api.productcatalogservice.controller.apiFakeStore;

import org.api.productcatalogservice.model.Product;
import org.api.productcatalogservice.repo.ProductRepo;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


/**
 * @author yogeshjoga
 */

@RestController
@RequestMapping("/catageory")
public class CatageoryController {

    ProductRepo repo = new ProductRepo();

    @GetMapping("/all_catageories")
    public List<Product> getAllCatageoryProducts() {
        return repo.add();
    }


//    @GetMapping("{name}")
//    public List<Product> getCatageoryProductsByCategory(@PathVariable("name") String category) {
//        List<Product> result = new ArrayList<>();
//        List<Product> list = repo.add();
//        for(Product p: list) {
//            if(p.getCatageoryType().toString().equalsIgnoreCase(category)) {
//                result.add(p);
//            }
//        }
//        return result;
//    }





}