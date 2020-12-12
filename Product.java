package com.ikea.inventory.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import java.util.List;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "name",
        "contain_articles"
})
public class Product {

    @JsonProperty("name")
    private String name;
    @JsonProperty("contain_articles")
    private List<ContainArticle> containArticles = null;

    @JsonProperty("name")
    public String getName() {
        return name;
    }

    @JsonProperty("name")
    public void setName(String name) {
        this.name = name;
    }

    @JsonProperty("contain_articles")
    public List<ContainArticle> getContainArticles() {
        return containArticles;
    }

    @JsonProperty("contain_articles")
    public void setContainArticles(List<ContainArticle> containArticles) {
        this.containArticles = containArticles;
    }
}
