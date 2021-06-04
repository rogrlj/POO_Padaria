package dominio.padaria.control;

import dominio.padaria.entity.Ingrediente;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.TableView;

public class EstoqueControl {
	
	private ObservableList<Ingrediente> lista = FXCollections.observableArrayList();
	private TableView<Ingrediente> table = new TableView<>();

	private StringProperty nome = new SimpleStringProperty("");


}
