package HomeWork1.online;

public abstract class Team {

    protected String name;
    protected int age;
    protected String color;



    public Team(String name, int age, String color) {
        this.name = name;
        this.age = age;
        this.color = color;

    }

    public abstract void run();

    public abstract void jump();

    public abstract void swim();

    String getName() {
        return this.name;
    }

    int getMaxRun() {
        return this.maxRun;
    } private int maxRun;
    private int maxSwim;
    private int maxJump;

    int getMaxSwim() {
        return this.maxSwim;
    }
    int getMaxJump() {
        return this.maxJump;
    }

    protected boolean run(int distance) {
        return (distance <= maxRun);
    }

    protected boolean swim(int distance) {
        return (distance <= maxSwim);
    }

    protected boolean jump(int distance) {
        return (distance <= maxJump);
    }
}

