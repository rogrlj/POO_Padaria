package dominio.padaria.boundary;

import dominio.padaria.control.EstoqueControl;
import dominio.padaria.control.IngredienteControl;
import javafx.beans.binding.Bindings;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.Spinner;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.util.StringConverter;
import javafx.util.converter.IntegerStringConverter;

public class EstoqueBoundary implements ITelaStrategy{
	
	private TextField nomeProduto = new TextField();
	private Button btnPesquisar = new Button("Pesquisar");
	private Button btnAdicionar = new Button("Adicionar");
	private Button btnRemover = new Button("Remover");
	private Label lblNome = new Label("");
	private Label lblId = new Label("");
	private TextField spnQtde = new TextField();
	
	private BorderPane border = new BorderPane();
	private VBox vbox = new VBox();
	private HBox hbox2 = new HBox();
	
	private EstoqueControl control = new EstoqueControl();
	private IngredienteControl controlIng = new IngredienteControl();
	
    public EstoqueBoundary() {
			
		vbox.getChildren().addAll(lblNome, spnQtde, btnAdicionar, btnRemover );
		
		border.setRight(vbox);
		
		
		control.generateTable();       
        border.setCenter(control.getTable());
        
		
		@SuppressWarnings("rawtypes")
		StringConverter converter = new IntegerStringConverter();
		Bindings.bindBidirectional(lblNome.textProperty(), control.nomeProperty());
		Bindings.bindBidirectional(spnQtde.textProperty(), control.quantidadeProperty(), converter);
		Bindings.bindBidirectional(lblId.textProperty(), control.idProperty(), converter);
		
		btnAdicionar.setOnAction((e) -> {control.adicionar();});
		btnRemover.setOnAction((e) -> {control.adicionar();});
		
	}

	@Override
	public Pane fornecerConteudo() {
		// TODO Auto-generated method stub
		return border;
	}

}

