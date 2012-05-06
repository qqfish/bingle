package baseUse;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.Map.Entry;

public class CacheManager {
	private Map<String, CacheMap> maps;

	public CacheManager() {
		maps = new TreeMap<String, CacheMap>();
	}
	
	public boolean hasCacheMap(String mapName){
		return maps.containsKey(mapName);
	}

	public boolean setMinNum(String mapName, int minNum){
		if(!hasCacheMap(mapName)){
			return false;
		}
		else{
			maps.get(mapName).setMinNum(minNum);
			return true;
		}
	}
	
	public boolean createUncleanMap(String mapName){
		if(hasCacheMap(mapName)){
			return false;
		}
		else {
			maps.put(mapName, new CacheMap(0));
			return true;
		}
	}
	
	public boolean insert(String mapName, String key, Object element) {
		if (!hasCacheMap(mapName)) {
			maps.put(mapName, new CacheMap());
		}
		return maps.get(mapName).insert(key, element);
	}
	
	public boolean updateOne(String mapName, String key, Object element){
		if (!hasCacheMap(mapName)) {
			maps.put(mapName, new CacheMap());
		}
		return maps.get(mapName).updateOne(key, element);
	}

	public void deleteCache(String mapName, String key){
		if(hasCacheMap(mapName)){
			maps.get(mapName).deleteCache(key);
		}
	}
	
	public Object getCache(String mapName, String key) {
		if (!hasCacheMap(mapName)) {
			return null;
		} else {
			return maps.get(mapName).getCache(key);
		}
	}

	public void autoClean() {
		List<String> rmArray = new ArrayList<String>();

		Iterator<Entry<String, CacheMap>> iter = maps.entrySet().iterator();
		while (iter.hasNext()) {
			Entry<String, CacheMap> entry = iter.next();
			CacheMap val = entry.getValue();
			if (val.isEmpty()) {
				rmArray.add(entry.getKey());
			}
			else {
				val.autoClean();
			}
		}

		for (int i = 0; i < rmArray.size(); i++) {
			maps.remove(rmArray.get(i));
		}
	}
	
}
