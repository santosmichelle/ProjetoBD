package controller;

import java.awt.HeadlessException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import conexao.ConexaoBD;
import model.Postagem;
import model.Usuario;

public class PostagemController {

	ConexaoBD bd;
	Postagem p;
	ResultSet rs;

	public PostagemController(ConexaoBD b) {

		this.bd = b;
	}

	
	public Postagem SetarPost(ResultSet rs){ // um objeto que vai receber linhas do bd

		//		List<Usuario> us;
		try {
			while(rs.next()){
				//System.out.println("Oiii user");
				p = new Postagem(rs.getString(1), rs.getString(2), rs.getString(3));   
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

		return p;
	}
	public void criarPost(Postagem post) {
		Connection con = bd.conexao();

		try {

			PreparedStatement sql = con.prepareStatement("INSERT INTO POSTAGEM (TEXTO, IDUSUARIO,FOTO,DATA) "
					+ "VALUES (?,?,?,to_date(to_char(sysdate,'dd/mm/yyyy hh24:mi:ss'),'dd/mm/yyyy hh24:mi:ss'))");

			sql.setString(1, post.getTexto());
			sql.setString(2, post.getIdUsuario());
			sql.setString(3, post.getFoto());



			sql.executeUpdate(); // usado para inserts, update e delete 

		} catch (Exception e) {
			// TODO: handle exception
		}



	}



	public void deletePost(String idPost ) {
		Connection con = bd.conexao();

		try {

			PreparedStatement sql = con.prepareStatement("DELETE FROM POSTAGEM where idPost = ?");

			sql.setString(1, idPost);



			sql.executeUpdate(); // usado para inserts, update e delete 

		} catch (Exception e) {
			// TODO: handle exception
		}
		

	}
	
	
	
	public Postagem buscaPost(String idPost) {
		Connection con = bd.conexao();
		try {

			PreparedStatement sql = con.prepareStatement("select * from postagem where id = ?");

			sql.setString(1, idPost);
			rs = sql.executeQuery();
			p = SetarPost(rs);
		}
		catch (Exception e) {
			e.printStackTrace();
			// TODO: handle exception
		}
		
		return p;
	}
	}


