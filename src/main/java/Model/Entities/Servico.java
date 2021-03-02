package Model.Entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Servico {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@Column(length = 30)
	private String nome;
	
	@Column(length = 11)
	private Double valor;
	
	@Column(length = 3)
	private Integer porcentagemdofuncionario;
	
	public Servico() {
		
	}
	

	public Servico(Integer id, String nome, Double valor, Integer porcentagemdofuncionario) {
		super();
		this.id = id;
		this.nome = nome;
		this.valor = valor;
		this.porcentagemdofuncionario = porcentagemdofuncionario;
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

	public Double getValor() {
		return valor;
	}

	public void setValor(Double valor) {
		this.valor = valor;
	}

	public Integer getPorcentagemdofuncionario() {
		return porcentagemdofuncionario;
	}

	public void setPorcentagemdofuncionario(Integer porcentagemdofuncionario) {
		this.porcentagemdofuncionario = porcentagemdofuncionario;
	}

	@Override
	public String toString() {
		return "Servico [id=" + id + ", nome=" + nome + "]";
	}
	
	
	
}
