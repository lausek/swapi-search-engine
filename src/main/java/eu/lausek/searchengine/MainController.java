package eu.lausek.searchengine;

import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.ObjectMapper;
import eu.lausek.searchengine.model.*;
import eu.lausek.searchengine.model.swapi.*;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.util.DefaultUriBuilderFactory;
import org.springframework.web.util.UriBuilder;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.HashMap;
import java.util.Map;

@Controller
public class MainController {
    public final String STARWARS_API_BASE = "https://swapi.dev/api/";

    @GetMapping("/")
    public String index() {
        return "index";
    }

    @GetMapping("/search")
    public ModelAndView search(
            @RequestParam("query") String query,
            @RequestParam("area") SearchArea searchArea
    ) throws Exception {
        // build the api uri to call.
        // - `searchArea` is a path component like `/api/people/...`
        // - `search` is a parameter containing the keywords to take into account like `?search=luke`
        UriBuilder builder = new DefaultUriBuilderFactory(STARWARS_API_BASE).builder();
        builder.path(searchArea.toString().toLowerCase() + "/");
        builder.queryParam("search", query);
        URI uri = builder.build();

        // fetch the generated uri and check operation status (statusCode = 200)
        System.out.println(uri);
        HttpRequest httpRequest = HttpRequest.newBuilder().uri(uri).build();
        HttpClient client = HttpClient.newHttpClient();
        HttpResponse<String> response = client.send(httpRequest, HttpResponse.BodyHandlers.ofString());

        System.out.println(response.statusCode());
        if(response.statusCode() != 200) {
            throw new Exception("invalid request");
        }

        System.out.println(response.body());
        ObjectMapper mapper = new ObjectMapper();

        // which class is expected to be in the `results` attribute?
        Class inner = null;
        switch(searchArea) {
            case FILMS:
                inner = Film.class;
                break;
            case PEOPLE:
                inner = Person.class;
                break;
            case PLANETS:
                inner = Planet.class;
                break;
            case SPECIES:
                inner = Species.class;
                break;
            case STARSHIPS:
                inner = Starship.class;
                break;
            case VEHICLES:
                inner = Vehicle.class;
                break;
        }
        JavaType ty = mapper.getTypeFactory().constructParametricType(SwapiResult.class, inner);
        // use generic deserialization
        SwapiResult<Person> swapiResult = mapper.readValue(response.body(), ty);
        System.out.println(swapiResult.results);

        // pass retrieved data back to search engine overview
        Map<String, Object> model = new HashMap<>();
        model.put("entries", swapiResult.results);
        return new ModelAndView("index", model);
    }
}
