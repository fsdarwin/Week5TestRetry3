package com.example.week5testretry3.events;

import com.example.week5testretry3.pojos.school.School;

public class UserEvent {
//POJO for EventBus
    public final School selectedByUser;

    public UserEvent(School selectedByUser) {
        this.selectedByUser = selectedByUser;
    }

    public School getSelectedByUser() {
        return selectedByUser;
    }
}
