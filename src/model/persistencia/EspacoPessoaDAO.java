package model.persistencia;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import conexao.ConexaoFactory;
import model.entidade.EspacoPessoa;

/**
 * Metodo para consulta do EspacoPessoa no banco de dados 
 * @author Breno
 *
 */
public class EspacoPessoaDAO {
	
	private Connection conexao = ConexaoFactory.getConnection();
	
	/**
	 * Metodo para inserir um espacoPessoa no banco de dados
	 * @param EspacoPessoa espacoPessoa
	 * @author Leonardo
	 * @throws SQLException 
	 */
	public void insert(EspacoPessoa espacoPessoa) throws SQLException {
		String sql = "insert into espacoPessoa (fk_espaco, fk_pessoa) values (?, ?)";
		PreparedStatement comandoSql = conexao.prepareStatement(sql);
		
		comandoSql.setInt(1, espacoPessoa.getIdEspaco());
		comandoSql.setInt(2, espacoPessoa.getIdPessoa());
		
		comandoSql.execute();
		comandoSql.close();	
	}
	
	/**
	 * Metodo para Atualizar espacoPessoa no banco de dados.
	 * O <code>idEspacoPessoa</code> deve ser igual ao do espacoPessoa que deseja atualizar
	 * @param EspacoPessoa espacoPessoa
	 * @author Breno
	 * @throws SQLException 
	 */
	
	public void update(EspacoPessoa espacoPessoa) throws SQLException {
		String sql = "update espacoPessoa set fk_espaco = ?, fk_pessoa = ? where idEspacoPessoa = ?";
		PreparedStatement comandoSql = conexao.prepareStatement(sql);
		
		comandoSql.setInt(1, espacoPessoa.getIdEspaco());
		comandoSql.setInt(2, espacoPessoa.getIdPessoa());
		comandoSql.setInt(3, espacoPessoa.getIdEspacoPessoa());
		
		comandoSql.execute();
		comandoSql.close();
	}
	
	/**
	 * Deleta o espacoPessoa do respectivo id do banco de dados.
	 * O <code>idEspacoPessoa</code> deve ser igual ao do espacoPessoa que deseja deletar
	 * @param int idEspaco
	 * @author Breno
	 * @throws SQLException 
	 */
	public boolean deleteId(int idEspacoPessoa) throws SQLException {
		String sql = "delete from espacoPessoa where idEspacoPessoa = ?";
		PreparedStatement comandoSql = conexao.prepareStatement(sql);
		
		comandoSql.setInt(1, idEspacoPessoa);
		
		comandoSql.execute();
		comandoSql.close();
		return true;
	}
	
	/**
	 * Metodo para selecionar o espacoPessoa do banco de dados apartir do respectivo id.
	 * O <code>idEspacoPessoa</code> deve ser igual ao do espacoPessoa que deseja buscar
	 * @param int idEspacoPessoa
	 * @return EspacoPessoa espacoPessoa
	 * @author Breno
	 * @throws SQLException 
	 */
	public EspacoPessoa buscarId(int idEspacoPessoa) throws SQLException {
		EspacoPessoa espacoPessoa = new EspacoPessoa();
		String sql = "select * from espacoPessoa where idEspacoPessoa = ?";
		PreparedStatement comandoSql = conexao.prepareStatement(sql);
		
		comandoSql.setInt(1, idEspacoPessoa);
		ResultSet resultSet = comandoSql.executeQuery();
		
		if (resultSet.next()) {
			espacoPessoa.setIdEspacoPessoa(resultSet.getInt(1));
			espacoPessoa.setIdEspaco(resultSet.getInt(2));
			espacoPessoa.setIdPessoa(resultSet.getInt(3));
		}
		comandoSql.close();
		return espacoPessoa;
	}
	
	/**
	 * Metodo para selecionar do banco de dados todos os espacoPessoa cadastrados
	 * @author Breno
	 * @return lista de alunos registrados no banco 
	 * @throws SQLException
	 */
	public List<EspacoPessoa> buscarTodos() throws SQLException {
		List<EspacoPessoa> lista =  new ArrayList<EspacoPessoa>();
		String sql = "select * from espacoPessoa";
		
		PreparedStatement comandoSql = conexao.prepareStatement(sql);
		ResultSet resultSet = comandoSql.executeQuery();
		
		while (resultSet.next()) {
			EspacoPessoa espacoPessoa = new EspacoPessoa();
			espacoPessoa.setIdEspacoPessoa(resultSet.getInt(1));
			espacoPessoa.setIdEspaco(resultSet.getInt(2));
			espacoPessoa.setIdPessoa(resultSet.getInt(3));
			
			lista.add(espacoPessoa);
		}
		comandoSql.close();
		return lista;
	}
}
