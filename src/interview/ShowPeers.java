package interview;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.asteriskjava.manager.ManagerConnection;
import org.asteriskjava.manager.ManagerConnectionFactory;
import org.asteriskjava.manager.action.CommandAction;
import org.asteriskjava.manager.response.CommandResponse;



public class ShowPeers {
	
	private ManagerConnection managerConnection;


    public ShowPeers(String host,String user,String password) throws IOException
    {
        ManagerConnectionFactory factory = new ManagerConnectionFactory(
                host, user, password);

        this.managerConnection = factory.createManagerConnection();
    }
    
    public  List<String> show() throws Exception
    {
        this.managerConnection.login();
        
        CommandAction action;
        CommandResponse response;
        List<String> list = new ArrayList<String>();
        List<String> result = new ArrayList<String>();

        action = new CommandAction();
        //action.setCommand("core show help");
        action.setCommand(" sip show peers");
        response = (CommandResponse) this.managerConnection.sendAction(action);

        list = response.getResult();
        //System.out.println(list.size());
        int i = 0;
        while ( i <list.size()-1)
        {
        	result.add(list.get(i).split("[\\s+/]")[0]);
            System.out.println(list.get(i).split("\\s+")[0]);
            i++;
        }

        this.managerConnection.logoff();
		return result;
    }

}
