package com.henglong.application.Entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Orders {

    @Id
    @GeneratedValue
    private Integer ID;

    private String Number;
    private String Name;
    private String Business;
    private String OrderDate;
    private String MachineModel;
    private String ComputingPower;
    private String PowerSupply;
    private String QUANTITY;
    private String UnitPrice;
    private String DeliveryTime;
    private String AccountNumber;
    private String PaymentMethod;
    private String PaymentWay;
    private String HandMan;

    public void Order(){}

    public Integer getID() {
        return ID;
    }

    public void setID(Integer ID) {
        this.ID = ID;
    }

    public String getNumber() {
        return Number;
    }

    public void setNumber(String number) {
        Number = number;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getBusiness() {
        return Business;
    }

    public void setBusiness(String business) {
        Business = business;
    }

    public String getOrderDate() {
        return OrderDate;
    }

    public void setOrderDate(String orderDate) {
        OrderDate = orderDate;
    }

    public String getMachineModel() {
        return MachineModel;
    }

    public void setMachineModel(String machineModel) {
        MachineModel = machineModel;
    }

    public String getComputingPower() {
        return ComputingPower;
    }

    public void setComputingPower(String computingPower) {
        ComputingPower = computingPower;
    }

    public String getPowerSupply() {
        return PowerSupply;
    }

    public void setPowerSupply(String powerSupply) {
        PowerSupply = powerSupply;
    }

    public String getQUANTITY() {
        return QUANTITY;
    }

    public void setQUANTITY(String QUANTITY) {
        this.QUANTITY = QUANTITY;
    }

    public String getUnitPrice() {
        return UnitPrice;
    }

    public void setUnitPrice(String unitPrice) {
        UnitPrice = unitPrice;
    }

    public String getDeliveryTime() {
        return DeliveryTime;
    }

    public void setDeliveryTime(String deliveryTime) {
        DeliveryTime = deliveryTime;
    }

    public String getAccountNumber() {
        return AccountNumber;
    }

    public void setAccountNumber(String accountNumber) {
        AccountNumber = accountNumber;
    }

    public String getPaymentMethod() {
        return PaymentMethod;
    }

    public void setPaymentMethod(String paymentMethod) {
        PaymentMethod = paymentMethod;
    }

    public String getPaymentWay() {
        return PaymentWay;
    }

    public void setPaymentWay(String paymentWay) {
        PaymentWay = paymentWay;
    }

    public String getHandMan() {
        return HandMan;
    }

    public void setHandMan(String handMan) {
        HandMan = handMan;
    }
}
