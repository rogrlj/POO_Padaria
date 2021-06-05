package dominio.padario.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import dominio.padaria.entity.Ingrediente;

public class IngredienteDAO implements IIngredienteDAO{
	
	private Connection c;

    public IngredienteDAO() {
    	try {
    		IGenericDAO gDao = new GenericDAO();
            c = gDao.getConnection();
		} catch (Exception e) {
			e.printStackTrace();
		}
    	
	}
        

	@Override
	public void adicionar(Ingrediente i) throws SQLException {
		String sql = "INSERT INTO ingrediente (nome, tipoUnit) VALUES (?, ?)";
        PreparedStatement stmt = c.prepareStatement(sql);
        stmt.setString(1, i.getNome());
        stmt.setString(2, i.getTipoUnit());
        stmt.executeUpdate();
        c.close();
	}

	@Override
	public List<Ingrediente> pesquisarPorNome(String nome) throws SQLException {
		List<Ingrediente> lista = new ArrayList<>();
		
		String sql = "SELECT * FROM ingrediente WHERE nome LIKE ?";
        PreparedStatement stmt = c.prepareStatement(sql);
        stmt.setString(1, "%" + nome + "%");
        ResultSet rs = stmt.executeQuery();

        while(rs.next()) {
            Ingrediente i = new Ingrediente();
            i.setNome(rs.getString("nome"));
            i.setTipoUnit(rs.getString("tipoUnit"));
            lista.add(i);
        }
        c.close();
		return null;
	}

	@Override
	public void remover(Ingrediente i) throws SQLException {
		String sql = "DELETE FROM ingrediente WHERE nome LIKE ?";
        PreparedStatement stmt = c.prepareStatement(sql);
        stmt.setString(1, "%" + i.getNome() + "%");
        stmt.executeUpdate();
        c.close();
	}

	@Override
	public void alterar(Ingrediente i) throws SQLException {
		String sql = "UPDATE ingrediente SET nome = ?, tipoUnit = ? WHERE nome LIKE ?";
        PreparedStatement stmt = c.prepareStatement(sql);
        stmt.setString(1, i.getNome());
        stmt.setString(2, i.getTipoUnit());
        stmt.setString(3, "%" + i.getNome() + "%");
        stmt.executeUpdate();
        c.close();
		
	}

}
