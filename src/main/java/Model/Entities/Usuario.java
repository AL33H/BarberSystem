package Model.Entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedNativeQueries;
import javax.persistence.NamedNativeQuery;

@Entity
public class Usuario {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@Column(length = 20,unique = true, nullable = false)
	private String nome;

	@Column(length = 20, nullable = false)
	private String senha;

	@Column(length = 20, nullable = false)
	private Integer niveldeacesso;

	public Usuario() {
		// TODO Auto-generated constructor stub
	}

	public Usuario(Integer id, String nome, String senha, Integer niveldeacesso) {
		super();
		this.id = id;
		this.nome = nome;
		this.senha = senha;
		this.niveldeacesso = niveldeacesso;
	}

	
	
	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
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

	@Override
	public String toString() {
		return "Usuario [id=" + id + ", nome=" + nome + ", senha=" + senha + ", niveldeacesso=" + niveldeacesso + "]";
	}
	
	

}
