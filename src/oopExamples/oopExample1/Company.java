package oopExamples.oopExample1;

public class Company {
    private String name;
    private String dateOfCreation;
    private String id;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        if (id.length() == 0) {
            this.id = id;
        }
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDateOfCreation() {
        return dateOfCreation;
    }

    public void setDateOfCreation(String dateOfCreation) {
        this.dateOfCreation = dateOfCreation;
    }

}
