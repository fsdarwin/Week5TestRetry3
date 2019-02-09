package com.example.week5testretry3.events;

import com.example.week5testretry3.pojos.school.School;

public class SchoolEvent {
    //POJO for EventBus
    public final School[] schoolMessage;

    public SchoolEvent(School[] schoolMessage) {
        this.schoolMessage = schoolMessage;
    }

    public School[] getSchoolMessage() {
        return schoolMessage;
    }
}
