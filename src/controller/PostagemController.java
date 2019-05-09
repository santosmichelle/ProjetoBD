package controller;

import java.awt.HeadlessException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import conexao.ConexaoBD;
import model.Comentario;
import model.Postagem;
import model.Usuario;

public class PostagemController {

	ConexaoBD bd;
	Postagem p;
	Comentario c;
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
	
	
	public List<Comentario> listarComentarios (String idPost) {
		
		Connection con = bd.conexao();
		List<Comentario> c = null;
		try {
			PreparedStatement sql = con.prepareStatement("select * from COMENTARIO where IDPOST = ?");

			sql.setString(1, idPost);
			rs = sql.executeQuery();
			c = SetarComentario(rs);
			
			}
		catch (Exception e) {
			e.printStackTrace();
			// TODO: handle exception
		}

		return c;
	}	

	public List<Comentario> SetarComentario(ResultSet rs){ // um objeto que vai receber linhas do bd

				List<Comentario> cts = new ArrayList<>();
		try {
			while(rs.next()){
				//System.out.println("Oiii user");
				//c = new Comentario(rs.getString(1), rs.getString(2), rs.getString(3));   
				cts.add(c);
			}
		} catch (HeadlessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return cts;
	}
	
	public void incluirComentario (Usuario u, String idPost, String conteudo) {
		
		
		Connection con = bd.conexao();
		PreparedStatement sql3 = null;
		
		try {
			PreparedStatement sql = con.prepareStatement("INSERT INTO comentario (conteudo, IDUSUARIO,idpost,DATA) "
					+ "VALUES (?,?,?,to_date(to_char(sysdate,'dd/mm/yyyy hh24:mi:ss'),'dd/mm/yyyy hh24:mi:ss'))");
	
			sql.setString(1, conteudo);
			sql.setString(2, u.getIdUsuario());
			sql.setString(3, idPost);
			
			
			if(conteudo.contains("@")) {
				sql3 = con.prepareStatement("INSERT INTO notificacao (ID_SEGUIDOR,CONTEUDO)  VALUES (?,?)");

				sql3.setString(1, getIdUsuario(conteudo));
				sql3.setString(2, "USUARIO: " + u.getNomeUsuario()+" lhe marcou num comentario");
				
				sql3.executeUpdate();
			}



			sql.executeUpdate(); // usado para inserts, update e delete 

			
				}
		catch (Exception e) {
			e.printStackTrace();
			// TODO: handle exception
		}

	}	
	
	private String getIdUsuario(String conteudo) {

		Connection con = bd.conexao();
		
		String c = null;
		String nome = null;
		
		String g = conteudo.substring(conteudo.indexOf("@"));

		int	t = (g.indexOf(" ")==0)?0:g.indexOf(" ");
		
		if (t == -1 ) {
			
			nome = g.substring(1);
		}else {
			nome = g.substring(1,t);
			
		}		
		
		try {
			PreparedStatement sql = con.prepareStatement("select idusuario from usuario where nome= ?");

			sql.setString(1, nome);
			rs = sql.executeQuery();
			
			while(rs.next()){
				c = rs.getString(1);
			}
			
			}
		catch (Exception e) {
			e.printStackTrace();
			// TODO: handle exception
		}

		return c;
		
	}


	public void deleteComentario (String id) {
		
		Connection con = bd.conexao();

		try {

				}
		catch (Exception e) {
			e.printStackTrace();
			// TODO: handle exception
		}

	}


	public void deletePostComentario(String idPostComent, String opcao) {

		Connection con = bd.conexao();
		PreparedStatement sql = null; 
		
		try {
		
		if (opcao.equals("1")) {
			sql = con.prepareStatement("delete from postagem where idpost = ? ");
			sql = con.prepareStatement("delete from comentario where idpost = ? ");
		} else {
			sql = con.prepareStatement("delete from comentario where idpost = ? ");
		}
			
			
			sql.setString(1,idPostComent);
			
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


	public String getMarcacao(String tag) {

		Connection con = bd.conexao();
		
		String c = null;
	
		
		try {
			PreparedStatement sql = con.prepareStatement("select conteudo from vw_posts_coments where tipo = 1 conteudo like '% ? %' ");

			sql.setString(1, tag);
			rs = sql.executeQuery();
			
			while(rs.next()){
				c = c + rs.getString(1) + "\n";
			}
			
			}
		catch (Exception e) {
			e.printStackTrace();
			// TODO: handle exception
		}

		return c;
		
	}
}

