package model.testes;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.junit.jupiter.api.Test;

import model.entidade.EspacoPessoa;
import model.persistencia.EspacoPessoaDAO;

class EspacoPessoaTest {

	/**
	 * Metodo para testar o insert da clsse EspacoPessoaDAO
	 * @throws SQLException
	 */
	@Test
	void insertTest() throws SQLException {
		EspacoPessoa espacoPessoa = new EspacoPessoa(1, 1);
		EspacoPessoaDAO espacoPessoaDao = new EspacoPessoaDAO();
		
		espacoPessoaDao.insert(espacoPessoa);

	    EspacoPessoa espacoPessoaConsultado = new EspacoPessoa();
	    espacoPessoaConsultado = espacoPessoaDao.buscarId(espacoPessoa.getIdEspacoPessoa());

	     Assert.assertTrue(espacoPessoa.getIdEspaco() == espacoPessoaConsultado.getIdEspaco());
	}
	
	/**
	 * Metodo para testar o insert da clsse EspacoPessoaDAO
	 * @throws SQLException
	 */
	@Test
	void updateTest() throws SQLException {
		EspacoPessoaDAO espacoPessoaDao = new EspacoPessoaDAO();
		EspacoPessoa espacoPessoaConsultado = new EspacoPessoa();
		espacoPessoaConsultado = espacoPessoaDao.buscarId(1);
		
		EspacoPessoa espacoPessoa = new EspacoPessoa(1, 2);
		espacoPessoa.setIdEspacoPessoa(espacoPessoaConsultado.getIdEspacoPessoa());
		
		espacoPessoaDao.update(espacoPessoa);
		
	    Assert.assertTrue(espacoPessoaConsultado.getIdEspacoPessoa() != espacoPessoa.getIdEspacoPessoa());
	}
	
	/**
	 * Metodo para testar o delete da clsse EspacoPessoaDAO
	 * @throws SQLException
	 */
	@Test
	void deleteTest() throws SQLException {
		EspacoPessoaDAO espacoPessoaDao = new EspacoPessoaDAO();
		boolean isDelete = espacoPessoaDao.deleteId(1);
		
		Assert.assertTrue(isDelete);
	}
	
	/**
	 * Metodo para buscar id pela clsse EspacoPessoaDAO
	 * @throws SQLException
	 */
	@Test
	void buscarIdTest() throws SQLException {
		
		boolean isAchou;
		
		try {
			EspacoPessoaDAO espacoPessoaDao = new EspacoPessoaDAO();
			EspacoPessoa espacoPessoaConsultado = new EspacoPessoa();
			espacoPessoaConsultado = espacoPessoaDao.buscarId(1);
			System.out.println(espacoPessoaConsultado);
			isAchou = true;
		}catch(Exception ex) {
			isAchou = false;
		}

	    Assert.assertTrue(isAchou);
	}
	
	/**
	 * Metodo para buscar todos pela clsse EspacoPessoaDAO
	 * @throws SQLException
	 */
	@Test
	void buscarTodosTest() throws SQLException {
		
		boolean isAchou;
		
		try {
			EspacoPessoaDAO espacoPessoaDao = new EspacoPessoaDAO();
			List<EspacoPessoa> espacosPessoaConsultado = new ArrayList<EspacoPessoa>();
			espacosPessoaConsultado = espacoPessoaDao.buscarTodos();
			System.out.println(espacosPessoaConsultado);
			isAchou = true;
	
		    Assert.assertTrue(isAchou);
		    
		}catch(Exception ex){
			isAchou = false;
		}
	}
}
