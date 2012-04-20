package baseUse;

public class TagDataList {
	/** @pdOid e0c88a96-1425-4e7f-8f41-a69e6210a68c */
	private TagData[] tag;

	/**
	 * @pdRoleInfo migr=no name=TagData assc=association9
	 *             coll=java.util.Collection impl=java.util.HashSet mult=0..*
	 *             type=Composition
	 */
	public java.util.Collection<TagData> tagData;

	/** @pdGenerated default getter */
	public java.util.Collection<TagData> getTagData() {
		if (tagData == null)
			tagData = new java.util.HashSet<TagData>();
		return tagData;
	}

	/** @pdGenerated default iterator getter */
	public java.util.Iterator getIteratorTagData() {
		if (tagData == null)
			tagData = new java.util.HashSet<TagData>();
		return tagData.iterator();
	}

	/**
	 * @pdGenerated default setter
	 * @param newTagData
	 */
	public void setTagData(java.util.Collection<TagData> newTagData) {
		removeAllTagData();
		for (java.util.Iterator iter = newTagData.iterator(); iter.hasNext();)
			addTagData((TagData) iter.next());
	}

	/**
	 * @pdGenerated default add
	 * @param newTagData
	 */
	public void addTagData(TagData newTagData) {
		if (newTagData == null)
			return;
		if (this.tagData == null)
			this.tagData = new java.util.HashSet<TagData>();
		if (!this.tagData.contains(newTagData))
			this.tagData.add(newTagData);
	}

	/**
	 * @pdGenerated default remove
	 * @param oldTagData
	 */
	public void removeTagData(TagData oldTagData) {
		if (oldTagData == null)
			return;
		if (this.tagData != null)
			if (this.tagData.contains(oldTagData))
				this.tagData.remove(oldTagData);
	}

	/** @pdGenerated default removeAll */
	public void removeAllTagData() {
		if (tagData != null)
			tagData.clear();
	}
}
