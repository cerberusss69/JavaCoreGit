package HomeWork1.online;

public class Leo extends Team {
    public int maxRun = 300;
    public int maxSwim = 200;
    public int maxJump = 3;
    public Leo(String name, int age, String color) {
        super(name, age, color);
    }
    public void run (Course course) {
        course.decreaseRun(200);
        System.out.println(name + " бегает");
    }
    public void swim (Course course) {
        course.decreaseSwim(100);
        System.out.println(name + " плавает");
    }
    public void jump (Course course) {
        course.decreaseJump ( 2);
        System.out.println(name + " прыгает");
    }
    @Override
    public void run() {

    }

    @Override
    public void jump() {

    }

    @Override
    public void swim() {

    }
}

