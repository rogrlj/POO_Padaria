package dominio.padaria.entity;


public class Ingrediente_Produto {
	
	
	private int quantidade;
	private int id_ingrediente;
	private int id_produto;

	public int getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(int quantidade) {
		this.quantidade = quantidade;
	}

	public int getIngrediente() {
		return id_ingrediente;
	}

	public void setIngrediente(int id_ingrediente) {
		this.id_ingrediente = id_ingrediente;
	}

	public int getId_produto() {
		return id_produto;
	}

	public void setId_produto(int id_produto) {
		this.id_produto = id_produto;
	}

}

