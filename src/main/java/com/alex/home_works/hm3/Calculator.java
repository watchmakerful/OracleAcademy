package com.alex.home_works.hm3;

import java.util.Scanner;

/**
 * Created by root on 30.06.2016.
 */
public class Calculator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = "";
        String[] op = new String[3];
        int result = 0;
        int index = 0;
        boolean flag = true;
        System.out.println("Enter an expression");
        while (scanner.hasNext()) {
            input = scanner.next();
            if (input.equals("exit") || input.equals("x")) break;
            switch (index) {
                case 0:
                case 1:
                case 2:
                    op[index] = input;
                    index++;
                    break;
                default:


                    if (input.equals("=")) {


                        switch (op[1]) {
                            case ("+"):
                                result = Integer.parseInt(op[0]) + Integer.parseInt(op[2]);
                                break;
                            case ("-"):
                                result = Integer.parseInt(op[0]) - Integer.parseInt(op[2]);
                                break;
                            case ("*"):
                                result = Integer.parseInt(op[0]) * Integer.parseInt(op[2]);
                                break;
                            case ("/"):
                                try {
                                    result = Integer.parseInt(op[0]) / Integer.parseInt(op[2]);
                                } catch (java.lang.ArithmeticException e) {
                                    System.out.println("WTF, division by zero???");
                                    flag = false;
                                }
                                break;
                            default:
                                System.out.println("Wrong operator");
                                flag = false;

                        }
                        index = 0;
                        if (flag) System.out.println(result);
                        flag = true;
                        System.out.println("Enter an expression");
                    } else continue;

            }

        }
    }
}
