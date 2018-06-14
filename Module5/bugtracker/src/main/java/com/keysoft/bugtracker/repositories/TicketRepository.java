package com.keysoft.bugtracker.repositories;

import com.keysoft.bugtracker.domain.Ticket;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RestResource;

import java.util.List;

public interface TicketRepository extends JpaRepository<Ticket, Integer> {
    @RestResource(path = "descriptionIgnoreCaseContaining", rel = "descriptionIgnoreCaseContaining")
    public List<Ticket> findByDescriptionIgnoreCaseContaining(@Param("description") String description);

    @RestResource(path = "findByApplicationId", rel = "findByApplicationId")
    public List<Ticket> findByApplicationId(@Param("appId") Integer appId);

    @RestResource(path = "titleIgnoreCaseContaining", rel = "titleIgnoreCaseContaining")
    public List<Ticket> findByTitleIgnoreCaseContaining(@Param("title") String title);

}
