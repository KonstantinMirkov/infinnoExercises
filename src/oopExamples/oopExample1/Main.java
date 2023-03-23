package oopExamples.oopExample1;

import oopExamples.oopExample1.Company;
import oopExamples.oopExample1.CompanyET;

public class Main {


    public static void main(String[] args) {
        Company company = new Company();
        company.setName("Java2023");
        company.setId("1234567890");
        company.setDateOfCreation("12.12.1997");

        CompanyET et = new CompanyET();
        et.setName(company.getName());
        et.setId(company.getId());
        et.setDateOfCreation(company.getDateOfCreation());
        et.setCompanyOwner("John Nick");
        et.setFirstCapital(500);
        et.setActualCapital(25000.00);

        System.out.println(et.profit());
    }
}
