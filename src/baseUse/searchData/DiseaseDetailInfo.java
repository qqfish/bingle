package baseUse.searchData;

import java.util.Date;
import java.util.List;
import java.util.ArrayList;


public class DiseaseDetailInfo {
	/** @pdOid 39aa7c7c-26ae-4eb3-ae57-32eec7e8bec8 */
	private String diseaseName;
	/** @pdOid 70a2d8cc-fb8b-4aaf-8fb4-05bb5a3df6ee */
	private String diseaseIntro;
	/** @pdOid da93a619-5f77-4c16-a11c-61d8dd3ba6f6 */
	private Date editTime;
	/** @pdOid 7a8f2383-be35-4f9d-9005-6e8f07e9efee */
	private List<DrugInfo> drugs;
	private List<UserShortInfo> userOfThis;

	public DiseaseDetailInfo(String dn, String di, Date et, List<DrugInfo> d, List<UserShortInfo> user) {
		diseaseName = dn;
		diseaseIntro = di;
		editTime = et;
		drugs = d;
		userOfThis = user;
	}

	public DiseaseDetailInfo(String dn, String di, Date et) {
		diseaseName = dn;
		diseaseIntro = di;
		editTime = et; 
		drugs = new ArrayList<DrugInfo>();
	}
	
	public void addDrug(DrugInfo d){
		drugs.add(d);
	}
	
	public void setUserOfThis(List<UserShortInfo> user){
		userOfThis = user;
	}
	
	public String getDiseaseName(){
		return diseaseName;
	}
	public String getDiseaseIntro(){
		return diseaseIntro;
	}
	public Date getEditTime(){
		return editTime;
	}
	public List<DrugInfo> getDrugs(){
		return drugs;
	}
	public List<UserShortInfo> getUserOfThis(){
		return userOfThis;
	}
}
