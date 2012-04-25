package baseUse;

public class Global {
	private static CacheManager cacheManager;
	
	public static CacheManager cache(){
		if(cacheManager == null){
			cacheManager = new CacheManager();
		}
		return cacheManager;
	}
}
