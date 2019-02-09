package com.example.week5testnycschools.events;

import com.example.week5testnycschools.pojos.school.School;

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
