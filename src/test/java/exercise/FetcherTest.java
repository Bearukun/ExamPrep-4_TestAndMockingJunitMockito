package exercise;

import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import static org.mockito.Mockito.when;
import org.mockito.runners.MockitoJUnitRunner;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

@RunWith(MockitoJUnitRunner.class)
public class FetcherTest {

    //Create Mock objects 
    @Mock
    JokeFetcher jF;
    @Mock
    Emailer eM;

    public FetcherTest() {
    }

    @Test
    public void testGetJoke() throws CommunicationException {

        //Delare, instantiate and initiate a new Fetcher object. 
        Fetcher fetch = new Fetcher(jF, eM);

        //Set the mock object to return a new Joke when its function fetchJokeInternal() is called. 
        when(jF.fetchJokeInternal()).thenReturn(new Joke("This is a funny joke", "http://api.icndb.com/"));

        //Save the fetched joke into a String that we can test on.
        String joke = fetch.fetchJoke().toString();

        //Test wheter the result that we expect is true to what is returned to us.
        assertEquals("Joke received", "Joke{" + "joke=" + "This is a funny joke" + ", reference=" + "http://api.icndb.com/" + '}', joke);

    }

    @Test(expected = CommunicationException.class)
    public void testException() throws Exception {

        //Delare, instantiate and initiate a new Fetcher object. 
        Fetcher fetch = new Fetcher(jF, eM);
        
        //Throw CommunicationException when trown
        when(jF.fetchJokeInternal()).thenThrow(CommunicationException.class);
        
        //Fetch a new joke. 
        fetch.fetchJoke();
        
        //Verify that the sendEmailInternal is being run one time. 
        verify(eM, times(1)).sendEmailInternal("There is a problem with the server: http://api.icndb.com/jokes/random");
        
        //Check whether the exception was thrown or not.
        assertTrue(false);

    }

}
