package controller;

import java.awt.HeadlessException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

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

		} catch (Exception e) { 
			System.out.println("Erro - "+e);
		}finally {
			try {
				//con.close();
			} catch (Exception e2) {

			}
		}
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
	
	public void seguirUsuario(Usuario u, String idUsuarioSeguir){
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
		
	}	
	
	public Usuario SetarUser(ResultSet rs){ // um objeto que vai receber linhas do bd

		//		List<Usuario> us;
		try {
			while(rs.next()){
				System.out.println("Oiii user");
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

}
