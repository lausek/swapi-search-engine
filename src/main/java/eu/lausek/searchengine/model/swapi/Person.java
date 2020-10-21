package eu.lausek.searchengine.model.swapi;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Person extends GenericAttributes {
    @JsonProperty
    public String name;
    @JsonProperty("birth_year")
    public String birthYear;
    @JsonProperty
    public String gender;
    @JsonProperty
    public String height;
    @JsonProperty
    public String mass;
    @JsonProperty("skin_color")
    public String skinColor;
    @JsonProperty
    public String url;
}
