package model;

public class Seguindo {

	private String idUsuario;
	private String idUsuarioSeguindo;
	private String nomeUsuarioSeguindo;

	
	public Seguindo() {
		super();
	}
	
	public Seguindo(String idUsuarioSeguindo, String nomeUsuarioSeguindo) {
		super();
		this.idUsuarioSeguindo = idUsuarioSeguindo;
		this.nomeUsuarioSeguindo = nomeUsuarioSeguindo;
	}
	
	public Seguindo(String idUsuario, String idUsuarioSeguindo, String nomeUsuarioSeguindo) {
		super();
		this.idUsuario = idUsuario;
		this.idUsuarioSeguindo = idUsuarioSeguindo;
		this.nomeUsuarioSeguindo = nomeUsuarioSeguindo;
	}
	
	public String getIdUsuario() {
		return idUsuario;
	}
	public void setIdUsuario(String idUsuario) {
		this.idUsuario = idUsuario;
	}
	public String getIdUsuarioSeguindo() {
		return idUsuarioSeguindo;
	}
	public void setIdUsuarioSeguindo(String idUsuarioSeguindo) {
		this.idUsuarioSeguindo = idUsuarioSeguindo;
	}
	public String getNomeUsuarioSeguindo() {
		return nomeUsuarioSeguindo;
	}
	public void setNomeUsuarioSeguindo(String nomeUsuarioSeguindo) {
		this.nomeUsuarioSeguindo = nomeUsuarioSeguindo;
	}
	
	
}
