package Lab4;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        addGate();
    }

    private static Gate addGate() {
        Scanner sc = new Scanner(System.in);
        int type, input, noInputs;
        Gate gate;

        System.out.println("What kind of gate do you want to add?");
        System.out.println("\t1. NOT");
        System.out.println("\t2. AND");
        System.out.println("\t3. OR");
        System.out.println("\t4. XOR");
        type = sc.nextInt();
        switch (type) {
            case 1:
                gate = new Not();
                break;
            case 2:
                gate = new And();
                break;
            case 3:
                gate = new Or();
                break;
            case 4:
                gate = new Xor();
                break;
            default:
                addGate();
                break;
        }

        System.out.println("How many inputs do you want to use?");
        noInputs = sc.nextInt();

        for (int i = 0; i < noInputs; i++) {
            System.out.println("What inputs do you want to use?");
            System.out.println("\t1. True");
            System.out.println("\t2. False");
            System.out.println("\t3. Another gate's output");
            System.out.println("\t4. Done.");
            input = sc.nextInt();
/*
            switch (input) {
                case 1:
                    gate.setInput(true, i);
                    i++;
                    break;
                case 2:
                    gate.setInput(false, i);
                    i++;
                    break;
                case 3:
                    //TODO
                default:
                    break;
            }
        }
        return gate;*/
        }
        return null;
    }
}