package dominio.padario.dao;

import java.sql.SQLException;
import java.util.List;

import dominio.padaria.entity.Ingrediente;

public interface IIngredienteDAO {
	
	public void adicionar(Ingrediente i) throws SQLException;
	
	public List<Ingrediente> pesquisarPorNome(String nome) throws SQLException;
	
	public void remover(Ingrediente i) throws SQLException;
	
	public void alterar(Ingrediente i) throws SQLException;

}
