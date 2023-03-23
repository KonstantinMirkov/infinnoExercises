package oopExamples.oopExample1;

import oopExamples.oopExample1.Company;

public class CompanyET extends Company {
    private String companyOwner;
    private double firstCapital;
    private double actualCapital;

    public String getCompanyOwner() {
        return this.companyOwner;
    }

    public void setCompanyOwner(String companyOwner) {
        this.companyOwner = companyOwner;
    }

    public double getFirstCapital() {
        return this.firstCapital;
    }

    public void setFirstCapital(double firstCapital) {
        this.firstCapital = firstCapital;
    }

    public double getActualCapital() {
        return this.actualCapital;
    }

    public void setActualCapital(double actualCapital) {
        this.actualCapital = actualCapital;
    }

    public double profit(){
        return actualCapital - firstCapital;

    }
}
