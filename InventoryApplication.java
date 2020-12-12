package com.ikea.inventory;

import com.ikea.inventory.model.ContainArticle;
import com.ikea.inventory.model.Product;
import com.ikea.inventory.service.ProductService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
public class InventoryApplication {

    public static void main(String[] args) throws Exception {
        SpringApplication.run(InventoryApplication.class, args);
        ProductService service = new ProductService();
        try {
            /*
                Functionality 1
                Get all products and quantity of each that is an available with the current inventory
             */
            List<Product> productList = service.getProducts();
            if(productList != null && !productList.isEmpty()){
                productList.forEach(product -> {
                    System.out.println("Product: " + product.getName());
                    product.getContainArticles().forEach(containArticle -> {
                        System.out.println("Quantity of articleId:" + containArticle.getArtId() + " is " + containArticle.getAmountOf());
                    });
                });
            }

             /*
                Functionality 2
                Get all products and quantity of each that is an available with the current inventory
             */
            Product product = service.createProduct();
            service.sellProduct(product);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
