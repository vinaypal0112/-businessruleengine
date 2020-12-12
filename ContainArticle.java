package com.ikea.inventory.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "art_id",
        "amount_of"
})
public class ContainArticle {

    @JsonProperty("art_id")
    private String artId;
    @JsonProperty("amount_of")
    private String amountOf;

    @JsonProperty("art_id")
    public String getArtId() {
        return artId;
    }

    @JsonProperty("art_id")
    public void setArtId(String artId) {
        this.artId = artId;
    }

    @JsonProperty("amount_of")
    public String getAmountOf() {
        return amountOf;
    }

    @JsonProperty("amount_of")
    public void setAmountOf(String amountOf) {
        this.amountOf = amountOf;
    }
}
