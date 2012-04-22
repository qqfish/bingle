package baseUse;

import java.util.List;

public class DiseaseShortInfoList {
	/** @pdOid 208bb661-2f04-435d-b377-f473d1b6b594 */
	private List<DiseaseShortInfo> diseaseResult;

	public DiseaseShortInfoList(List<DiseaseShortInfo> d){
		diseaseResult = d;
	}
	
	public List<DiseaseShortInfo> getDiseaseResult(){
		return diseaseResult;
	}
}
