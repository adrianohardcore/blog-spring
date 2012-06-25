package br.com.adrianohardcore.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.Email;
import org.springframework.format.annotation.DateTimeFormat;

@Entity(name="usuario")
public class Usuario implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Long id;

    @NotNull  
    @Size(min = 5, max = 50)
    private String nome;

    @NotNull
    @Column(unique = true )   
    @Size(min = 5, max = 50)
    @Valid
    private String nomeUsuario;

    @NotNull
    @Column(unique = true)
    @Size(min = 5, max = 50)
    @Email
    @Valid
    private String email;

    @NotNull
    @Size(min = 5, max = 10)
    private String senha;
    
    @DateTimeFormat
    private Date dataCriacao;
    
    @DateTimeFormat
    private Date dataModificacao;      
    
	//@OneToOne
    //@OneToMany
    @ManyToOne	
	private Regra regra;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getNomeUsuario() {
		return nomeUsuario;
	}

	public void setNomeUsuario(String nomeUsuario) {
		this.nomeUsuario = nomeUsuario;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}
	
	@PreUpdate
    public void preUpdate() {
        dataModificacao = new Date();
    }
    
    @PrePersist
    public void prePersist() {
        Date now = new Date();
        dataCriacao = now;
        dataModificacao = now;
        
        //regra.setRegra("NOVO");
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

	public Regra getRegra() {
		return regra;
	}

	public void setRegra(Regra regra) {
		this.regra = regra;
	}


}

