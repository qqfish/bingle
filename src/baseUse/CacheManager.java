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

	public boolean setMinNum(String mapName, int minNum){
		if(!maps.containsKey(mapName)){
			return false;
		}
		else{
			maps.get(mapName).setMinNum(minNum);
			return true;
		}
	}
	public boolean insert(String mapName, String key, Object element) {
		if (!maps.containsKey(mapName)) {
			maps.put(mapName, new CacheMap());
		}
		return maps.get(mapName).insert(key, element);
	}

	public void deleteCache(String mapName, String key){
		if(maps.containsKey(mapName)){
			maps.get(mapName).deleteCache(key);
		}
	}
	
	public Object getCache(String mapName, String key) {
		if (!maps.containsKey(mapName)) {
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
