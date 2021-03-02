package Model.Entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Usuario {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@Column(length = 20)
	private String usuario;

	@Column(length = 20)
	private String senha;

	private Integer niveldeacesso;

	public Usuario() {
		super();
	}

	public Usuario(Integer id, String usuario, String senha, Integer niveldeacesso) {
		super();
		this.id = id;
		this.usuario = usuario;
		this.senha = senha;
		this.niveldeacesso = niveldeacesso;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getUsuario() {
		return usuario;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public Integer getNiveldeacesso() {
		return niveldeacesso;
	}

	public void setNiveldeacesso(Integer niveldeacesso) {
		this.niveldeacesso = niveldeacesso;
	}

}
