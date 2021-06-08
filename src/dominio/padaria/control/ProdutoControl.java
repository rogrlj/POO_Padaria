package dominio.padaria.control;

import java.util.ArrayList;
import java.util.List;

import dominio.padaria.entity.Ingrediente;
import dominio.padaria.entity.Ingrediente_Produto;
import dominio.padaria.entity.Produto;
import dominio.padario.dao.IIngredienteDAO;
import dominio.padario.dao.IProdutoDAO;
import dominio.padario.dao.IngredienteDAO;
import dominio.padario.dao.ProdutoDAO;
import javafx.beans.InvalidationListener;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class ProdutoControl {
	
	private ObservableList<Ingrediente> listaIngr = FXCollections.observableArrayList();
	private ObservableList<Produto> lista2 = FXCollections.observableArrayList();
//	private ObservableList<Ingrediente_Produto> lista3 = FXCollections.observableArrayList();
	
	private StringProperty nomeProduto = new SimpleStringProperty("");
	public StringProperty nomeProdutoProperty() {
		return nomeProduto;
	}
	
	private StringProperty nomeIngr = new SimpleStringProperty("");
	public StringProperty nomeIngrProperty() {
		return nomeIngr;
	}
	
	private IntegerProperty quantidade = new SimpleIntegerProperty();
	public IntegerProperty quantidadeProperty() {
		return quantidade;
	}
	
	private IntegerProperty idProd = new SimpleIntegerProperty();
	public IntegerProperty idProdProperty() {
		return idProd;
	}
	
	private IntegerProperty idIngr = new SimpleIntegerProperty();
	public IntegerProperty idIngrProperty() {
		return idIngr;
	}
	
	private IProdutoDAO prodDAO = new ProdutoDAO();
	
	public Ingrediente getEntity() {
		Ingrediente i = new Ingrediente();
		i.setId(idIngr.get());
		i.setNome(nomeIngr.get());
		return i;
	}
	
	public Produto getEntity1() {
		Produto p = new Produto();
		p.setNome(nomeIngr.get());
		p.setId(idProd.get());
		return p;
	}
	
	public Ingrediente_Produto getEntity2() {
		Ingrediente_Produto ip = new Ingrediente_Produto();
		ip.setId_produto(idProd.get());
		ip.setIngrediente(idIngr.get());
		ip.setQuantidade(quantidade.get());
		return ip;
	}
	
	
	
	private void setEntity1(Produto p) {
		if (p != null) {
			nomeProduto.set(p.getNome());
		}
	}
	
	private void setEntity2(Ingrediente_Produto ip) {
		if (ip != null) {
			idProd.set(ip.getId_produto());
			idIngr.set(ip.getIngrediente());
			quantidade.set(ip.getQuantidade());
		}
	}
	
	public void adicionar() {
		Produto p = getEntity1();
		prodDAO.adicionar(p);
	}
	
	public void adicionarIngredienteProduto() {
		Ingrediente_Produto ip = getEntity2();
		prodDAO.adicionaProdutoIngrediente(ip);
	}
		
	public List<String> buscaIngrediente() {
		List<Ingrediente> lista = prodDAO.buscaIngrediente();
		List<String> lista2 = new ArrayList<String>();

		for (Ingrediente i : lista) {
          lista2.add(i.getNome());
          
      }
		return lista2;
	}
	
	

}
