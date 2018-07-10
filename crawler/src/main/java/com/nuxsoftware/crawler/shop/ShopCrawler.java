package com.nuxsoftware.crawler.shop;

import com.nuxplanet.shared.product.ProductDto;
import com.nuxsoftware.crawler.integration.IntegrationFacade;
import edu.uci.ics.crawler4j.crawler.Page;
import edu.uci.ics.crawler4j.crawler.WebCrawler;
import edu.uci.ics.crawler4j.parser.HtmlParseData;
import edu.uci.ics.crawler4j.url.WebURL;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Optional;
import java.util.regex.Pattern;

public class ShopCrawler extends WebCrawler {

    private static final Logger log = LoggerFactory.getLogger(ShopCrawler.class);

    private final IntegrationFacade integrationFacade;

    public static final String NAME_XPATH = "#product-container > div > div.product-right > div > h1";

    private static final Pattern FILTERS = Pattern.compile(
            ".*(\\.(css|js|mid|mp2|mp3|mp4|json|wav|avi|flv|mov|mpeg|ram|m4v|pdf" +
                    "|rm|smil|wmv|swf|wma|zip|rar|gz))$");

    private final String shopUrl = "https://www.eltrex.net.pl/";

    public ShopCrawler(IntegrationFacade integrationFacade) {
        this.integrationFacade = integrationFacade;
    }

    @Override
    public boolean shouldVisit(Page referringPage, WebURL url) {
        String href = url.getURL().toLowerCase();
        return !FILTERS.matcher(href).matches()
                && href.startsWith(shopUrl) && href.endsWith(".html");
    }

    @Override
    public void visit(Page page) {
        String url = page.getWebURL().getURL();
        log.info("Processing page: "+url, url);

        if (page.getParseData() instanceof HtmlParseData) {
            HtmlParseData htmlParseData = (HtmlParseData) page.getParseData();

            parseProduct(Jsoup.parseBodyFragment(htmlParseData.getHtml()))
                    .ifPresent(integrationFacade::process);
        }
    }

    private Optional<ProductDto> parseProduct(Document doc) {
        return getElement(doc, NAME_XPATH)
                .map(name -> ProductDto.builder()
                        .name(name)
                        .build());
    }

    private Optional<String> getElement(Document doc, String xpath) {
        return Optional.ofNullable(doc.selectFirst(xpath))
                .map(Element::text);
    }
}
