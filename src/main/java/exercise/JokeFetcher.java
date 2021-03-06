package exercise;

import static com.jayway.restassured.RestAssured.given;


public class JokeFetcher {
    
     /**
     * Fetch a Chuck Norris joke (not political correct jokes ;-), and returns
     * it encapsulated as a Joke instance IT uses REST assured to Fetch jokes,
     * but don't focus on HOW it does what it do
     *
     * @return The Joke
     * @throws CommunicationException If communication failed (i.e. the external
     * server is not responding)
     */
    public Joke fetchJokeInternal() throws CommunicationException {
        try {
            String joke = given().get("http://api.icndb.com/jokes/random").path("value.joke");
            return new Joke(joke, "http://api.icndb.com/");
        } catch (Exception e) {
            throw new CommunicationException();
        }
    }
    
    
}
