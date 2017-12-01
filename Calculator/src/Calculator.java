import java.util.*;

public class Calculator {


    public static void main(String args[]) {

        //Scanner userInput = new Scanner(System.in);

        //String usershit = userInput.nextLine();

        String usershit = " 2-1*2";
        swag(usershit);
    }


    public static void swag(String userInput) {


        Stack<Character> outStackChar =  new Stack<Character>();
        Queue<Character> outQueueInt = new LinkedList<Character>();

        for (int i = 0; i < userInput.length(); i++) {


            char ch = userInput.charAt(i);

            if (ch >= '0' && ch <= '9') {
                outQueueInt.add(ch);
                System.out.println("INTEGER ADDED");

            }

            else if (ch == ' ') {
                continue;
            }

            else if ( ch == '+' || ch == '-' || ch == '*' || ch == '/') {
                if (outStackChar.empty() == true) {
                    outStackChar.push(ch);
                    System.out.println("OPERATOR ADDED");

                } else {

                    if (precedenceLevel(outStackChar.peek()) >= precedenceLevel(ch)) {

                        while (!outStackChar.empty()) {
                            outQueueInt.add(outStackChar.pop());
                        }
                        outStackChar.push(ch);

                    } else {
                        outStackChar.push(ch);
                    }
                }
            }

            else if (ch == '('){
                outStackChar.pop();
                continue;
            }
            else if (ch== ')' ){
                while( !outStackChar.empty()&& !(outStackChar.peek() == '(')) {
                    outQueueInt.add(outStackChar.pop());
                }

            }



        }

        while (!outStackChar.empty()) {
            outQueueInt.add(outStackChar.pop());
        }

        String testArray = outQueueInt.toString();
        String s = "";
        System.out.println(outQueueInt.toString());
    }


    public static int precedenceLevel (char test)
    {

        if(test == '+' || test == '-')
        {
            return 0;
        }

        else if(test == '*' || test == '/'){

            return 1;
        }

        else if (test == '^') {
            return 2;
        }
            return 0;
    }
}