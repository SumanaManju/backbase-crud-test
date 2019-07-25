package com.automated;

import com.automated.create.Computer;
import com.automated.create.CreateComputer;
import com.automated.delete.DeleteComputer;
import com.automated.read.ReadComputer;
import com.automated.update.UpdateComputer;

import java.io.IOException;
import java.time.LocalDate;

public class Main {

    public static void main(String... args) {

        CreateComputer createComputer = new CreateComputer();
        ReadComputer readComputer = new ReadComputer();
        DeleteComputer deleteComputer = new DeleteComputer();
        UpdateComputer updateComputer = new UpdateComputer();
        try {
            // create a computer, then verify if it's there
            Computer computer = mockComputer();
            createComputer.createComputer(computer);
            readComputer.readComputer(computer);

            // change some values on the computer, verify if they changed
            updateComputer.updateComputer(computer);
            readComputer.readComputer(computer);

            // Delete the computer afterwards and verify that the computer is not there
            deleteComputer.deleteComputer(computer);
            readComputer.readComputer(computer);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static Computer mockComputer() {
        Computer computer = new Computer();
        computer.setCompany(1);
        computer.setDiscontinued(LocalDate.of(1991,10, 23));
        computer.setIntroduced(LocalDate.of(2001,10, 23));
        computer.setName("Macintosh128K");
        return computer;
    }

    
}
