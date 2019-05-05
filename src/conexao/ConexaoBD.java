package conexao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JOptionPane;

public class ConexaoBD {
	Connection con = null;
	
	public Connection conexao() {
		
		try {
			Class.forName("org.h2.Driver");
			con = DriverManager.getConnection ("jdbc:h2:~/db_instagram","sa","");
			System.out.println("Conectado!");
		} catch (Exception e) {
			System.out.println("Erro - "+e);
		}
		return con;
	}
	
	public void fechar() {
		try {
			con.close();
			System.out.println("fechada!");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

/*	public ResultSet login(String login, String senha){
		Connection con = conexao();
		ResultSet rs = null;

		try {
			PreparedStatement sql = con.prepareStatement("select * from usuario where login=? and senha=?");
			sql.setString(1, login);
			sql.setString(2, senha);
			
			rs = sql.executeQuery();
			
			
		} catch (Exception e) { 
			System.out.println("Erro - "+e);
		}finally {
			try {
				
			} catch (Exception e2) {

			}
		}
		return rs;
	}

	public static void main(String[] args){
		ConexaoBD con  = new ConexaoBD();
		ResultSet rs = con.login("m","m");

		try {
			while(rs.next()){

				JOptionPane.showMessageDialog(null,rs.getString(1)+rs.getString(2)+rs.getString(3));   
				rs.close();
			}
		} catch (Exception e) {
			System.out.println("Erro - "+e);
		}
	}*/

}
