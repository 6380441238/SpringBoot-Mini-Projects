package com.movie.movie_ticket_booking.model;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Positive;

public class Ticket {

    private int ticketId;

    @NotBlank(message = "Movie name is required")
    private String movieName;

    @NotBlank(message = "Customer name cannot be empty")
    private String customerName;

    private String seatNumber;

    @Positive(message = "Ticket price must be positive")
    private double ticketPrice;


    // Default Constructor
    public Ticket() {
    }


    // Parameterized Constructor
    public Ticket(int ticketId, String movieName, String customerName,
                  String seatNumber, double ticketPrice) {

        this.ticketId = ticketId;
        this.movieName = movieName;
        this.customerName = customerName;
        this.seatNumber = seatNumber;
        this.ticketPrice = ticketPrice;
    }


    // Getter and Setter for ticketId
    public int getTicketId() {
        return ticketId;
    }

    public void setTicketId(int ticketId) {
        this.ticketId = ticketId;
    }


    // Getter and Setter for movieName
    public String getMovieName() {
        return movieName;
    }

    public void setMovieName(String movieName) {
        this.movieName = movieName;
    }


    // Getter and Setter for customerName
    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }


    // Getter and Setter for seatNumber
    public String getSeatNumber() {
        return seatNumber;
    }

    public void setSeatNumber(String seatNumber) {
        this.seatNumber = seatNumber;
    }


    // Getter and Setter for ticketPrice
    public double getTicketPrice() {
        return ticketPrice;
    }

    public void setTicketPrice(double ticketPrice) {
        this.ticketPrice = ticketPrice;
    }
}