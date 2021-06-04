package dominio.padaria.control;

import java.time.format.DateTimeFormatter;

import dominio.padaria.entity.Estoque;
import dominio.padaria.entity.Historico;
import dominio.padaria.entity.Ingrediente;
import javafx.beans.property.ReadOnlyStringWrapper;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

public class RelatorioControl {
	
	private ObservableList<Estoque> listaEstoque = FXCollections.observableArrayList();
	private TableView<Estoque> tableEstoque = new TableView<>();
	
	private ObservableList<Historico> listaHist = FXCollections.observableArrayList();
	private TableView<Historico> tableHist = new TableView<>();
	
	private DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
	
	public void generateTableEstoque() {

		TableColumn<Estoque, String> colNome = new TableColumn<>("Nome Ingrediente");
		colNome.setCellValueFactory(new PropertyValueFactory<Estoque, String>("ingrediente"));

		TableColumn<Estoque, Integer> colQtde = new TableColumn<>("Quantidade");
		colQtde.setCellValueFactory(new PropertyValueFactory<Estoque, Integer>("quantidade"));

		tableEstoque.getColumns().addAll(colNome, colQtde); 
		tableEstoque.setItems(listaEstoque);
	}
	
	public void generateTableHist() {

		TableColumn<Historico, String> colNome = new TableColumn<>("Nome");
		colNome.setCellValueFactory(new PropertyValueFactory<Historico, String>("nome"));
		
		TableColumn<Historico, String> colAcao = new TableColumn<>("Ação");
		colNome.setCellValueFactory(new PropertyValueFactory<Historico, String>("acao"));

		TableColumn<Historico, Integer> colQtde = new TableColumn<>("Quantidade");
		colQtde.setCellValueFactory(new PropertyValueFactory<Historico, Integer>("quantidade"));
		
		TableColumn<Historico, String> colDate = new TableColumn<>("Data");
		colDate.setCellValueFactory((item) -> {
            String txtData = item.getValue().getDate().format(formatter);
            return new ReadOnlyStringWrapper(txtData);
        });
		

		tableHist.getColumns().addAll(colNome, colAcao, colQtde, colDate); 
		tableHist.setItems(listaHist);
	}
	
	public TableView<Estoque> getTableEstoque() {
		return tableEstoque;
	}
	
	public TableView<Historico> getTableHist() {
		return tableHist;
	}
	
}
