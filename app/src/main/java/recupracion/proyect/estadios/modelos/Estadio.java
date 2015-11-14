package recupracion.proyect.estadios.modelos;

import java.util.ArrayList;

public class Estadio {
    private String zip;
    private String phone;
    private String ticket_link;
    private String state;
    private int pcode;
    private String city;
    private int id;
    private String tollfreephone;
    private ArrayList<Schedule> schedule;
    private String address;
    private String image_url;
    private String description;
    private String name;
    private String longitude;
    private String latitude;

    public Estadio(String zip, String phone, String ticket_link, String state, int pcode, String city, int id, String tollfreephone, ArrayList<Schedule> schedule, String address, String image_url, String description, String name, String longitude, String latitude) {
        this.zip = zip;
        this.phone = phone;
        this.ticket_link = ticket_link;
        this.state = state;
        this.pcode = pcode;
        this.city = city;
        this.id = id;
        this.tollfreephone = tollfreephone;
        this.schedule = schedule;
        this.address = address;
        this.image_url = image_url;
        this.description = description;
        this.name = name;
        this.longitude = longitude;
        this.latitude = latitude;
    }

    public String getZip() {
        return zip;
    }

    public void setZip(String zip) {
        this.zip = zip;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getTicket_link() {
        return ticket_link;
    }

    public void setTicket_link(String ticket_link) {
        this.ticket_link = ticket_link;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public int getPcode() {
        return pcode;
    }

    public void setPcode(int pcode) {
        this.pcode = pcode;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTollfreephone() {
        return tollfreephone;
    }

    public void setTollfreephone(String tollfreephone) {
        this.tollfreephone = tollfreephone;
    }

    public ArrayList<Schedule> getSchedule() {
        return schedule;
    }

    public void setSchedule(ArrayList<Schedule> schedule) {
        this.schedule = schedule;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getImage_url() {
        return image_url;
    }

    public void setImage_url(String image_url) {
        this.image_url = image_url;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLongitude() {
        return longitude;
    }

    public void setLongitude(String longitude) {
        this.longitude = longitude;
    }

    public String getLatitude() {
        return latitude;
    }

    public void setLatitude(String latitude) {
        this.latitude = latitude;
    }

}
