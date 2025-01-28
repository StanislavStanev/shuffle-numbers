package org.sample.app1;

import java.util.Arrays;
import java.util.List;
import java.util.Random;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class MessagingService {

  private final RabbitTemplate rabbitTemplate;

  @Value("${spring.rabbitmq.queue.name}")
  private String queueName;

  public MessagingService(RabbitTemplate rabbitTemplate) {
    this.rabbitTemplate = rabbitTemplate;
  }

  public void sendMessage(int num) {
    List<Integer> shuffledNumList = getShuffledNumList(num);
    rabbitTemplate.convertAndSend(queueName, shuffledNumList);
  }

  private static List<Integer> getShuffledNumList(int num) {
    if (num == 1) {
      return List.of(1);
    }

    int[] array = new int[num];
    for (int i = 0; i < num; i++) {
      array[i] = i + 1;
    }

    Random random = new Random();
    for (int i = num - 1; i > 0; i--) {
      int j = random.nextInt(i + 1);
      int temp = array[i];
      array[i] = array[j];
      array[j] = temp;
    }

    return Arrays.stream(array).boxed().toList();
  }
}
