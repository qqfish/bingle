package baseUse;

public class TagAlternate {
	private String tagname;
	private String alternateName;

	/**
	 * 该替代名的状态 u for unchanged; c for changed; n for new; d for delete;
	 */
	private char status;

	public TagAlternate(String t, String a, char s) {
		tagname = t;
		alternateName = a;
		status = s;
	}

	public String getTagname() {
		return tagname;
	}

	public String getAlternateName() {
		return alternateName;
	}

	public char getStatus() {
		return status;
	}

	public void setAlternateName(String a) {
		alternateName = a;
		status = 'c';
	}

	public void delete() {
		status = 'd';
	}
}
