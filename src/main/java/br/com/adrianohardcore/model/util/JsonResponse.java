package br.com.adrianohardcore.model.util;
import java.util.Collection;

public class JsonResponse {
	
	private Object data ;
	private Collection<Object> list;
	
	public void salvarLista(Object object){
		System.out.println("########################################");
		this.list.add(object);		
	}	

	public Object getData() {
		return data;
	}

	public void setData(Object data) {
		this.data = data;
	}

	public Collection<Object> getList() {
		return list;
	}
}