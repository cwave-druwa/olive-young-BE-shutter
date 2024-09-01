package olive.young.shutter.domain;

public record ShutterDTO(
        Long id,
        String imageURL,
        String userName,
        String content,
        boolean isLiked,
        Integer likedCount
){
}
