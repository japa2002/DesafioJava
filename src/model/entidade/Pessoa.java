package model.entidade;

/**
 * Metodo da entidade Pessoa
 * @author Leonardo
 *
 */
public class Pessoa {
	
	private int idPessoa;
	private String nomePessoa;
	private String sobrenomePessoa;
	
	/**
	 * Metodo padrao 
	 */
	public Pessoa() {
	}
	
	/**
	 * Metodo construtor que preenche todos os atributos menos o id
	 * @param nomePessoa
	 * @param sobrenomePessoa
	 */
	public Pessoa(String nomePessoa, String sobrenomePessoa) {
		setNomePessoa(sobrenomePessoa);
		setSobrenomePessoa(sobrenomePessoa);
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

	/**
	 * Metodo para retorno do nome da pessoa
	 * @return nomePessoa
	 */
	public String getNomePessoa() {
		return nomePessoa;
	}
	
	/**
	 * Metodo para insercao do nome da pessoa
	 * @param nomePessoa
	 */
	public void setNomePessoa(String nomePessoa) {
		this.nomePessoa = nomePessoa;
	}
	
	/**
	 * Metodo para retorno do sobrenome da pessoa 
	 * @return sobrenomePessoa 
	 */
	public String getSobrenomePessoa() {
		return sobrenomePessoa;
	}
	
	/**
	 * Metodo para insercao do sobrenome da pessoa 
	 * @param sobrenomePessoa
	 */
	public void setSobrenomePessoa(String sobrenomePessoa) {
		this.sobrenomePessoa = sobrenomePessoa;
	}
}
