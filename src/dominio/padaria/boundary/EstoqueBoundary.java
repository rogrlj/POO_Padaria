package dominio.padaria.boundary;

import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.Spinner;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;

public class EstoqueBoundary implements ITelaStrategy{
	
	private TextField nomeProduto = new TextField();
	private Button btnPesquisar = new Button("Pesquisar");
	private Button btnAdicionar = new Button("Adicionar");
	private Button btnRemover = new Button("Remover");
	private Label lblNome = new Label("Nome");
	private Spinner<Integer> spnQtde = new Spinner<>(0, 1000, 0);
	
	private BorderPane border = new BorderPane();
	private HBox hbox = new HBox();
	private HBox hbox2 = new HBox();
	
	
    public EstoqueBoundary() {
			
		hbox.getChildren().addAll(lblNome, nomeProduto, btnPesquisar);
		
		border.setTop(hbox);
		
		hbox.getChildren().addAll(spnQtde, btnAdicionar, btnRemover);
		
		
		border.setRight(hbox2);
		
		
	}

	@Override
	public Pane fornecerConteudo() {
		// TODO Auto-generated method stub
		return border;
	}

}

