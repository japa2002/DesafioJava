package model.entidade;

/**
 * Metodo de entidade Espaco
 * @author Leonardo
 *
 */
public class Espaco {

	private int idEspaco;
	private String nomeEspaco;
	private int lotacaoEspaco;
	private boolean intervalo;
	
	/**
	 * Metodo padrao 
	 */
	public Espaco() {
	}
	
	/**
	 * Metodo construtor que preenche todos os atributos menos o id
	 * @param nome
	 * @param lotacao
	 * @param intervalo
	 */
	public Espaco(String nome, int lotacao, boolean intervalo) {
		setNomeEspaco(nome);
		setLotacaoEspaco(lotacao);
		setIntervalo(intervalo);
	}
	
	/**
	 * Metodo para retorno do id do espaco
	 * @return idEspaco
	 */
	public int getIdEspaco() {
		return idEspaco;
	}

	/**
	 * Metodo para insercao do espaco 
	 * @param idEspaco
	 */
	public void setIdEspaco(int idEspaco) {
		this.idEspaco = idEspaco;
	}

	/**
	 * Metodo para retorno do nome
	 * @return nomeEspaco
	 */
	public String getNomeEspaco() {
		return nomeEspaco;
	}
	
	/**
	 * Metodo para insercao do nome 
	 * @param nomeEspaco
	 */
	public void setNomeEspaco(String nomeEspaco) {
		this.nomeEspaco = nomeEspaco;
	}
	
	/**
	 * Metodo para retorno da lotacao
	 * @return lotacaoEspaco
	 */
	public int getLotacaoEspaco() {
		return lotacaoEspaco;
	}
	
	/**
	 * Metodo para insercao da lotacao 
	 * @param lotacaoEspaco
	 */
	public void setLotacaoEspaco(int lotacaoEspaco) {
		this.lotacaoEspaco = lotacaoEspaco;
	}
	
	/**
	 * Metodo para retorno do intervalo
	 * @return intervalo
	 */
	public boolean isIntervalo() {
		return intervalo;
	}
	
	/**
	 * Metodo para insercao do intervalo 
	 * @param intervalo
	 */
	public void setIntervalo(boolean intervalo) {
		this.intervalo = intervalo;
	}
}
