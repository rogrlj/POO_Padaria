package dominio.padaria.control;

import java.util.Iterator;

import dominio.padaria.entity.Ingrediente;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

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

	public void adicionar() {
		lista.add(getEntity());
	}

	public void pesquisarPorNome() {
		for (Ingrediente i : lista) {
			if (i.getNome().contains(nome.get())) {
				setEntity(i);
			}
		}
	}

	public void remover() {
		try {
			for (Ingrediente i : lista) {
				if (i.getNome().equalsIgnoreCase(nome.get())) {
					lista.remove(i);
				}
			}
		}
		 catch (Exception e) {
			System.out.println(e);
		}
		

	}

	public void alterar() {
		for (Ingrediente i : lista) {
			if (i.getNome().contains(nome.get())) {
				lista.set(lista.indexOf(i), getEntity());
			}
		}
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
