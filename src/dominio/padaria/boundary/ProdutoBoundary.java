package dominio.padaria.boundary;

import dominio.padaria.control.ProdutoControl;
import javafx.application.Application;
import javafx.beans.binding.Bindings;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import javafx.util.StringConverter;
import javafx.util.converter.IntegerStringConverter;

public class ProdutoBoundary implements ITelaStrategy{
	
	private TextField nomeProduto = new TextField();
	private Button btnCriar= new Button("Criar");
	private Button btnSalvar = new Button("Salvar");
	private ComboBox<String> cmbIngr = new ComboBox<>();
	private TextField qtdeIngr = new TextField();
	private Button btnNovoIngr = new Button("+");
	private Label lblNome = new Label("Nome");
	private int x= 0;
	
	private BorderPane border = new BorderPane();
	private HBox hbox = new HBox();
	private GridPane grid = new GridPane();
	
	private ProdutoControl control = new ProdutoControl();
	
	private ObservableList<String> ingr =  FXCollections.observableArrayList();
	
    @SuppressWarnings("unchecked")
	public ProdutoBoundary() {
			
		hbox.getChildren().addAll(lblNome, nomeProduto, btnCriar);
		
		border.setTop(hbox);
		
		ingr.addAll(control.buscaIngrediente());
		
		cmbIngr.setItems(ingr);
		

		grid.add(cmbIngr, 0, x);
		grid.add(new Label("Quantidade"), 1, x);
		grid.add(qtdeIngr, 2, x);
		grid.add(btnNovoIngr, 3, x);
		
		border.setCenter(grid);
		
		btnNovoIngr.setOnAction((e) -> {
			x++;
			ComboBox<String> newCmbIngr = new ComboBox<>();
			newCmbIngr.setItems(ingr);
			TextField qtdeIngr = new TextField();
			grid.add(newCmbIngr, 0, x);
			grid.add(new Label("Quantidade"), 1, x);
			grid.add(qtdeIngr, 2, x);
			});
		
		border.setBottom(btnSalvar);
		
        StringConverter converter = new IntegerStringConverter();
		
		Bindings.bindBidirectional(nomeProduto.textProperty(), control.nomeProdutoProperty());
		Bindings.bindBidirectional(qtdeIngr.textProperty(), control.quantidadeProperty(), converter);
		Bindings.bindBidirectional(cmbIngr.valueProperty(), control.nomeIngrProperty());
		
		btnCriar.setOnAction((e) -> {control.adicionar();});
		btnSalvar.setOnAction((e) -> {control.adicionarIngredienteProduto();});;
	}

	@Override
	public Pane fornecerConteudo() {
		// TODO Auto-generated method stub
		return border;
	}
	

}
