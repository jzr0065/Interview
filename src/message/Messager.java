package message;

import com.twilio.Twilio;
import com.twilio.rest.api.v2010.account.Message;
import com.twilio.type.PhoneNumber;
public class Messager {
  // Find your Account Sid and Token at twilio.com/user/account
  public static final String ACCOUNT_SID = "ACc998e118bf791b6bffee4290c46497f7";
  public static final String AUTH_TOKEN = "6fc47887b98fd09b43bcaf9bba442108";
  public static void main(String[] args) {
    Twilio.init(ACCOUNT_SID, AUTH_TOKEN);
    Message message = Message
      .creator(new PhoneNumber("+14047405766"), new PhoneNumber("+14064122548"),
        "Tomorrow's forecast in Financial District, San Francisco is Clear")
      .setMediaUrl("https://climacons.herokuapp.com/clear.png")
      .create();
    System.out.println(message.getSid());
  }
}