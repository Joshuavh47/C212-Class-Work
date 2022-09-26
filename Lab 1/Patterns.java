public class Patterns {
    public static void main(String[] args){
        char[] stars = new char[10];
        for(int i = 0; i<10;i++){
            stars[i] = ' ' ;
        }
        //for loop iterates through 10 rows, adding a star to the character array after each itteration
        for(int i = 0; i<10;i++){
            stars[i] = '*';
            for(int j = 0; j<stars.length; j++){
                System.out.print(stars[j]);
            }
            System.out.println();
        }
        System.out.println();
        //clears the char array of all spaces
        for(int i = 0;i<stars.length;i++){
            stars[i] = '*';
        }
        //This second for loop does the same as the first one, but instead of adding '*' we add ' '
        for(int i = 0; i<10;i++){
            for(int j = 0; j<stars.length; j++){
                System.out.print(stars[j]);
            }
            stars[i] = ' ';
            System.out.println();
        }
        System.out.println();
        //clears the array
        for(int i = 0;i<stars.length;i++){
            stars[i] = '*';
        }
        //same as the first for loop, except the counter went from highest index to lowest and replaced each with a space
        for(int i = 0; i<10;i++){
            for(int j = 0; j<stars.length; j++){
                System.out.print(stars[j]);
            }
            stars[stars.length-i-1] = ' ';
            System.out.println();
        }
        //clears the array
        for(int i = 0;i<stars.length;i++){
            stars[i] = ' ';
        }
        //Does the same thing as other for loops, except it adds the stars to the end, counting down the indexes with each itteration then printing the char array
        for(int i = 0;i<10;i++){
            stars[stars.length-i-1] = '*';
            System.out.println();
            for(int j = 0;j<stars.length;j++){
                System.out.print(stars[j]);
            }
        }
    } }