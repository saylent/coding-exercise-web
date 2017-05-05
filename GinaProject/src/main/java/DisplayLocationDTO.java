import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class DisplayLocationDTO {

	@JsonProperty("city")
	public String city;

	@JsonProperty("state")
	public String state;

}