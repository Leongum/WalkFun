import com.usavich.common.logService.LogHelper;
import com.usavich.thirdparty.weather.def.WeatherService;
import org.codehaus.jettison.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.testng.Assert;
import org.testng.annotations.Test;

/**
 * Created with IntelliJ IDEA.
 * User: LeonLu
 * Date: 6/5/13
 * Time: 5:05 PM
 * To change this template use File | Settings | File Templates.
 */
public class TestWeatherService extends TestBase {

    LogHelper logger = new LogHelper(TestWeatherService.class);
    @Autowired
    private WeatherService weatherService;

    @Test
    public void testGetPM25() throws Exception {
        //String response = weatherService.getPM25Object("shanghai");
        //remove [] from string
        //response =response.substring(1,response.length()-1);
        //JSONObject json = new JSONObject(response);
        //String quality = json.get("quality").toString();
        //Assert.assertNotNull(quality);
    }
}
