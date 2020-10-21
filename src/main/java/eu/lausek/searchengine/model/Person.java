package eu.lausek.searchengine.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Person {
    @JsonProperty
    public String name;
    @JsonProperty
    public List<String> species;
    @JsonProperty
    public List<String> starships;
    @JsonProperty
    public String url;
    @JsonProperty
    public List<String> vehicles;
}
