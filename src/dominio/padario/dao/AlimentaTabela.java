package dominio.padario.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import dominio.padaria.entity.Estoque;
import dominio.padaria.entity.Historico;
import dominio.padaria.entity.Ingrediente;
import dominio.padaria.entity.Ingrediente_Produto;
import dominio.padaria.entity.Produto;

public class AlimentaTabela implements IAlimentaTabelaDAO{
	
	private Connection c;

    public AlimentaTabela() {
    	try {
    		IGenericDAO gDao = new GenericDAO();
            c = gDao.getConnection();
		} catch (Exception e) {
			e.printStackTrace();
		}
    	
	}

	@Override
	public List<Ingrediente> alimentaIngrediente() {
		List<Ingrediente> lista = new ArrayList<>();
		try {
			String sql = "SELECT * FROM ingrediente";
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

	@Override
	public List<Produto> alimentaProd() {
		List<Produto> lista = new ArrayList<>();
		try {
			String sql = "SELECT * FROM produto";
	        PreparedStatement stmt = c.prepareStatement(sql);
	        ResultSet rs = stmt.executeQuery();

	        while(rs.next()) {
	            Produto p = new Produto();
	            p.setId(rs.getInt("id"));
	            p.setNome(rs.getString("nome"));
	            lista.add(p);
	        } 
		}catch (SQLException e) {
			e.printStackTrace();
		}
		
		return lista;
	}

	@Override
	public List<Ingrediente_Produto> alimentaIngPr() {
		List<Ingrediente_Produto> lista = new ArrayList<>();
		try {
			String sql = "SELECT * FROM produto_ingrediente";
	        PreparedStatement stmt = c.prepareStatement(sql);
	        ResultSet rs = stmt.executeQuery();

	        while(rs.next()) {
	            Ingrediente_Produto p = new Ingrediente_Produto();
	            p.setId_produto(rs.getInt("produto_id"));
	            p.setIngrediente(rs.getInt("ingrediente_id"));
	            p.setQuantidade(rs.getInt("quantidade"));
	            lista.add(p);
	        } 
		}catch (SQLException e) {
			e.printStackTrace();
		}
		
		return lista;
	}

	@Override
	public List<Estoque> alimentaEstoque() {
		List<Estoque> lista = new ArrayList<>();
		try {
			String sql = "SELECT * FROM estoque";
	        PreparedStatement stmt = c.prepareStatement(sql);
	        ResultSet rs = stmt.executeQuery();

	        while(rs.next()) {
	            Estoque p = new Estoque();
	            p.setId(rs.getInt("id"));
	            p.setIngrediente(rs.getInt("ingrediente_id"));
	            p.setQuantidade(rs.getInt("quantidade"));
	            lista.add(p);
	        } 
		}catch (SQLException e) {
			e.printStackTrace();
		}
		
		return lista;
	}

	@Override
	public List<Historico> alimentaHist() {
		return null;
	}

}
