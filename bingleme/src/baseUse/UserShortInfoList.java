package baseUse;

public class UserShortInfoList {
	/** @pdOid 3bc6c3eb-ead2-477c-a3fb-adda0b1496fa */
	private UserShortInfo userResult;

	/**
	 * @pdRoleInfo migr=no name=UserShortInfo assc=association5
	 *             coll=java.util.Collection impl=java.util.HashSet mult=0..*
	 *             type=Composition
	 */
	public java.util.Collection<UserShortInfo> userShortInfo;

	/** @pdGenerated default getter */
	public java.util.Collection<UserShortInfo> getUserShortInfo() {
		if (userShortInfo == null)
			userShortInfo = new java.util.HashSet<UserShortInfo>();
		return userShortInfo;
	}

	/** @pdGenerated default iterator getter */
	public java.util.Iterator getIteratorUserShortInfo() {
		if (userShortInfo == null)
			userShortInfo = new java.util.HashSet<UserShortInfo>();
		return userShortInfo.iterator();
	}

	/**
	 * @pdGenerated default setter
	 * @param newUserShortInfo
	 */
	public void setUserShortInfo(
			java.util.Collection<UserShortInfo> newUserShortInfo) {
		removeAllUserShortInfo();
		for (java.util.Iterator iter = newUserShortInfo.iterator(); iter
				.hasNext();)
			addUserShortInfo((UserShortInfo) iter.next());
	}

	/**
	 * @pdGenerated default add
	 * @param newUserShortInfo
	 */
	public void addUserShortInfo(UserShortInfo newUserShortInfo) {
		if (newUserShortInfo == null)
			return;
		if (this.userShortInfo == null)
			this.userShortInfo = new java.util.HashSet<UserShortInfo>();
		if (!this.userShortInfo.contains(newUserShortInfo))
			this.userShortInfo.add(newUserShortInfo);
	}

	/**
	 * @pdGenerated default remove
	 * @param oldUserShortInfo
	 */
	public void removeUserShortInfo(UserShortInfo oldUserShortInfo) {
		if (oldUserShortInfo == null)
			return;
		if (this.userShortInfo != null)
			if (this.userShortInfo.contains(oldUserShortInfo))
				this.userShortInfo.remove(oldUserShortInfo);
	}

	/** @pdGenerated default removeAll */
	public void removeAllUserShortInfo() {
		if (userShortInfo != null)
			userShortInfo.clear();
	}

}
