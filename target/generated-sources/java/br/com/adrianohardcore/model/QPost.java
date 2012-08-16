package br.com.adrianohardcore.model;

import static com.mysema.query.types.PathMetadataFactory.*;

import com.mysema.query.types.*;
import com.mysema.query.types.path.*;

import javax.annotation.Generated;


/**
 * QPost is a Querydsl query type for Post
 */
@Generated("com.mysema.query.codegen.EntitySerializer")
public class QPost extends EntityPathBase<Post> {

    private static final long serialVersionUID = -1609383764;

    public static final QPost post = new QPost("post");

    public final StringPath body = createString("body");

    public final SetPath<Comment, QComment> comments = this.<Comment, QComment>createSet("comments", Comment.class, QComment.class);

    public final NumberPath<Long> id = createNumber("id", Long.class);

    public final StringPath title = createString("title");

    public QPost(String variable) {
        super(Post.class, forVariable(variable));
    }

    public QPost(Path<? extends Post> entity) {
        super(entity.getType(), entity.getMetadata());
    }

    public QPost(PathMetadata<?> metadata) {
        super(Post.class, metadata);
    }

}

