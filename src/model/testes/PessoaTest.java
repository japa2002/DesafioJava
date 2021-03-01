package model.testes;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.junit.jupiter.api.Test;

import model.entidade.Pessoa;
import model.persistencia.PessoaDAO;

class PessoaTest {

	/**
	 * Metodo para testar o insert da clsse PessoaDAO
	 * @throws SQLException
	 */
	@Test
	void insertTest() throws SQLException {
		Pessoa pessoa = new Pessoa("Leonardo", "Tavares");
		PessoaDAO pessoaDao = new PessoaDAO();
		
		pessoaDao.insert(pessoa);

	    Pessoa pessoaConsultada = new Pessoa();
	    pessoaConsultada = pessoaDao.buscarId(pessoa.getIdPessoa());

	     Assert.assertTrue(pessoa.getIdPessoa() == pessoaConsultada.getIdPessoa());
	}
	
	/**
	 * Metodo para testar o insert da clsse PessoaDAO
	 * @throws SQLException
	 */
	@Test
	void updateTest() throws SQLException {
		PessoaDAO pessoaDao = new PessoaDAO();
		Pessoa pessoaConsultada = new Pessoa();
		pessoaConsultada = pessoaDao.buscarId(1);
		
		Pessoa pessoa = new Pessoa("João", "Ernesto");
		pessoa.setIdPessoa(pessoaConsultada.getIdPessoa());
		
		pessoaDao.update(pessoa);
		
	    Assert.assertTrue(pessoaConsultada.getNomePessoa() != pessoa.getNomePessoa());
	}
	
	/**
	 * Metodo para testar o delete da clsse PessoaDAO
	 * @throws SQLException
	 */
	@Test
	void deleteTest() throws SQLException {
		PessoaDAO pessoaDao = new PessoaDAO();
		boolean isDelete = pessoaDao.deleteId(1);
		
		Assert.assertTrue(isDelete);
	}
	
	/**
	 * Metodo para buscar id pela clsse PessoaDAO
	 * @throws SQLException
	 */
	@Test
	void buscarIdTest() throws SQLException {
		
		boolean isAchou;
		
		try {
			PessoaDAO pessoaDao = new PessoaDAO();
			Pessoa pessoaConsultada = new Pessoa();
			pessoaConsultada = pessoaDao.buscarId(1);
			System.out.println(pessoaConsultada);
			isAchou = true;
		}catch(Exception ex) {
			isAchou = false;
		}

	    Assert.assertTrue(isAchou);
	}
	
	/**
	 * Metodo para buscar todos pela clsse PessoaDAO
	 * @throws SQLException
	 */
	@Test
	void buscarTodosTest() throws SQLException {
		
		boolean isAchou;
		
		try {
			PessoaDAO pessoaDao = new PessoaDAO();
			List<Pessoa> pessoaConsultada = new ArrayList<Pessoa>();
			pessoaConsultada = pessoaDao.buscarTodos();
			System.out.println(pessoaConsultada);
			isAchou = true;
	
		    Assert.assertTrue(isAchou);
		    
		}catch(Exception ex){
			isAchou = false;
		}
	}
}
