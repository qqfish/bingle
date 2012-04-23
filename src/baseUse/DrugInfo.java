package baseUse;

public class DrugInfo {
	/** @pdOid 41045a03-a872-4b88-9e5d-fa05528c0969 */
	private String drugname;
	/** @pdOid 542c9cf2-384c-4c14-86c4-1275bd29ff3b */
	private int num;
	
	public DrugInfo(String dn, int n){
		drugname = dn;
		num = n;
	}
	
	public String getDrugname(){
		return drugname;
	}
	
	public int getNum(){
		return num;
	}
}
