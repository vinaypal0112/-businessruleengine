package com.ikea.inventory.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.ikea.inventory.InventoryApplication;
import com.ikea.inventory.model.*;
import org.springframework.web.client.HttpServerErrorException;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ProductService {

    private final String Inventory_File_URL = "file:C:\\\\project\\\\ikea-inventory\\\\src\\\\main\\\\resources\\\\inventory\\\\inventory.json";
    private final String Inventory_File_Path = "C:\\\\project\\\\ikea-inventory\\\\src\\\\main\\\\resources\\\\inventory\\\\inventory.json";
    private final String Products_File_URL = "file:C:\\\\project\\\\ikea-inventory\\\\src\\\\main\\\\resources\\\\inventory\\\\products.json";

    private Logger logger
            = Logger.getLogger(
            InventoryApplication.class.getName());

    public List<Product> getProducts() throws IOException{
        ObjectMapper objectMapper = new ObjectMapper();
        Products products = objectMapper.readValue(new URL(Products_File_URL), Products.class);
        return products.getProducts();
    }

    public Inventory sellProduct(Product product) throws Exception {
        ObjectMapper objectMapper = new ObjectMapper();
        if(product != null) {
            Inventory inventory = objectMapper.readValue(new URL(Inventory_File_URL), Inventory.class);
            List<InventoryDetail> inventoryDetailList = new ArrayList<>();
            if (inventory != null) {
                inventory.getInventory().forEach(inventoryDetail -> {
                    product.getContainArticles().forEach(containArticle -> {
                            if (containArticle.getArtId().equals(inventoryDetail.getArtId())) {
                                int inventoryStock = Integer.valueOf(inventoryDetail.getStock());
                                int articleAmount = Integer.valueOf(containArticle.getAmountOf());
                                if(inventoryStock >= articleAmount) {
                                    inventoryDetail.setStock(String.valueOf(inventoryStock - articleAmount));
                                }else{
                                    logger.log(Level.SEVERE, "Article : " + containArticle.getArtId() + " not available");
                                }
                            }
                    });
                    inventoryDetailList.add(inventoryDetail);
                    inventory.setInventory(inventoryDetailList);
                });
                objectMapper.enable(SerializationFeature.INDENT_OUTPUT);
                objectMapper.writeValue(new File(Inventory_File_Path), inventory);
            }
        }
        return objectMapper.readValue(new URL(Inventory_File_URL), Inventory.class);
    }

    public Product createProduct(){
        Product product = new Product();
        product.setName("Dining Chair");
        List<ContainArticle> containArticleList = new ArrayList<ContainArticle>(2);
        ContainArticle containArticleOne = new ContainArticle();
        containArticleOne.setArtId("1");
        containArticleOne.setAmountOf("4");
        ContainArticle containArticleTwo = new ContainArticle();
        containArticleTwo.setArtId("2");
        containArticleTwo.setAmountOf("4");
        containArticleList.add(containArticleOne);
        containArticleList.add(containArticleTwo);
        product.setContainArticles(containArticleList);
        return  product;
    }

}
