package com.automated;

import com.automated.create.Computer;
import com.automated.create.CreateComputer;

import java.io.IOException;
import java.time.LocalDate;

public class Main {

    public static void main(String... args) {

        CreateComputer createComputer = new CreateComputer();
        try {
            Computer computer = mockComputer();
            createComputer.createComputer(computer);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static Computer mockComputer() {
        Computer computer = new Computer();
        computer.setCompany(1);
        computer.setDiscontinued(LocalDate.of(1991,10, 23));
        computer.setIntroduced(LocalDate.of(2001,10, 23));
        computer.setName("Apple Mac");
        return computer;
    }

}
