package vn.duong.itech.service.dto.sale;

import jakarta.persistence.Column;
import java.math.BigDecimal;
import java.time.LocalDateTime;

public class SaleRequest {

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

    public SaleRequest() {}

    public SaleRequest(
        int id,
        String name,
        double discount,
        String typeDiscount,
        String typeSale,
        LocalDateTime startDate,
        LocalDateTime endDate,
        Integer topUser,
        BigDecimal minimumPrice,
        String note,
        boolean status
    ) {
        this.id = id;
        this.name = name;
        this.discount = discount;
        this.typeDiscount = typeDiscount;
        this.typeSale = typeSale;
        this.startDate = startDate;
        this.endDate = endDate;
        this.topUser = topUser;
        this.minimumPrice = minimumPrice;
        this.note = note;
        this.status = status;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getDiscount() {
        return discount;
    }

    public void setDiscount(double discount) {
        this.discount = discount;
    }

    public String getTypeDiscount() {
        return typeDiscount;
    }

    public void setTypeDiscount(String typeDiscount) {
        this.typeDiscount = typeDiscount;
    }

    public String getTypeSale() {
        return typeSale;
    }

    public void setTypeSale(String typeSale) {
        this.typeSale = typeSale;
    }

    public LocalDateTime getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDateTime startDate) {
        this.startDate = startDate;
    }

    public LocalDateTime getEndDate() {
        return endDate;
    }

    public void setEndDate(LocalDateTime endDate) {
        this.endDate = endDate;
    }

    public Integer getTopUser() {
        return topUser;
    }

    public void setTopUser(Integer topUser) {
        this.topUser = topUser;
    }

    public BigDecimal getMinimumPrice() {
        return minimumPrice;
    }

    public void setMinimumPrice(BigDecimal minimumPrice) {
        this.minimumPrice = minimumPrice;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }
}
