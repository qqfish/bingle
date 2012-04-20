package baseUse;

import java.util.List;

public class UserShortInfo {
	/** @pdOid 42df4e26-4094-4507-a91e-5e0662470165 */
	private String username;
	/** @pdOid 988920c6-5f13-4edd-8302-5da148664c10 */
	private String currentDisease;
	/** @pdOid f7fad145-7a57-4a1b-9924-2cb015060351 */
	private List<String> tagname;
	/** @pdOid d517d5c9-1292-4f60-9b0f-de2bcd66ebad */
	private Short age;
	/** @pdOid 876ed466-713b-4f9a-95dd-1f2e9c12a4c8 */
	private Boolean gender;
	
	public UserShortInfo(String u, String cd, List<String> t, Short a, Boolean g){
		username = u;
		currentDisease = cd;
		tagname = t;
		age = a;
		gender = g;
	}
}
