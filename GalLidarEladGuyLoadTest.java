
import java.time.Duration;
import java.util.*;

import io.gatling.javaapi.core.*;
import io.gatling.javaapi.http.*;
import io.gatling.javaapi.jdbc.*;

import static io.gatling.javaapi.core.CoreDsl.*;
import static io.gatling.javaapi.http.HttpDsl.*;
import static io.gatling.javaapi.jdbc.JdbcDsl.*;

public class GalLidarEladGuyLoadTest extends Simulation {

  {
    HttpProtocolBuilder httpProtocol = http
      .baseUrl("http://localhost:8081")
      .inferHtmlResources()
      .acceptHeader("text/html,application/xhtml+xml,application/xml;q=0.9,image/avif,image/webp,image/apng,*/*;q=0.8,application/signed-exchange;v=b3;q=0.9")
      .acceptEncodingHeader("gzip, deflate")
      .acceptLanguageHeader("he-IL,he;q=0.9,en-US;q=0.8,en;q=0.7")
      .contentTypeHeader("application/x-www-form-urlencoded")
      .originHeader("http://localhost:8081")
      .upgradeInsecureRequestsHeader("1")
      .userAgentHeader("Mozilla/5.0 (Macintosh; Intel Mac OS X 10_15_7) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/108.0.0.0 Safari/537.36");
    
    Map<CharSequence, String> headers_0 = new HashMap<>();
    headers_0.put("Cache-Control", "max-age=0");
    headers_0.put("Sec-Fetch-Dest", "document");
    headers_0.put("Sec-Fetch-Mode", "navigate");
    headers_0.put("Sec-Fetch-Site", "same-origin");
    headers_0.put("Sec-Fetch-User", "?1");
    headers_0.put("sec-ch-ua", "Not?A_Brand\";v=\"8\", \"Chromium\";v=\"108\", \"Google Chrome\";v=\"108");
    headers_0.put("sec-ch-ua-mobile", "?0");
    headers_0.put("sec-ch-ua-platform", "macOS");


    ScenarioBuilder scn = scenario("Gal, Lidar, Elad and Guy Load Test")
      .exec(
        http("request_0")
          .post("/Final_Project_Devops/index.jsp")
          .headers(headers_0)
          .formParam("first_name", "Gal")
          .formParam("last_name", "Bachar")
      ).pause(80);


	  setUp(scn.injectOpen(rampUsers(10).during(10),rampUsers(30).during(100),rampUsers(10).during(10))).protocols(httpProtocol);
  }
}
