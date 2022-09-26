public class MyTriangle {
    //private variables for each instance of MyTriangle
    private double base;
    private double height;
    //sets the private variables equal to the variables passed through arguments
    public MyTriangle(double base, double height){
        this.base=base;
        this.height=height;
    }

    //returns the base value
    public double getBase(){
        return base;
    }

    //returns the height value
    public double getHeight() {
        return height;
    }

    //returns the area
    public double calcArea(){
        return .5*base*height;
    }

    //returns a string of the height and area
    public String toString(){
        return "Height: "+height+" Base: "+base;
    }
}
