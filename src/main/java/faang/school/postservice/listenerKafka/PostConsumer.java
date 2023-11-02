package faang.school.postservice.listenerKafka;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import faang.school.postservice.model.kafka.StringValue;
import lombok.RequiredArgsConstructor;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class PostConsumer {
    private final ObjectMapper objectMapper;

    @KafkaListener(topics = "post_views")
    public void listenGroupPost(String message) {
        StringValue value = null;
        try {
            value = objectMapper.readValue(message, StringValue.class);
        }catch (JsonProcessingException e) {
            System.out.println("error mapper");
        }
         
        System.out.println("----------------: " + message + " :------------------------" + value.getMessage());
    }
}
