package com.example.week5testnycschools.events;

import com.example.week5testnycschools.pojos.school.School;

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
