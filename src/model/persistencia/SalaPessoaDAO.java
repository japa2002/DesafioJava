package model.persistencia;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import conexao.ConexaoFactory;
import model.entidade.SalaPessoa;

/**
 * Metodo para consulta da salaPessoa no banco de dados 
 * @author Breno
 *
 */
public class SalaPessoaDAO {

	private Connection conexao = ConexaoFactory.getConnection();
	
	/**
	 * Metodo para inserir uma salaPessoa no banco de dados
	 * @param SalaPessoa salaPessoa
	 * @author Leonardo
	 * @throws SQLException 
	 */
	public void insert(SalaPessoa salaPessoa) throws SQLException {
		String sql = "insert into salaPessoa (fk_sala, fk_pessoa) values (?, ?)";
		PreparedStatement comandoSql = conexao.prepareStatement(sql);
		
		comandoSql.setInt(1, salaPessoa.getIdSala());
		comandoSql.setInt(2, salaPessoa.getIdPessoa());
		
		comandoSql.execute();
		comandoSql.close();	
	}
	
	/**
	 * Metodo para Atualizar salaPessoa no banco de dados.
	 * O <code>idSalaPessoa</code> deve ser igual ao da salaPessoa que deseja atualizar
	 * @param SalaPessoa salaPessoa
	 * @author Breno
	 * @throws SQLException 
	 */
	
	public void update(SalaPessoa salaPessoa) throws SQLException {
		String sql = "update salaPessoa set fk_sala = ?, fk_pessoa = ? where idSalaPessoa = ?";
		PreparedStatement comandoSql = conexao.prepareStatement(sql);
		
		comandoSql.setInt(1, salaPessoa.getIdSala());
		comandoSql.setInt(2, salaPessoa.getIdPessoa());
		comandoSql.setInt(3, salaPessoa.getIdSalaPessoa());
		
		comandoSql.execute();
		comandoSql.close();
	}
	
	/**
	 * Deleta a salaPessoa do respectivo id do banco de dados.
	 * O <code>idSalaPessoa</code> deve ser igual ao da salaPessoa que deseja deletar
	 * @param int idSalaPessoa
	 * @author Breno
	 * @return 
	 * @throws SQLException 
	 */
	public boolean deleteId(int idSalaPessoa) throws SQLException {
		String sql = "delete from salaPessoa where idSalaPessoa = ?";
		PreparedStatement comandoSql = conexao.prepareStatement(sql);
		
		comandoSql.setInt(1, idSalaPessoa);
		
		comandoSql.execute();
		comandoSql.close();
		return true;
	}
	
	/**
	 * Metodo para selecionar a salaPessoa do banco de dados apartir do respectivo id.
	 * O <code>idSalaPessoa</code> deve ser igual ao da salaPessoa que deseja buscar
	 * @param int idSalaPessoa
	 * @return SalaPessoa salaPessoa
	 * @author Breno
	 * @throws SQLException 
	 */
	public SalaPessoa buscarId(int idSalaPessoa) throws SQLException {
		SalaPessoa salaPessoa = new SalaPessoa();
		String sql = "select * from salaPessoa where idSalaPessoa = ?";
		PreparedStatement comandoSql = conexao.prepareStatement(sql);
		
		comandoSql.setInt(1, idSalaPessoa);
		ResultSet resultSet = comandoSql.executeQuery();
		
		if (resultSet.next()) {
			salaPessoa.setIdSalaPessoa(resultSet.getInt(1));
			salaPessoa.setIdSala(resultSet.getInt(2));
			salaPessoa.setIdPessoa(resultSet.getInt(3));
		}
		comandoSql.close();
		return salaPessoa;
	}
	
	/**
	 * Metodo para selecionar do banco de dados todos as salaPessoas cadastrados
	 * @author Breno
	 * @return lista de salaPessoas registrados no banco 
	 * @throws SQLException
	 */
	public List<SalaPessoa> buscarTodos() throws SQLException {
		List<SalaPessoa> lista =  new ArrayList<SalaPessoa>();
		String sql = "select * from salaPessoa";
		
		PreparedStatement comandoSql = conexao.prepareStatement(sql);
		ResultSet resultSet = comandoSql.executeQuery();
		
		while (resultSet.next()) {
			SalaPessoa salaPessoa = new SalaPessoa();
			salaPessoa.setIdSalaPessoa(resultSet.getInt(1));
			salaPessoa.setIdSala(resultSet.getInt(2));
			salaPessoa.setIdPessoa(resultSet.getInt(3));
			
			lista.add(salaPessoa);
		}
		comandoSql.close();
		return lista;
	}
}
