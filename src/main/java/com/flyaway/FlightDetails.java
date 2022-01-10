package com.flyaway;

import java.sql.Time;

public class FlightDetails {

	private double price;
	private String airline;
	private String flight_no;
	private Time departure_time;
	private Time duration;
	private int available_seat;
	public FlightDetails() {
		
	}
	public FlightDetails(double price, String airline, String flight_no,Time departure_time, Time duration, int available_seat) {
		this.price = price;
		this.airline = airline;
		this.flight_no = flight_no;
		this.departure_time = departure_time;
		this.duration = duration;
		this.available_seat = available_seat;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public String getAirline() {
		return airline;
	}
	public void setAirline(String airline) {
		this.airline = airline;
	}
	public String getFlight_no() {
		return flight_no;
	}
	public void setFlight_no(String flight_no) {
		this.flight_no = flight_no;
	}
	public Time getDeparture_time() {
		return departure_time;
	}
	public void setDeparture_time(Time departure_time) {
		this.departure_time = departure_time;
	}
	public Time getDuration() {
		return duration;
	}
	public void setDuration(Time duration) {
		this.duration = duration;
	}
	public int getAvailable_seat() {
		return available_seat;
	}
	public void setAvailable_seat(int available_seat) {
		this.available_seat = available_seat;
	}
	@Override
	public String toString() {
		return "FlightDetails [price=" + price + ", airline=" + airline + ", flight_no=" + flight_no
				+", departure_time="+ departure_time + ", duration=" + duration + "]";
	}
}
