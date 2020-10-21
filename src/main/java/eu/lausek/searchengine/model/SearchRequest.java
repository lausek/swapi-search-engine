package eu.lausek.searchengine.model;

public class SearchRequest {
    private SearchArea searchArea;
    private String input;

    public String getInput() {
        return input;
    }

    public void setInput(String input) {
        this.input = input;
    }

    public SearchArea getSearchArea() {
        return searchArea;
    }

    public void setSearchArea(SearchArea searchArea) {
        this.searchArea = searchArea;
    }
}
