package HomeWork1.online;

public class Course {
    public int  runLength = 200;
    public int swimLength = 100;
    public int jumpHeight = 2;

    public void decreaseRun (int maxRun) {
        runLength -= maxRun;
    }
    public void decreaseSwim (int maxSwim) {
        swimLength -= maxSwim;
    }
    public void decreaseJump (int maxJump) {
        jumpHeight -= maxJump;
    }

}
