package model.persistencia;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import conexao.ConexaoFactory;
import model.entidade.Pessoa;

/**
 * Metodo para consulta do Pessoa no banco de dados 
 * @author Breno
 *
 */
public class PessoaDAO {

	private Connection conexao = ConexaoFactory.getConnection();
	
	/**
	 * Metodo para inserir um pessoa no banco de dados
	 * @param Pessoa pessoa
	 * @author Breno
	 * @throws SQLException 
	 */
	public void insert(Pessoa pessoa) throws SQLException {
		String sql = "insert into pessoa (nomePessoa, soLeonardomePessoa) values (?, ?)";
		PreparedStatement comandoSql = conexao.prepareStatement(sql);
		
		comandoSql.setString(1, pessoa.getNomePessoa());
		comandoSql.setString(2, pessoa.getSobrenomePessoa());
		
		comandoSql.execute();
		comandoSql.close();	
	}
	
	/**
	 * Metodo para Atualizar pessoa no banco de dados.
	 * O <code>idPessoa</code> deve ser igual ao da pessoa que deseja atualizar
	 * @param Pessoa pessoa
	 * @author Breno
	 * @throws SQLException 
	 */
	
	public void update(Pessoa pessoa) throws SQLException {
		String sql = "update pessoa set nomePessoa = ?, sobrenomePessoa = ? where idPessoa = ?";
		PreparedStatement comandoSql = conexao.prepareStatement(sql);
		
		comandoSql.setString(1, pessoa.getNomePessoa());
		comandoSql.setString(2, pessoa.getSobrenomePessoa());
		comandoSql.setInt(3, pessoa.getIdPessoa());
		
		comandoSql.execute();
		comandoSql.close();
	}
	
	/**
	 * Deleta a pessoa do respectivo id do banco de dados.
	 * O <code>idPessoa</code> deve ser igual ao da pessoa que deseja deletar
	 * @param int idEspaco
	 * @author Breno
	 * @return 
	 * @throws SQLException 
	 */
	public boolean deleteId(int idPessoa) throws SQLException {
		String sql = "delete from pessoa where idPessoa = ?";
		PreparedStatement comandoSql = conexao.prepareStatement(sql);
		
		comandoSql.setInt(1, idPessoa);
		
		comandoSql.execute();
		comandoSql.close();
		return true;
	}
	
	/**
	 * Metodo para selecionar a pessoa do banco de dados apartir do respectivo id.
	 * O <code>idPessoa</code> deve ser igual ao da pessoa que deseja buscar
	 * @param int idPessoa
	 * @return Pessoa pessoa
	 * @author Breno
	 * @throws SQLException 
	 */
	public Pessoa buscarId(int idPessoa) throws SQLException {
		Pessoa pessoa = new Pessoa();
		String sql = "select * from pessoa where idPessoa = ?";
		PreparedStatement comandoSql = conexao.prepareStatement(sql);
		
		comandoSql.setInt(1, idPessoa);
		ResultSet resultSet = comandoSql.executeQuery();
		
		if (resultSet.next()) {
			pessoa.setIdPessoa(resultSet.getInt(1));
			pessoa.setNomePessoa(resultSet.getString(2));
			pessoa.setSobrenomePessoa(resultSet.getString(3));
		}
		comandoSql.close();
		return pessoa;
	}
	
	/**
	 * Metodo para selecionar do banco de dados todos as pessoas cadastrados
	 * @author Breno
	 * @return lista de pessoas registrados no banco 
	 * @throws SQLException
	 */
	public List<Pessoa> buscarTodos() throws SQLException {
		List<Pessoa> lista =  new ArrayList<Pessoa>();
		String sql = "select * from pessoa";
		
		PreparedStatement comandoSql = conexao.prepareStatement(sql);
		ResultSet resultSet = comandoSql.executeQuery();
		
		while (resultSet.next()) {
			Pessoa pessoa = new Pessoa();
			pessoa.setIdPessoa(resultSet.getInt(1));
			pessoa.setNomePessoa(resultSet.getString(2));
			pessoa.setSobrenomePessoa(resultSet.getString(3));
			
			lista.add(pessoa);
		}
		comandoSql.close();
		return lista;
	}
}
