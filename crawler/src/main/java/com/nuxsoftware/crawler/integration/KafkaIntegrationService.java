package com.nuxsoftware.crawler.integration;

import com.nuxplanet.shared.product.ProductDto;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
class KafkaIntegrationService implements IntegrationService {
    private static final Logger log = LoggerFactory.getLogger(KafkaIntegrationService.class);

    private final KafkaTemplate<String, ProductDto> productKafkaTemplate;

    public KafkaIntegrationService(KafkaTemplate<String, ProductDto> productKafkaTemplate) {
        this.productKafkaTemplate = productKafkaTemplate;
    }

    @Override
    public void process(ProductDto product) {
        log.info("Processing product to Kafka: {}", product);
        productKafkaTemplate.send("product2", product);
    }
}
