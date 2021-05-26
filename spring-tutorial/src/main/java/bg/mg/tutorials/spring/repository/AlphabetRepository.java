package bg.mg.tutorials.spring.repository;

import java.util.Arrays;
import java.util.List;
import org.springframework.stereotype.Repository;

@Repository
public class AlphabetRepository {
  public List<String> getEnglishAlphabet() {
    return Arrays.asList("A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L", "M", "N", "O",
        "P", "Q", "R", "S", "T", "U", "V", "W", "X", "Y", "Z");
  }

  public List<String> getBulgarianAlphabet() {
    return Arrays.asList("А", "Б", "В", "Г", "Д", "Е", "Ж", "З", "И", "Й", "К", "Л", "М", "Н", "О",
        "П", "Р", "С", "Т", "У", "Ф", "Х", "Ц", "Ч", "Ш", "Щ", "Ъ", "Ь", "Ю", "Я");
  }
}
