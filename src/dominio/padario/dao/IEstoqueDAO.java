package dominio.padario.dao;

import java.time.LocalDate;
import java.util.List;

import dominio.padaria.entity.Estoque;
import dominio.padaria.entity.Ingrediente;

public interface IEstoqueDAO {
	
	public void adicionar(Ingrediente i, int qtde);
	public void remover(Ingrediente i, int qtde);
	public List<Ingrediente> pesquisarIngrediente(String nome);
	public void gerarHistorico(Ingrediente i, String acao, int qtde);
}
