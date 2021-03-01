package model.entidade;

/**
 * Metodo da entidade SalaPessoa 
 * @author Leonardo
 *
 */
public class SalaPessoa {

	private int idSalaPessoa;
	private int idSala;
	private int idPessoa;
	
	/**
	 * Metodo padrao 
	 */
	public SalaPessoa() {
	}
	
	/**
	 * Metodo construtor que preenche todos os atributos menos o id
	 * @param idSala
	 * @param idPessoa
	 */
	public SalaPessoa(int idSala, int idPessoa) {
		setIdSala(idSala);
		setIdPessoa(idPessoa);
	}
	
	/**
	 * Metodo para retorno do id da SalaPessoa
	 * @return idSalaPessoa
	 */
	public int getIdSalaPessoa() {
		return idSalaPessoa;
	}

	/**
	 * Metodo para insercao do id da SalaPessoa 
	 * @param idSalaPessoa
	 */
	public void setIdSalaPessoa(int idSalaPessoa) {
		this.idSalaPessoa = idSalaPessoa;
	}

	/**
	 * Metodo para insercao do id da sala
	 * @return idSala
	 */
	public int getIdSala() {
		return idSala;
	}
	
	/**
	 * Metodo para retorno do id da sala 
	 * @param idSala
	 */
	public void setIdSala(int idSala) {
		this.idSala = idSala;
	}
	
	/**
	 * Metodo para retorno do id da pessoa 
	 * @return
	 */
	public int getIdPessoa() {
		return idPessoa;
	}
	
	/**
	 * Metodo para insercao do id da pessoa 
	 * @param idPessoa
	 */
	public void setIdPessoa(int idPessoa) {
		this.idPessoa = idPessoa;
	}
}
