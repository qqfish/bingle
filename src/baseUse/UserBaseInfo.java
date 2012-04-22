package baseUse;

public class UserBaseInfo {
	/** @pdOid fbc730db-3619-4660-b76d-6cdffdc8c56f */
	private String username;
	/** @pdOid 8839dbc8-bd26-4512-8b4b-7126f8823947 */
	private String password;
	/** @pdOid 94c26df7-2c46-47ee-b1cb-b2ddcefba2d7 */
	private String email;
	/** @pdOid f1ecd885-9f88-41a4-96db-c93a03bc371d */
	private Boolean gender;
	/** @pdOid a1f46d1e-ed71-450c-bc4a-3f42e51757e4 */
	private Short age;
	
	public UserBaseInfo(String u, String p, String e, Boolean g, Short a){
		username = u;
		password = p;
		email = e;
		gender = g;
		age = a;
	}
	
	public String getUsername(){
		return username;
	}
	
	public String getPassword(){
		return password;
	}
	
	public String getEmail(){
		return email;
	}
	
	public Boolean getGender(){
		return gender;
	}
	
	public Short getAge(){
		return age;
	}
}
