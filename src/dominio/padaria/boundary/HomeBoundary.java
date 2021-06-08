package dominio.padaria.boundary;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ToolBar;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class HomeBoundary extends Application{
	
	private Label nome = new Label("BEM VINDO AO SIGP");
	
	private ITelaStrategy telaIngr = new IngredienteBoundary();
	private ITelaStrategy telaEst = new EstoqueBoundary();
	private ITelaStrategy telaRelat = new RelatorioBoundary();

	
	public static void main(String[] args) {
		Application.launch(HomeBoundary.class, args);
	}

	@Override
	public void start(Stage stg) throws Exception {
		
		BorderPane border = new BorderPane();
	    AnchorPane pane = new AnchorPane();
		ToolBar toolBar = new ToolBar();
		Scene scn = new Scene(pane, 600, 400);
		
	    border.setCenter(nome);
     
		
		Button btnHome = new Button("Home");
        toolBar.getItems().add(btnHome);
        
        btnHome.setOnAction((e) -> { border.setCenter(nome);});      
        
                
        Button btnIng = new Button("Cadastrar Ingrediente");
        toolBar.getItems().add(btnIng);
        
        btnIng.setOnAction((e) -> { border.setCenter(telaIngr.fornecerConteudo());});
        
        Button btnEstoque = new Button("Controle Estoque");
        toolBar.getItems().add(btnEstoque);
        
        btnEstoque.setOnAction((e) -> { border.setCenter(telaEst.fornecerConteudo());});
        
        Button btnRelat= new Button("Visualizar Relatórios");
        toolBar.getItems().add(btnRelat);
        
        btnRelat.setOnAction((e) -> { border.setCenter(telaRelat.fornecerConteudo());});

	    border.setTop(toolBar);
	    



	      AnchorPane.setTopAnchor(border, 15.0);
	      AnchorPane.setRightAnchor(border, 15.0);
	      AnchorPane.setBottomAnchor(border, 15.0);
	      AnchorPane.setLeftAnchor(border, 15.0);
	      pane.getChildren().addAll(border);
	      pane.setStyle("-fx-background-color: BEIGE");
	      
	      stg.setTitle("SIGP");
	      stg.setScene(scn);
	      stg.show();
		
		
	}

	
}
