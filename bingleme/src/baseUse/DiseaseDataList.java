package baseUse;

public class DiseaseDataList {
	/** @pdOid 4dfbd463-4666-46da-ba1d-e7bbd864a945 */
	private DiseaseData[] disease;

	/**
	 * @pdRoleInfo migr=no name=DiseaseData assc=association11
	 *             coll=java.util.Collection impl=java.util.HashSet mult=0..*
	 *             type=Composition
	 */
	public java.util.Collection<DiseaseData> diseaseData;

	/** @pdGenerated default getter */
	public java.util.Collection<DiseaseData> getDiseaseData() {
		if (diseaseData == null)
			diseaseData = new java.util.HashSet<DiseaseData>();
		return diseaseData;
	}

	/** @pdGenerated default iterator getter */
	public java.util.Iterator getIteratorDiseaseData() {
		if (diseaseData == null)
			diseaseData = new java.util.HashSet<DiseaseData>();
		return diseaseData.iterator();
	}

	/**
	 * @pdGenerated default setter
	 * @param newDiseaseData
	 */
	public void setDiseaseData(java.util.Collection<DiseaseData> newDiseaseData) {
		removeAllDiseaseData();
		for (java.util.Iterator iter = newDiseaseData.iterator(); iter
				.hasNext();)
			addDiseaseData((DiseaseData) iter.next());
	}

	/**
	 * @pdGenerated default add
	 * @param newDiseaseData
	 */
	public void addDiseaseData(DiseaseData newDiseaseData) {
		if (newDiseaseData == null)
			return;
		if (this.diseaseData == null)
			this.diseaseData = new java.util.HashSet<DiseaseData>();
		if (!this.diseaseData.contains(newDiseaseData))
			this.diseaseData.add(newDiseaseData);
	}

	/**
	 * @pdGenerated default remove
	 * @param oldDiseaseData
	 */
	public void removeDiseaseData(DiseaseData oldDiseaseData) {
		if (oldDiseaseData == null)
			return;
		if (this.diseaseData != null)
			if (this.diseaseData.contains(oldDiseaseData))
				this.diseaseData.remove(oldDiseaseData);
	}

	/** @pdGenerated default removeAll */
	public void removeAllDiseaseData() {
		if (diseaseData != null)
			diseaseData.clear();
	}
}
