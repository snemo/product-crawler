package com.nuxplanet.indexer.elastic;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class ElasticFacade {

    private final ProductCommandService service;

    public void save(ProductCommand product) {
        service.save(product);
    }
}
