package br.com.adrianohardcore.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;

import org.codehaus.jackson.map.annotate.JsonSerialize;
import org.springframework.format.annotation.DateTimeFormat;

import br.com.adrianohardcore.util.JsonDateSerializer;

@Entity
@Table(name = "comments")
public class Comment implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	
	private Long id;	

	@Min(value=5,message="O comentário não pode ter menos que 5 caracteres!")
	@Max(value=20,message="O comentário não pode ter mais de 20 caracteres!")
	private String comment;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "post_id", referencedColumnName = "id")
	private Post post;
	
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

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

	public Post getPost() {
		return post;
	}

	public void setPost(Post post) {
		this.post = post;
	}

	public Long getUserCreation() {
		return userCreation;
	}

	public void setUserCreation(Long userCreation) {
		this.userCreation = userCreation;
	}

	public Long getUserUpdate() {
		return userUpdate;
	}

	public void setUserUpdate(Long userUpdate) {
		this.userUpdate = userUpdate;
	}

}