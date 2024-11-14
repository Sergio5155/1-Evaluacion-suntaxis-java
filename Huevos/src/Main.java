import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner leer = new Scanner(System.in);

        short h, c;
        float t;

        h = leer.nextShort();
        c = leer.nextShort();

        while(h != 0 && c != 0){
            t = (float) h / c;

            if(t > (short)h/c){
                t = t + 1;
            }

            System.out.println((short)t * 10);

            h = leer.nextShort();
            c = leer.nextShort();
        }
    }
}