@SuppressWarnings("unchecked")
public class ArrayList<T> implements List<T>{

	private T[] arrList;
	private int cap = 10;
	private int size;

	ArrayList(){
		arrList =  (T[]) new Object[cap];
		size = 0;
	}

	public void add(T item){
		if (size == arrList.length){
			growArray();
		}
		arrList[size++] = item;
	}

	public void add(int pos, T item){
		if (size == arrList.length){
			growArray();
		}
		for(int i = size-1; i > pos; i--){
			arrList[i+1] = arrList[i];
		}
		arrList[pos] = item;
		size++;
	}

	public T get(int pos){
		return arrList[pos];
	}

	public T remove(int pos){
		T temp = arrList[pos];
		for( int i = pos; i< size-1; i++){
			arrList[i+1] = arrList[i];
		}
		--size;
		return temp;
	}

	public int size(){
		return size;
	}

	protected void growArray(){
		T[] temp = (T[]) new Object[arrList.length*2];
		for (int i = 0; i < arrList.length; i++){
			temp[i] = arrList[i];
		}
		arrList = temp;
	}



}