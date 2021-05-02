package model.dao;

import java.sql.ResultSet;

public interface InterfaceDAO<T> {
	public void inserir(T t);
	
	public void remover(T t);
	
	public void atualizar(T t, T nt);
	
	public ResultSet buscarID(T t);
	
	public ResultSet listar();
}
