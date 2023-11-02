package faang.school.postservice.mapper.album;

import faang.school.postservice.dto.album.AlbumCreateDto;
import faang.school.postservice.dto.album.AlbumDto;
import faang.school.postservice.dto.album.AlbumUpdateDto;
import faang.school.postservice.dto.album.AuthorAlbumDto;
import faang.school.postservice.model.Album;
import faang.school.postservice.model.Post;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2023-10-25T12:14:36+0700",
    comments = "version: 1.5.3.Final, compiler: IncrementalProcessingEnvironment from gradle-language-java-7.6.1.jar, environment: Java 17.0.8.1 (Amazon.com Inc.)"
)
@Component
public class AlbumMapperImpl implements AlbumMapper {

    @Override
    public Album toAlbumCreate(AlbumCreateDto albumCreateDto) {
        if ( albumCreateDto == null ) {
            return null;
        }

        Album.AlbumBuilder album = Album.builder();

        album.title( albumCreateDto.getTitle() );
        album.description( albumCreateDto.getDescription() );
        if ( albumCreateDto.getAuthorId() != null ) {
            album.authorId( albumCreateDto.getAuthorId() );
        }
        album.visibility( albumCreateDto.getVisibility() );
        List<Long> list = albumCreateDto.getUsersWithAccessIds();
        if ( list != null ) {
            album.usersWithAccessIds( new ArrayList<Long>( list ) );
        }

        return album.build();
    }

    @Override
    public Album toAlbum(AlbumDto albumDto) {
        if ( albumDto == null ) {
            return null;
        }

        Album.AlbumBuilder album = Album.builder();

        album.posts( toPosts( albumDto.getPostsId() ) );
        if ( albumDto.getId() != null ) {
            album.id( albumDto.getId() );
        }
        album.title( albumDto.getTitle() );
        album.description( albumDto.getDescription() );
        if ( albumDto.getAuthorId() != null ) {
            album.authorId( albumDto.getAuthorId() );
        }
        album.createdAt( albumDto.getCreatedAt() );
        album.updatedAt( albumDto.getUpdatedAt() );

        return album.build();
    }

    @Override
    public AlbumDto toAlbumDto(Album album) {
        if ( album == null ) {
            return null;
        }

        AlbumDto.AlbumDtoBuilder albumDto = AlbumDto.builder();

        albumDto.postsId( toId( album.getPosts() ) );
        albumDto.id( album.getId() );
        albumDto.title( album.getTitle() );
        albumDto.description( album.getDescription() );
        albumDto.authorId( album.getAuthorId() );
        albumDto.createdAt( album.getCreatedAt() );
        albumDto.updatedAt( album.getUpdatedAt() );

        return albumDto.build();
    }

    @Override
    public AuthorAlbumDto toAuthorAlbumDto(Album album) {
        if ( album == null ) {
            return null;
        }

        AuthorAlbumDto.AuthorAlbumDtoBuilder authorAlbumDto = AuthorAlbumDto.builder();

        authorAlbumDto.postsId( toId( album.getPosts() ) );
        authorAlbumDto.id( album.getId() );
        authorAlbumDto.title( album.getTitle() );
        authorAlbumDto.description( album.getDescription() );
        authorAlbumDto.authorId( album.getAuthorId() );
        authorAlbumDto.createdAt( album.getCreatedAt() );
        authorAlbumDto.updatedAt( album.getUpdatedAt() );
        authorAlbumDto.visibility( album.getVisibility() );
        List<Long> list1 = album.getUsersWithAccessIds();
        if ( list1 != null ) {
            authorAlbumDto.usersWithAccessIds( new ArrayList<Long>( list1 ) );
        }

        return authorAlbumDto.build();
    }

    @Override
    public void updateAlbum(AlbumUpdateDto albumUpdateDto, Album album) {
        if ( albumUpdateDto == null ) {
            return;
        }

        if ( album.getPosts() != null ) {
            List<Post> list = toPosts( albumUpdateDto.getPostsId() );
            if ( list != null ) {
                album.getPosts().clear();
                album.getPosts().addAll( list );
            }
            else {
                album.setPosts( null );
            }
        }
        else {
            List<Post> list = toPosts( albumUpdateDto.getPostsId() );
            if ( list != null ) {
                album.setPosts( list );
            }
        }
        album.setTitle( albumUpdateDto.getTitle() );
        album.setDescription( albumUpdateDto.getDescription() );
        if ( albumUpdateDto.getAuthorId() != null ) {
            album.setAuthorId( albumUpdateDto.getAuthorId() );
        }
        album.setUpdatedAt( albumUpdateDto.getUpdatedAt() );
        album.setVisibility( albumUpdateDto.getVisibility() );
        if ( album.getUsersWithAccessIds() != null ) {
            List<Long> list1 = albumUpdateDto.getUsersWithAccessIds();
            if ( list1 != null ) {
                album.getUsersWithAccessIds().clear();
                album.getUsersWithAccessIds().addAll( list1 );
            }
            else {
                album.setUsersWithAccessIds( null );
            }
        }
        else {
            List<Long> list1 = albumUpdateDto.getUsersWithAccessIds();
            if ( list1 != null ) {
                album.setUsersWithAccessIds( new ArrayList<Long>( list1 ) );
            }
        }
    }
}
