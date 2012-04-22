package baseUse;

import java.util.ArrayList;
import java.util.List;

public class DiseaseDataList {
	/** @pdOid 4dfbd463-4666-46da-ba1d-e7bbd864a945 */
	private List<DiseaseData> disease;

	public DiseaseDataList(List<DiseaseData> d){
		disease = d;
	}
	
	public DiseaseDataList(){
		disease = new ArrayList<DiseaseData>();
	}
	
	public void addDisease(DiseaseData d){
		disease.add(d);
	}
	
	
	public List<DiseaseData> getDisease(){
		return disease;
	}
	
}
