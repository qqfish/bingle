package baseUse.wikiData;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class DiseaseData {
	/** @pdOid 41fe3d01-2e87-4b25-a1c0-c6657f0ed1b6 */
	private String diseasename;
	/** @pdOid 8c0d4412-d274-450b-9d1e-db813d990824 */
	private String diseaseIntro;
	/** @pdOid f4d355e7-923f-47cd-b3f4-aa5552571e39 */
	
	private Date editTime;
	
	private List<DiseaseDataTag> tag;
	/**
	 * 更新状�? u for unchanged; c for changed; n for new; d for delete;
	 */
	private char status;

	public DiseaseData(String dn, String di,Date et, List<DiseaseDataTag> t, char s) {
		diseasename = dn;
		diseaseIntro = di;
		editTime = et;
		tag = t;
		status = s;
	}

	public DiseaseData(String dn, String di,Date et, char s) {
		diseasename = dn;
		diseaseIntro = di;
		editTime = et;
		status = s;
		tag = new ArrayList<DiseaseDataTag>();
	}
	
	public void addTag(DiseaseDataTag t){
		tag.add(t);
	}

	public String getDiseasename() {
		return diseasename;
	}

	public String getDiseaseIntro() {
		return diseaseIntro;
	}
	
	public Date getEditTime(){
		return editTime;
	}

	public List<DiseaseDataTag> getTag() {
		return tag;
	}

	public char getStatus() {
		return status;
	}
}
