package br.com.time07.sevenfit.fluentValidation;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class Notifiable {
    private final List<Notification> notifications = new ArrayList<>();

    public List<Notification> getNotifications(){
        return Collections.unmodifiableList(notifications);
    }

    public void addNotification(String property, String message) {
        notifications.add(new Notification(property, message));
    }

    public void addNotification(Notification notification) {
        notifications.add(notification);
    }

    public void addNotifications(Collection<Notification> notifications) {
        this.notifications.addAll(notifications);
    }

    public void addNotifications(List<Notification> notifications) {
        this.notifications.addAll(notifications);
    }

    public boolean isValid() {
        return notifications.isEmpty();
    }
}
