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

import org.codehaus.jackson.map.annotate.JsonSerialize;
import org.springframework.format.annotation.DateTimeFormat;

import br.com.adrianohardcore.util.JsonDateSerializer;

@Entity
@Table(name = "posts")  
public class Post implements Serializable{
	private static final long serialVersionUID = 1L;	
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")	
	private Long id;	

	//@Min(value=5,message="O título não pode ter menos que 5 caracteres!")
	//@Max(value=20,message="O título não pode ter mais de 20 caracteres!")
	@Size(min=5, max=20)
	private String title;	

	//@Min(value=10 , message="O conteúdo não pode ter menos que 10 caracteres!")
	//@Max(value=255, message="O conteúdo não pode ter mais que 255 caracteres!")
	@Size(min=5, max=1000)
	private String body;
	
	@OneToMany(mappedBy="post", fetch=FetchType.LAZY, cascade = CascadeType.ALL)
	private Set<Comment>  comments;
	
	private Long userCreation = (long) 1;
	
	private Long userUpdate = (long) 1;
	
    @DateTimeFormat
    @JsonSerialize(using=JsonDateSerializer.class)
    private Date dateCreation;
    
    @DateTimeFormat
    @JsonSerialize(using=JsonDateSerializer.class)
    private Date dateUpdate;
    
    @PrePersist
    public void prePersist() {
        Date now = new Date();
        dateCreation = now;
        dateUpdate = now;   
        
    }
    
    @PreUpdate
    public void preUpdate() {
        dateUpdate = new Date();
    }
	
	public Date getDateCreation() {
		return dateCreation;
	}
	public void setDateCreation(Date dataCriacao) {
		this.dateCreation = dataCriacao;
	}
	public Date getDateUpdate() {
		return dateUpdate;
	}
	public void setDateUpdate(Date dataModificacao) {
		this.dateUpdate = dataModificacao;
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

	public Long getUserCreation() {
		return userCreation;
	}

	public void setUserCreation(Long usuarioCriacao) {
		this.userCreation = usuarioCriacao;
	}

	public Long getUserUpdate() {
		return userUpdate;
	}

	public void setUserUpdate(Long usuarioModificacao) {
		this.userUpdate = usuarioModificacao;
	}
}