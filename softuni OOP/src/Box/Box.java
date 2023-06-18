package Box;
public class Box {
    private double length;
    private double width;
    private double height;

    public Box(double length, double width, double height) {
        setLength(length);
        setWidth(width);
        setHeight(height);
    }

    public void setWidth(double width) {
        this.width = width;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    public void setLength(double length) {
        this.length = length;
    }

    private double getLength() {

        if (length<=0){
            throw new IllegalArgumentException("Length cannot be zero or negative.");
        }
        return length;
    }

    public double getWidth() {
        if (width<=0){
            throw new IllegalArgumentException("Width cannot be zero or negative.");
        }
        return width;
    }

    public double getHeight() {
        if (height<=0){
            throw new IllegalArgumentException("Height cannot be zero or negative.");
        }
        return height;
    }

    public double calculateSurfaceArea (){
        return 2* length*width+ 2* length*height+2*width*length;
    }
    public double calculateLateralSurfaceArea (){
        return 2*length*height+2*width*height;
    }
    public double calculateVolume (){
        return width*height*length;
    }
}
