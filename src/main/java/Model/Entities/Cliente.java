package Model.Entities;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Cliente {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@Column(length = 30)
	private String nome;
	
	@Column(length = 30)
	private String sexo;
	
	@Column(length = 30)
	private LocalDate datadenascimento;
	
	@Column(length = 30)
	private String telefone;
	
	@Column(length = 30)
	private String cidade;
	
	
	

	public Cliente(Integer id, String nome, String sexo, LocalDate datadenascimento, String telefone, String cidade) {
		super();
		this.id = id;
		this.nome = nome;
		this.sexo = sexo;
		this.datadenascimento = datadenascimento;
		this.telefone = telefone;
		this.cidade = cidade;
	}

	public Cliente() {
		super();
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

	public String getSexo() {
		return sexo;
	}

	public void setSexo(String sexo) {
		this.sexo = sexo;
	}

	public LocalDate getDatadenascimento() {
		return datadenascimento;
	}

	public void setDatadenascimento(LocalDate datadenascimento) {
		this.datadenascimento = datadenascimento;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public String getCidade() {
		return cidade;
	}

	public void setCidade(String cidade) {
		this.cidade = cidade;
	}

	@Override
	public String toString() {
		return "Cliente [id=" + id + ", nome=" + nome + "]";
	}
	
	
}
