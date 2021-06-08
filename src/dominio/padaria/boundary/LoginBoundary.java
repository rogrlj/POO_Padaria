package dominio.padaria.boundary;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class LoginBoundary extends Application{
	
	private TextField txtUser = new TextField();
	private TextField txtPassword = new TextField();
	
	private Button btnEntrar = new Button("Entrar");

	public static void main(String[] args) {
		Application.launch(LoginBoundary.class, args);
	}

	
	@Override
	public void start(Stage stg) throws Exception {
		
		Label nome =new Label("SIGP");
		
		VBox vbox = new VBox();
		GridPane grid = new GridPane();
		
		Scene scn = new Scene(vbox, 600, 400);
				
		vbox.setPadding(new Insets(15, 15, 15, 15) );
		
		grid.setAlignment(Pos.CENTER);
		
		vbox.setAlignment(Pos.CENTER);
		
		grid.setPadding(new Insets(15, 15, 15, 15));
		
		grid.setHgap(10);
		grid.setVgap(15);
		
		
		grid.add(new Label("Usuário"), 0, 0);
		grid.add(txtUser, 1, 0);
		grid.add(new Label("Senha"), 0, 1);
		grid.add(txtPassword, 1, 1);
		
		vbox.getChildren().addAll(nome, grid, btnEntrar);
		
		
		stg.setTitle("Login");
        stg.setScene(scn);
        stg.show();
	}
	
	
}
