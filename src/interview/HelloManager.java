package interview;

import java.io.IOException;

import org.asteriskjava.manager.AuthenticationFailedException;
import org.asteriskjava.manager.ManagerConnection;
import org.asteriskjava.manager.ManagerConnectionFactory;
import org.asteriskjava.manager.TimeoutException;
import org.asteriskjava.manager.action.OriginateAction;
import org.asteriskjava.manager.response.ManagerResponse;

public class HelloManager
{
    private ManagerConnection managerConnection;
    private String SIP;
    private String Context;
    private String ex;
    
    public HelloManager(String sip,String context,String ex) throws IOException
    {
        ManagerConnectionFactory factory = new ManagerConnectionFactory(
                "localhost", "admin", "secret5");

        this.managerConnection = factory.createManagerConnection();
        this.SIP = "SIP/"+ sip;
        this.Context = context;
        this.ex = ex;
    }

    public String run() throws IOException, AuthenticationFailedException,
            TimeoutException
    {
        OriginateAction originateAction;
        ManagerResponse originateResponse;

        originateAction = new OriginateAction();
        originateAction.setChannel(this.SIP);
        originateAction.setContext(this.Context);
        originateAction.setExten(this.ex);
        originateAction.setPriority(new Integer(1));

        // connect to Asterisk and log in
        managerConnection.login();

        // send the originate action and wait for a maximum of 30 seconds for Asterisk
        // to send a reply
        originateResponse = managerConnection.sendAction(originateAction, 30000);

        // print out whether the originate succeeded or not
        System.out.println(originateResponse.getResponse());

        // and finally log off and disconnect
        managerConnection.logoff();
        return originateResponse.getResponse();
    }
    
    //public static void main(String[] args) throws Exception
    //{
    //   String s = new HelloManager("1001","from-internal","100").run();
   // }
}