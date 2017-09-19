/**
 * Created by vthiagarajan on 9/6/17.
 */
// Install the Java helper library from twilio.com/docs/java/install

import java.net.URI;
import java.net.URISyntaxException;

import com.twilio.Twilio;
import com.twilio.rest.api.v2010.account.Call;
import com.twilio.rest.api.v2010.account.CallCreator;
import com.twilio.type.PhoneNumber;

public class Example {
    // Find your Account Sid and Token at twilio.com/user/account
    public static final String ACCOUNT_SID = "ACe9bd589acf25766773e0eec2f1f99cfb";
    public static final String AUTH_TOKEN = "ef3a04b85d073b19c6dff0cf478a5d63";

    public static void main(final String[] args) {
        Twilio.init("ACe9bd589acf25766773e0eec2f1f99cfb", "ef3a04b85d073b19c6dff0cf478a5d63");

        try {

            CallCreator creator =
                Call.creator(
                    ACCOUNT_SID,
                    new PhoneNumber("+16824018808"),
                    new PhoneNumber("(682) 200-8898"),
                    new URI("http://vinodh.adaptainer.io/services/playmessage?recordFilePath=https://storage.googleapis.com/jonsnow/dragon.mp3")
                ).setMachineDetection("DetectMessageEnd")
                .setMachineDetectionTimeout(120);

            Call call = creator.create();

            System.out.println(call.getSid());
            System.out.println(call.getStatus().toString());

        } catch (URISyntaxException e) {
            System.err.println("womp womp");
            System.exit(1);
        }
    }

}