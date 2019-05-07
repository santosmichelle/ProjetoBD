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
		MsgPrivadaController mp = new MsgPrivadaController(bd);
		
		Postagem post;
		Usuario rs;
		Comentario coment= null;
		MensagemPrivada m = null;
		String dados = null;
		String vlrTmp = null;
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
						rs = null;
						try {
						 rs = new Usuario
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
						+ "4  - Publicar no mural \n"
						+ "5  - Comentar Postagem \n"
						+ "6  - Incluir uma marcação \n"
						+ "7  - Listar Conversas \n"
						+ "8  - Listar Uma Conversas \n"
						+ "9  - Inserir uma msg privada \n"
						
						+ "digite 999 p sair"));


				switch (opt) {
				case 1:
					
					rs = null;
					
						try {
							rs = uc.buscaUsuario(JOptionPane.showInputDialog("Digite o usuario para buscar"));
							
							JOptionPane.showMessageDialog(null,rs.getNomeUsuario());
							
							
						} catch (Exception e) {
							e.printStackTrace();
							bd.fechar();
							System.out.println("nao achei");
							// TODO: handle exception
						}

					break;
				case 2:
					
					try {
						uc.seguirUsuario(userlogado, JOptionPane.showInputDialog("Digite o id do usuario p seguir"));
						
						
					} catch (Exception e) {
						e.printStackTrace();
						bd.fechar();
						System.out.println("nao achei");
						// TODO: handle exception
					}

					break;
				case 3:

					try {
						uc.UserBloqueado(userlogado, JOptionPane.showInputDialog("Digite o id do usuario p bloquear"));
						
						
					} catch (Exception e) {
						e.printStackTrace();
						bd.fechar();
						System.out.println("nao achei");
						// TODO: handle exception
					}
					

					
					break;
				case 4:
					post= null;
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
//				case 5:
//					coment= null;
//						try {
//							
//							coment = new Comentario(JOptionPane.showInputDialog("Digite o id do post"),
//									userlogado.getIdUsuario(), 
//									JOptionPane.showInputDialog("Digite o comentario"));	
//							
//						pc.incluirComentario(coment); 
//							
//					
//						} catch (Exception e) {
//							e.printStackTrace();
//							bd.fechar();
//							System.out.println("main fechar!");
//							// TODO: handle exception
//						}

//					break;
				case 6:
				
//n fez				
					break;
				case 7:
					vlrTmp= null;
					
					try {
						
						for (MensagemPrivada s : mp.listarConversas(userlogado)) {
							vlrTmp = "idConversa: "+ s.getIdMensagem() +"Nome: "+ s.getNomeUsuario() + "\n";
							
						} 
						
						JOptionPane.showMessageDialog(null, vlrTmp);
				
					} catch (Exception e) {
						e.printStackTrace();
						bd.fechar();
						System.out.println("main fechar!");
						// TODO: handle exception
					}
					
					break;
				case 8:

					vlrTmp= null;
					
					try {
						
						for (MensagemPrivada s : mp.listarUmaConversa(JOptionPane.showInputDialog("Digite o id da conversa"))) {
							vlrTmp = "Nome: "+ s.getNomeUsuario() + "Conteudo: "+ s.getConteudo() 
							+ "Data: "+ s.getData() +"\n";
							
						} 
						
						JOptionPane.showMessageDialog(null, vlrTmp);
				
					} catch (Exception e) {
						e.printStackTrace();
						bd.fechar();
						System.out.println("main fechar!");
						// TODO: handle exception
					}
					
					break;

				case 9:

					m= null;
					
//					try {
//						
//						m = new MensagemPrivada(userlogado.getIdUsuario(),
//								JOptionPane.showInputDialog("Digite o conteudo da conversa"));
//						
//						mp.incluirConversa(m);
//				
//					} catch (Exception e) {
//						e.printStackTrace();
//						bd.fechar();
//						System.out.println("main fechar!");
//						// TODO: handle exception
//					}
					
					break;					
				default:
					break;
				}
			}

		} while (opt!=999);


		bd.fechar();
	}

}
