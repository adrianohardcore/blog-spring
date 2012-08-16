package br.com.adrianohardcore.model;

import java.io.Serializable;
import java.util.Date;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity(name="regra")
public class Regra implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	@NotNull
	@Size(min=5 , max=30)
	private String regra;
	
	private String descricao;
	
    
    private Date dataCriacao;
    
    
    private Date dataModificacao;
	
	//@OneToOne(mappedBy="regra", cascade={CascadeType.ALL},fetch=FetchType.EAGER)
	//@ManyToOne(cascade={CascadeType.ALL},fetch=FetchType.EAGER)
    @OneToMany(mappedBy="regra")
	private Set<Usuario> usuarios;   
	
		
	
	@PreUpdate
    public void preUpdate() {
        dataModificacao = new Date();
    }
    
    @PrePersist
    public void prePersist() {
        Date now = new Date();
        dataCriacao = now;
        dataModificacao = now;
    }
	

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getRegra() {
		return regra;
	}

	public void setRegra(String regra) {
		this.regra = regra;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}



	public Set<Usuario> getUsuarios() {
		return usuarios;
	}

	public void setUsuarios(Set<Usuario> usuarios) {
		this.usuarios = usuarios;
	}

	public Date getDataCriacao() {
		return dataCriacao;
	}

	public void setDataCriacao(Date dataCriacao) {
		this.dataCriacao = dataCriacao;
	}

	public Date getDataModificacao() {
		return dataModificacao;
	}

	public void setDataModificacao(Date dataModificacao) {
		this.dataModificacao = dataModificacao;
	}

	@Override
	public String toString() {
		return regra;
	}
	
	
}
