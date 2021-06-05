package dominio.padaria.control;

import dominio.padaria.entity.Ingrediente;
import dominio.padaria.entity.Ingrediente_Produto;
import dominio.padaria.entity.Produto;
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
	
//	private ObservableList<Ingrediente> lista = FXCollections.observableArrayList();
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
	public IntegerProperty quantidade() {
		return quantidade;
	}
	
	public Ingrediente getEntity() {
		Ingrediente i = new Ingrediente();
		i.setNome(nomeIngr.get());
		return i;
	}
	
	
	private void setEntity1(Produto p) {
		if (p != null) {
			nomeProduto.set(p.getNome());
		}
	}
	
	private void setEntity2(Ingrediente_Produto ip) {
		if (ip != null) {
			nomeIngr.set(ip.getIngrediente());
			quantidade.set(ip.getQuantidade());
		}
	}
	
	public void pesquisarPorNome() {
		for (Produto p : lista2) {
			if (p.getNome().contains(nomeProduto.get())) {
				setEntity1(p);
			}
		}
	}
	

}
