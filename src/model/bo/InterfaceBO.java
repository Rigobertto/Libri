package model.bo;

import java.util.List;

public interface InterfaceBO<T> {
	public void inserir(T t);
	
	public void remover(T t);
	
	public void atualizar(T t, T nt);
	
	public T buscarID(T t);
	
	public List<T> listar();
}
