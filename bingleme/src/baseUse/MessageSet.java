package baseUse;

import java.util.*;

public class MessageSet {
	/** @pdOid 9e0186ef-630a-438d-a837-507c254aedef */
	   private String username;
	   /** @pdOid a7c72728-470e-41b1-b1d5-f1d0863ae845 */
	   private Set<Message> messages;
	   
	   public MessageSet(){ 
	   }
	   
	   public void addMessage(String from, String content, Date time){
		   messages.add(new Message(from,content,time));
	   }
	   
	   /** @param from 
	    * @param content
	    * @pdOid 48682e09-d488-4397-95b1-3ea3a7a22bce */
	   public void sendMessage(String from, String content) {
	      messages.add(new Message(from,content));
	   }
	   
	   /** @pdOid 3a3e2a6d-a6f3-4aa5-8677-3410abfc2077 */
	   public void clean() {
	      messages.clear();
	   }
	   
	   /** @pdOid ecdfdf15-4bed-49f9-880f-01af244b0a31 */
	   public Set<Message> getNewMessage() {
	      if(messages.isEmpty()){
	    	  return null;
	      }
	      else{
	    	  return messages;
	      }
	   }
	   
	   
}
