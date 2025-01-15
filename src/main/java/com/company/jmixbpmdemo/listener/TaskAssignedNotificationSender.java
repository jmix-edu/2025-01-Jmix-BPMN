package com.company.jmixbpmdemo.listener;

import com.company.jmixbpmdemo.entity.User;
import io.jmix.bpm.engine.events.UserTaskAssignedEvent;
import io.jmix.core.DataManager;
import io.jmix.notifications.NotificationManager;
import org.flowable.task.api.Task;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

@Component
public class TaskAssignedNotificationSender {

    private final DataManager dataManager;
    private final NotificationManager notificationManager;

    public TaskAssignedNotificationSender(DataManager dataManager, NotificationManager notificationManager) {
        this.dataManager = dataManager;
        this.notificationManager = notificationManager;
    }

    @EventListener
    public void onTaskAssigned(UserTaskAssignedEvent event) {
        User user = dataManager.load(User.class)
                .query("select u from User u where u.username = :username")
                .parameter("username", event.getUsername())
                .one();
        Task task = event.getTask();

        notificationManager.createNotification()
                .withSubject("New task")
                .withRecipients(user)
                .toChannelsByNames("in-app")
                .withPlainTextContentType()
                .withTypeName("task")
                .withBody("A new task [" + task.getName() + "] is assigned to you")
                .send();

    }
}
