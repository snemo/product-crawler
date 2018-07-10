package com.nuxplanet.indexer.elastic;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
class ProductCommandService {

    private final ProductCommandRepository repository;

    public void save(ProductCommand product) {
        repository.save(product);
    }
}
