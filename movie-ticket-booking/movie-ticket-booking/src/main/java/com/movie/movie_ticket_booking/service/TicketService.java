package com.movie.movie_ticket_booking.service;

import com.movie.movie_ticket_booking.model.Ticket;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class TicketService {

    // In-memory storage
    private final List<Ticket> ticketList = new ArrayList<>();


    // 1. Book Ticket
    public Ticket bookTicket(Ticket ticket) {

        ticketList.add(ticket);

        return ticket;
    }


    // 2. Search Ticket by ID
    public Ticket getTicketById(int ticketId) {

        for (Ticket ticket : ticketList) {

            if (ticket.getTicketId() == ticketId) {
                return ticket;
            }
        }

        return null;
    }


    // 3. Update Ticket
    public Ticket updateTicket(int ticketId, Ticket updatedTicket) {

        Ticket existingTicket = getTicketById(ticketId);

        if (existingTicket != null) {

            existingTicket.setMovieName(updatedTicket.getMovieName());
            existingTicket.setCustomerName(updatedTicket.getCustomerName());
            existingTicket.setSeatNumber(updatedTicket.getSeatNumber());
            existingTicket.setTicketPrice(updatedTicket.getTicketPrice());

            return existingTicket;
        }

        return null;
    }


    // 4. Delete Ticket
    public boolean deleteTicket(int ticketId) {

        Ticket ticket = getTicketById(ticketId);

        if (ticket != null) {

            ticketList.remove(ticket);

            return true;
        }

        return false;
    }
}