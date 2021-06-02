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
import javafx.stage.Stage;

public class ProdutoBoundary extends Application{
	
	private TextField nomeProduto = new TextField();
	private Button btnPesquisar = new Button("Pesquisar");
	private Button btnSalvar = new Button("Salvar");
//	private ComboBox<String> cmbIngr = new ComboBox<>();
//	private TextField qtdeIngr = new TextField();
	private Button btnNovoIngr = new Button("+");
	private Label lblNome = new Label("Nome");
	private int x= 0;
	
	public static void main(String[] args) {
		Application.launch(ProdutoBoundary.class, args);
	}

	@Override
	public void start(Stage stg) throws Exception {
		
		AnchorPane pane = new AnchorPane();
		BorderPane border = new BorderPane();
		HBox hbox = new HBox();
		GridPane grid = new GridPane();
		
		Scene scn = new Scene(pane, 600, 400);
		
		hbox.getChildren().addAll(lblNome, nomeProduto, btnPesquisar);
		
		border.setTop(hbox);
		
		

		grid.add(new ComboBox<>(), 0, x);
		grid.add(new Label("Quantidade"), 1, x);
		grid.add(new TextField(), 2, x);;
		grid.add(btnNovoIngr, 3, x);
		
		border.setCenter(grid);
		
		btnNovoIngr.setOnAction((e) -> {
			x++;
			grid.add(new ComboBox<String>(), 0, x);
			grid.add(new Label("Quantidade"), 1, x);
			grid.add(new TextField(), 2, x);
//			grid.add(cmbIngr, 0, x);
//			grid.add(new Label("Quantidade"), 1, x);
//			grid.add(qtdeIngr, 2, x);
			});
		
		border.setBottom(btnSalvar);
		
		
		AnchorPane.setTopAnchor(border, 15.0);
	    AnchorPane.setRightAnchor(border, 15.0);
	    AnchorPane.setBottomAnchor(border, 15.0);
	    AnchorPane.setLeftAnchor(border, 15.0);
	    pane.getChildren().addAll(border);
	    pane.setStyle("-fx-background-color: BEIGE");
	    
	    stg.setTitle("Cadastrar Produto");
	    stg.setScene(scn);
	    stg.show();
		
	}
	

}
