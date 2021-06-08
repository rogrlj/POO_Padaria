package dominio.padario.dao;

import java.util.List;

import dominio.padaria.entity.Estoque;
import dominio.padaria.entity.Historico;
import dominio.padaria.entity.Ingrediente;
import dominio.padaria.entity.Ingrediente_Produto;
import dominio.padaria.entity.Produto;

public interface IAlimentaTabelaDAO {
	
	public List<Ingrediente> alimentaIngrediente();
	public List<Produto> alimentaProd();
	public List<Ingrediente_Produto> alimentaIngPr();
	public List<Estoque> alimentaEstoque();
	public List<Historico> alimentaHist();

}
