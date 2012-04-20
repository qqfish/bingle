package baseUse;

import java.util.Date;

public class DiseaseDetailInfo {
	/** @pdOid 39aa7c7c-26ae-4eb3-ae57-32eec7e8bec8 */
	private String diseaseName;
	/** @pdOid 70a2d8cc-fb8b-4aaf-8fb4-05bb5a3df6ee */
	private String diseaseIntro;
	/** @pdOid da93a619-5f77-4c16-a11c-61d8dd3ba6f6 */
	private Date editTime;
	/** @pdOid 7a8f2383-be35-4f9d-9005-6e8f07e9efee */
	private DrugInfo[] drugs;

	/**
	 * @pdRoleInfo migr=no name=DrugInfo assc=association14
	 *             coll=java.util.Collection impl=java.util.HashSet mult=0..*
	 *             type=Composition
	 */
	public java.util.Collection<DrugInfo> drugInfo;

	/** @pdGenerated default getter */
	public java.util.Collection<DrugInfo> getDrugInfo() {
		if (drugInfo == null)
			drugInfo = new java.util.HashSet<DrugInfo>();
		return drugInfo;
	}

	/** @pdGenerated default iterator getter */
	public java.util.Iterator getIteratorDrugInfo() {
		if (drugInfo == null)
			drugInfo = new java.util.HashSet<DrugInfo>();
		return drugInfo.iterator();
	}

	/**
	 * @pdGenerated default setter
	 * @param newDrugInfo
	 */
	public void setDrugInfo(java.util.Collection<DrugInfo> newDrugInfo) {
		removeAllDrugInfo();
		for (java.util.Iterator iter = newDrugInfo.iterator(); iter.hasNext();)
			addDrugInfo((DrugInfo) iter.next());
	}

	/**
	 * @pdGenerated default add
	 * @param newDrugInfo
	 */
	public void addDrugInfo(DrugInfo newDrugInfo) {
		if (newDrugInfo == null)
			return;
		if (this.drugInfo == null)
			this.drugInfo = new java.util.HashSet<DrugInfo>();
		if (!this.drugInfo.contains(newDrugInfo))
			this.drugInfo.add(newDrugInfo);
	}

	/**
	 * @pdGenerated default remove
	 * @param oldDrugInfo
	 */
	public void removeDrugInfo(DrugInfo oldDrugInfo) {
		if (oldDrugInfo == null)
			return;
		if (this.drugInfo != null)
			if (this.drugInfo.contains(oldDrugInfo))
				this.drugInfo.remove(oldDrugInfo);
	}

	/** @pdGenerated default removeAll */
	public void removeAllDrugInfo() {
		if (drugInfo != null)
			drugInfo.clear();
	}
}
