package model;

import java.util.Date;

public class Postagem {



	private String idPost;
	private String texto;
	private String idUsuario;
	private Date data;
	private String foto;

	public Postagem() {

	}

	public Postagem(String texto, String idUsuario, String foto) {
		this.texto = texto;
		this.idUsuario = idUsuario;
		this.foto = foto;

	}
	
	public Postagem(String idPost, String texto, String idUsuario, Date data, String foto) {
		this.idPost = idPost;
		this.texto = texto;
		this.idUsuario = idUsuario;
		this.data = data;
		this.foto = foto;

	}

	public String getIdUsuario() {
		return idUsuario;
	}
	public void setIdUsuario(String idUsuario) {
		this.idUsuario = idUsuario;
	}
	public String getFoto() {
		return foto;
	}
	public void setFoto(String foto) {
		this.foto = foto;
	}
	public String getIdPost() {
		return idPost;
	}
	public void setIdPost(String idPost) {
		this.idPost = idPost;
	}

	public Date getData() {
		return data;
	}
	public void setData(Date data) {
		this.data = data;
	}
	public String getTexto() {
		return texto;
	}
	public void setTexto(String texto) {
		this.texto = texto;
	}




}
