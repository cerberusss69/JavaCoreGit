package onlineHomeWork2;

public class MyArrayDataException extends Exception{
    private int width;
    private int height;

    public MyArrayDataException (int width, int height) {
        this.width = width;
        this.height = height;
    }
    @Override
    public String getMessage(){
        return "некорректные данные : x = " + width + " y = " + height;
    }
}
