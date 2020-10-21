package eu.lausek.searchengine.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Species {
    @JsonProperty
    public String name;
    @JsonProperty
    public String url;
}
