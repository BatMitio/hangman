package bg.mg.tutorials.spring.api;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import bg.mg.tutorials.spring.entity.Country;
import bg.mg.tutorials.spring.repository.CountriesRepository;

//@Component
//@Service
//@Repository
//@Controller
@RestController
public class CountriesApi {
  
  @Autowired
  private CountriesRepository countriesRepository;
  
//  @RequestMapping(value = "/api/countries", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
  @GetMapping(value = "/api/countries", produces = MediaType.APPLICATION_JSON_VALUE)
  public ResponseEntity<Collection<Country>> list() {
    return ResponseEntity.ok(countriesRepository.getCountries());
  }
  
  @PostMapping(value = "/api/countries", consumes = MediaType.APPLICATION_JSON_VALUE)
  public void addCountry(@RequestBody Country country) {
    countriesRepository.addCountry(country);
  }
  
  @GetMapping(value = "/api/country", produces = MediaType.APPLICATION_JSON_VALUE)
  public ResponseEntity<Country> randomCountry() {
    List<Country> countries = new ArrayList<>();
    countries.addAll(countriesRepository.getCountries());
    Collections.shuffle(countries);
    return ResponseEntity.ok(countries.get(0));
  }
}
