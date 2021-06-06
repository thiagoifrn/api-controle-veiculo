package br.com.zup.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Transient;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonBackReference;


@Entity
public class Veiculo implements Serializable{
	private static final long serialVersionUID = 1L;


	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Id
	private Long id;
	
	@NotNull
	private String marca;
	
	@NotNull
	private String modelo;
	
	@NotNull
	private String ano;
	
	private String valor;
	
	private String diaRodizio;
	
	@Transient
	private Boolean rodizioAtivo;
	
	@NotNull
	@ManyToOne
	@JoinColumn(name = "usuario_id", referencedColumnName = "id")
	@JsonBackReference
	private Usuario usuario;
	
	

	public Veiculo() {
	}

	public Veiculo(Long id, @NotNull String marca, @NotNull String modelo, @NotNull String ano, String valor,
			String diaRodizio, Boolean rodizioAtivo, @NotNull Usuario usuario) {
		super();
		this.id = id;
		this.marca = marca;
		this.modelo = modelo;
		this.ano = ano;
		this.valor = valor;
		this.diaRodizio = diaRodizio;
		this.rodizioAtivo = rodizioAtivo;
		this.usuario = usuario;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getMarca() {
		return marca;
	}

	public void setMarca(String marca) {
		this.marca = marca;
	}

	public String getModelo() {
		return modelo;
	}

	public void setModelo(String modelo) {
		this.modelo = modelo;
	}

	public String getAno() {
		return ano;
	}

	public void setAno(String ano) {
		this.ano = ano;
	}

	public String getValor() {
		return valor;
	}

	public void setValor(String valor) {
		this.valor = valor;
	}

	public String getDiaRodizio() {
		return diaRodizio;
	}

	public void setDiaRodizio(String diaRodizio) {
		this.diaRodizio = diaRodizio;
	}

	public Boolean getRodizioAtivo() {
		return rodizioAtivo;
	}

	public void setRodizioAtivo(Boolean rodizioAtivo) {
		this.rodizioAtivo = rodizioAtivo;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((ano == null) ? 0 : ano.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Veiculo other = (Veiculo) obj;
		if (ano == null) {
			if (other.ano != null)
				return false;
		} else if (!ano.equals(other.ano))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Veiculo [id=" + id + ", marca=" + marca + ", modelo=" + modelo + ", ano=" + ano + ", valor=" + valor
				+ ", diaRodizio=" + diaRodizio + ", rodizioAtivo=" + rodizioAtivo + ", usuario=" + usuario + "]";
	}
	
	
	
}
