package exercise;

public class Fetcher {

    private JokeFetcher jF;
    private Emailer eM;

    public Fetcher(JokeFetcher jF, Emailer eM) {
        this.jF = jF;
        this.eM = eM;
    }

    
    /**
     * Fetch a Chuck Norris Joke from http://api.icndb.com
     *
     * @return A new Chuck Norris Joke
     * @throws CommunicationException In case of an error with the external
     * call. This will also send an email to admin
     */
    public Joke fetchJoke() throws CommunicationException {
        try {
            return jF.fetchJokeInternal();
        } catch (CommunicationException e) {
            eM.sendEmailInternal("There is a problem with the server: http://api.icndb.com/jokes/random");
            throw e; //Rethrow to signal error to the caller
        }
    }

    //DO NOT TEST THIS METHOD: It's just meant as a quick manual test, to see the code in action
    public static void main(String[] args) throws CommunicationException {
        Fetcher f = new Fetcher( new JokeFetcher(), new Emailer() );
        System.out.println(f.fetchJoke());
    }
}
