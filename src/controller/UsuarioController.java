package controller;

import java.awt.HeadlessException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.swing.text.html.HTMLEditorKit.Parser;

import conexao.ConexaoBD;
import model.Seguidores;
import model.Seguindo;
import model.Usuario;

public class UsuarioController {

	ConexaoBD bd;
	Usuario u;
	ResultSet rs;

	public UsuarioController(ConexaoBD b) {

		this.bd = b;
	}

	public Usuario login(String nome, String senha){

		
		Connection con = bd.conexao();

		
		try {
			PreparedStatement sql = con.prepareStatement("select * from usuario where nome = ? and senha = ?");
			sql.setString(1, nome);
			sql.setString(2, senha);

			rs = sql.executeQuery();

			u = SetarUser(rs);

		} catch (Exception e) { 
			System.out.println("Erro - "+e);
		}finally {
			try {
				//con.close();
			} catch (Exception e2) {

			}
		}
		return u;
	}

	public void UserBloqueado(Usuario u, String idBloqueio){

		Connection con = bd.conexao();
		
		try {
			
			PreparedStatement sql = con.prepareStatement("INSERT INTO bloqueio (ID_USUARIO_BLOQUEADO,ID_USUARIO_BLOQUEADOR) VALUES (?,?)");

			sql.setString(1, u.getIdUsuario());
			sql.setString(2, idBloqueio);

			sql.executeUpdate();

		} catch (Exception e) { 
			System.out.println("Erro - "+e);
		}finally {
			try {
				//con.close();
			} catch (Exception e2) {

			}
		}
	}

public int getPerfilUserPublico(String idUsuario){

		
		Connection con = bd.conexao();
		int valor = 0;
		
		try {
			PreparedStatement sql = con.prepareStatement("select COUNT(*) from usuario where TIPOPERFIL = 'PUBLICO' AND IDUSUARIO  = ?");
			sql.setString(1, idUsuario);

			rs = sql.executeQuery();

			while(rs.next()){
				valor = Integer.parseInt(rs.getString(1));   
			}
			
		} catch (Exception e) { 
			System.out.println("Erro - "+e);
		}finally {
			try {
				//con.close();
			} catch (Exception e2) {

			}
		}
		return valor;
	}


	public List<Seguidores> ListarSeguidores(Usuario u){
		List<Seguidores> s = null;
		Connection con = bd.conexao();
		
		try {

		} catch (Exception e) { 
			System.out.println("Erro - "+e);
		}finally {
			try {
				//con.close();
			} catch (Exception e2) {

			}
		}
		
		return s;
	}

	
	public List<Seguindo> ListarSeguindo(Usuario u){
		List<Seguindo> s = null;
		Connection con = bd.conexao();
		
		try {

		} catch (Exception e) { 
			System.out.println("Erro - "+e);
		}finally {
			try {
				//con.close();
			} catch (Exception e2) {

			}
		}
		
		return s;
	}

	public String listarNotificacao (Usuario u){
		
		String  s = "";
		Connection con = bd.conexao();
		
		try {
			
			PreparedStatement sql = con.prepareStatement("select notificacao from vw_notificacao where id_usuario = ?");
			sql.setString(1, u.getIdUsuario());

			rs = sql.executeQuery();

			while(rs.next()){
				s = rs.getString(1) + "\n";   
			}


		} catch (Exception e) { 
			System.out.println("Erro - "+e);
		}finally {
			try {
				//con.close();
			} catch (Exception e2) {

			}
		}
		
		return s;
	}

	public void aceitarSolicSeguir(Usuario u, String idUsuarioAceito){
		Connection con = bd.conexao();
		PreparedStatement sql = null; 
		PreparedStatement sql2 = null; 
		try {

				sql = con.prepareStatement("INSERT INTO SEGUINDO (ID_USUARIO, ID_SEGUINDO) "
						+ " select ?,? from dual " + 
						" where not exists (select 1 from SEGUINDO r where  r.ID_USUARIO = ? and  r.ID_SEGUINDO= ?)");
				
				sql = con.prepareStatement("DELETE FROM solicitacao_seguidor"
						+ " WHERE ID_USU_SOLICITA = ? AND ID_USU_SEGUIR = ?");

				sql.setString(1, idUsuarioAceito);
				sql.setString(2, u.getIdUsuario());
				

			sql.executeUpdate();
			
		} catch (Exception e) { 
			System.out.println("Erro - "+e);
		}finally {
			try {
				//con.close();
			} catch (Exception e2) {

			}
		}
		
	}
	
