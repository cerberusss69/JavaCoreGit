package onlineHomeWork3;

import Fruits.Apple;
import Fruits.Box;
import Fruits.Orange;

import java.util.ArrayList;
import java.util.Arrays;

public class Main {

    public static void main(String[] args) {
        String[] arr = {"1", "2"};
        changeArrayElements(arr, 0, 1);
        System.out.println(Arrays.toString(arr));

        Box<Apple> appleBox = new Box<>(makeNewApples(10));
        Box<Orange> orangeBox = new Box<>(makeNewOranges(10));
        Box<Orange> secondOrangeBox = new Box<>(makeNewOranges(0));

        appleBox.compare(orangeBox);
        appleBox.compare(secondOrangeBox);
        orangeBox.transferTo(secondOrangeBox);
        appleBox.compare(orangeBox);
        appleBox.compare(secondOrangeBox);
    }

    public static ArrayList<Apple> makeNewApples(int count) {
        ArrayList<Apple> fruits = new ArrayList<>();
        for (int i = 0; i < count; i++) {
            fruits.add(new Apple());
        }
        return fruits;
    }

    public static ArrayList<Orange> makeNewOranges(int count) {
        ArrayList<Orange> fruits = new ArrayList<>();
        for (int i = 0; i < count; i++) {
            fruits.add(new Orange());
        }
        return fruits;
    }


    public static <T>void changeArrayElements(T[] array, int firstIndex, int secondIndex) {
        if (firstIndex < 0 || array.length <= firstIndex || secondIndex < 0 || array.length <= secondIndex || array.length < 2) {
            System.out.println("Некорректные индексы");
            return;
        }


        try {
            T arrayElement = array[firstIndex];
            array[firstIndex] = array[secondIndex];
            array[secondIndex] = arrayElement;
        } catch (ArrayIndexOutOfBoundsException ex) {
            System.out.println("Некорректные индексы");
        }
    }
}

