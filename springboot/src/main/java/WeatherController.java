import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

public class WeatherController {
  @Autowired
  private  WeatherService weatherService;
  @GetMapping("/weather")
  public String getWeather(@RequestParam(name="city",required = false,defaultValue = "Newyork") String city, Model model){
    String weatherData=weatherService.getWeather(city);
    model.addAttribute("weatherData",weatherData);
    model.addAttribute("city",city);
    return  "weather";
  }
}
