package Model.Entities;

import java.time.LocalDate;
import java.time.LocalTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class Agendamento {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@OneToOne
	private Cliente cliente;
	
	@OneToOne
	private Funcionario funcionario;
	
	@OneToOne
	private Servico servico;
	
	@Column(length = 11)
	private Double valor;
	
	@Column(length = 30)
	private LocalDate data;
	
	@Column(length = 30)
	private LocalTime hora;
	
	@Column(length = 2)
	private Integer status;
	
	public Agendamento() {
		
	}

	public Agendamento(Integer id, Cliente cliente, Funcionario funcionario, Servico servico, Double valor,
			LocalDate data, LocalTime hora, Integer status) {
		super();
		this.id = id;
		this.cliente = cliente;
		this.funcionario = funcionario;
		this.servico = servico;
		this.valor = valor;
		this.data = data;
		this.hora = hora;
		this.status = status;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public Funcionario getFuncionario() {
		return funcionario;
	}

	public void setFuncionario(Funcionario funcionario) {
		this.funcionario = funcionario;
	}

	public Servico getServico() {
		return servico;
	}

	public void setServico(Servico servico) {
		this.servico = servico;
	}

	public Double getValor() {
		return valor;
	}

	public void setValor(Double valor) {
		this.valor = valor;
	}

	public LocalDate getData() {
		return data;
	}

	public void setData(LocalDate data) {
		this.data = data;
	}

	public LocalTime getHora() {
		return hora;
	}

	public void setHora(LocalTime hora) {
		this.hora = hora;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}
	
	
	
}
