package com.nuxplanet.indexer.consumer;

import com.nuxplanet.indexer.elastic.ElasticFacade;
import com.nuxplanet.indexer.elastic.ProductCommand;
import com.nuxplanet.shared.product.ProductDto;
import lombok.AllArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
class KafkaConsumerService implements ConsumerService {

    private static final Logger log = LoggerFactory.getLogger(KafkaConsumerService.class);

    private final ElasticFacade elasticFacade;

    @KafkaListener(topics = "${product.topic.name}", containerFactory = "productKafkaListenerContainerFactory")
    public void greetingListener(ProductDto product) {
        log.info("Recieved product message: {}", product);
        elasticFacade.save(ProductCommand.from(product));
    }

}
