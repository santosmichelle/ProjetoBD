package model;

public class Usuario {
	
	private String idUsuario;
	private String nomeReal;
	private String nomeUsuario;
	private String senha;
	private String biografia;
	private String tipoPerfil;
	
	
	public Usuario( String nomeUsuario,String tipoPerfil, String nomeReal, String biografia, String senha ) {
		//this.idUsuario = idUsuario;
		this.nomeReal = nomeReal;
		this.nomeUsuario = nomeUsuario;
		this.senha = senha;
		this.biografia = biografia;
		this.tipoPerfil = tipoPerfil;
	}
	
	public Usuario(String idUsuario,  String nomeUsuario,String tipoPerfil, String nomeReal, String biografia, String senha ) {
		this.idUsuario = idUsuario;
		this.nomeReal = nomeReal;
		this.nomeUsuario = nomeUsuario;
		this.senha = senha;
		this.biografia = biografia;
		this.tipoPerfil = tipoPerfil;
	}

	public String getIdUsuario() {
		return idUsuario;
	}

	public void setIdUsuario(String idUsuario) {
		this.idUsuario = idUsuario;
	}

	public String getBiografia() {
		return biografia;
	}

	public void setBiografia(String biografia) {
		this.biografia = biografia;
	}

	public String getTipoPerfil() {
		return tipoPerfil;
	}

	public void setTipoPerfil(String tipoPerfil) {
		this.tipoPerfil = tipoPerfil;
	}
	
	

	
	public String getNomeReal() {
		return nomeReal;
	}
	public void setNomeReal(String nomeReal) {
		this.nomeReal = nomeReal;
	}
	public String getNomeUsuario() {
		return nomeUsuario;
	}
	public void setNomeUsuario(String nomeUsuario) {
		this.nomeUsuario = nomeUsuario;
	}
	public String getSenha() {
		return senha;
	}
	public void setSenha(String senha) {
		this.senha = senha;
	}
	

}
