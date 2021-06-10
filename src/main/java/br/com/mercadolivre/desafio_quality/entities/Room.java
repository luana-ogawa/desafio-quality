package br.com.mercadolivre.desafio_quality.entities;

public class Room implements Comparable<Room>{

    private String room_name;
    private Double room_width;
    private Double room_length;

    public Room() {
    }

    public Room(String room_name, Double room_width, Double room_length) {
        this.room_name = room_name;
        this.room_width = room_width;
        this.room_length = room_length;
    }

    public Double calculateRoomSize() {
        return this.room_length * this.room_width;
    }

    public String getRoom_name() {
        return room_name;
    }

    public void setRoom_name(String room_name) {
        this.room_name = room_name;
    }

    public Double getRoom_width() {
        return room_width;
    }

    public void setRoom_width(Double room_width) {
        this.room_width = room_width;
    }

    public Double getRoom_length() {
        return room_length;
    }

    public void setRoom_length(Double room_length) {
        this.room_length = room_length;
    }

    @Override
    public int compareTo(Room o) {
        return calculateRoomSize().compareTo(o.calculateRoomSize());
    }
}
