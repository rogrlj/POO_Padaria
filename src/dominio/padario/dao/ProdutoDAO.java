package dominio.padario.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import dominio.padaria.entity.Ingrediente;
import dominio.padaria.entity.Ingrediente_Produto;
import dominio.padaria.entity.Produto;

public class ProdutoDAO implements IProdutoDAO{
	
	private Connection c;
	
	public ProdutoDAO() {
		try {
    		IGenericDAO gDao = new GenericDAO();
            c = gDao.getConnection();
		} catch (Exception e) {
			e.printStackTrace();
		}
    	
	}

	@Override
	public void adicionar(Produto p) {
		try {
			String sql = "INSERT INTO produto (nome) VALUES (?)";
	        PreparedStatement stmt = c.prepareStatement(sql);
	        stmt.setString(1, p.getNome());
	        stmt.executeUpdate();
	        stmt.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}

	@Override
	public List<Ingrediente> buscaIngrediente() {
		List<Ingrediente> lista = new ArrayList<>();
		try {
			String sql = "SELECT id, nome FROM ingrediente";
	        PreparedStatement stmt = c.prepareStatement(sql);
	        ResultSet rs = stmt.executeQuery();

	        while(rs.next()) {
	            Ingrediente i = new Ingrediente();
	            i.setId(rs.getInt("id"));
	            i.setNome(rs.getString("nome"));
	            lista.add(i);
	        } 
		}catch (SQLException e) {
			e.printStackTrace();
		}
		return lista;
	}

	@Override
	public void adicionaProdutoIngrediente(Ingrediente_Produto ip) {
		try {
			String sql = "INSERT INTO produto_ingrediente (produto_id, ingrediente_id, quantidade) VALUES (?, ?, ?)";
	        PreparedStatement stmt = c.prepareStatement(sql);
	        stmt.setInt(1, ip.getId_produto());
	        stmt.setInt(2, ip.getIngrediente());
	        stmt.setInt(3, ip.getQuantidade());
	        stmt.executeUpdate();
	        stmt.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}

}
