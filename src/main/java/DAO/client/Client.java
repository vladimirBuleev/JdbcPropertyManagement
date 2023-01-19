package DAO.client;

public class Client {
    private Integer id;
    private String name;
    private String surname;
    private String middleName;
    private String passport;
    private String telNumber;

    public Client(String name, String surname, String middleName, String passport, String telNumber) {
        this.name = name;
        this.surname = surname;
        this.middleName = middleName;
        this.passport = passport;
        this.telNumber = telNumber;
    }

    public Client(Integer id, String name, String surname, String middleName, String passport, String telNumber) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.middleName = middleName;
        this.passport = passport;
        this.telNumber = telNumber;
    }

    public Client() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getMiddleName() {
        return middleName;
    }

    public void setMiddleName(String middleName) {
        this.middleName = middleName;
    }

    public String getPassport() {
        return passport;
    }

    public void setPassport(String passport) {
        this.passport = passport;
    }

    public String getTelNumber() {
        return telNumber;
    }

    public void setTelNumber(String telNumber) {
        this.telNumber = telNumber;
    }

    @Override
    public String toString() {
        return "data.client.Client{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", middleName='" + middleName + '\'' +
                ", passport='" + passport + '\'' +
                ", telNumber=" + telNumber +
                '}';
    }
}
