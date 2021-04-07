package com.keysoft.bugtracker.bootstrap;

import com.keysoft.bugtracker.domain.Ticket;
import com.keysoft.bugtracker.repositories.TicketRepository;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;


@Component
public class BugtrackerApplicationLoader implements ApplicationListener<ContextRefreshedEvent> {

    private TicketRepository ticketRepository;

    private Logger log = Logger.getLogger(BugtrackerApplicationLoader.class);

    @Autowired
    public void setTicketRepository(TicketRepository ticketRepository) {
        this.ticketRepository = ticketRepository;
    }

    @Override
    public void onApplicationEvent(ContextRefreshedEvent event) {
        Ticket tick1 = new Ticket("Add the ability to sort by release date", "The users need this new feature", 1, 2);
        Ticket tick2 = new Ticket("Updates are not saved correctly to task name", "This is a bug impacting this feature in production", 1, 2);

        ticketRepository.save(tick1);
        ticketRepository.save(tick2);

        log.info("Saved Ticket id: " + tick1.getId());
        log.info("Saved Ticket id: " + tick2.getId());
    }
}
