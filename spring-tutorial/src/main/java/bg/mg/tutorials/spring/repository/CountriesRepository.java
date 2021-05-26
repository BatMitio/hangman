package bg.mg.tutorials.spring.repository;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;
import org.springframework.stereotype.Repository;
import bg.mg.tutorials.spring.entity.Country;

@Repository
public class CountriesRepository {
  private Collection<Country> countries = new HashSet<>(
      Set.of(new Country("Австрия"), new Country("Азербайджан"), new Country("Албания"),
          new Country("Андора"), new Country("Армения"), new Country("Беларус"),
          new Country("Белгия"), new Country("Босна и Херцеговина"), new Country("България")));

  public Collection<Country> getCountries() {
    return countries;
  }

  public void setCountries(Collection<Country> countries) {
    this.countries = countries;
  }

  public void addCountry(Country country) {
    this.getCountries().add(country);
  }

}
