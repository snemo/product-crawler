package com.nuxplanet.indexer.elastic;

import com.nuxplanet.shared.product.ProductDto;
import lombok.Builder;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;

@Data
@Builder(toBuilder = true)
@Document(indexName = "crawler", type = "product")
public class ProductCommand {
    @Id private final String id;
    private final String name;

    public static ProductCommand from(ProductDto productDto) {
        return ProductCommand.builder()
                .id(productDto.getId())
                .name(productDto.getName())
                .build();
    }
}
