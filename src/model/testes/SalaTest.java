package model.testes;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.junit.jupiter.api.Test;

import model.entidade.Sala;
import model.persistencia.SalaDAO;

class SalaTest {

	/**
	 * Metodo para testar o insert da clsse SalaDAO
	 * @throws SQLException
	 */
	@Test
	void insertTest() throws SQLException {
		Sala sala = new Sala("Sala 1", 40, false);
		SalaDAO salaDao = new SalaDAO();
		
		salaDao.insert(sala);

	    Sala salaConsultada = new Sala();
	    salaConsultada = salaDao.buscarId(sala.getIdSala());

	     Assert.assertTrue(sala.getIdSala() == salaConsultada.getIdSala());
	}
	
	/**
	 * Metodo para testar o insert da clsse SalaDAO
	 * @throws SQLException
	 */
	@Test
	void updateTest() throws SQLException {
		SalaDAO salaDao = new SalaDAO();
		Sala salaConsultada = new Sala();
		salaConsultada = salaDao.buscarId(1);
		
		Sala sala = new Sala("Sala 2", 40, true);
		sala.setIdSala(salaConsultada.getIdSala());
		
		salaDao.update(sala);
		
	    Assert.assertTrue(!(salaConsultada.getNomeSala() == sala.getNomeSala()));
	}
	
	/**
	 * Metodo para testar o delete da clsse SalaDAO
	 * @throws SQLException
	 */
	@Test
	void deleteTest() throws SQLException {
		SalaDAO salaDao = new SalaDAO();
		boolean isDelete = salaDao.deleteId(1);
		
		Assert.assertTrue(isDelete);
	}
	
	/**
	 * Metodo para buscar id pela clsse SalaDAO
	 * @throws SQLException
	 */
	@Test
	void buscarIdTest() throws SQLException {
		
		boolean isAchou;
		
		try {
			SalaDAO salaDao = new SalaDAO();
			Sala salaConsultada = new Sala();
			salaConsultada = salaDao.buscarId(1);
			System.out.println(salaConsultada);
			isAchou = true;
		}catch(Exception ex) {
			isAchou = false;
		}

	    Assert.assertTrue(isAchou);
	}
	
	/**
	 * Metodo para buscar todos pela clsse SalaDAO
	 * @throws SQLException
	 */
	@Test
	void buscarTodosTest() throws SQLException {
		
		boolean isAchou;
		
		try {
			SalaDAO salaDao = new SalaDAO();
			List<Sala> salaConsultada = new ArrayList<Sala>();
			salaConsultada = salaDao.buscarTodos();
			System.out.println(salaConsultada);
			isAchou = true;
	
		    Assert.assertTrue(isAchou);
		    
		}catch(Exception ex){
			isAchou = false;
		}
	}
}
