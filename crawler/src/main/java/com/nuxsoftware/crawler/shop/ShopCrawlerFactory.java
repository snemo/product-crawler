package com.nuxsoftware.crawler.shop;

import com.nuxsoftware.crawler.integration.IntegrationFacade;
import edu.uci.ics.crawler4j.crawler.CrawlController;
import edu.uci.ics.crawler4j.crawler.WebCrawler;

class ShopCrawlerFactory implements CrawlController.WebCrawlerFactory {

    private final IntegrationFacade integrationFacade;

    public ShopCrawlerFactory(IntegrationFacade integrationFacade) {
        this.integrationFacade = integrationFacade;
    }

    @Override
    public WebCrawler newInstance() throws Exception {
        return new ShopCrawler(integrationFacade);
    }
}
