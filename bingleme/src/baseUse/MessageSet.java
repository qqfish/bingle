package baseUse;

public class MessageSet {
	/** @pdOid 9e0186ef-630a-438d-a837-507c254aedef */
	   private String username;
	   /** @pdOid a7c72728-470e-41b1-b1d5-f1d0863ae845 */
	   private Message[] messages;
	   
	   /** @pdRoleInfo migr=no name=Message assc=association9 coll=java.util.Collection impl=java.util.HashSet mult=0..* type=Composition */
	   public java.util.Collection<Message> message;
	   
	   /** @param from 
	    * @param content
	    * @pdOid 48682e09-d488-4397-95b1-3ea3a7a22bce */
	   public void sendMessage(String from, String content) {
	      // TODO: implement
	   }
	   
	   /** @pdOid 3a3e2a6d-a6f3-4aa5-8677-3410abfc2077 */
	   public void clean() {
	      // TODO: implement
	   }
	   
	   /** @pdOid ecdfdf15-4bed-49f9-880f-01af244b0a31 */
	   public Message[] getNewMessage() {
	      // TODO: implement
	      return null;
	   }
	   
	   
	   /** @pdGenerated default getter */
	   public java.util.Collection<Message> getMessage() {
	      if (message == null)
	         message = new java.util.HashSet<Message>();
	      return message;
	   }
	   
	   /** @pdGenerated default iterator getter */
	   public java.util.Iterator getIteratorMessage() {
	      if (message == null)
	         message = new java.util.HashSet<Message>();
	      return message.iterator();
	   }
	   
	   /** @pdGenerated default setter
	     * @param newMessage */
	   public void setMessage(java.util.Collection<Message> newMessage) {
	      removeAllMessage();
	      for (java.util.Iterator iter = newMessage.iterator(); iter.hasNext();)
	         addMessage((Message)iter.next());
	   }
	   
	   /** @pdGenerated default add
	     * @param newMessage */
	   public void addMessage(Message newMessage) {
	      if (newMessage == null)
	         return;
	      if (this.message == null)
	         this.message = new java.util.HashSet<Message>();
	      if (!this.message.contains(newMessage))
	         this.message.add(newMessage);
	   }
	   
	   /** @pdGenerated default remove
	     * @param oldMessage */
	   public void removeMessage(Message oldMessage) {
	      if (oldMessage == null)
	         return;
	      if (this.message != null)
	         if (this.message.contains(oldMessage))
	            this.message.remove(oldMessage);
	   }
	   
	   /** @pdGenerated default removeAll */
	   public void removeAllMessage() {
	      if (message != null)
	         message.clear();
	   }

}
