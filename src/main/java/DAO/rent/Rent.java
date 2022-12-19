package DAO.rent;


import java.sql.Date;

public class Rent {
    private Integer id;
    private Integer clientId;
    private Integer flatId;
    private Date startDate;
    private Date endDate;
    private Date paymentDate;
    private Double sum;

    public Rent(Integer id, Integer clientId, Integer flatId, Date startDate, Date endDate, Date paymentDate, Double sum) {
        this.id = id;
        this.clientId = clientId;
        this.flatId = flatId;
        this.startDate = startDate;
        this.endDate = endDate;
        this.paymentDate = paymentDate;
        this.sum = sum;
    }

    public Rent(Integer clientId, Integer flatId, Date startDate, Date endDate, Date paymentDate, Double sum) {
        this.clientId = clientId;
        this.flatId = flatId;
        this.startDate = startDate;
        this.endDate = endDate;
        this.paymentDate = paymentDate;
        this.sum = sum;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getClientId() {
        return clientId;
    }

    public void setClientId(Integer clientId) {
        this.clientId = clientId;
    }

    public Integer getFlatId() {
        return flatId;
    }

    public void setFlatId(Integer flatId) {
        this.flatId = flatId;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public Date getPaymentDate() {
        return paymentDate;
    }

    public void setPaymentDate(Date paymentDate) {
        this.paymentDate = paymentDate;
    }

    public Double getSum() {
        return sum;
    }

    public void setSum(Double sum) {
        this.sum = sum;
    }

    @Override
    public String toString() {
        return "Rent{" +
                "id=" + id +
                ", clientId=" + clientId +
                ", flatId=" + flatId +
                ", startDate=" + startDate +
                ", endDate=" + endDate +
                ", paymentDate=" + paymentDate +
                ", sum=" + sum +
                '}';
    }
}
