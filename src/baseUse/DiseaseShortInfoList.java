package baseUse;

import java.util.List;

public class DiseaseShortInfoList {
	/** @pdOid 208bb661-2f04-435d-b377-f473d1b6b594 */
	private List<DiseaseShortInfo> diseaseResult;

	public DiseaseShortInfoList(List<DiseaseShortInfo> d) {
		diseaseResult = d;
	}

	public void setDiseaseResult(List<DiseaseShortInfo> d) {
		diseaseResult = d;
	}

	public List<DiseaseShortInfo> getDiseaseResult() {
		return diseaseResult;
	}
	
	public List<DiseaseShortInfo> getDiseaseResultPage(int page, int perPage){
		int begin = perPage * (page - 1) - 1;
		int end = perPage * page - 1;
		if(begin > diseaseResult.size()){
			return null;
		}
		if(end > diseaseResult.size()){
			end = diseaseResult.size() - 1;
		}
		List<DiseaseShortInfo> result = diseaseResult.subList(begin, end);
		return result;
	}
}
