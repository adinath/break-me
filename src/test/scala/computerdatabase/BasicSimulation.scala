package computerdatabase

import io.gatling.core.Predef._
import io.gatling.http.Predef._

import scala.concurrent.duration._

class BasicSimulation extends Simulation {

  val httpProtocol = http
    .baseUrl("http://localhost:8081/health") // Here is the root for all relative URLs

  val scn = scenario("Spring health endpoing") // A scenario is a chain of requests and pauses
    .exec(http("request_1")
    .get("/"))

  setUp(
    scn.inject(
      rampUsers(300) during (30 seconds)
    )
      .protocols(httpProtocol))
}
