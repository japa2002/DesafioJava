package model.entidade;

/**
 * Metodo da entidade EspacoPessoa 
 * @author Leonardo
 *
 */
public class EspacoPessoa {
	
	private int idEspacoPessoa;
	private int idEspaco;
	private int idPessoa;
	
	/**
	 * Metodo padrao 
	 */
	public EspacoPessoa() {
	}
	
	/**
	 * Metodo construtor que preenche todos os atributos menos o id
	 * @param idEspaco
	 * @param idPessoa
	 */
	public EspacoPessoa(int idEspaco, int idPessoa) {
		setIdEspaco(idEspaco);
		setIdPessoa(idPessoa);
	}

	/**
	 * Metodo para retorno do id do espacoPessoa
	 * @return
	 */
	public int getIdEspacoPessoa() {
		return idEspacoPessoa;
	}

	/**
	 * Metodo para insercao do id do espacoPessoa
	 * @param idEspacoPessoa
	 */
	public void setIdEspacoPessoa(int idEspacoPessoa) {
		this.idEspacoPessoa = idEspacoPessoa;
	}

	/**
	 * Metodo para retorno do id do espaco 
	 * @return
	 */
	public int getIdEspaco() {
		return idEspaco;
	}
	
	/**
	 * Metodo para insercao do id do espaco 
	 * @param idEspaco
	 */
	public void setIdEspaco(int idEspaco) {
		this.idEspaco = idEspaco;
	}
	
	/**
	 * Metodo para retorno do id da pessoa 
	 * @return idPessoa
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
