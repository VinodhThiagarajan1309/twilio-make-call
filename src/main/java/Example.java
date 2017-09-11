/**
 * Created by vthiagarajan on 9/6/17.
 */
// Install the Java helper library from twilio.com/docs/java/install
    import java.net.URI;
    import java.net.URISyntaxException;
    import com.twilio.sdk.Twilio;
    import com.twilio.sdk.client.TwilioRestClient;
    import com.twilio.sdk.resource.api.v2010.account.Call;
    import com.twilio.sdk.type.PhoneNumber;
    import com.twilio.twiml.Play;
    import com.twilio.twiml.TwiMLException;
    import com.twilio.twiml.VoiceResponse;

public class Example {
    // Find your Account Sid and Token at twilio.com/user/account
    public static final String ACCOUNT_SID = "ACe9bd589acf25766773e0eec2f1f99cfb";
    public static final String AUTH_TOKEN = "ef3a04b85d073b19c6dff0cf478a5d63";

    public static void main(String[] args) throws URISyntaxException {
        Twilio.init(ACCOUNT_SID, AUTH_TOKEN);

        // Find your Account Sid and Auth Token at twilio.com/console
        // public static final String ACCOUNT_SID = "AC123";
        //public static final String AUTH_TOKEN = "456bef";

        TwilioRestClient client = new TwilioRestClient(ACCOUNT_SID, AUTH_TOKEN);

        PhoneNumber to = new PhoneNumber("+16824018808"); // Replace with your phone number
        PhoneNumber from = new PhoneNumber("(682) 200-8898"); // Replace with a Twilio number
        URI uri = URI.create("http://vinodh.adaptainer.io/playmessage?recordFilePath=https://storage.googleapis.com/jonsnow/dragon.mp3");


        // Make the call
        Call call = Call.create(ACCOUNT_SID, to, from,
            uri).execute(client);
        // Call call = Call.creator(to, from, uri).create(client);
        // Print the call SID (a 32 digit hex like CA123..)
        System.out.println(call.getSid());

    }

}