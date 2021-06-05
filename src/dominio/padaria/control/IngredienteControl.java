package dominio.padaria.control;

import java.util.Iterator;
import java.util.List;

import dominio.padaria.entity.Ingrediente;
import dominio.padario.dao.DAOException;
import dominio.padario.dao.IIngredienteDAO;
import dominio.padario.dao.IngredienteDAO;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import java.sql.SQLException;


public class IngredienteControl {

	private ObservableList<Ingrediente> lista = FXCollections.observableArrayList();
	private TableView<Ingrediente> table = new TableView<>();

	private StringProperty nome = new SimpleStringProperty("");
	public StringProperty nomeProperty() {
		return nome;
	}

	private StringProperty tipoUnit = new SimpleStringProperty("");
	public StringProperty tipoUnitProperty() {
		return tipoUnit;
	}
	
	private IIngredienteDAO ingDAO = new IngredienteDAO();

	public Ingrediente getEntity() {
		Ingrediente i = new Ingrediente();
		i.setNome(nome.get());
		i.setTipoUnit(tipoUnit.get());
		return i;
	}

	private void setEntity(Ingrediente i) {
		if (i != null) {
			nome.set(i.getNome());
			tipoUnit.set(i.getTipoUnit());
		}
	}

	public void adicionar() throws SQLException {
		Ingrediente i = getEntity();
		ingDAO.adicionar(i);
	}

	public void pesquisarPorNome() throws SQLException {
		List<Ingrediente> pets = ingDAO.pesquisarPorNome(nome.get());
        lista.clear();
        lista.addAll(pets);
	}

	public void remover() throws SQLException {
		Ingrediente i = getEntity();
		ingDAO.remover(i);
		

	}

	public void alterar() throws SQLException {
		Ingrediente i = getEntity();
		ingDAO.alterar(i);
	}

	public void generateTable() {

		TableColumn<Ingrediente, String> colNome = new TableColumn<>("Nome");
		colNome.setCellValueFactory(new PropertyValueFactory<Ingrediente, String>("nome"));

		TableColumn<Ingrediente, String> colTipoUnit = new TableColumn<>("Tipo Unitário");
		colTipoUnit.setCellValueFactory(new PropertyValueFactory<Ingrediente, String>("tipoUnit"));

		table.getColumns().addAll(colNome, colTipoUnit);
		table.setItems(lista);

	}

	public TableView<Ingrediente> getTable() {
		return table;
	}

}
