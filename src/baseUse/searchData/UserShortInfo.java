package baseUse.searchData;

import java.util.ArrayList;
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
		setUsername(u);
		setCurrentDisease(cd);
		setTagname(t);
		setAge(a);
		setGender(g);
	}
	
	public UserShortInfo(String u, String cd, Short a, Boolean g){
		setUsername(u);
		setCurrentDisease(cd);
		setAge(a);
		setGender(g);
		tagname = new ArrayList<String>();
	}
	
	public void addTagname(String t){
		tagname.add(t);
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getCurrentDisease() {
		return currentDisease;
	}

	public void setCurrentDisease(String currentDisease) {
		this.currentDisease = currentDisease;
	}

	public List<String> getTagname() {
		return tagname;
	}

	public void setTagname(List<String> tagname) {
		this.tagname = tagname;
	}

	public Short getAge() {
		return age;
	}

	public void setAge(Short age) {
		this.age = age;
	}

	public Boolean getGender() {
		return gender;
	}

	public void setGender(Boolean gender) {
		this.gender = gender;
	}
}
