package com.example.modulefive.finalproject;

import java.util.Date;

public class Claim {
    private long claimId;
    private String description;
    private String category;
    private String title;
    private Date dateSubmitted;
    private String status;
    private User assignedManager;
    private User customer;

    public long getClaimId() {
        return claimId;
    }

    public void setClaimId(long claimId) {
        this.claimId = claimId;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Date getDateSubmitted() {
        return dateSubmitted;
    }

    public void setDateSubmitted(Date dateSubmitted) {
        this.dateSubmitted = dateSubmitted;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public User getAssignedManager() {
        return assignedManager;
    }

    public void setAssignedManager(User assignedManager) {
        this.assignedManager = assignedManager;
    }

    public User getCustomer() {
        return customer;
    }

    public void setCustomer(User customer) {
        this.customer = customer;
    }

    public static void main(String[] args) {
        //Claim
        Claim claim = new Claim();
        claim.setClaimId(1);
        claim.setDescription("Claim for car accident");
        claim.setCategory("Accident");
        claim.setTitle("Car Accident Claim");
        claim.setDateSubmitted(new Date());
        claim.setStatus("Pending");

        //User to represent the assigned manager
        User manager = new User();
        manager.setFirstName("Alissa");
        manager.setLastName("Smith");
        claim.setAssignedManager(manager);

        //User to represent the customer
        User customer = new User();
        customer.setFirstName("Connie");
        customer.setLastName("Sims");
        claim.setCustomer(customer);

        //Claim details
        System.out.println("Claim");
        System.out.println("Claim ID - " + claim.getClaimId());
        System.out.println("Description - " + claim.getDescription());
        System.out.println("Category -  " + claim.getCategory());
        System.out.println("Title - " + claim.getTitle());
        System.out.println("Date Submitted - " + claim.getDateSubmitted());
        System.out.println("Status - " + claim.getStatus());
        System.out.println("Assigned Manager - " + claim.getAssignedManager().getFirstName() + " " + claim.getAssignedManager().getLastName());
        System.out.println("Customer - " + claim.getCustomer().getFirstName() + " " + claim.getCustomer().getLastName());
    }

}
