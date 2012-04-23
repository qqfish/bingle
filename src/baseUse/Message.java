package baseUse;

import java.util.Date;

public class Message {
	/** @pdOid c27ce9bb-baa6-453e-929d-0f8c61fe631a */
	private String from;
	/** @pdOid 5a854c2c-0f11-42df-8f17-518c17991fa3 */
	private Date time;
	/** @pdOid 0181db23-4324-48cc-be3c-5931ca0903fd */
	private String content;
	
	public Message(String f, String c){
		from = f;
		content = c;
		time =  new Date();
		time.getTime();
	}
	
	public Message(String f, String c, Date t){
		from = f;
		content = c;
		time = t;
	}
	
	public String getFrom(){
		return from;
	}
	
	public Date getTime(){
		return time;
	}
	public String getContent(){
		return content;
	}

}
