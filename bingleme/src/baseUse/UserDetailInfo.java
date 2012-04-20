package baseUse;

public class UserDetailInfo {
	/** @pdOid be1b31ae-ae46-4f34-8af4-6ffdcfe7231a */
	private String username;
	/** @pdOid 526ff42b-d80e-4e69-b251-9c7fac0c1702 */
	private String age;
	/** @pdOid 34e47f00-dd95-40e6-987d-1230ff610d70 */
	private String address;
	/** @pdOid d2c1fd56-4ecb-41bf-85eb-98dcbf6a9cc3 */
	private String email;
	/** @pdOid c409ca67-bb27-44f9-a6d5-0a476f520a94 */
	private int mindStatus;
	/** @pdOid ff693e4c-38f2-46fb-9dc9-c7970ee29c7f */
	private int bodyStatus;
	/** @pdOid 8e05e94a-aff2-49df-bdad-f1afeac35ca5 */
	private String[] tags[];

	/**
	 * @pdRoleInfo migr=no name=FriendList assc=association12 mult=1
	 *             type=Aggregation
	 */
	public FriendList friendList;
	/**
	 * @pdRoleInfo migr=no name=UserDiseaseInfo assc=association13
	 *             coll=java.util.Collection impl=java.util.HashSet mult=0..*
	 *             type=Aggregation
	 */
	public java.util.Collection<UserDiseaseInfo> userDiseaseInfo;

	/** @pdGenerated default getter */
	public java.util.Collection<UserDiseaseInfo> getUserDiseaseInfo() {
		if (userDiseaseInfo == null)
			userDiseaseInfo = new java.util.HashSet<UserDiseaseInfo>();
		return userDiseaseInfo;
	}

	/** @pdGenerated default iterator getter */
	public java.util.Iterator getIteratorUserDiseaseInfo() {
		if (userDiseaseInfo == null)
			userDiseaseInfo = new java.util.HashSet<UserDiseaseInfo>();
		return userDiseaseInfo.iterator();
	}

	/**
	 * @pdGenerated default setter
	 * @param newUserDiseaseInfo
	 */
	public void setUserDiseaseInfo(
			java.util.Collection<UserDiseaseInfo> newUserDiseaseInfo) {
		removeAllUserDiseaseInfo();
		for (java.util.Iterator iter = newUserDiseaseInfo.iterator(); iter
				.hasNext();)
			addUserDiseaseInfo((UserDiseaseInfo) iter.next());
	}

	/**
	 * @pdGenerated default add
	 * @param newUserDiseaseInfo
	 */
	public void addUserDiseaseInfo(UserDiseaseInfo newUserDiseaseInfo) {
		if (newUserDiseaseInfo == null)
			return;
		if (this.userDiseaseInfo == null)
			this.userDiseaseInfo = new java.util.HashSet<UserDiseaseInfo>();
		if (!this.userDiseaseInfo.contains(newUserDiseaseInfo))
			this.userDiseaseInfo.add(newUserDiseaseInfo);
	}

	/**
	 * @pdGenerated default remove
	 * @param oldUserDiseaseInfo
	 */
	public void removeUserDiseaseInfo(UserDiseaseInfo oldUserDiseaseInfo) {
		if (oldUserDiseaseInfo == null)
			return;
		if (this.userDiseaseInfo != null)
			if (this.userDiseaseInfo.contains(oldUserDiseaseInfo))
				this.userDiseaseInfo.remove(oldUserDiseaseInfo);
	}

	/** @pdGenerated default removeAll */
	public void removeAllUserDiseaseInfo() {
		if (userDiseaseInfo != null)
			userDiseaseInfo.clear();
	}

}
