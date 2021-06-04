package dominio.padaria.entity;

import java.util.List;

public class Produto {
	
	private String nome;
	
	private List<Ingrediente_Produto> ingrediente;
	

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public List<Ingrediente_Produto> getIngrediente() {
		return ingrediente;
	}

	public void setIngrediente(List<Ingrediente_Produto> ingrediente) {
		this.ingrediente = ingrediente;
	}

}
