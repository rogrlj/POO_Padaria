package dominio.padario.dao;

import java.util.List;

import dominio.padaria.entity.Ingrediente;
import dominio.padaria.entity.Ingrediente_Produto;
import dominio.padaria.entity.Produto;

public interface IProdutoDAO {
	
	public void adicionar(Produto i);
	
	public List<Ingrediente> buscaIngrediente();
	
	public void adicionaProdutoIngrediente(Ingrediente_Produto ip);

}
