package baseUse;

import java.util.List;

public class TagDataList {

	/**
	 * @pdRoleInfo migr=no name=TagData assc=association9
	 *             coll=java.util.Collection impl=java.util.HashSet mult=0..*
	 *             type=Composition
	 */
	public List<TagData> tag;
	
	public TagDataList(List<TagData> t){
		tag = t;
	}
	
	public List<TagData> getTag(){
		return tag;
	}
	
}
