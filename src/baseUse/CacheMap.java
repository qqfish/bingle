package baseUse;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

public class CacheMap {
	private Map<String, CacheData> cacheMap;
	private int minNum;
	private boolean empty;

	public CacheMap() {
		cacheMap = new HashMap<String, CacheData>();
		minNum = 10;
		empty = true;
	}

	public CacheMap(int minNum) {
		this.cacheMap = new HashMap<String, CacheData>();
		this.minNum = minNum;
		this.empty = true;
	}

	public synchronized Object getCache(String key) {
		CacheData result = cacheMap.get(key);
		if (result != null) {
			return result.getElement();
		} else {
			return null;
		}
	}

	public synchronized boolean insert(String key, Object element) {
		if (cacheMap.containsKey(key)) {
			return false;
		} else {
			CacheData cache = new CacheData(element);
			cacheMap.put(key, cache);
			empty = false;
			return true;
		}
	}
	
	public synchronized void deleteCache(String key){
		if(cacheMap.containsKey(key)){
			cacheMap.remove(key);
		}
	}

	public synchronized void autoClean() {
		List<String> rmArray = new ArrayList<String>();

		Iterator<Entry<String, CacheData>> iter = cacheMap.entrySet()
				.iterator();
		while (iter.hasNext()) {
			Entry<String, CacheData> entry = iter.next();
			CacheData val = entry.getValue();
			if (val.getHitNum() < minNum) {
				rmArray.add(entry.getKey());
			} else {
				val.resetHitNum();
			}
		}

		for (int i = 0; i < rmArray.size(); i++) {
			cacheMap.remove(rmArray.get(i));
		}

		if (cacheMap.isEmpty()) {
			empty = true;
		}

	}

	public synchronized void cleanAll() {
		cacheMap.clear();
	}

	public boolean isEmpty() {
		return empty;
	}

	public void setMinNum(int minNum) {
		this.minNum = minNum;
	}

}
