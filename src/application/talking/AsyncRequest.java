package application.talking;

import java.io.PrintWriter;
import java.util.List;

import javax.servlet.AsyncContext;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import baseUse.IBTalkSystem;
import baseUse.bTalkData.Message;
import businessServices.bTalkSystem.BTalkProxy;
import businessServices.datamanager.userdata.UserDataProxy;

public class AsyncRequest implements Runnable{
	private AsyncContext ctx;  
    public AsyncRequest(AsyncContext ctx) {  
        this.ctx = ctx;  
    }
    @Override 
    public void run() {
    	try{
    	IBTalkSystem ibs = new BTalkProxy();
    	JSONArray jsonArray1 = new JSONArray();
    	JSONArray jsonArray2 = new JSONArray(); 
    	JSONObject json = new JSONObject();
    	UserDataProxy udp = new UserDataProxy();
    	List<Message> m = udp.getMessage("zy").getNewMessage();
    	//List<Message> m = ibs.getMessage("zy").getNewMessage();
    	for(int i=0;i<m.size();i++){
    		jsonArray1.add(m.get(i).getContent());
    		//jsonArray1.add(m.get(i).getTime());
    		jsonArray1.add(m.get(i).getFrom());
    		jsonArray2.add(jsonArray1);
    		jsonArray1.clear();
    	}
    	json.put("messages", jsonArray2);
    	System.out.println(json.toString());
    	ctx.getResponse().getWriter().println(json.toString());
    	//ctx.getResponse().getWriter().println(num);
    	ctx.complete();
    	} catch (Exception e) {  
    		throw new RuntimeException(e);  
    	}
    } 
}
