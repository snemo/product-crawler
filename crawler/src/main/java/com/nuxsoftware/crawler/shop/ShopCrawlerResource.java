package com.nuxsoftware.crawler.shop;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/crawler/shop")
class ShopCrawlerResource {

    private final ShopCrawlerFacade facade;

    public ShopCrawlerResource(ShopCrawlerFacade facade) {
        this.facade = facade;
    }

    @GetMapping("/crawl")
    public String crawl(@RequestParam String url) {
        facade.crawl(url);
        return url;
    }

}
