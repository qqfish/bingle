package baseUse.searchData;

import java.util.List;

public class DiseaseShortInfoList {
	/** @pdOid 208bb661-2f04-435d-b377-f473d1b6b594 */
	private List<DiseaseShortInfo> diseaseResult;
	private int num;

	public DiseaseShortInfoList(List<DiseaseShortInfo> d) {
		diseaseResult = d;
		num = d.size();
	}

	public void setDiseaseResult(List<DiseaseShortInfo> d) {
		diseaseResult = d;
	}
	
	public void setNum(int n){
		num = n;
	}

	public List<DiseaseShortInfo> getDiseaseResult() {
		return diseaseResult;
	}
	
	public int getNum(){
		return num;
	}
	
	public List<DiseaseShortInfo> getDiseaseResultPage(int page, int perPage){
		int begin = perPage * (page - 1) ;
		int end = perPage * page ;
		if(begin > diseaseResult.size()){
			return null;
		}
		if(end > diseaseResult.size()){
			end = diseaseResult.size();
		}
		List<DiseaseShortInfo> result = diseaseResult.subList(begin, end);
		return result;
	}
}
