package bg.mg.tutorials.spring.configuration;

import java.util.UUID;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

@Configuration
public class ApplicationConfiguration {
  
  @Bean(name = "staticValue")
  @Scope("singleton")
  public String appName() {
    return UUID.randomUUID().toString();
  }
  
  @Bean(name = "randomString")
  @Scope("prototype")
  public String randomString() {
    return UUID.randomUUID().toString();
  }
  
  @Bean
  public String countryName() {
    return "Bulgaria";
  }
}
