package eu.lausek.searchengine.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public class SwapiResult<T> {
    @JsonProperty
    public int count;
    @JsonProperty
    public List<T> results;
}
