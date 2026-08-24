package com.movie.movie_ticket_booking.controller;

import com.movie.movie_ticket_booking.model.Ticket;
import com.movie.movie_ticket_booking.service.TicketService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/tickets")
public class TicketController {

    private final TicketService ticketService;

    // Constructor Injection
    public TicketController(TicketService ticketService) {
        this.ticketService = ticketService;
    }


    // 1. Book Ticket
    @PostMapping
    public ResponseEntity<Ticket> bookTicket(
            @Valid @RequestBody Ticket ticket) {

        Ticket bookedTicket = ticketService.bookTicket(ticket);

        return new ResponseEntity<>(
                bookedTicket,
                HttpStatus.CREATED
        );
    }


    // 2. Search Ticket by ID
    @GetMapping("/{ticketId}")
    public ResponseEntity<?> getTicketById(
            @PathVariable int ticketId) {

        Ticket ticket = ticketService.getTicketById(ticketId);

        if (ticket != null) {
            return ResponseEntity.ok(ticket);
        }

        return ResponseEntity
                .status(HttpStatus.NOT_FOUND)
                .body("Ticket not found");
    }


    // 3. Update Ticket
    @PutMapping("/{ticketId}")
    public ResponseEntity<?> updateTicket(
            @PathVariable int ticketId,
            @Valid @RequestBody Ticket updatedTicket) {

        Ticket ticket =
                ticketService.updateTicket(ticketId, updatedTicket);

        if (ticket != null) {
            return ResponseEntity.ok(ticket);
        }

        return ResponseEntity
                .status(HttpStatus.NOT_FOUND)
                .body("Ticket not found");
    }


    // 4. Delete Ticket
    @DeleteMapping("/{ticketId}")
    public ResponseEntity<?> deleteTicket(
            @PathVariable int ticketId) {

        boolean deleted =
                ticketService.deleteTicket(ticketId);

        if (deleted) {
            return ResponseEntity.ok(
                    "Ticket deleted successfully"
            );
        }

        return ResponseEntity
                .status(HttpStatus.NOT_FOUND)
                .body("Ticket not found");
    }
}