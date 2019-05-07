package model;

import java.util.Date;

public class Comentario {

	private String idComentario;
	private String idPost;
	private String idUsuario;
	private String nomeUsuario;
	private String Conteudo;
	private Date Data;
	
	
	public Comentario() {
		super();
	}

	public Comentario(String idPost, String idUsuario, String nomeUsuario, String conteudo, Date data) {
		super();
		this.idPost = idPost;
		this.idUsuario = idUsuario;
		this.nomeUsuario = nomeUsuario;
		Conteudo = conteudo;
		Data = data;
	}
	
	public Comentario(String idComentario, String idPost, String idUsuario, String nomeUsuario, String conteudo,
			Date data) {
		super();
		this.idComentario = idComentario;
		this.idPost = idPost;
		this.idUsuario = idUsuario;
		this.nomeUsuario = nomeUsuario;
		Conteudo = conteudo;
		Data = data;
	}
	
	public String getNomeUsuario() {
		return nomeUsuario;
	}
	public void setNomeUsuario(String nomeUsuario) {
		this.nomeUsuario = nomeUsuario;
	}
	public String getIdComentario() {
		return idComentario;
	}
	public void setIdComentario(String idComentario) {
		this.idComentario = idComentario;
	}
	public String getIdPost() {
		return idPost;
	}
	public void setIdPost(String idPost) {
		this.idPost = idPost;
	}
	public String getIdUsuario() {
		return idUsuario;
	}
	public void setIdUsuario(String idUsuario) {
		this.idUsuario = idUsuario;
	}
	public String getConteudo() {
		return Conteudo;
	}
	public void setConteudo(String conteudo) {
		Conteudo = conteudo;
	}
	public Date getData() {
		return Data;
	}
	public void setData(Date data) {
		Data = data;
	}
	
	
}
