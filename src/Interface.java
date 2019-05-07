import javax.swing.JOptionPane;

import conexao.ConexaoBD;
import controller.*;
import model.*;

public class Interface {
	
	private static Usuario userlogado;
	
	public static void main(String[] args) {

		ConexaoBD bd = new ConexaoBD();
		PostagemController pc = new PostagemController(bd);
		UsuarioController uc = new UsuarioController(bd);
		Postagem post;
		String dados = null;
		Integer opt = null;

		boolean menuInicial = true;


		do {
			if (menuInicial) { 	 
				try {
					opt = Integer.parseInt(JOptionPane.showInputDialog("Digite um numero! \n"
							+ "1 - Logar no sistema \n"
							+ "2 - Cadastrar Usuario \n"
							+ "999 - Sair"));

				} catch (NullPointerException e) {
					throw new RuntimeException("erro ao logar");
				}
				if (opt!=null ) {

					switch (opt) {
					case 1:
						try {
								userlogado = uc.login(JOptionPane.showInputDialog("Digite o login"), 
								JOptionPane.showInputDialog("Digite a senha"));
						
								if (userlogado != null) {
									JOptionPane.showMessageDialog(null, "Logado");
								}					
				
						} catch (Exception e) {
							e.printStackTrace();
							bd.fechar();
							System.out.println("main fechar!");
							// TODO: handle exception
						}
						break;
					case 2:

						try {
						Usuario rs = new Usuario
									(JOptionPane.showInputDialog("Digite o seu nome de usuario"), 
									JOptionPane.showInputDialog("Qual seu tipo de perfil?"),
									JOptionPane.showInputDialog("Qual seu nome completo?"),
									JOptionPane.showInputDialog("Digite sua biografia"),
									JOptionPane.showInputDialog("Digite sua senha"));
						
						
						uc.criarUsuario(rs);
						
					} catch (Exception e) {
						e.printStackTrace();
						bd.fechar();
						System.out.println("main fechar!");
						// TODO: handle exception
					}
						
					default:
						break;
					}
				}
			}

			if(userlogado !=null) {

				opt = Integer.parseInt(JOptionPane.showInputDialog("Digite um numero! \n"
						+ "1  - Digite o nome do usuario para pesquisar \n"
						+ "2  - Adicionar usuario para seguir \n"
						+ "3  - Bloquear usuario \n"
						+ "4  - Mensagem privada \n"
						+ "5  - Publicar no mural \n"
						+ "6  - Comentar Postagem \n"
						+ "7  - Incluir uma marcação \n"
						
						+ "digite 999 p sair"));


				switch (opt) {
				case 1:
							try {
							Usuario rs = uc.buscaUsuario(JOptionPane.showInputDialog("Digite o usuario para buscar"));
							
							JOptionPane.showMessageDialog(null,rs.getNomeUsuario());
							
							
						} catch (Exception e) {
							e.printStackTrace();
							bd.fechar();
							System.out.println("nao achei");
							// TODO: handle exception
						}

					break;
				case 2:


					break;
				case 3:

					break;
				case 4:


					break;
				case 5:

							try {
							
							post = new Postagem(JOptionPane.showInputDialog("Digite o texto"), 
									userlogado.getIdUsuario(), JOptionPane.showInputDialog("Digite a foto"));	
							
						pc.criarPost(post);
							
					
						} catch (Exception e) {
							e.printStackTrace();
							bd.fechar();
							System.out.println("main fechar!");
							// TODO: handle exception
						}

					break;
				case 6:
					break;
				case 7:

					break;

					
				default:
					break;
				}
			}

		} while (opt!=999);


		bd.fechar();
	}

}
