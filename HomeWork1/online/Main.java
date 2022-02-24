package HomeWork1.online;

public class Main {

    public static void main(String[] args) {
        String tempWinEvent = " это получилось";
        String tempLossEvent = " это не получилось";
        String eventName;
        String eventResult;

        Leo leo = new Leo("Leonardo", 20, "синий");
        Raf raf = new Raf("Raphael", 20, "красный");
        Donny donny = new Donny("Danatello", 20, "фиолетовый");
        Mike mike = new Mike("Michelangelo", 20, "оранжевый");

        leo.run();
        raf.run();
        donny.run();
        mike.run();

        leo.jump();
        raf.jump();
        donny.jump();
        mike.jump();

        leo.swim();
        raf.swim();
        donny.swim();
        mike.swim();

        Team[] teams = {leo, raf, donny, mike};
        int runLength = 200;
        int swimLength = 100;
        int jumpHeight = 2;

        for (int i = 0; i < teams.length; i++) {
            String nameString = teams[i].getName() + " может ";

            }
        }
    }

