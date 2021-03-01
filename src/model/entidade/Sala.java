package model.entidade;

/**
 * Metodo da entidade Sala 
 * @author Leonardo
 *
 */
public class Sala {

	private int idSala;
	private String nomeSala;
	private int lotacaoSala;
	private boolean etapa;
	
	/**
	 * Metodo padrao 
	 */
	public Sala() {
	}
	
	/**
	 * Metodo construtor que preenche todos os atributos menos o id 
	 * @param nomeSala
	 * @param lotacaoSala
	 * @param etapa
	 */
	public Sala(String nomeSala, int lotacaoSala, boolean etapa) {
		setNomeSala(nomeSala);
		setLotacaoSala(lotacaoSala);
		setEtapa(etapa);
	}

	/**
	 * Metodo para retorno do id da sala 
	 * @return idSala
	 */
	public int getIdSala() {
		return idSala;
	}

	/**
	 * Metodo para insercao do id da sala 
	 * @param idSala
	 */
	public void setIdSala(int idSala) {
		this.idSala = idSala;
	}

	/**
	 * Metodo para retorno do nome da sala 
	 * @return
	 */
	public String getNomeSala() {
		return nomeSala;
	}
	
	/**
	 * Metodo para insercao do nome da sala 
	 * @param nomeSala
	 */
	public void setNomeSala(String nomeSala) {
		this.nomeSala = nomeSala;
	}
	
	/**
	 * Metodo para retorno da lotacao da sala 
	 * @return lotacaoSala 
	 */
	public int getLotacaoSala() {
		return lotacaoSala;
	}
	
	/**
	 * Metodo para insercao da lotacao da sala 
	 * @param lotacaoSala
	 */
	public void setLotacaoSala(int lotacaoSala) {
		this.lotacaoSala = lotacaoSala;
	}
	
	/**
	 * Metodo para retorno da etapa 
	 * @return
	 */
	public boolean isEtapa() {
		return etapa;
	}
	
	/**
	 * Metodo para insercao da etapa 
	 * @param etapa
	 */
	public void setEtapa(boolean etapa) {
		this.etapa = etapa;
	}
}
