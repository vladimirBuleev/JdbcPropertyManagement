package DAO.flat;

public class Flat {
    private Integer id;
    private String city;
    private String street;
    private String houseNum;
    private String floor;
    private String apNum;
    private Double apArea;
    private Double rentPrice;
    private String status;

    public Flat(Integer id, String city, String street, String houseNum, String floor, String apNum, Double apArea, Double rentPrice, String status) {
        this.id = id;
        this.city = city;
        this.street = street;
        this.houseNum = houseNum;
        this.floor = floor;
        this.apNum = apNum;
        this.apArea = apArea;
        this.rentPrice = rentPrice;
        this.status = status;
    }

    public Flat(String city, String street, String houseNum, String floor, String apNum, Double apArea, Double rentPrice, String status) {
        this.city = city;
        this.street = street;
        this.houseNum = houseNum;
        this.floor = floor;
        this.apNum = apNum;
        this.apArea = apArea;
        this.rentPrice = rentPrice;
        this.status = status;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getHouseNum() {
        return houseNum;
    }

    public void setHouseNum(String houseNum) {
        this.houseNum = houseNum;
    }

    public String getFloor() {
        return floor;
    }

    public void setFloor(String floor) {
        this.floor = floor;
    }

    public String getApNum() {
        return apNum;
    }

    public void setApNum(String apNum) {
        this.apNum = apNum;
    }

    public Double getApArea() {
        return apArea;
    }

    public void setApArea(Double apArea) {
        this.apArea = apArea;
    }

    public Double getRentPrice() {
        return rentPrice;
    }

    public void setRentPrice(Double rentPrice) {
        this.rentPrice = rentPrice;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "Flat{" +
                "id=" + id +
                ", city='" + city + '\'' +
                ", street='" + street + '\'' +
                ", houseNum='" + houseNum + '\'' +
                ", floor='" + floor + '\'' +
                ", apNum='" + apNum + '\'' +
                ", apArea=" + apArea +
                ", rentPrice=" + rentPrice +
                ", status='" + status + '\'' +
                '}';
    }
}
