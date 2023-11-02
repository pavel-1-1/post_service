package faang.school.postservice.mapper;

import faang.school.postservice.dto.comment.CommentDto;
import faang.school.postservice.model.Comment;
import faang.school.postservice.model.Post;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2023-10-25T12:14:36+0700",
    comments = "version: 1.5.3.Final, compiler: IncrementalProcessingEnvironment from gradle-language-java-7.6.1.jar, environment: Java 17.0.8.1 (Amazon.com Inc.)"
)
@Component
public class CommentMapperImpl extends CommentMapper {

    @Override
    public CommentDto toDto(Comment comment) {
        if ( comment == null ) {
            return null;
        }

        CommentDto.CommentDtoBuilder commentDto = CommentDto.builder();

        commentDto.postId( commentPostId( comment ) );
        commentDto.id( comment.getId() );
        commentDto.content( comment.getContent() );
        commentDto.authorId( comment.getAuthorId() );
        commentDto.createdAt( comment.getCreatedAt() );
        commentDto.updatedAt( comment.getUpdatedAt() );

        return commentDto.build();
    }

    @Override
    public Comment toEntity(CommentDto commentDto) {
        if ( commentDto == null ) {
            return null;
        }

        Comment.CommentBuilder comment = Comment.builder();

        comment.post( mapPostIdToPost( commentDto.getPostId() ) );
        if ( commentDto.getId() != null ) {
            comment.id( commentDto.getId() );
        }
        comment.content( commentDto.getContent() );
        if ( commentDto.getAuthorId() != null ) {
            comment.authorId( commentDto.getAuthorId() );
        }
        comment.createdAt( commentDto.getCreatedAt() );
        comment.updatedAt( commentDto.getUpdatedAt() );

        return comment.build();
    }

    @Override
    public void update(CommentDto commentDto, Comment comment) {
        if ( commentDto == null ) {
            return;
        }

        comment.setPost( mapPostIdToPost( commentDto.getPostId() ) );
        if ( commentDto.getId() != null ) {
            comment.setId( commentDto.getId() );
        }
        comment.setContent( commentDto.getContent() );
        if ( commentDto.getAuthorId() != null ) {
            comment.setAuthorId( commentDto.getAuthorId() );
        }
        comment.setCreatedAt( commentDto.getCreatedAt() );
        comment.setUpdatedAt( commentDto.getUpdatedAt() );
    }

    private Long commentPostId(Comment comment) {
        if ( comment == null ) {
            return null;
        }
        Post post = comment.getPost();
        if ( post == null ) {
            return null;
        }
        long id = post.getId();
        return id;
    }
}
