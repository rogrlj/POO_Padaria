package dominio.padario.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import dominio.padaria.entity.Estoque;
import dominio.padaria.entity.Ingrediente;

public class EstoqueDAO implements IEstoqueDAO{
	
	private Connection c;
	
	public EstoqueDAO() {
		try {
    		IGenericDAO gDao = new GenericDAO();
            c = gDao.getConnection();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public void adicionar(Estoque e) {
		try {
			String sql = "INSERT INTO estoque (quantidade, ingrediente_id) VALUES (?, ?)";
	        PreparedStatement stmt = c.prepareStatement(sql);
	        stmt.setInt(1, e.getQuantidade());
	        stmt.executeUpdate();
	        stmt.close();
		} catch (SQLException e1) {
			e1.printStackTrace();
		}
		
	}

	@Override
	public void alterar(Estoque e) {
		try {
			String sql = "UPDATE estoque SET quantidade = ?, ingrediente_id = ? WHERE id = ?";
	        PreparedStatement stmt = c.prepareStatement(sql);
	        stmt.setInt(1, e.getQuantidade());
	        stmt.setInt(2, e.getIngrediente());
	        stmt.setInt(3, e.getId());
	        stmt.executeUpdate();
	        stmt.close();
		} catch (SQLException e1) {
			e1.printStackTrace();
		}
		
	}

	@Override
	public List<Ingrediente> pesquisarIngrediente(String nome) {
		List<Ingrediente> lista = new ArrayList<>();
		try {
			String sql = "\r\n" + 
					"SELECT ping.ingrediente_id, i.nome, ping.quantidade \r\n" + 
					"FROM ingrediente i, produto_ingrediente ping\r\n" + 
					"WHERE i.id = ping.ingrediente_id";
	        PreparedStatement stmt = c.prepareStatement(sql);
	        ResultSet rs = stmt.executeQuery();

	        while(rs.next()) {
	            Ingrediente i = new Ingrediente();
	            i.setId(rs.getInt("id"));
	            i.setNome(rs.getString("nome"));
	            i.setTipoUnit(rs.getString("tipoUnit"));
	            lista.add(i);
	        } 
		}catch (SQLException e) {
			e.printStackTrace();
		}
		
		return lista;
	}
	
	public int getIdIngrediente(String nome) {
		
		int id = 0;
		
		try {
			String sql = "SELECT id FROM ingrediente WHERE nome LIKE ?";
	        PreparedStatement stmt = c.prepareStatement(sql);
	        stmt.setString(1, "%" + nome + "%");
	        ResultSet rs = stmt.executeQuery();

	        while(rs.next()) {
	            
	            id = (rs.getInt("id"));
	        } 
		}catch (SQLException e) {
			e.printStackTrace();
		}
		return id;
	}

}
