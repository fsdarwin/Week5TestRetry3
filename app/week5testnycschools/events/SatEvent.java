package com.example.week5testnycschools.events;

import com.example.week5testnycschools.pojos.Sat.Sat;

public class SatEvent {
    //POJO for EventBus
    public final Sat[] satMessage;

    public SatEvent(Sat[] satMessage) {
        this.satMessage = satMessage;
    }

    public Sat[] getSatMessage() {
        return satMessage;
    }
}
