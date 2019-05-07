package model;

public class Seguidores {

	private String idUsuario;
	private String idUsuarioSeguidor;
	private String nomeUsuarioSeguidor;




	public Seguidores() {
		super();
	}




	public Seguidores(String idUsuarioSeguidor, String nomeUsuarioSeguidor) {
		super();
		this.idUsuarioSeguidor = idUsuarioSeguidor;
		this.nomeUsuarioSeguidor = nomeUsuarioSeguidor;
	}




	public Seguidores(String idUsuario, String idUsuarioSeguidor, String nomeUsuarioSeguidor) {
		super();
		this.idUsuario = idUsuario;
		this.idUsuarioSeguidor = idUsuarioSeguidor;
		this.nomeUsuarioSeguidor = nomeUsuarioSeguidor;
	}




	public String getIdUsuario() {
		return idUsuario;
	}




	public void setIdUsuario(String idUsuario) {
		this.idUsuario = idUsuario;
	}




	public String getIdUsuarioSeguidor() {
		return idUsuarioSeguidor;
	}




	public void setIdUsuarioSeguidor(String idUsuarioSeguidor) {
		this.idUsuarioSeguidor = idUsuarioSeguidor;
	}




	public String getNomeUsuarioSeguidor() {
		return nomeUsuarioSeguidor;
	}




	public void setNomeUsuarioSeguidor(String nomeUsuarioSeguidor) {
		this.nomeUsuarioSeguidor = nomeUsuarioSeguidor;
	}


}
