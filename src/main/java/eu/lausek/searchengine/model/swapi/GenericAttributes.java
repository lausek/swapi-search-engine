package eu.lausek.searchengine.model.swapi;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public abstract class GenericAttributes {
    @JsonProperty
    public List<String> species;
    @JsonProperty
    public List<String> starships;
    @JsonProperty
    public List<String> vehicles;
}
