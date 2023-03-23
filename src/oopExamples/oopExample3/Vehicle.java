package oopExamples.oopExample3;

public class Vehicle {
    private String maker;
    private String model;
    private int age;
    private int weigh;

    public Vehicle(String maker, String model, int age, int weigh) {
        this.maker = maker;
        this.model = model;
        this.age = age;
        this.weigh = weigh;
    }

    public String getMaker() {
        return maker;
    }

    public void setMaker(String maker) {
        this.maker = maker;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getWeigh() {
        return weigh;
    }

    public void setWeigh(int weigh) {
        this.weigh = weigh;
    }

    @Override
    public String toString() {
        return "Vehicle{" +
                "maker='" + maker + '\'' +
                ", model='" + model + '\'' +
                ", age=" + age +
                ", weigh=" + weigh +
                '}';
    }
}
