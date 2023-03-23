package oopExamples.oopExample8;

public class Animal {
    private String name;
    private int age;
    private String sound;

    public Animal(String name, int age, String sound) {
        this.name = name;
        this.age = age;
        this.sound = sound;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public String getSound() {
        return sound;
    }

    public void makeSound() {
        System.out.println(this.sound);
    }

    public void getInfo() {
        System.out.println(this.name + " " + this.age + " " + this.sound);
    }

    public Cat createCat(String name, int age, String sound, int lives) {
        return new Cat(name, age, sound, lives);

    }


    private class Cat {
        private int lives;

        public Cat(String name, int age, String sound, int lives) {
            Animal.this.name = name;
            Animal.this.age = age;
            Animal.this.sound = sound;
            this.lives = lives;
        }

        public int getLives() {
            return lives;
        }

        public Cat createCat(String name, int age, String sound, int lives) {
            return new Cat(name, age, sound, lives);

        }
    }
}
