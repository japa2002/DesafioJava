package model.testes;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.junit.jupiter.api.Test;

import model.entidade.Espaco;
import model.persistencia.EspacoDAO;

class EspacoTest {

	/**
	 * Metodo para testar o insert da clsse EspacoDAO
	 * @throws SQLException
	 */
	@Test
	void insertTest() throws SQLException {
		Espaco espaco = new Espaco("Almoxarifado", 10, false);
		EspacoDAO espacoDao = new EspacoDAO();
		
		espacoDao.insert(espaco);

	    Espaco espacoConsultado = new Espaco();
	    espacoConsultado = espacoDao.buscarId(espaco.getIdEspaco());

	     Assert.assertTrue(espaco.getIdEspaco() == espacoConsultado.getIdEspaco());
	}
	
	/**
	 * Metodo para testar o insert da clsse EspacoDAO
	 * @throws SQLException
	 */
	@Test
	void updateTest() throws SQLException {
		EspacoDAO espacoDao = new EspacoDAO();
		Espaco espacoConsultado = new Espaco();
		espacoConsultado = espacoDao.buscarId(1);
		
		Espaco espaco = new Espaco("Praça", 15, true);
		espaco.setIdEspaco(espacoConsultado.getIdEspaco());
		
		espacoDao.update(espaco);
		
	    Assert.assertTrue(!(espacoConsultado.getNomeEspaco().equals(espaco.getNomeEspaco())));
	}
	
	/**
	 * Metodo para testar o delete da clsse EspacoDAO
	 * @throws SQLException
	 */
	@Test
	void deleteTest() throws SQLException {
		EspacoDAO espacoDao = new EspacoDAO();
		boolean isDelete = espacoDao.deleteId(1);
		
		Assert.assertTrue(isDelete);
	}
	
	/**
	 * Metodo para buscar id pela clsse EspacoDAO
	 * @throws SQLException
	 */
	@Test
	void buscarIdTest() throws SQLException {
		
		boolean isAchou;
		
		try {
			EspacoDAO espacoDao = new EspacoDAO();
			Espaco espacoConsultado = new Espaco();
			espacoConsultado = espacoDao.buscarId(1);
			System.out.println(espacoConsultado);
			isAchou = true;
		}catch(Exception ex) {
			isAchou = false;
		}

	    Assert.assertTrue(isAchou);
	}
	
	/**
	 * Metodo para buscar todos pela clsse EspacoDAO
	 * @throws SQLException
	 */
	@Test
	void buscarTodosTest() throws SQLException {
		
		boolean isAchou;
		
		try {
			EspacoDAO espacoDao = new EspacoDAO();
			List<Espaco> espacosConsultado = new ArrayList<Espaco>();
			espacosConsultado = espacoDao.buscarTodos();
			System.out.println(espacosConsultado);
			isAchou = true;
	
		    Assert.assertTrue(isAchou);
		    
		}catch(Exception ex){
			isAchou = false;
		}
	}
}
