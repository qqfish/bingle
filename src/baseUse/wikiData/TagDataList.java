package baseUse.wikiData;

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
	
	public TagDataList() {
		// TODO Auto-generated constructor stub
	}

	public void addTagData(TagData tag){
		this.tag.add(tag);
	}
	
	public List<TagData> getTag(){
		return tag;
	}
	
	public TagData getOneTag(String tagname){
		for(int i = 0; i < tag.size(); i++){
			if(tag.get(i).getTagname().equals(tagname)){
				return tag.get(i);
			}
		}
		return null;
	}
	
}
