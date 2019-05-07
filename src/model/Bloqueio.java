package model;

public class Bloqueio {
	
	private String idUsuarioBloqueado;
	private String nomeUsuarioBloqueado;
	private String idUsuarioBloqueou;
	private String nomeUsuarioBloqueou;
	
	public Bloqueio() {
		super();
	}
	
	public Bloqueio(String idUsuarioBloqueado, String nomeUsuarioBloqueado, String idUsuarioBloqueou,
			String nomeUsuarioBloqueou) {
		super();
		this.idUsuarioBloqueado = idUsuarioBloqueado;
		this.nomeUsuarioBloqueado = nomeUsuarioBloqueado;
		this.idUsuarioBloqueou = idUsuarioBloqueou;
		this.nomeUsuarioBloqueou = nomeUsuarioBloqueou;
	}
	
	public String getIdUsuarioBloqueado() {
		return idUsuarioBloqueado;
	}
	public void setIdUsuarioBloqueado(String idUsuarioBloqueado) {
		this.idUsuarioBloqueado = idUsuarioBloqueado;
	}
	public String getNomeUsuarioBloqueado() {
		return nomeUsuarioBloqueado;
	}
	public void setNomeUsuarioBloqueado(String nomeUsuarioBloqueado) {
		this.nomeUsuarioBloqueado = nomeUsuarioBloqueado;
	}
	public String getIdUsuarioBloqueou() {
		return idUsuarioBloqueou;
	}
	public void setIdUsuarioBloqueou(String idUsuarioBloqueou) {
		this.idUsuarioBloqueou = idUsuarioBloqueou;
	}
	public String getNomeUsuarioBloqueou() {
		return nomeUsuarioBloqueou;
	}
	public void setNomeUsuarioBloqueou(String nomeUsuarioBloqueou) {
		this.nomeUsuarioBloqueou = nomeUsuarioBloqueou;
	}
	

}
