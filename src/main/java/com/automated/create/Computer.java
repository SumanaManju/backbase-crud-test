package com.automated.create;

import java.time.LocalDate;

public class Computer {

    private String id;
    private String name;
    private LocalDate introduced;
    private LocalDate discontinued;
    private int company;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDate getIntroduced() {
        return introduced;
    }

    public void setIntroduced(LocalDate introduced) {
        this.introduced = introduced;
    }

    public LocalDate getDiscontinued() {
        return discontinued;
    }

    public void setDiscontinued(LocalDate discontinued) {
        this.discontinued = discontinued;
    }

    public int getCompany() {
        return company;
    }

    public void setCompany(int company) {
        this.company = company;
    }

//    /**
//     * Prints this object in the application/x-www-form-urlencoded format
//     * @return
//     */
//    @Override
//    public String toString() {
//        return "name=" + name  +
//                "&introduced=" + introduced +
//                "&discontinued=" + discontinued +
//                "&company=" + company ;
//    }

}
