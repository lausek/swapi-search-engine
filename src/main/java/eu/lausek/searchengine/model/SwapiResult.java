package eu.lausek.searchengine.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public class SwapiResult<T> {
    @JsonProperty
    public int count;

    // according to the swapi docs, the elements of `results` differ in
    // their type. we can achieve more flexibility here by using type arguments
    // when deserializing.
    @JsonProperty
    public List<T> results;
}
