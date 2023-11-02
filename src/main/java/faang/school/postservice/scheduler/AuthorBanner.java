package faang.school.postservice.scheduler;

import faang.school.postservice.config.context.UserContext;
import faang.school.postservice.service.PostService;
import lombok.RequiredArgsConstructor;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class AuthorBanner {
    private final PostService postService;
    private final UserContext userContext;
    @Scheduled(cron = "${post.user-banner.cron}")
    public void banForOffensiveContent(){
        userContext.setUserId(-1L);
		postService.banForOffensiveContent();
    }
}
