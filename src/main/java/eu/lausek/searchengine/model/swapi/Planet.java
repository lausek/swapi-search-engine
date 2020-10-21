package eu.lausek.searchengine.model.swapi;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Planet extends GenericAttributes {
    @JsonProperty
    public String name;
    @JsonProperty
    public String url;
}
