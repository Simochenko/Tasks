package task1;

public class Main {
    public static void main(String[] args) {

        NumberOfBraces calc = new NumberOfBraces();

        int numValidBracesSequences = calc.calculateCountBraces();

        System.out.println("Number of valid braces sequences = " + numValidBracesSequences);
    }
}
