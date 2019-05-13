package task1;

import task1.exceptions.NegativeNumberException;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Valid braces sequence is:
 * 1) Empty sequence (if doesn't contain any brace)
 * 2) If "A" is a valid braces sequence, than "(A)" is a sequence inside braces
 * 3) If "A" and "B" is a valid braces sequences than "AB" is a a valid braces sequence too.
 * --->
 *     Some valid braces sequence is (A)B where "A" and "B" is a valid braces sequences
 *     --->
 *          Count of valid braces sequences from 2n (where n - open brackets and n - close brackets) ==  Catalan number.
 *
 * The Catalan numbers satisfy the recurrence relation:
 *  Cn = C0Cn - 1 + C1Cn - 2 + C2Cn - 3 +...+ Cn - 2C1 + Cn - 1C0.
 */
public class NumberOfBraces {

    private List<Integer> arrayList;
    private int countBraces;

    public NumberOfBraces(){
        // initialisation fields
        arrayList = new ArrayList<>();
        readNumberFromKeyboard();
    }

    /**
     * Method  calculate a count of valid braces sequences.
     * For implementation task use the Catalan's recurrence relation.
     *
     * @return count of valid braces sequences
     */
    public int calculateCountBraces() {

        // for countBraces == 0 valid braces sequence only one
        if (countBraces == 0) {
            return 1;
        } else arrayList.add(1);

        int countSequences;

        // if countBraces >= 1 use Catalan's recurrence relation
        for (int i = 1; i <= countBraces; ++i){
            countSequences = 0;
            for(int j = 0; j < i; ++j) {
                countSequences += arrayList.get(j) * arrayList.get(i-1-j);
            }
            arrayList.add(countSequences);
        }
        return arrayList.get(countBraces);
    }

    /**
     * Method reading data from keyboard.
     * User must entered only a positive integer number.
     *
     * If line from keyboard isn't integer number. User get a warning massage.
     * If line from keyboard is number, but this is a negative number. User get a warning massage.
     *
     * When user entered the correct data, method save int positive number for further use
     */
    private void readNumberFromKeyboard(){

        int enteredNumber;
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the count of braces: ");
        while (true) {
            try {
                enteredNumber = Integer.parseInt(scanner.nextLine());
                if (enteredNumber < 0) throw new NegativeNumberException();
                break;
            } catch (NumberFormatException ex){
                System.out.print("The character entered is not a number, enter a number: ");
                continue;
            } catch (NegativeNumberException ex) {
                System.out.print("The character entered is not a positive number, enter a number: ");
                continue;
            }
        }
        countBraces = enteredNumber;
    }
}
