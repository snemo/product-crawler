package com.nuxsoftware.crawler.integration;

import com.nuxplanet.shared.product.ProductDto;

public interface IntegrationService {

    void process(ProductDto product);
}
