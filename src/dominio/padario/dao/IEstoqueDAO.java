package dominio.padario.dao;

import java.util.List;

import dominio.padaria.entity.Estoque;
import dominio.padaria.entity.Ingrediente;

public interface IEstoqueDAO {
	
	public void adicionar(Estoque e);
	public void alterar(Estoque e);
	public List<Ingrediente> pesquisarIngrediente(String nome);
	public int getIdIngrediente(String nome);

}
