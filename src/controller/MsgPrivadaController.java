package controller;

import java.sql.Connection;
import java.sql.ResultSet;
import java.util.List;

import conexao.ConexaoBD;
import model.MensagemPrivada;
import model.Usuario;

public class MsgPrivadaController {
	
	ConexaoBD bd;
	MensagemPrivada mp;
	ResultSet rs;	

	
	public MsgPrivadaController(ConexaoBD b) {

		this.bd = b;
	}
	
	
	public List<MensagemPrivada> listarConversas (Usuario u) {
		
		Connection con = bd.conexao();
		List<MensagemPrivada> m = null;
		try {

				}
		catch (Exception e) {
			e.printStackTrace();
			// TODO: handle exception
		}

		return m;
	}	

	
	public List<MensagemPrivada> listarUmaConversa (String idMsgPv) {
		
		Connection con = bd.conexao();
		List<MensagemPrivada> m = null;
		try {

				}
		catch (Exception e) {
			e.printStackTrace();
			// TODO: handle exception
		}

		return m;
	}		
	
	public void incluirConversa (MensagemPrivada m ) {
		
		Connection con = bd.conexao();

		try {

				}
		catch (Exception e) {
			e.printStackTrace();
			// TODO: handle exception
		}

	}

}
