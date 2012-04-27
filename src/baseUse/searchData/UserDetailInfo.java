package baseUse.searchData;

import java.util.List;

public class UserDetailInfo {
	/** @pdOid be1b31ae-ae46-4f34-8af4-6ffdcfe7231a */
	private String username;
	private String groupname;
	/** @pdOid 526ff42b-d80e-4e69-b251-9c7fac0c1702 */
	private Short age;
	private boolean gender;
	/** @pdOid 34e47f00-dd95-40e6-987d-1230ff610d70 */
	private String address;
	/** @pdOid d2c1fd56-4ecb-41bf-85eb-98dcbf6a9cc3 */
	private String email;
	/** @pdOid c409ca67-bb27-44f9-a6d5-0a476f520a94 */
	private int mindStatus;
	/** @pdOid ff693e4c-38f2-46fb-9dc9-c7970ee29c7f */
	private int bodyStatus;
	/** @pdOid 8e05e94a-aff2-49df-bdad-f1afeac35ca5 */
	private List<String> tags;

	/**
	 * @pdRoleInfo migr=no name=UserDiseaseInfo assc=association13
	 *             coll=java.util.Collection impl=java.util.HashSet mult=0..*
	 *             type=Aggregation
	 */
	private List<UserDiseaseInfo> userDiseaseInfo;

	public UserDetailInfo(String u, String group, Short a, boolean gen, String add, String e, int mind,
			int body, List<String> t, List<UserDiseaseInfo> ud) {
		username = u;
		groupname = group;
		age = a;
		gender = gen;
		address = add;
		email = e;
		mindStatus = mind;
		bodyStatus = body;
		tags = t;
		userDiseaseInfo = ud;
	}

	public String getUsername() {
		return username;
	}
	
	public String getGroupname(){
		return groupname;
	}

	public Short getAge() {
		return age;
	}
	
	public boolean getGender(){
		return gender;
	}

	public String getAddress() {
		return address;
	}

	public String getEmail() {
		return email;
	}

	public int getMindStatus() {
		return mindStatus;
	}

	public int getBodyStatus() {
		return bodyStatus;
	}

	public List<String> getTags() {
		return tags;
	}

	public List<UserDiseaseInfo> getUserDiseaseInfo() {
		return userDiseaseInfo;
	}

}
