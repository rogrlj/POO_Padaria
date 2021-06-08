package dominio.padaria.control;

import java.util.ArrayList;
import java.util.List;

import dominio.padaria.entity.Estoque;
import dominio.padaria.entity.Ingrediente;
import dominio.padario.dao.EstoqueDAO;
import dominio.padario.dao.IEstoqueDAO;
import dominio.padario.dao.IIngredienteDAO;
import dominio.padario.dao.IngredienteDAO;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

public class EstoqueControl {
	
	private ObservableList<Ingrediente> lista = FXCollections.observableArrayList();
	private TableView<Ingrediente> table = new TableView<>();
	
	private IEstoqueDAO estDAO = new EstoqueDAO();
	private IIngredienteDAO ingDAO = new IngredienteDAO();
	
	private IngredienteControl controlIng = new IngredienteControl();
	private Ingrediente i;

	private StringProperty nome = new SimpleStringProperty("");
	public StringProperty nomeProperty() {
		return nome;
	}
	
	private IntegerProperty quantidade = new SimpleIntegerProperty();
	public IntegerProperty quantidadeProperty() {
		return quantidade;
	}
	
	private IntegerProperty id = new SimpleIntegerProperty();
	public IntegerProperty idProperty() {
		return id;
	}
	
	
	private void setEntity(Estoque e) {
		if (e != null) {
			quantidade.set(e.getQuantidade());
			id.set(e.getIngrediente());
		}
	}
	
	public Estoque getEntity() {
		Estoque e = new Estoque();
		e.setIngrediente(i.getId());
		e.setQuantidade(quantidade.get());
		return e;
	}
	
	public void adicionar() {
		Estoque e = getEntity();
		if (e == null) {
			estDAO.adicionar(e);
		} else {
			alterar(e);
		}
	}
	
	private void alterar(Estoque e) {
		estDAO.alterar(e);
		
	}

	public void pesquisarIngrediente() {
		List<Ingrediente> i = ingDAO.pesquisarPorNome(nome.get());
        lista.clear();
        lista.addAll(i);
	}
	
	public void generateTable() {
		TableColumn<Ingrediente, String> colNome = new TableColumn<>("Nome");
		colNome.setCellValueFactory(new PropertyValueFactory<Ingrediente, String>("nome"));
		
		TableColumn<Ingrediente, Integer> colId = new TableColumn<>("Id");
		colId.setCellValueFactory(new PropertyValueFactory<Ingrediente, Integer>("id"));

		table.getColumns().addAll(colId, colNome);
		table.setItems(lista);
		
		table.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> {
            setEntity(newValue);
        });
		
		table.setItems(lista);
		pesquisarPorNome();
	}

	private void setEntity(Ingrediente newValue) {
		controlIng.
		
	}


	public TableView<Ingrediente> getTable() {
		return table;
	}

}

