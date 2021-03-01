package model.testes;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.junit.jupiter.api.Test;

import model.entidade.SalaPessoa;

import model.persistencia.SalaPessoaDAO;

class SalaPessoaTest {

	/**
	 * Metodo para testar o insert da clsse SalaPessoaDAO
	 * @throws SQLException
	 */
	@Test
	void insertTest() throws SQLException {
		SalaPessoa salaPessoa = new SalaPessoa(1, 1);
		SalaPessoaDAO salaPessoaDao = new SalaPessoaDAO();
		
		salaPessoaDao.insert(salaPessoa);

	    SalaPessoa salaPessoaConsultada = new SalaPessoa();
	    salaPessoaConsultada = salaPessoaDao.buscarId(salaPessoa.getIdSalaPessoa());

	     Assert.assertTrue(salaPessoa.getIdSalaPessoa() == salaPessoaConsultada.getIdSalaPessoa());
	}
	
	/**
	 * Metodo para testar o insert da clsse SalaPessoaDAO
	 * @throws SQLException
	 */
	@Test
	void updateTest() throws SQLException {
		SalaPessoaDAO salaPessoaDao = new SalaPessoaDAO();
		SalaPessoa salaPessoaConsultada = new SalaPessoa();
		salaPessoaConsultada = salaPessoaDao.buscarId(1);
		
		SalaPessoa salaPessoa = new SalaPessoa(1, 2);
		salaPessoa.setIdSalaPessoa(salaPessoaConsultada.getIdSalaPessoa());
		
		salaPessoaDao.update(salaPessoa);
		
	    Assert.assertTrue(salaPessoaConsultada.getIdSala() != salaPessoa.getIdSala());
	}
	
	/**
	 * Metodo para testar o delete da clsse SalaPessoaDAO
	 * @throws SQLException
	 */
	@Test
	void deleteTest() throws SQLException {
		SalaPessoaDAO salaPessoaDao = new SalaPessoaDAO();
		boolean isDelete = salaPessoaDao.deleteId(1);
		
		Assert.assertTrue(isDelete);
	}
	
	/**
	 * Metodo para buscar id pela clsse SalaPessoaDAO
	 * @throws SQLException
	 */
	@Test
	void buscarIdTest() throws SQLException {
		
		boolean isAchou;
		
		try {
			SalaPessoaDAO salaPessoaDao = new SalaPessoaDAO();
			SalaPessoa salaPessoaConsultada = new SalaPessoa();
			salaPessoaConsultada = salaPessoaDao.buscarId(1);
			System.out.println(salaPessoaConsultada);
			isAchou = true;
		}catch(Exception ex) {
			isAchou = false;
		}

	    Assert.assertTrue(isAchou);
	}
	
	/**
	 * Metodo para buscar todos pela clsse SalaPessoaDAO
	 * @throws SQLException
	 */
	@Test
	void buscarTodosTest() throws SQLException {
		
		boolean isAchou;
		
		try {
			SalaPessoaDAO salaPessoaDao = new SalaPessoaDAO();
			List<SalaPessoa> salaPessoaConsultada = new ArrayList<SalaPessoa>();
			salaPessoaConsultada = salaPessoaDao.buscarTodos();
			System.out.println(salaPessoaConsultada);
			isAchou = true;
	
		    Assert.assertTrue(isAchou);
		    
		}catch(Exception ex){
			isAchou = false;
		}
	}
}
