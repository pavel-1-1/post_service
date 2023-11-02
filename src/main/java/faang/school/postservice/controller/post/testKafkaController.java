package faang.school.postservice.controller.post;

import faang.school.postservice.model.kafka.StringValue;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.CompletableFuture;

@RestController
@RequestMapping("/")
@RequiredArgsConstructor
public class testKafkaController {
    @Value("${application.kafka.topic.post-views}")
    private String postTopic;
    private final KafkaTemplate<String, Object> kafkaTemplate;

    @PostMapping("post")
    public void post() {
        StringValue value = new StringValue("excellent");
        CompletableFuture<SendResult<String, Object>> future = kafkaTemplate.send(postTopic, value);
        future.whenComplete(((result, throwable) -> {
            if (throwable == null) {
                //   System.out.println(value);
                // StringValue value1 = (StringValue) result.getProducerRecord().value();
                //   System.out.println(value1.getMessage());
            } else {
                System.out.println("Unable to send message=[" +
                        value + "] due to : " + throwable.getMessage());
            }
        }));
    }
}
