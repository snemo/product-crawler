package com.nuxsoftware.crawler.shop;

import com.nuxsoftware.crawler.integration.IntegrationFacade;
import edu.uci.ics.crawler4j.crawler.CrawlConfig;
import edu.uci.ics.crawler4j.crawler.CrawlController;
import edu.uci.ics.crawler4j.fetcher.PageFetcher;
import edu.uci.ics.crawler4j.robotstxt.RobotstxtConfig;
import edu.uci.ics.crawler4j.robotstxt.RobotstxtServer;

class ShopCrawlerExecutor {

    private final String url;
    private final IntegrationFacade integrationFacade;

    public ShopCrawlerExecutor(String url, IntegrationFacade integrationFacade) {
        this.url = url;
        this.integrationFacade = integrationFacade;
    }

    public void execute() throws Exception {
        String crawlStorageFolder = "/Users/oleciwoj/Projects/product-crawler/crawler/data";
        int numberOfCrawlers = 2;

        CrawlConfig config = new CrawlConfig();
        config.setCrawlStorageFolder(crawlStorageFolder);
        config.setPolitenessDelay(400);

        /*
         * Instantiate the controller for this crawl.
         */
        PageFetcher pageFetcher = new PageFetcher(config);
        RobotstxtConfig robotstxtConfig = new RobotstxtConfig();
        RobotstxtServer robotstxtServer = new RobotstxtServer(robotstxtConfig, pageFetcher);
        CrawlController controller = new CrawlController(config, pageFetcher, robotstxtServer);
        ShopCrawlerFactory factory = new ShopCrawlerFactory(integrationFacade);

        /*
         * For each crawl, you need to add some seed urls. These are the first
         * URLs that are fetched and then the crawler starts following links
         * which are found in these pages
         */
        controller.addSeed("https://www.eltrex.net.pl/");


        /*
         * Start the crawl. This is a blocking operation, meaning that your code
         * will reach the line after this only when crawling is finished.
         */
        controller.startNonBlocking(factory, numberOfCrawlers);
    }
}
