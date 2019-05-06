import javax.swing.JOptionPane;

import conexao.ConexaoBD;
import controller.PostagemController;
import controller.UsuarioController;
import model.Postagem;
import model.Usuario;

public class Main {
	private static Usuario user_logado;
	public static void main(String[] args) {
		ConexaoBD bd = new ConexaoBD();
		
		UsuarioController uc = new UsuarioController(bd);
		PostagemController pc = new PostagemController(bd);
		 
		Postagem post = new Postagem();  
				
//				try {
//					user_logado = uc.login(JOptionPane.showInputDialog("Digite o login"), 
//							JOptionPane.showInputDialog("Digite a senha"));
//										
//					JOptionPane.showMessageDialog(null, user_logado.getNomeUsuario());
//				 
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
		
//		try {
//		Usuario rs = uc.buscaUsuario(JOptionPane.showInputDialog("Digite o usuario para buscar"));
//		
//		JOptionPane.showMessageDialog(null,rs.getNomeUsuario());
//		
//		
//	} catch (Exception e) {
//		e.printStackTrace();
//		bd.fechar();
//		System.out.println("nao achei");
//		// TODO: handle exception
//	}
//		
		
		
		try {
			
			post = new Postagem(JOptionPane.showInputDialog("Digite o texto"), 
					user_logado.getIdUsuario(), JOptionPane.showInputDialog("Digite a foto"));	
			
		pc.criarPost(post);
			
	
		} catch (Exception e) {
			e.printStackTrace();
			bd.fechar();
			System.out.println("main fechar!");
			// TODO: handle exception
		}
	

	}

	
}
