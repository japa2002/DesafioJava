package model.persistencia;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import conexao.ConexaoFactory;
import model.entidade.Sala;

/**
 * Metodo para consulta da sala no banco de dados 
 * @author Breno
 *
 */
public class SalaDAO {

	private Connection conexao = ConexaoFactory.getConnection();
	
	/**
	 * Metodo para inserir uma sala no banco de dados
	 * @param Sala sala
	 * @author Leonardo
	 * @throws SQLException 
	 */
	public void insert(Sala sala) throws SQLException {
		String sql = "insert into sala (nomeSala, lotacaoSala, etapa) values (?, ?, ?)";
		PreparedStatement comandoSql = conexao.prepareStatement(sql);
		
		comandoSql.setString(1, sala.getNomeSala());
		comandoSql.setInt(2, sala.getLotacaoSala());
		comandoSql.setBoolean(3, sala.isEtapa());
		
		comandoSql.execute();
		comandoSql.close();	
	}
	
	/**
	 * Metodo para Atualizar sala no banco de dados.
	 * O <code>idSala</code> deve ser igual ao da sala que deseja atualizar
	 * @param Sala sala
	 * @author Breno
	 * @throws SQLException 
	 */
	
	public void update(Sala sala) throws SQLException {
		String sql = "update sala set nomeSala = ?, lotacaoSala = ?, etapa = ? where idSala = ?";
		PreparedStatement comandoSql = conexao.prepareStatement(sql);
		
		comandoSql.setString(1, sala.getNomeSala());
		comandoSql.setInt(2, sala.getLotacaoSala());
		comandoSql.setBoolean(3, sala.isEtapa());
		comandoSql.setInt(4, sala.getIdSala());
		
		comandoSql.execute();
		comandoSql.close();
	}
	
	/**
	 * Deleta a sala do respectivo id do banco de dados.
	 * O <code>idSala</code> deve ser igual ao da sala que deseja deletar
	 * @param int idSala
	 * @author Breno
	 * @return 
	 * @throws SQLException 
	 */
	public boolean deleteId(int idSala) throws SQLException {
		String sql = "delete from sala where idSala = ?";
		PreparedStatement comandoSql = conexao.prepareStatement(sql);
		
		comandoSql.setInt(1, idSala);
		
		comandoSql.execute();
		comandoSql.close();
		return true;
	}
	
	/**
	 * Metodo para selecionar a sala do banco de dados apartir do respectivo id.
	 * O <code>idSala</code> deve ser igual ao da sala que deseja buscar
	 * @param int idSala
	 * @return Sala sala
	 * @author Breno
	 * @throws SQLException 
	 */
	public Sala buscarId(int idSala) throws SQLException {
		Sala sala = new Sala();
		String sql = "select * from sala where idSala = ?";
		PreparedStatement comandoSql = conexao.prepareStatement(sql);
		
		comandoSql.setInt(1, idSala);
		ResultSet resultSet = comandoSql.executeQuery();
		
		if (resultSet.next()) {
			sala.setIdSala(resultSet.getInt(1));
			sala.setNomeSala(resultSet.getString(2));
			sala.setLotacaoSala(resultSet.getInt(3));
			sala.setEtapa(resultSet.getBoolean(4));
		}
		comandoSql.close();
		return sala;
	}
	
	/**
	 * Metodo para selecionar do banco de dados todos as salas cadastrados
	 * @author Breno
	 * @return lista de salas registrados no banco 
	 * @throws SQLException
	 */
	public List<Sala> buscarTodos() throws SQLException {
		List<Sala> lista =  new ArrayList<Sala>();
		String sql = "select * from sala";
		
		PreparedStatement comandoSql = conexao.prepareStatement(sql);
		ResultSet resultSet = comandoSql.executeQuery();
		
		while (resultSet.next()) {
			Sala sala = new Sala();
			sala.setIdSala(resultSet.getInt(1));
			sala.setNomeSala(resultSet.getString(2));
			sala.setLotacaoSala(resultSet.getInt(3));
			sala.setEtapa(resultSet.getBoolean(4));
			
			lista.add(sala);
		}
		comandoSql.close();
		return lista;
	}
}
