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
		String opcao = null;
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
									System.out.println("Conectado!");
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
				
				menuInicial = false; //apos logado n chama o login

				opt = Integer.parseInt(JOptionPane.showInputDialog("Digite um numero! \n"
						/*+ "1  - Digite o nome do usuario para pesquisar \n" //OK
						+ "2  - Adicionar usuario para seguir \n" //OK
						+ "3  - Bloquear usuario \n" //OK
						+ "4  - Publicar no mural \n" //OK
						+ "5  - Comentar Postagem \n"
						+ "6  - Incluir uma marcação \n"
						+ "7  - Listar Conversas \n"
						+ "8  - Listar Uma Conversas \n"
						+ "9  - Inserir uma msg privada \n"
						+ "10  - Listar notificação \n" //OK, INCLUIR NOTIFICACAO DE MARCACAO OU CONVERSA
						+ "11  - Aceitar solicitação \n" //OK
						+ "12  - Listar Posts \n"
						+ "13  - Listar um Post \n" */

						+ "1  - Digite o nome do usuario para pesquisar \n" //OK
				/*ok*/	+ "2  - Adicionar usuario para seguir \n" //OK
				/*ok*/	+ "3  - Bloquear usuario \n" //OK
				/*ok*/	+ "4  - Publicar no mural \n" //OK
				/*ok*/	+ "5  - Listar Posts/comentario \n" //ok //ordenar decrescente, listar qlq pessoa
				/*ok*/	+ "6  - Listar notificação \n" //OK, INCLUIR NOTIFICACAO DE MARCACAO OU CONVERSA, listar  por data, incluir opcao de buscar posts e comentarios com @ ou #, alem de pessoas q seguem
				/*ok*/	+ "7  - Aceitar solicitação \n" //OK
				/*ok*/	+ "8  - Inserir comentario \n" //OK
				/*ok*/	+ "9  - Deleltar post/comentario \n" //OK
				/*ok*/	+ "10 - Buscar Marcacao \n" 	
//				/*ok*/	+ "10  - Listar um Post/comentario \n" 						
						
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
				case 5:
					opcao = null;
					
					try {

					opcao = JOptionPane.showInputDialog("Digite a opção para listar (1- Post,2- Coment)");
					if (opcao.equals("1")) {
						vlrTmp = uc.listarPostComentario(userlogado.getIdUsuario(),opcao);
					}else if (opcao.equals("2")){
						vlrTmp = uc.listarPostComentario(JOptionPane.showInputDialog("Digite o id do post"),opcao);
					}
				
					
					JOptionPane.showMessageDialog(null, vlrTmp);
			
				} catch (Exception e) {
					e.printStackTrace();
					bd.fechar();
					System.out.println("main fechar!");
					// TODO: handle exception
				}	
					
					break;
				case 6:
				
				try {
						
						JOptionPane.showMessageDialog(null, uc.listarNotificacao(userlogado));
		
					} catch (Exception e) {
						e.printStackTrace();
						bd.fechar();
						System.out.println("main fechar!");
						// TODO: handle exception
					}			
					break;
				case 7:
					
					try {
						
				uc.aceitarSolicSeguir(userlogado,JOptionPane.showInputDialog("Digite o id do usuario pra aceitar"));
		
					} catch (Exception e) {
						e.printStackTrace();
						bd.fechar();
						System.out.println("main fechar!");
						// TODO: handle exception
					}
					
					
					break;
				case 8:

					try {
						
					pc.incluirComentario(userlogado,
							JOptionPane.showInputDialog("Digite o id do post"),
							JOptionPane.showInputDialog("Digite o conteudo")); 
			
				} catch (Exception e) {
					e.printStackTrace();
					bd.fechar();
					System.out.println("main fechar!");
					// TODO: handle exception
				}	
					
					break;

				case 9:

					opcao = null;
					
					try {

					opcao = JOptionPane.showInputDialog("Digite a opção para listar (1- Post,2- Coment)");
					if (opcao.equals("1")) {
						pc.deletePostComentario(JOptionPane.showInputDialog("Digite o id do post"),opcao);
					}else if (opcao.equals("2")){
						pc.deletePostComentario(JOptionPane.showInputDialog("Digite o id dos comentario"),opcao);
					}
				
			
				} catch (Exception e) {
					e.printStackTrace();
					bd.fechar();
					System.out.println("main fechar!");
					// TODO: handle exception
				}	
					
					
					break;					
				case 10:
					
	
					
					break;					
				case 11:


					
					break;					
				case 12:

					
					break;
				case 13:

					
					break;					
				default:
					break;
				}
			}

		} while (opt!=999);


		bd.fechar();
	}

}
