package baseUse;

import java.util.List;

public class TagData {
	/** @pdOid 4e23cd75-b88b-4241-8dde-8c30c79dca07 */
	private String tagname;
	/** @pdOid 19637a08-5a28-4835-9d67-b136bf5b4b63 */
	private String tagIntro;
	/** @pdOid e263afbc-2f15-4c5c-ab1b-7233856b9932 */
	/**
	 * 标签种类，包括t for normal tag; d for drug;
	 */
	private char type;
	private List<TagAlternate> alterName;

	/**
	 * 该标签的状态 u for unchanged; c for changed; n for new; d for delete;
	 */
	private char status;

	public TagData(String tn, String ti, List<TagAlternate> a, char s) {
		tagname = tn;
		tagIntro = ti;
		alterName = a;
		status = s;
	}

	public String getTagname() {
		return tagname;
	}

	public String getTagIntro() {
		return tagIntro;
	}

	public List<TagAlternate> getAlterName() {
		return alterName;
	}
	
	public char getType(){
		return type;
	}

	public char getStatus() {
		return status;
	}
}
