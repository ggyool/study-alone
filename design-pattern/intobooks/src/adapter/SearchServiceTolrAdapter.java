package adapter;

public class SearchServiceTolrAdapter implements SearchService {

    private TolrClient tolrClient;

    public SearchServiceTolrAdapter(TolrClient tolrClient) {
        this.tolrClient = tolrClient;
    }

    @Override
    public SearchResult search(String keyword) {
        TolrQuery tolrQuery = new TolrQuery(keyword);
        QueryResponse queryResponse = tolrClient.query(tolrQuery);
        return convertToResult(queryResponse);
    }

    private SearchResult convertToResult(QueryResponse queryResponse) {
        return new SearchResult();
    }
}
