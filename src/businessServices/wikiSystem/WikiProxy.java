package businessServices.wikiSystem;

import java.sql.SQLException;

import baseUse.Global;
import baseUse.IDiseaseData;
import baseUse.ITagData;
import baseUse.IWikiSystem;
import baseUse.wikiData.DiseaseData;
import baseUse.wikiData.DiseaseDataList;
import baseUse.wikiData.TagData;
import baseUse.wikiData.TagDataList;
import businessServices.datamanager.diseasedata.DiseaseDataProxy;
import businessServices.datamanager.tagdata.TagDataProxy;

public class WikiProxy implements IWikiSystem {

	private String tagCache;
	private String diseaseCache;
	private String wikiCache;

	public WikiProxy() {
		tagCache = "editTag";
		diseaseCache = "editDisease";
		wikiCache = "wiki";
		if (!Global.cache().hasCacheMap(wikiCache)) {
			Global.cache().createUncleanMap(wikiCache);
		}
	}

	@Override
	public void submitDisease(DiseaseDataList result) throws SQLException {
		IDiseaseData itf = new DiseaseDataProxy();
		itf.updateDiseaseDatabase(result);
	}

	@Override
	public DiseaseDataList showDiseaseList() {
		DiseaseDataList result = (DiseaseDataList) Global.cache().getCache(
				wikiCache, diseaseCache);
		Global.cache().deleteCache(wikiCache, diseaseCache);
		return result;
	}

	@Override
	public void submitTag(TagDataList result) throws SQLException {
		ITagData itf = new TagDataProxy();
		itf.updateTagDatabase(result);
	}

	@Override
	public TagDataList showTagList() {
		TagDataList result = (TagDataList) Global.cache().getCache(wikiCache,
				tagCache);
		Global.cache().deleteCache(wikiCache, tagCache);
		return result;
	}

	@Override
	public void sendEditDisease(DiseaseData content) {
		DiseaseDataList result = (DiseaseDataList) Global.cache().getCache(
				wikiCache, diseaseCache);
		result.addDisease(content);
		Global.cache().updateOne(wikiCache, diseaseCache, result);

	}

	@Override
	public void sendEditTag(TagData content) {
		TagDataList result = (TagDataList) Global.cache().getCache(wikiCache,
				tagCache);
		result.addTagData(content);
		Global.cache().updateOne(wikiCache, tagCache, result);

	}

	@Override
	public TagData getTagData(String tagname) {
		TagDataList result = (TagDataList) Global.cache().getCache(wikiCache,
				tagCache);
		return result.getOneTag(tagname);
	}
}
