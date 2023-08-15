package dev.matheusvictor.backendchallenger.service;

import dev.matheusvictor.backendchallenger.domain.user.User;

public interface NotificationService {

  public void sendNotification(User user, String message) throws Exception;
}
