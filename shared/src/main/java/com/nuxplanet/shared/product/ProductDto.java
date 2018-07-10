package com.nuxplanet.shared.product;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Data;

@Data
@Builder(toBuilder = true)
public class ProductDto {
    @JsonProperty("id")
    private final String id;
    @JsonProperty("name")
    private final String name;

    @JsonCreator
    public ProductDto(@JsonProperty("id") String id, @JsonProperty("name") String name) {
        this.id = id;
        this.name = name;
    }
}
