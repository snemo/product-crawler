package com.nuxsoftware.crawler.integration;

import com.nuxplanet.shared.product.ProductDto;
import org.springframework.stereotype.Component;

@Component
public class IntegrationFacade {

    private final IntegrationService integrationService;

    public IntegrationFacade(IntegrationService integrationService) {
        this.integrationService = integrationService;
    }

    public void process(ProductDto product) {
        integrationService.process(product);
    }
}
