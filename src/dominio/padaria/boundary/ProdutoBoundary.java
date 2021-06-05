package dominio.padaria.boundary;

import javafx.application.Application;
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

public class ProdutoBoundary implements ITelaStrategy{
	
	private TextField nomeProduto = new TextField();
	private Button btnPesquisar = new Button("Pesquisar");
	private Button btnSalvar = new Button("Salvar");
	private ComboBox<String> cmbIngr = new ComboBox<>();
	private TextField qtdeIngr = new TextField();
	private Button btnNovoIngr = new Button("+");
	private Label lblNome = new Label("Nome");
	private int x= 0;
	
	private BorderPane border = new BorderPane();
	private HBox hbox = new HBox();
	private GridPane grid = new GridPane();
	
    public ProdutoBoundary() {
			
		hbox.getChildren().addAll(lblNome, nomeProduto, btnPesquisar);
		
		border.setTop(hbox);
		
//		cmbIngr.setItems();
		

		grid.add(cmbIngr, 0, x);
		grid.add(new Label("Quantidade"), 1, x);
		grid.add(qtdeIngr, 2, x);
		grid.add(btnNovoIngr, 3, x);
		
		border.setCenter(grid);
		
		btnNovoIngr.setOnAction((e) -> {
			x++;
			ComboBox<String> newCmbIngr = new ComboBox<>();
			TextField qtdeIngr = new TextField();
			grid.add(newCmbIngr, 0, x);
			grid.add(new Label("Quantidade"), 1, x);
			grid.add(qtdeIngr, 2, x);
			});
		
		border.setBottom(btnSalvar);
		
	}

	@Override
	public Pane fornecerConteudo() {
		// TODO Auto-generated method stub
		return border;
	}
	

}
