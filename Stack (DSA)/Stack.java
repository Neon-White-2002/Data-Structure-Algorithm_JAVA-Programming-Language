/* STACK (DATA-STRUCTURE & ALGORITHM) */

import java.util.*; // JAVA-PACKAGE (SCANNER)

/* CLASS-NODE */
class Node {
    int data;
    Node next;

    /* NODE-CLASS (CONSTRUCTOR) */
    public Node(int value) {
        // NODE-DATA :
        this.data = value;
        // NODE (NEXT-POINTER) :
        this.next = null;
    }
}

/* CLASS-STACK */
public class Stack {
    /* STACK (PARAMETER'S) */
    private Node top;
    private Node bottom;

    /* STACK (HEIGHT & LENGTH) */
    private int height = 0;
    private int length = 0;

    /* # STACK (METHOD'S)
    *  => PUSH
    *  => POP
    *  => DISPLAY, STACK
    * */

    /* APPEND-NODE (PUSH-METHOD) */
    public void push_node(int value) {
        /* GENERATE, NEW-NODE */
        Node add_node = new Node(value);

        /* CHECK, WEATHER 'STACK-HEIGHT', IS EQUAL TO 'STACK-LENGTH' */
        if (height == length) {
            System.out.println("\n\t>>> ----- OOPS ! SEEMS LIKE 'STACK', IS FULL -----");
            System.out.println("\t>>> LENGTH : " + length);
        }
        else if (height == 0) {
            /* ADD-NEW-NODE */
            top = add_node;
            bottom = add_node;
            /* INCREMENT-HEIGHT */
            height++;

            /*  DISPLAY, RESULT */
            System.out.println("\n\t>>> ----- YA, 'NEW-NODE' (PUSH) - SUCCESSFULLY ! -----");
        }
        else {
            /* PREPEND-NODE */
            add_node.next = top;
            top = add_node;
            /* INCREMENT-HEIGHT */
            height++;

            /*  DISPLAY, RESULT */
            System.out.println("\n\t>>> ----- YA, 'NEW-NODE' (PUSH) - SUCCESSFULLY ! -----");
        }
    }

    /* REMOVE-NODE (POP-METHOD) */
    public void pop_node() {
        /* CHECK, WEATHER 'STACK (HEIGHT)', IS EMPTY OR NOT */
        if (height == 0) {
            System.out.println("\n\t>>> ----- OOPS ! SEEMS LIKE 'STACK', IS 'EMPTY' -----");

            System.out.println("\t>>> TOP : -1");
            System.out.println("\t>>> BOTTOM : -1");
            System.out.println("\t>>> HEIGHT : 0");
        }
        else {
            /* TEMPORARY-NODE */
            Node temp = top;
            /* SET, 'TOP-POINTER', TO 'TOP-NEXT-POINTER' */
            top = top.next;
            /* UPDATE, 'TEMP-NODE (NEXT)', TO 'NULL' */
            temp.next = null;
            /* DECREMENT-LENGTH */
            height--;

            /* DISPLAY, RESULT */
            System.out.println("\n\t>>> YA, 'NODE' (POP) - SUCCESSFULLY ! -----");
            System.out.println("\t>>> DELETED-NODE : " + temp.data);
            System.out.println("\t>>> DELETED-NODE (NEXT) : " + temp.next);

            /* NOW, CHECK WEATHER 'STACK-LENGTH', IS 'ZERO' OR NOT */
            if (height == 0) {
                /* SET, 'TOP & BOTTOM', TO 'NULL' */
                top = null;
                bottom = null;
            }
        }
    }

