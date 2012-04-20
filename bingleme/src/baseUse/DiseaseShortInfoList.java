package baseUse;

public class DiseaseShortInfoList {
	/** @pdOid 208bb661-2f04-435d-b377-f473d1b6b594 */
	private DiseaseShortInfo[] diseaseResult;

	/**
	 * @pdRoleInfo migr=no name=DiseaseShortInfo assc=association1
	 *             coll=java.util.Collection impl=java.util.HashSet mult=0..*
	 *             type=Composition
	 */
	public java.util.Collection<DiseaseShortInfo> diseaseShortInfo;

	/** @pdGenerated default getter */
	public java.util.Collection<DiseaseShortInfo> getDiseaseShortInfo() {
		if (diseaseShortInfo == null)
			diseaseShortInfo = new java.util.HashSet<DiseaseShortInfo>();
		return diseaseShortInfo;
	}

	/** @pdGenerated default iterator getter */
	public java.util.Iterator getIteratorDiseaseShortInfo() {
		if (diseaseShortInfo == null)
			diseaseShortInfo = new java.util.HashSet<DiseaseShortInfo>();
		return diseaseShortInfo.iterator();
	}

	/**
	 * @pdGenerated default setter
	 * @param newDiseaseShortInfo
	 */
	public void setDiseaseShortInfo(
			java.util.Collection<DiseaseShortInfo> newDiseaseShortInfo) {
		removeAllDiseaseShortInfo();
		for (java.util.Iterator iter = newDiseaseShortInfo.iterator(); iter
				.hasNext();)
			addDiseaseShortInfo((DiseaseShortInfo) iter.next());
	}

	/**
	 * @pdGenerated default add
	 * @param newDiseaseShortInfo
	 */
	public void addDiseaseShortInfo(DiseaseShortInfo newDiseaseShortInfo) {
		if (newDiseaseShortInfo == null)
			return;
		if (this.diseaseShortInfo == null)
			this.diseaseShortInfo = new java.util.HashSet<DiseaseShortInfo>();
		if (!this.diseaseShortInfo.contains(newDiseaseShortInfo))
			this.diseaseShortInfo.add(newDiseaseShortInfo);
	}

	/**
	 * @pdGenerated default remove
	 * @param oldDiseaseShortInfo
	 */
	public void removeDiseaseShortInfo(DiseaseShortInfo oldDiseaseShortInfo) {
		if (oldDiseaseShortInfo == null)
			return;
		if (this.diseaseShortInfo != null)
			if (this.diseaseShortInfo.contains(oldDiseaseShortInfo))
				this.diseaseShortInfo.remove(oldDiseaseShortInfo);
	}

	/** @pdGenerated default removeAll */
	public void removeAllDiseaseShortInfo() {
		if (diseaseShortInfo != null)
			diseaseShortInfo.clear();
	}
}
