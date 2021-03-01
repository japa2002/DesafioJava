package model.persistencia;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import conexao.ConexaoFactory;
import model.entidade.Espaco;

/**
 * Metodo para consulta do espaco no banco de dados 
 * @author Leonardo
 *
 */
public class EspacoDAO {
	
	private Connection conexao = ConexaoFactory.getConnection();
	
	/**
	 * Metodo para inserir um espaco no banco de dados
	 * @param Espaco espaco
	 * @author Breno
	 * @throws SQLException 
	 */
	public void insert(Espaco espaco) throws SQLException {
		String sql = "insert into espaco (nomeEspaco, lotacaoEspaco, intervalo) values (?, ?, ?)";
		PreparedStatement comandoSql = conexao.prepareStatement(sql);
		
		comandoSql.setString(1, espaco.getNomeEspaco());
		comandoSql.setInt(2, espaco.getLotacaoEspaco());
		comandoSql.setBoolean(3, espaco.isIntervalo());
		
		comandoSql.execute();
		comandoSql.close();	
	}
	
	/**
	 * Metodo para Atualizar espaco no banco de dados.
	 * O <code>idEspaco</code> deve ser igual ao do espaco que deseja atualizar
	 * @param Espaco espaco
	 * @author Breno
	 * @throws SQLException 
	 */
	
	public void update(Espaco espaco) throws SQLException {
		String sql = "update espaco set nomeEspaco = ?, lotacaoEspaco = ?, intervalo = ? where idEspaco = ?";
		PreparedStatement comandoSql = conexao.prepareStatement(sql);
		
		comandoSql.setString(1, espaco.getNomeEspaco());
		comandoSql.setInt(2, espaco.getLotacaoEspaco());
		comandoSql.setBoolean(3, espaco.isIntervalo());
		comandoSql.setInt(4, espaco.getIdEspaco());
		
		comandoSql.execute();
		comandoSql.close();
	}
	
	/**
	 * Deleta o espaco do respectivo id do banco de dados.
	 * O <code>idEspaco</code> deve ser igual ao do espaco que deseja deletar
	 * @param int idEspaco
	 * @author Leonardo
	 * @return 
	 * @throws SQLException 
	 */
	public boolean deleteId(int idEspaco) throws SQLException {
		String sql = "delete from espaco where idEspaco = ?";
		PreparedStatement comandoSql = conexao.prepareStatement(sql);
		
		comandoSql.setInt(1, idEspaco);
		
		comandoSql.execute();
		comandoSql.close();
		return true;
	}
	
	/**
	 * Metodo para selecionar o espaco do banco de dados apartir do respectivo id.
	 * O <code>idEspaco</code> deve ser igual ao do espaco que deseja buscar
	 * @param int idEspaco
	 * @return Espaco espaco
	 * @author Breno
	 * @throws SQLException 
	 */
	public Espaco buscarId(int idEspaco) throws SQLException {
		Espaco espaco = new Espaco();
		String sql = "select * from espaco where idEspaco = ?";
		PreparedStatement comandoSql = conexao.prepareStatement(sql);
		
		comandoSql.setInt(1, idEspaco);
		ResultSet resultSet = comandoSql.executeQuery();
		
		if (resultSet.next()) {
			espaco.setIdEspaco(resultSet.getInt(1));
			espaco.setNomeEspaco(resultSet.getString(2));
			espaco.setLotacaoEspaco(resultSet.getInt(3));
			espaco.setIntervalo(resultSet.getBoolean(4));
		}
		comandoSql.close();
		return espaco;
	}
	
	/**
	 * Metodo para selecionar do banco de dados todos os espacos cadastrados
	 * @author Leonardo
	 * @return lista de alunos registrados no banco 
	 * @throws SQLException
	 */
	public List<Espaco> buscarTodos() throws SQLException {
		List<Espaco> lista =  new ArrayList<Espaco>();
		String sql = "select * from espaco";
		
		PreparedStatement comandoSql = conexao.prepareStatement(sql);
		ResultSet resultSet = comandoSql.executeQuery();
		
		while (resultSet.next()) {
			Espaco espaco = new Espaco();
			espaco.setIdEspaco(resultSet.getInt(1));
			espaco.setNomeEspaco(resultSet.getString(2));
			espaco.setLotacaoEspaco(resultSet.getInt(3));
			espaco.setIntervalo(resultSet.getBoolean(4));
			
			lista.add(espaco);
		}
		comandoSql.close();
		return lista;
	}
}
