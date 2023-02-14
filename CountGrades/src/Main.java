
import java.util.Random;

public class Main {

    static void input (String[] x){
        String grades = "ABCDF";
        Random r = new Random();

        for(int i=0;i<x.length;i++){
            char c = grades.charAt(r.nextInt(grades.length()));
            x[i]= String.valueOf(c);
    }
    }

    static void output(String[] x){
        System.out.println("Grades for the test:");
        for(int i=0;i<x.length;i++){
            System.out.print(x[i] + " ");
        }
        System.out.println();
    }

    static void count(String[] x){
        int countA = 0;
        int countB = 0;
        int countC = 0;
        int countD = 0;
        int countF = 0;

        for (String s : x) {
            if (s.equals("A")) {
                countA++;
            }
            if (s.equals("B")) {
                countB++;
            }
            if (s.equals("C")) {
                countC++;
            }
            if (s.equals("D")) {
                countD++;
            }
            if (s.equals("F")) {
                countF++;
            }
        }

        System.out.println(countA + " Students received A");
        System.out.println(countB + " Students received B");
        System.out.println(countC + " Students received C");
        System.out.println(countD + " Students received D");
        System.out.println(countF + " Students received F");

    }
    public static void main(String[] args) {

        String[] studentsGrades = new String[15];
        input(studentsGrades);
        output(studentsGrades);
        count(studentsGrades);
    }
}