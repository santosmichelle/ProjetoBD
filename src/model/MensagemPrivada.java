package model;

import java.util.Date;

public class MensagemPrivada {
	
	private String idMensagem;
	private String idUsuario;
	private String nomeUsuario;
	private String conteudo;
	private Date data;
	
	public MensagemPrivada() {
		super();
	}
	public MensagemPrivada(String idUsuario, String nomeUsuario, String conteudo, Date data) {
		super();
		this.idUsuario = idUsuario;
		this.nomeUsuario = nomeUsuario;
		this.conteudo = conteudo;
		this.data = data;
	}
	public MensagemPrivada(String idMensagem, String idUsuario, String nomeUsuario, String conteudo, Date data) {
		super();
		this.idMensagem = idMensagem;
		this.idUsuario = idUsuario;
		this.nomeUsuario = nomeUsuario;
		this.conteudo = conteudo;
		this.data = data;
	}
	public String getIdMensagem() {
		return idMensagem;
	}
	public void setIdMensagem(String idMensagem) {
		this.idMensagem = idMensagem;
	}
	public String getIdUsuario() {
		return idUsuario;
	}
	public void setIdUsuario(String idUsuario) {
		this.idUsuario = idUsuario;
	}
	public String getNomeUsuario() {
		return nomeUsuario;
	}
	public void setNomeUsuario(String nomeUsuario) {
		this.nomeUsuario = nomeUsuario;
	}
	public String getConteudo() {
		return conteudo;
	}
	public void setConteudo(String conteudo) {
		this.conteudo = conteudo;
	}
	public Date getData() {
		return data;
	}
	public void setData(Date data) {
		this.data = data;
	}

	
}
