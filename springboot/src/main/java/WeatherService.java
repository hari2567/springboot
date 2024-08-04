import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;
@Service
public class WeatherService {
  @Value("${weatherstack.api.key}")
  private String apiKey;
  private  static final String WEATHER_API_URL="https://api.weatherstack.com/current";
  public String getWeather(String city){
    RestTemplate restTemplate=new RestTemplate();
    UriComponentsBuilder uriBuilder=UriComponentsBuilder.fromHttpUrl(WEATHER_API_URL)
      .queryParam("access_key",apiKey)
      .queryParam("query",city);
    return restTemplate.getForObject(uriBuilder.toUriString(),String.class);

  }
}
