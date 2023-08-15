package dev.matheusvictor.backendchallenger.service.impl;

import dev.matheusvictor.backendchallenger.domain.user.User;
import dev.matheusvictor.backendchallenger.dtos.NotificationDTO;
import dev.matheusvictor.backendchallenger.service.NotificationService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
@AllArgsConstructor
public class NotificationServiceImpl implements NotificationService {

  private final RestTemplate restTemplate;


  @Override
  public void sendNotification(User user, String message) throws Exception {
    String email = user.getEmail();
    NotificationDTO notificationDTO = new NotificationDTO(email, message);

    ResponseEntity<String> notificationResponse =
            restTemplate.postForEntity("http://o4d9z.mocklab.io/notify", notificationDTO, String.class);

    if (!notificationResponse.getStatusCode().is2xxSuccessful()) {
      System.out.println(notificationResponse);
      throw new Exception("service invaluable");
    }
  }
}
