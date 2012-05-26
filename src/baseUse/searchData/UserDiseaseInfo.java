package baseUse.searchData;

import java.util.List;

public class UserDiseaseInfo {
	/** @pdOid 12ff1999-247d-4060-8913-001ed1dcebd2 */
	private String diseaseName;
	/** @pdOid 2039122b-1634-450f-99eb-6e54bc183764 */
	private String treatmentIntro;
	/** @pdOid b6f5ae60-24c4-4135-b79f-07a60a472019 */
	private String reason;
	/** @pdOid 7f0b6ad7-2a8d-4ef8-945f-cc6daa9d7b47 */
	private String tips;
	/** @pdOid 29a2e96f-19d6-4479-b198-f5d136d0fb34 */
	private List<String> drugName;

	public UserDiseaseInfo(String d, String t, String r, String tip,
			List<String> drug) {
		diseaseName = d;
		treatmentIntro = t;
		reason = r;
		tips = tip;
		drugName = drug;
	}

	public String getDiseaseName() {
		return diseaseName;
	}

	public String getTreatmentIntro() {
		return treatmentIntro;
	}

	public String getReason() {
		return reason;
	}

	public String getTips() {
		return tips;
	}

	public List<String> getDrugName() {
		return drugName;
	}

}
