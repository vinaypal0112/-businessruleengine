package com.ikea.inventory.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import java.util.List;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "inventory"
})
public class Inventory {

    @JsonProperty("inventory")
    private List<InventoryDetail> inventory = null;

    @JsonProperty("inventory")
    public List<InventoryDetail> getInventory() {
        return inventory;
    }

    @JsonProperty("inventory")
    public void setInventory(List<InventoryDetail> inventory) {
        this.inventory = inventory;
    }
}