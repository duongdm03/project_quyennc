package vn.duong.itech.service.dto.sale;

import jakarta.persistence.Column;
import java.math.BigDecimal;
import java.time.LocalDateTime;

public class SaleRespone {

    private int id;
    private String name;
    private double discount;
    private String typeDiscount;
    private String typeSale;
    private LocalDateTime startDate;
    private LocalDateTime endDate;
    private Integer topUser;
    private BigDecimal minimumPrice;
    private String note;
    private boolean status;

    public SaleRespone() {}

    public SaleRespone(
        int id,
        boolean status,
        String note,
        BigDecimal minimumPrice,
        Integer topUser,
        LocalDateTime endDate,
        LocalDateTime startDate,
        String typeSale,
        String typeDiscount,
        double discount,
        String name
    ) {
        this.id = id;
        this.status = status;
        this.note = note;
        this.minimumPrice = minimumPrice;
        this.topUser = topUser;
        this.endDate = endDate;
        this.startDate = startDate;
        this.typeSale = typeSale;
        this.typeDiscount = typeDiscount;
        this.discount = discount;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public LocalDateTime getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDateTime startDate) {
        this.startDate = startDate;
    }

    public BigDecimal getMinimumPrice() {
        return minimumPrice;
    }

    public void setMinimumPrice(BigDecimal minimumPrice) {
        this.minimumPrice = minimumPrice;
    }

    public Integer getTopUser() {
        return topUser;
    }

    public void setTopUser(Integer topUser) {
        this.topUser = topUser;
    }

    public LocalDateTime getEndDate() {
        return endDate;
    }

    public void setEndDate(LocalDateTime endDate) {
        this.endDate = endDate;
    }

    public String getTypeSale() {
        return typeSale;
    }

    public void setTypeSale(String typeSale) {
        this.typeSale = typeSale;
    }

    public String getTypeDiscount() {
        return typeDiscount;
    }

    public void setTypeDiscount(String typeDiscount) {
        this.typeDiscount = typeDiscount;
    }

    public double getDiscount() {
        return discount;
    }

    public void setDiscount(double discount) {
        this.discount = discount;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
