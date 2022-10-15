package liga.medical.message.queues.core.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import liga.medical.message.queues.core.config.RabbitMQConfig;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ListenService {

    private final ObjectMapper objectMapper;

    @Autowired
    public ListenService(ObjectMapper objectMapper) {
        this.objectMapper = objectMapper;
    }

    @RabbitListener(queues = RabbitMQConfig.QUEUE_NAME_ALERT)
    public void listenQueueAlert(String message) throws JsonProcessingException {
        System.out.println("Cообщение пришло из очереди alert_queue с содержимым : " + message);
    }
    @RabbitListener(queues = RabbitMQConfig.QUEUE_NAME_DAILY)
    public void listenQueueDaily(String message) throws JsonProcessingException {
        System.out.println("Cообщение пришло из очереди daily_queue с содержимым : " + message);
    }
    @RabbitListener(queues = RabbitMQConfig.QUEUE_NAME_ERROR)
    public void listenQueueError(String message) throws JsonProcessingException {
        System.out.println("Cообщение пришло из очереди error_queue с содержимым : " + message);
    }



}
