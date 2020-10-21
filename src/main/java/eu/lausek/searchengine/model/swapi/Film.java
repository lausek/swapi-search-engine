package eu.lausek.searchengine.model.swapi;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Film extends GenericAttributes {
    @JsonProperty("title")
    public String name;
    @JsonProperty
    public String director;
    @JsonProperty
    public String producer;
    @JsonProperty("release_date")
    public String releaseDate;
    @JsonProperty
    public String url;
}
