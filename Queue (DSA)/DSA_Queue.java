/* DATA-STRUCTURE & ALGORITHM (QUEUE) */

import java.util.*;  // # JAVA-PACKAGE

/* CLASS (NODE) */
class Node {
    int data;
    Node next;

    /* CONSTRUCTOR (GENERATE-NODE) */
    public Node(int value) {
        // NODE-DATA :
        this.data = value;
        // NODE-NEXT-POINTER :
        this.next = null;
    }
}

/* CLASS (DSA-QUEUE) */
public class DSA_Queue {
    /* 'QUEUE' (PARAMETER'S) */
    private Node first;
    private Node last;
    // TRACK-LENGTH (QUEUE) :
    private int length;

    /* # DATA-STRUCTURE & ALGORITHM : (QUEUE)
       :=> APPEND-NODE (EN-QUEUE METHOD)
       :=> REMOVE-NODE (DE-QUEUE METHOD)
       :=> DISPLAY, 'QUEUE'
    */

    /* EN-QUEUE (APPEND-NODE) */
    public void enqueue_method(int value) {
        /* GENERATE, NEW-NODE */
        Node add_node = new Node(value);

        /* CHECK, WEATHER 'QUEUE', IS EMPTY */
        if (length == 0) {
            /* SET, 'FIRST & LAST (POINTER)', AS 'NEW-NODE' */
            first = add_node;
            last = add_node;
        }
        else {
            /* SET, 'LAST-POINTER', TO 'NEW-NODE' */
            last.next = add_node;
            last = add_node;
        }
        /* INCREMENT-LENGTH */
        length++;

        /* DISPLAY, RESULT */
        System.out.println("\n\t>>> YA ! 'NEW-NODE' (APPEND : EN-QUEUE) - SUCCESSFULLY...! ;)");
    }

    /* DE-QUEUE (REMOVE-NODE) */
    public void dequeue_method() {
        /* TEMPORARY-NODE */
        Node deleted_node;

        /* CHECK, WEATHER 'QUEUE', IS 'EMPTY' */
        if (length == 0) {
            System.out.println("\n\t>>> SORRY, SEEMS LIKE 'QUEUE', IS 'EMPTY', CAN'T REMOVE-NODE ! :(");
        }
        /* CHECK, WEATHER 'QUEUE', CONSIST OF 'ONE-NODE' */
        else if (length == 1) {
            /* SET, 'FIRST & LAST (POINTER), TO 'NULL' */
            first = null;
            last = null;
            /* DECREMENT-LENGTH */
            length--;

            /* DISPLAY, RESULT */
            System.out.println("\n\t>>> OK, 'QUEUE', IS 'EMPTY';) \n");
            System.out.println("\t>>> FIRST : NULL");
            System.out.println("\t>>> LAST : NULL");
            System.out.println("\t>>> LENGTH : " + length);
        }
        else {
            /* STORE, DELETED-NODE */
            deleted_node = first;
            /* SET, 'FIRST-POINTER' */
            first = first.next;
            deleted_node.next = null;
            /* DECREMENT-LENGTH */
            length--;

            /* DISPLAY, RESULT */
            System.out.println("\n\t>>> YA ! 'QUEUE' (REMOVE : DE-QUEUE & UPDATED) - SUCCESSFULLY...! ;)\n");
            System.out.println("\t>>> DELETED-NODE : " + deleted_node.data);
            System.out.println("\t>>> DELETED-NODE (NEXT-POINTER) : " + deleted_node.next);
        }
    }

    /* DISPLAY, 'DSA-QUEUE' */
    public void display_queue() {
        /* CHECK, WEATHER 'QUEUE', IS 'EMPTY' */
        if (length == 0) {
            System.out.println("\n\t>>> OOPS ! SEEMS LIKE 'QUEUE', IS ALREADY 'EMPTY' :( \n");
            System.out.println("\t>>> FIRST : " + first);
            System.out.println("\t>>> LAST : " + last);
            System.out.println("\t>>> LENGTH : " + length);
        }
        else {
            /* GENERATE, TEMPORARY-NODE */
            Node current_node = first;

            System.out.print("\n\t>>> QUEUE : ");
            for (int i = 0; i < length; i++) {
                System.out.print(current_node.data + " --> ");
                /* NEXT-NODE (INCREMENT) */
                current_node = current_node.next;
            }
            System.out.print("NULL" + "\n\n");

            /* DISPLAY, 'QUEUE-PARAMETER'S' */
            System.out.println("\t>>> FIRST : " + first.data);
            System.out.println("\t>>> LAST : " + last.data);
            System.out.println("\t>>> LENGTH : " + length);
        }
    }

    /* CONSTRUCTOR (QUEUE) */
    public DSA_Queue() {
        /* JAVA-PACKAGE (USER-INPUT) : SCANNER */
        Scanner scan = new Scanner(System.in);

        /* INFINITY-LOOP (QUEUE-MENU) */
        while (true) {
            System.out.println("\n\t----- WELCOME TO, 'QUEUE' (MENU) ----- \n");
            System.out.println("\t>>> PRESS (1) : EN-QUEUE (APPEND-NODE)");
            System.out.println("\t>>> PRESS (2) : DE-QUEUE (REMOVE-NODE");
            System.out.println("\t>>> PRESS (3) : DISPLAY, 'QUEUE'");

            System.out.print("\n\t>>> ENTER, YOUR OPTION : ");
            String option = scan.next();

            /* CHECK, WEATHER 'OPTION', IS 'EMPTY' */
            if (option.isEmpty()) {
                System.out.println("\n\t>>> OOPS ! SEEMS LIKE, U DIDN'T PROVIDE AN 'OPTION'");
            }
            else {
                try {
                    /* CONVERT, DATA-TYPE (INTEGER) */
                    int choice = Integer.parseInt(option);

                    /* QUEUE-MENU */
                    if (choice == 1) {
                        /* EN-QUEUE */
                        System.out.print("\n\t>>> ENTER, 'DATA', U WANT TO 'APPEND-NODE (EN-QUEUE)' : ");
                        String data = scan.next();

                        /* CHECK, WEATHER 'DATA', IS 'EMPTY' */
                        if (data.isEmpty()) {
                            System.out.println("\n\t>>> OOPS ! SEEMS LIKE U DIDN'T PROVIDE 'DATA' :(");
                        }
                        else {
                            try {
                                /* CONVERT, DATA-TYPE (INTEGER) */
                                int value = Integer.parseInt(data);
                                /* EN-QUEUE (METHOD) */
                                enqueue_method(value);
                            }
                            catch (NumberFormatException e) {
                                System.out.println("\n\t>>> SORRY, SEEM LIKE U DIDN'T PROVIDE AN 'VALID-DATA', TRY AGAIN ! :(");
                            }
                        }
                    }
                    else if (choice == 2) {
                        /* DISPLAY, QUEUE */
                        display_queue();
                        /* DE-QUEUE */
                        dequeue_method();
                    }
                    else if (choice == 3) {
                        /* DISPLAY, QUEUE */
                        display_queue();
                    }
                    else {
                        System.out.println("\n\t>>> SORRY, SEEMS LIKE U CHOSEN 'WRONG-OPTION', TRY AGAIN ! :(");
                    }
                }
                catch (NumberFormatException e) {
                    System.out.println("\n\t>>> SORRY, SEEM LIKE U DIDN'T PROVIDE AN 'VALID-CHOICE', TRY AGAIN ! :(");
                }
            }
        }
    }
}
