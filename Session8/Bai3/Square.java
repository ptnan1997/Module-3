package Session8.Bai3;

import java.awt.*;

public class Square implements Colorable {
    private int length;
    private int width;
    private String color;
    public Square(int length,int width) {
        this.length = length;
        this.width = width;
    }
    @Override
    public void setColor (String color) {
        this.color = color;
    }
    // Phương thức getter

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
