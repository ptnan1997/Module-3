package Session8.Bai3;

public class Rectangle implements Colorable{
    private int length;
    private int width;
    private String  color;
    public Rectangle(int length, int width) {
        this.length = length;
        this.width = width;
    }
    @Override
    public void setColor(String color) {
        this.color = color;
    }
    // Phuong thuc getter

    public int getLength() {
        return length;
    }

    public int getWidth() {
        return width;
    }

    public String getColor() {
        return color;
    }

}
