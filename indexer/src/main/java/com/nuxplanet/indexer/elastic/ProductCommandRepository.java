package com.nuxplanet.indexer.elastic;

import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

interface ProductCommandRepository extends ElasticsearchRepository<ProductCommand, String> {
}
