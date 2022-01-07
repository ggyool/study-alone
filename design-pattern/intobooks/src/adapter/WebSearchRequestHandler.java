package adapter;

public class WebSearchRequestHandler {

    private SearchService searchService;

    public WebSearchRequestHandler(SearchService searchService) {
        this.searchService = searchService;
    }

    public void request() {
        searchService.search("input");
    }

    public static void main(String[] args) {
        WebSearchRequestHandler webSearchRequestHandler = new WebSearchRequestHandler(
                new SearchServiceTolrAdapter(new TolrClient())
        );

        webSearchRequestHandler.request();
    }
}
