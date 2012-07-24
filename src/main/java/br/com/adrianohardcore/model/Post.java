package br.com.adrianohardcore.model;

import java.io.Serializable;
import java.util.Date;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;
import javax.validation.constraints.Size;

import org.springframework.format.annotation.DateTimeFormat;



@Entity
@Table(name = "posts")  
public class Post implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")	
	private Long id;	
	
	@Size(min=5, message="O título não pode ter menos que 5 caracteres!")
	private String title;	

	//@Min(value=10 , message="O conteúdo não pode ter menos que 10 caracteres!")
	//@Max(value=255, message="O conteúdo não pode ter mais que 255 caracteres!")	
	private String body;
	
	@OneToMany(mappedBy="post", fetch=FetchType.EAGER, cascade = CascadeType.ALL)
	private Set<Comment>  comments;
	
	private Long usuarioCriacao = (long) 1;
	
	private Long usuarioModificacao = (long) 1;
	
    @DateTimeFormat
    private Date dataCriacao;
    
    @DateTimeFormat
    private Date dataModificacao;
    
    @PrePersist
    public void prePersist() {
        Date now = new Date();
        dataCriacao = now;
        dataModificacao = now;   
        
    }
    
    @PreUpdate
    public void preUpdate() {
        dataModificacao = new Date();
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
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getBody() {
		return body;
	}
	public void setBody(String body) {
		this.body = body;
	}
	public Set<Comment> getComments() {
		return comments;
	}
	public void setComments(Set<Comment> comments) {
		this.comments = comments;
	}

	public Long getUsuarioCriacao() {
		return usuarioCriacao;
	}

	public void setUsuarioCriacao(Long usuarioCriacao) {
		this.usuarioCriacao = usuarioCriacao;
	}

	public Long getUsuarioModificacao() {
		return usuarioModificacao;
	}

	public void setUsuarioModificacao(Long usuarioModificacao) {
		this.usuarioModificacao = usuarioModificacao;
	}
	
	
	
	

}