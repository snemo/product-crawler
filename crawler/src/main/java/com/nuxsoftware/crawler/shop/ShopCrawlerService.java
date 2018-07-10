package com.nuxsoftware.crawler.shop;

import com.nuxplanet.shared.product.ProductDto;
import com.nuxsoftware.crawler.integration.IntegrationFacade;
import org.springframework.stereotype.Service;

@Service
class ShopCrawlerService {

    private final IntegrationFacade integrationFacade;

    public ShopCrawlerService(IntegrationFacade integrationFacade) {
        this.integrationFacade = integrationFacade;
    }

    void crawl(String url) {
        integrationFacade.process(ProductDto.builder().name("dsdsd").build());

        try {
            new ShopCrawlerExecutor(url, integrationFacade).execute();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
