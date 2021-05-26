package bg.mg.tutorials.spring.api;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import bg.mg.tutorials.spring.repository.AlphabetRepository;

@RestController
@RequestMapping(value = "/api/alphabet")
public class AlphabetApi {

  @Autowired
  private AlphabetRepository alphabetRepository;

  @GetMapping(value = "/{language}", produces = MediaType.APPLICATION_JSON_VALUE)
  public ResponseEntity<List<String>> getAlphabet(
      @PathVariable(value = "language") String language) {
    if (language.toLowerCase().equals("bg")) {
      return ResponseEntity.ok(alphabetRepository.getBulgarianAlphabet());
    } else if (language.toLowerCase().equals("en")) {
      return ResponseEntity.ok(alphabetRepository.getEnglishAlphabet());
    } else {
      return ResponseEntity.badRequest().build();
    }
  }
  
  @GetMapping(value = "/v2/{language}", produces = MediaType.APPLICATION_XML_VALUE)
  public ResponseEntity<List<String>> getAlphabetv2(
      @PathVariable(value = "language") String language) {
    if (language.toLowerCase().equals("bg")) {
      return ResponseEntity.ok(alphabetRepository.getBulgarianAlphabet());
    } else if (language.toLowerCase().equals("en")) {
      return ResponseEntity.ok(alphabetRepository.getEnglishAlphabet());
    } else {
      return ResponseEntity.badRequest().build();
    }
  }
}
