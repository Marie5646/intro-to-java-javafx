package com.example.modulefive.finalproject;

public class User {
    private String firstName;
    private String lastName;
    private String email;
    private String password;
    private boolean isClaimsManager;

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getEmail() {
        return email;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPassword() {
        return password;
    }

    public boolean isClaimsManager() {
        return isClaimsManager;
    }

    public void setClaimsManager(boolean isClaimsManager) {
        this.isClaimsManager = isClaimsManager;
    }
    public static void main(String[] args) {
        User user = new User();
        user.setFirstName("John");
        user.setLastName("Doe");
        user.setEmail("john.doe@gmail.com");
        user.setPassword("mypassword");
        user.setClaimsManager(true);

        System.out.println("User");
        System.out.println("First Name - " + user.getFirstName());
        System.out.println("Last Name - " + user.getLastName());
        System.out.println("Email - " + user.getEmail());
        System.out.println("Is Claims Manager - " + user.isClaimsManager());
    }

}
