package baseUse.wikiData;

public class DiseaseDataTag {
	
	private String tagname;
	/*
	 * u for unchanged; n for new; d for delete;
	 */
	private char status;
	
	public DiseaseDataTag(String t, char s){
		tagname = t;
		status = s;
	}
	
	public String getTagname(){
		return tagname;
	}
	
	public char getStatus(){
		return status;
	}
}
