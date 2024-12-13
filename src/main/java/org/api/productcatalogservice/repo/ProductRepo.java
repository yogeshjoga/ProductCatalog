package org.api.productcatalogservice.repo;

import org.api.productcatalogservice.model.Product;
import org.api.productcatalogservice.util.CatageoryType;
import org.api.productcatalogservice.util.State;

import java.util.ArrayList;

public class ProductRepo {

    ArrayList<Product> list = new ArrayList<>();

    public  ArrayList<Product> add(){
        for( int i=0; i<=10; i++){
            Product p = new Product();
            p.setId(1L+i);
            p.setName("Product "+i);
            p.setDescription("Description "+i);
            p.setOwner("Owner"+i);
            p.setState(State.ACTIVE);
            p.setImageUrl("Proucts imageurl "+i);
            p.setPrice(000000123D + i);
            if((i&1) == 0){
                p.setCatageoryType(CatageoryType.BIOMETRIC);
            }else{
                p.setCatageoryType(CatageoryType.ELECTRONIC);
            }
            list.add(p);
        }
        return list;
    }

    public boolean addNewProduct(Product p){
        if(p == null){
            return false;
        }
        list.add(p);

        return true;
    }


}
