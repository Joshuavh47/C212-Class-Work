import java.util.*;
public class LargeTriangles {
    public static ArrayList<MyTriangle> findTriangles(ArrayList<MyTriangle> arr, double thresh){
        //establishes a new ArrayList containing the MyTriangle objects that will be outputted
        ArrayList<MyTriangle> output = new ArrayList<MyTriangle>();
        //loops through each MyTriangle in the ArrayList and checks if their area is greater than the threshold value.
        //If the area is greater, it will add the MyTriangle object to the output ArrayList
        for (MyTriangle a:arr){
            if (a.calcArea()>thresh){
                output.add(a);
            }
        }
        return output;
    }

    public static void main(String[] args) {

        ArrayList<MyTriangle> triangles = new ArrayList<>();
        MyTriangle tri1=new MyTriangle(1, 6);
        MyTriangle tri2=new MyTriangle(2, 9);
        MyTriangle tri3=new MyTriangle(10, 10);
        MyTriangle tri4=new MyTriangle(6, 9);
        MyTriangle tri5=new MyTriangle(4, 7);
        MyTriangle tri6=new MyTriangle(8, 11);
        MyTriangle tri7=new MyTriangle(9, 4);
        MyTriangle tri8=new MyTriangle(3, 8);
        MyTriangle tri9=new MyTriangle(3, 7);
        MyTriangle tri10=new MyTriangle(6, 7);
        triangles.add(tri1);
        triangles.add(tri2);
        triangles.add(tri3);
        triangles.add(tri4);
        triangles.add(tri5);
        triangles.add(tri6);
        triangles.add(tri7);
        triangles.add(tri8);
        triangles.add(tri9);
        triangles.add(tri10);
        for (MyTriangle tri:findTriangles(triangles,10)){
            System.out.println(tri.toString());
        }
        System.out.println();
        for (MyTriangle tri:findTriangles(triangles,15)){
            System.out.println(tri.toString());
        }
        System.out.println();
        for (MyTriangle tri:findTriangles(triangles,45)){
            System.out.println(tri.toString());
        }





    }
}
