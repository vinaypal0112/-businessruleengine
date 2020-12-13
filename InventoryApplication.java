package com.ikea.inventory;

import com.ikea.inventory.model.Product;
import com.ikea.inventory.service.ProductService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.logging.Level;
import java.util.logging.Logger;

import java.io.IOException;
import java.util.List;

@SpringBootApplication
public class InventoryApplication {

    public static void main(String[] args) throws Exception {
        SpringApplication.run(InventoryApplication.class, args);
        ProductService service = new ProductService();
        Logger logger
                = Logger.getLogger(
                InventoryApplication.class.getName());
        try {
            /*
                Get all products and quantity of each article that available with the current inventory
             */
            List<Product> productList = service.getProducts();
            if(productList != null && !productList.isEmpty()){
                productList.forEach(product -> {
                    logger.log(Level.INFO, "Product: " + product.getName());
                    product.getContainArticles().forEach(containArticle -> {
                        logger.log(Level.INFO, "Quantity of articleId:" + containArticle.getArtId() + " is " + containArticle.getAmountOf());
                    });
                });
            }

             /*
                Sell a product and update the inventory accordingly
             */
            Product product = service.createProduct();
            service.sellProduct(product);
        } catch (Exception e) {
            logger.log(Level.SEVERE, e.getMessage());
        }
    }

}