	public void seguirUsuario(Usuario u, String idUsuarioSeguir){
		Connection con = bd.conexao();
		PreparedStatement sql = null; 
		PreparedStatement sql2 = null; 
		try {
			if (getPerfilUserPublico(idUsuarioSeguir)==1) {

				sql = con.prepareStatement("INSERT INTO SEGUINDO (ID_USUARIO, ID_SEGUINDO) "
						+ " select ?,? from dual " + 
						" where not exists (select 1 from SEGUINDO r where  r.ID_USUARIO = ? and  r.ID_SEGUINDO= ?)");
				
				sql2 = con.prepareStatement("INSERT INTO SEGUIDOR (ID_USUARIO, ID_SEGUIDOR)"
						+ " select ?,? from dual " + 
						" where not exists (select 1 from SEGUIDOR r where  r.ID_USUARIO = ? and  r.ID_SEGUIDOR= ?)");

				sql2.setString(1, idUsuarioSeguir);
				sql2.setString(2, u.getIdUsuario());
				
			}else {
				sql = con.prepareStatement("INSERT INTO SOLICITACAO_SEGUIDOR (ID_USU_SOLICITA, ID_USU_SEGUIR ) VALUES (?,?)");
			}
				

			sql.setString(1, u.getIdUsuario());
			sql.setString(2, idUsuarioSeguir);

			sql.executeUpdate();
			if(sql2 != null) {
				sql2.executeUpdate();
				
			}
			
		} catch (Exception e) { 
			System.out.println("Erro - "+e);
		}finally {
			try {
				//con.close();
			} catch (Exception e2) {

			}
		}
		
	}	
	
	public Usuario SetarUser(ResultSet rs){ // um objeto que vai receber linhas do bd

		//		List<Usuario> us;
		try {
			while(rs.next()){
				//System.out.println("Oiii user");
				u = new Usuario(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6));   
				//rs.close();
				//				us = new ArrayList<>();
				//				us.add(u);
			}
		} catch (HeadlessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return u;
	}

	public void criarUsuario(Usuario user) {
		Connection con = bd.conexao();
		try {

			PreparedStatement sql = con.prepareStatement("INSERT INTO USUARIO (NOME, TIPOPERFIL,"
					+ " NOMEREAL, BIOGRAFIA, SENHA) VALUES (?,?,?,?,?)");

			sql.setString(1, user.getNomeUsuario());
			sql.setString(2, user.getTipoPerfil());
			sql.setString(3, user.getNomeReal());
			sql.setString(4, user.getBiografia());
			sql.setString(5, user.getSenha());

			sql.executeUpdate(); // usado para inserts, update e delete 

		} catch (Exception e) {
			// TODO: handle exception
		}

	}

	public Usuario buscaUsuario(String nome) {
		
		Connection con = bd.conexao();
		try {

			PreparedStatement sql = con.prepareStatement("select * from usuario where nome = ?");

			sql.setString(1, nome);
			rs = sql.executeQuery();
			u = SetarUser(rs);
		}
		catch (Exception e) {
			e.printStackTrace();
			// TODO: handle exception
		}
		
		return u;
	}

	public String listarPostComentario(String idUsuario_Post, String opcaoSelect) {
		
		String  s = "";
		Connection con = bd.conexao();
		PreparedStatement sql = null; 
		try {
		
			sql = con.prepareStatement("select conteudo from vw_posts_coments where id = ? and tipo =?");
			
			sql.setString(1,idUsuario_Post);
			sql.setString(2, opcaoSelect);
			
			rs = sql.executeQuery();

			while(rs.next()){
				s = rs.getString(1) + "\n";   
			}


		} catch (Exception e) { 
			System.out.println("Erro - "+e);
		}finally {
			try {
				//con.close();
			} catch (Exception e2) {

			}
		}
		
		return s;
	}

}
