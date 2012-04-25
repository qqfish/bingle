package baseUse;

public class CacheData {
	private Object element;
	private int hitNum;
	
	public CacheData(){
		super();
		this.hitNum = 0;
	}
	
	public CacheData(Object element){
		this.element = element;
		this.hitNum = 1;
	}
	
	public  Object getElement(){
		this.hitNum ++;
		return element;
	}
	
	public int getHitNum(){
		return hitNum;
	}
	
	public void setElement(Object element){
		this.element = element;
		this.hitNum = 0;
	}
	
	public void resetHitNum(){
		this.hitNum = 0;
	}
	
}
