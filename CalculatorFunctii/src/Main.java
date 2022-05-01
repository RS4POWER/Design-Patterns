import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;
import java.lang.Math;

public class Main {

    public static void main(String[] args) {
        ArrayList<Ecuatie> ecuatii = new ArrayList<Ecuatie>();
        Scanner scan = new Scanner(System.in);
        System.out.println("Pentru ecuatie de gradul 1 selectati 1. Pentru ecuatie de gradul 2 selectati 2. Selectati 3 pentru afisare");
        int cerinta = scan.nextInt();
        int optiune=0;
        while (cerinta != 3) {
            double a=0,b=0,c=0,egal=0;

            if (cerinta == 2) {
                optiune=2;
                System.out.println("ax^2+bx+c=0");
                System.out.print("a:");
               a = scan.nextDouble();
                if (a == 0) {
                    System.out.println("a trebuie sa fie diferit de 0");
                    return;
                }
                System.out.print("b:");
                 b = scan.nextDouble();
                System.out.print("c:");
                c = scan.nextDouble();
                System.out.print(a + "x^2 + " + b + "x + " + c + " = ");
                 egal = scan.nextDouble();

            } else {
                optiune=1;
                System.out.println("ax+b=0");
                System.out.print("a:");
                a = scan.nextDouble();
                System.out.print("b:");
                 b = scan.nextDouble();
                System.out.print(a + "x + " + b + " = ");
                egal = scan.nextDouble();
            }
            Ecuatie e = new Ecuatie();
            e.optiune=optiune;
            e.a=a;
            e.b=b;
            e.c=c;
            e.egal=egal;
            ecuatii.add(e);
            System.out.println("Pentru ecuatie de gradul 1 selectati 1. Pentru ecuatie de gradul 2 selectati 2. Selectati 3 pentru iesire");
            cerinta = scan.nextInt();

        }
        int k=0;
        Iterator<Ecuatie> it = ecuatii.iterator();
        while(it.hasNext()) {
            k++;
            System.out.print("Ecuatia: " + k + " ");
            Ecuatie i = it.next();
            System.out.println("de gradul: " + i.optiune +" ");
            if(i.optiune == 1)
            {

                double x = (-i.b + i.egal) / i.a;
                System.out.println("x= " + x);

            }
            else
            {
                double x1 = 0;
                double x2 = 0;
                double delta = i.b * i.b - 4 * i.a * (i.c - i.egal);
                if (delta > 0) {
                    x1 = (-i.b + Math.sqrt(delta)) / 2 * i.a;
                    x2 = (-i.b - Math.sqrt(delta)) / 2 * i.a;
                    System.out.println(x1);
                    System.out.println(x2);

                } else if (delta == 0) {
                    x1 = -i.b / (2 * i.a);
                    System.out.println(x1);
                } else
                    System.out.println("Nu exista x in multimea numerelor Reale");
            }
        }
    }
}
