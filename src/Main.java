import java.sql.ResultSet;

import javax.swing.JOptionPane;

import conexao.ConexaoBD;
import controller.UsuarioController;
import model.Usuario;

public class Main {

	public static void main(String[] args) {
		ConexaoBD bd = new ConexaoBD();
		
		UsuarioController uc = new UsuarioController(bd);
		
		  
				
//				try {
//					Usuario rs = uc.login(JOptionPane.showInputDialog("Digite o login"), 
//							JOptionPane.showInputDialog("Digite a senha"));
//					
//					JOptionPane.showMessageDialog(null,rs.getNomeReal());
//					
//					
//				} catch (Exception e) {
//					e.printStackTrace();
//					bd.fechar();
//					System.out.println("main fechar!");
//					// TODO: handle exception
//				}
//				
	
//		try {
//			Usuario rs = new Usuario
//						(JOptionPane.showInputDialog("Digite o seu nome de usuario"), 
//						JOptionPane.showInputDialog("Qual seu tipo de perfil?"),
//						JOptionPane.showInputDialog("Qual seu nome completo?"),
//						JOptionPane.showInputDialog("Digite sua biografia"),
//						JOptionPane.showInputDialog("Digite sua senha"));
//			
//			
//			uc.criarUsuario(rs);
//			
//		} catch (Exception e) {
//			e.printStackTrace();
//			bd.fechar();
//			System.out.println("main fechar!");
//			// TODO: handle exception
//		}
		
		try {
		Usuario rs = uc.buscaUsuario(JOptionPane.showInputDialog("Digite o usuario para buscar"));
		
		JOptionPane.showMessageDialog(null,rs.getNomeUsuario());
		
		
	} catch (Exception e) {
		e.printStackTrace();
		bd.fechar();
		System.out.println("nao achei");
		// TODO: handle exception
	}
		
		
		
		

	}

	
}
