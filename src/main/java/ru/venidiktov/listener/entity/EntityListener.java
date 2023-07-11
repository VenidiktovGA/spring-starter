package ru.venidiktov.listener.entity;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class EntityListener {
    @EventListener(condition = "#root.args[0].accessType.name() == 'READ'")
    public void acceptEntityRead(EntityEvent event) {
        log.info("Отработал EntityEventListener, entity: " + event);
    }
}
