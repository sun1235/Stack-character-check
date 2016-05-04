/**
 * Created by Hunter on 4/14/2016.
 */
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class stack
{
    public static void main (String [] args) throws IOException {

        Scanner input = new Scanner(System.in);
        String arr[] = new String[4];
        FileReader fr = new FileReader("C:\\Users\\Hunter\\Desktop\\stack\\src\\file.txt");
        BufferedReader br = new BufferedReader(fr);
        for (int i = 0; i < 4; i++)
        {
            arr[i] = br.readLine();
            System.out.println(arr[i]);
            System.out.println(stack(arr[i]));
        }
    }

    public static String stack (String value) {
        Stack<Character> specialCharStack = new Stack<Character>();
        String response = "Fail";
        char tempChar;
        Character[] openingBraces = {'[', '(', '{'};
        Character[] closingBraces = {']', ')', '}'};
        List<Character> openingBracesList = Arrays.asList(openingBraces);
        List<Character> closingBracesList = Arrays.asList(closingBraces);


        if (value == null) {
            return response;
        } else if (value.length() == 0) {
            response = "Pass";
        } else {

            for (int i = 0; i < value.length(); i++) {
                tempChar = value.charAt(i);

                if (openingBracesList.contains(tempChar)) {
                    specialCharStack.push(tempChar);
                } else if (closingBracesList.contains(tempChar)) {
                    if (!specialCharStack.isEmpty()) {
                        if (tempChar == ')' && '(' != specialCharStack.pop()) {
                            return response;
                        } else if (tempChar == '}' && '{' != specialCharStack.pop()) {
                            return response;
                        } else if (tempChar == ']' && '[' != specialCharStack.pop()) {
                            return response;
                        }
                    } else {
                        return response;
                    }
                } else {
                    return response;
                }
            }

        }

        if (specialCharStack.isEmpty()) {
            response = "Pass";
            return response;
        } else {
            return response;
        }
    }
}
