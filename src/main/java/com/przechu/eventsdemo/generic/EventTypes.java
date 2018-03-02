package com.przechu.eventsdemo.generic;

import org.springframework.context.annotation.Profile;

@Profile("generic")
public enum EventTypes {
    AGENT_STARTED,
    AGENT_ACTIVE,
    AGENT_STOPPED
}
