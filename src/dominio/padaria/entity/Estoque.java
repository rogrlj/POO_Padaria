package dominio.padaria.entity;

public class Estoque {
	
	private int id;
	
	private int quantidade;
	
	private int ingrediente;

	public int getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(int quantidade) {
		this.quantidade = quantidade;
	}

	public int getIngrediente() {
		return ingrediente;
	}

	public void setIngrediente(int ingrediente) {
		this.ingrediente = ingrediente;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}


}
