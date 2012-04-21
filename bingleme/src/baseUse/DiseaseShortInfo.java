package baseUse;

import java.util.ArrayList;
import java.util.List;

public class DiseaseShortInfo {
	/** @pdOid 3384ec4b-5a05-460c-a76f-68aa42f50505 */
	private String diseasename;
	/** @pdOid 95b91033-aa5d-4a3c-a8b4-ac00b8d0c486 */
	private List<String> tagname;
	
	public DiseaseShortInfo(String d, List<String> t){
		diseasename = d;
		tagname = t;
	}
	
	public DiseaseShortInfo(String d){
		diseasename = d;
		tagname = new ArrayList<String>();
	}
	
	public void addTagname(String t){
		tagname.add(t);
	}
	
	public String getDiseasename(){
		return diseasename;
	}
	
	public List<String> getTagname(){
		return tagname;
	}
}
