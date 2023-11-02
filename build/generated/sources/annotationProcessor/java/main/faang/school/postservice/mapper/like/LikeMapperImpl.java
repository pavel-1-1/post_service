package faang.school.postservice.mapper.like;

import faang.school.postservice.dto.like.LikeDto;
import faang.school.postservice.model.Comment;
import faang.school.postservice.model.Like;
import faang.school.postservice.model.Post;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2023-10-25T12:14:36+0700",
    comments = "version: 1.5.3.Final, compiler: IncrementalProcessingEnvironment from gradle-language-java-7.6.1.jar, environment: Java 17.0.8.1 (Amazon.com Inc.)"
)
@Component
public class LikeMapperImpl implements LikeMapper {

    @Override
    public LikeDto toDto(Like entity) {
        if ( entity == null ) {
            return null;
        }

        LikeDto.LikeDtoBuilder likeDto = LikeDto.builder();

        likeDto.postId( entityPostId( entity ) );
        likeDto.commentId( entityCommentId( entity ) );
        likeDto.id( entity.getId() );
        likeDto.userId( entity.getUserId() );
        likeDto.createdAt( entity.getCreatedAt() );

        return likeDto.build();
    }

    @Override
    public Like toEntity(LikeDto dto) {
        if ( dto == null ) {
            return null;
        }

        Like.LikeBuilder like = Like.builder();

        like.post( mapPost( dto.getPostId() ) );
        like.comment( mapComment( dto.getCommentId() ) );
        if ( dto.getId() != null ) {
            like.id( dto.getId() );
        }
        like.userId( dto.getUserId() );
        like.createdAt( dto.getCreatedAt() );

        return like.build();
    }

    private Long entityPostId(Like like) {
        if ( like == null ) {
            return null;
        }
        Post post = like.getPost();
        if ( post == null ) {
            return null;
        }
        long id = post.getId();
        return id;
    }

    private Long entityCommentId(Like like) {
        if ( like == null ) {
            return null;
        }
        Comment comment = like.getComment();
        if ( comment == null ) {
            return null;
        }
        long id = comment.getId();
        return id;
    }
}
