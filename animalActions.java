// Bekbol Shiribaiev

public class animalActions {
    // Main test driver
    public static void main(String[] args) {
        Animal [] animals = new Animal[4];

        animals[0] = new Dog("Sunny");
        animals[1] = new Cat("Johny");
        animals[2] = new Cow("Maya");
        animals[3] = new Sheep("Kochkor");

        for (int i = 0; i < 4; i++){
            animals[i].makeSound();
            
            if (animals[i] instanceof Pet) {
                Pet pet = (Pet) animals[i];
                pet.play();
                System.out.println();
            }

            if (animals[i] instanceof DairyAnimal) {
                DairyAnimal dairyAnimal = (DairyAnimal) animals[i];  
                dairyAnimal.milk();
                System.out.println();
            }
        }
    }


    // Abstract animal class
    static abstract class Animal {
        protected String name;

        abstract void makeSound();

        // Constructor
        public Animal(String name) {
            this.name = name;
        }

        // Getter
        String getName(){
            return name;
        }
    }

    @FunctionalInterface
    interface Pet {
        void play();
    }

    @FunctionalInterface
    interface DairyAnimal {
        void milk();
    }

    static class Dog extends Animal implements Pet{
        private Pet dogBehavior;
        public Dog(String name) {
            super(name);
            this.dogBehavior = () -> System.out.println(name + " fetches the ball!");
        }

        @Override
        void makeSound() {
            System.out.println(name + " says: Woof!");
        }

        @Override
        public void play() {
            dogBehavior.play();
        }
    }

    static class Cat extends Animal implements Pet{
        private Pet catBehavior;
        public Cat(String name) {
            super(name);
            this.catBehavior = () -> System.out.println(name + " chases a toy mouse!");
        }

        @Override
        void makeSound() {
            System.out.println(name + " says: Myau!");
        }

        @Override
        public void play() {
            catBehavior.play();
        }
    }

    static class Cow extends Animal implements DairyAnimal{
        public Cow(String name) {
            super(name);
        }

        @Override
        void makeSound() {
            System.out.println(name + " says: Moo!");
        }

        @Override
        public void milk() {
            System.out.println(name + " is being milked!");
        }
    }

    static class Sheep extends Animal implements DairyAnimal {
        public Sheep(String name){
            super(name);
        }

        @Override
        void makeSound() {
            System.out.println(name + " says: Baa!");
        }

        @Override
        public void milk() {
            System.out.println(name + " is giving milk!");
        }
    }
}