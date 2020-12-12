package com.ikea.inventory.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.ikea.inventory.model.*;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

public class ProductService {


    public List<Product> getProducts() throws IOException{
        ObjectMapper objectMapper = new ObjectMapper();
        Products products = objectMapper.readValue(new URL("file:C:\\\\project\\\\ikea-inventory\\\\src\\\\main\\\\resources\\\\inventory\\\\products.json"), Products.class);
        return products.getProducts();
    }

    public void sellProduct(Product product) throws Exception {
        ObjectMapper objectMapper = new ObjectMapper();
        Inventory inventory = objectMapper.readValue(new URL("file:C:\\\\project\\\\ikea-inventory\\\\src\\\\main\\\\resources\\\\inventory\\\\inventory.json"), Inventory.class);
        List<InventoryDetail> inventoryDetailList = new ArrayList<>();
        inventory.getInventory().forEach(inventoryDetail -> {
            product.getContainArticles().forEach(containArticle -> {
                if(containArticle.getArtId().equals(inventoryDetail.getArtId())){
                    inventoryDetail.setStock(String.valueOf(Integer.valueOf(inventoryDetail.getStock()) - Integer.valueOf(containArticle.getAmountOf())));
                }
            });
            inventoryDetailList.add(inventoryDetail);
            inventory.setInventory(inventoryDetailList);
        });
        objectMapper.enable(SerializationFeature.INDENT_OUTPUT);
        objectMapper.writeValue(new File("C:\\\\project\\\\ikea-inventory\\\\src\\\\main\\\\resources\\\\inventory\\\\inventory.json"), inventory);
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