    /* DISPLAY, 'STACK (DSA)' */
    public void display_stack() {
        /*CHECK, WEATHER 'STACK', IS 'EMPTY' OR NOT  */
        if (height == 0) {
            System.out.println("\n\t>>> OOPS ! SEEMS LIKE 'STACK', IS 'EMPTY' ----- \n");

            System.out.println("\t>>> TOP : " + top);
            System.out.println("\t>>> BOTTOM : " + bottom);
            System.out.println("\t>>> HEIGHT : " + height);
        }
        else {
            /* TEMPORARY-NODE */
            Node current_node = top;

            System.out.print("\n\t>>> STACK : ");
            for (int i = 0; i < height; i++) {
                System.out.print(current_node.data + " --> ");
                /* NEXT-POINTER (INCREMENT) */
                current_node = current_node.next;
            }
            System.out.print("NULL" + "\n\n");

            System.out.println("\t>>> TOP : " + top.data);
            System.out.println("\t>>> BOTTOM : " + bottom.data);
            System.out.println("\t>>> HEIGHT : " + height);
        }
    }

    /* STACK-CLASS (CONSTRUCTOR) : */
    public Stack() {
        /* JAVA-PACKAGE (SCANNER) */
        Scanner scan = new Scanner(System.in);

        /* STACK-HEIGHT */
        System.out.print("\n\t>>> ENTER, 'LENGTH (HEIGHT), OF STACK : ");
        String len = scan.next();

        if (len.isEmpty()) {
            System.out.println("\n\t>>> ----- OOPS ! SEEMS LIKE, U DIDN'T PROVIDE YOUR 'LENGTH', TRY AGAIN ! -----");
        }
        else {
            try {
                /* CONVERT, DATA-TYPE (INTEGER) */
                length = Integer.parseInt(len);
            }
            catch (NumberFormatException e) {
                System.out.println("\n\t>>> ----- OOPS ! SEEMS LIKE 'WRONG-DATA', TRY AGAIN ! -----");
            }
        }

        /* STACK (MENU) */
        while (true) {
            /* INFINITY-LOOP */
            System.out.println("\n\t----- WELCOME TO, 'STACK (DSA)' - MENU -----\n");
            System.out.println("\t>>> PRESS (1) : APPEND-NODE (PUSH)");
            System.out.println("\t>>> PRESS (2) : REMOVE-NODE (POP)");
            System.out.println("\t>>> PRESS (3) : DISPLAY, 'STACK-STRUCTURE'");

            System.out.print("\n\t>>> ENTER, YOUR CHOICE : ");
            String choice = scan.next();

            if (choice.isEmpty()) {
                System.out.println("\n\t>>> ----- OOPS ! SEEMS LIKE, U DIDN'T PROVIDE YOUR 'CHOICE', TRY AGAIN ! -----");
            }
            else {
                try {
                    int option = Integer.parseInt(choice);

                    if (option == 1) {
                        /* PUSH-METHOD */
                        System.out.print("\n\t>>> ENTER, 'DATA' U WANT TO 'PUSH' : ");
                        String data = scan.next();

                        if (data.isEmpty()) {
                            System.out.println("\n\t>>> ----- OOPS ! SEEMS LIKE, U DIDN'T PROVIDE YOUR 'DATA', TRY AGAIN ! -----");
                        }
                        else {
                            try {
                                /* CONVERT, DATA-TYPE (INTEGER) */
                                int value = Integer.parseInt(data);
                                /* PUSH-METHOD */
                                push_node(value);
                            }

                            catch (NumberFormatException e) {
                                System.out.println("\n\t>>> ----- OOPS ! SEEMS LIKE 'WRONG-DATA', TRY AGAIN ! -----");
                            }
                        }
                    }
                    else if (option == 2) {
                        /* POP-METHOD */
                        pop_node();
                    }
                    else if (option == 3) {
                        /* DISPLAY, STACK */
                        display_stack();
                    }
                    else {
                        System.out.println("\n\t>>> ----- OOPS ! 'WRONG-CHOICE', TRY AGAIN ! -----");
                    }
                }

                catch (NumberFormatException e) {
                    System.out.println("\n\t>>> ----- OOPS ! SEEMS LIKE 'WRONG-CHOICE', TRY AGAIN ! -----");
                }
            }
        }
    }
}
