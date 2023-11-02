package faang.school.postservice.kafkaPublisher;

import faang.school.postservice.model.kafka.StringValue;

public interface KafkaSender {
    void send(StringValue value);
}
