package dominio.padaria.boundary;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.control.ToolBar;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class HomeBoundary extends Application{
	
	private Label nome = new Label("BEM VINDO AO SIGP");
	
	public static void main(String[] args) {
		Application.launch(HomeBoundary.class, args);
	}

	@Override
	public void start(Stage stg) throws Exception {
		
		BorderPane border = new BorderPane();
	    AnchorPane pane = new AnchorPane();
		ToolBar toolBar = new ToolBar();
		Scene scn = new Scene(pane, 600, 400);
     
		
		Button btnHome = new Button("Home");
        toolBar.getItems().add(btnHome);
        
        Button btnProd = new Button("Cadastrar Produto");
        toolBar.getItems().add(btnProd);
        
        Button btnIng = new Button("Cadastrar Ingrediente");
        toolBar.getItems().add(btnIng);
        
        IngredienteBoundary ib = new IngredienteBoundary();
        btnIng.setOnAction((e) -> { ib.start(stg);});
        
        Button btnEstoque = new Button("Controle Estoque");
        toolBar.getItems().add(btnEstoque);
        
        Button btnRelat= new Button("Visualizar Relatórios");
        toolBar.getItems().add(btnRelat);

	    border.setTop(toolBar);
	    
	    border.setCenter(nome);


	      AnchorPane.setTopAnchor(border, 15.0);
	      AnchorPane.setRightAnchor(border, 15.0);
	      AnchorPane.setBottomAnchor(border, 15.0);
	      AnchorPane.setLeftAnchor(border, 15.0);
	      pane.getChildren().addAll(border);
	      pane.setStyle("-fx-background-color: BEIGE");
	      
	      stg.setTitle("Home");
	      stg.setScene(scn);
	      stg.show();
		
		
	}

	
	public void teste () {
		
	}
}
