package com.nuxsoftware.crawler.shop;

import org.springframework.stereotype.Component;

@Component
public class ShopCrawlerFacade {

    private final ShopCrawlerService shopCrawlerService;

    public ShopCrawlerFacade(ShopCrawlerService shopCrawlerService) {
        this.shopCrawlerService = shopCrawlerService;
    }

    public void crawl(String url) {
        shopCrawlerService.crawl(url);
    }
}
