package conexao;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 * Estabelece a conexao com o banco de dados 
 * @author Leonardo
 *
 */
public class ConexaoFactory {
	
	private static Connection conexao = null;
	
	public static Connection getConnection() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			if (conexao == null) {
				conexao = DriverManager.getConnection("jdbc:mysql://localhost:3306/bddesafio", "root","12345");
			}
			return conexao;
		} catch (Exception e) {
			System.err.println(e);
		}
		return null;
	}
}
