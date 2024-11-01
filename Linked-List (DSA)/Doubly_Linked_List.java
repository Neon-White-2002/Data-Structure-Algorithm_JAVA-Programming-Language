/* DOUBLY-LINKED-LIST (JAVA) */

import java.util.*;

/* CLASS-NODE */
class Doubly_Linked_List_NODE {
    int data;
    Doubly_Linked_List_NODE next_pointer;
    Doubly_Linked_List_NODE previous_pointer;

    /* GENERATE, NEW-NODE :
    *  >>> CONSTRUCTOR:
    * */
    public Doubly_Linked_List_NODE(int value) {
        /* NODE-DATA : */
        this.data = value;
        /* NODE-NEXT (POINTER) : */
        this.next_pointer = null;
        /* NODE-PREVIOUS (POINTER) : */
        this.previous_pointer = null;
    }
}

public class Doubly_Linked_List {
    /* DOUBLY-LINKED-LIST (PARAMETER'S) : */
    private Doubly_Linked_List_NODE head;
    private Doubly_Linked_List_NODE tail;
    private int length;

    /* >>> DOUBLY-LINKED-LIST (OPERATION'S) :
    * => ADD-NODE
    * => DELETE-NODE
    * => UPDATE-NODE
    * => INSERT-NODE
    * => SEARCH-NODE
    * => REVERSE-LINKED-LIST
    * => DISPLAY-LINKED-LIST
    * */

    // APPEND-NODE :
    public void append_node(int value) {
        /* GENERATE NEW-NODE : */
        Doubly_Linked_List_NODE add_doublyLinkedListNODE = new Doubly_Linked_List_NODE(value);

        /* CHECK, WEATHER LINKED-LIST (EMPTY OR NOT) : */
        if (length == 0 || head == null) {
            head = add_doublyLinkedListNODE;
            tail = add_doublyLinkedListNODE;
        }
        else {
            /* HERE, WE WILL
            * => FIRST-STEP : ON (TAIL.NEXT => POINTER) ADD-NEW-NODE
            * => SECOND-STEP : NOW, ON (NEW-NODE.PREVIOUS => POINTER) ADD, TAIL-NODE
            * => LAST-STEP : UPDATE, (TAIL-NODE) TO NEW-ADDED-NODE
            *  */
            tail.next_pointer = add_doublyLinkedListNODE;
            add_doublyLinkedListNODE.previous_pointer = tail;
            tail = add_doublyLinkedListNODE;
        }
        /* INCREMENT-LENGTH : */
        length++;
        System.out.println("\n\t>>> ----- YA, NODE (ADDED) - SUCCESSFULLY ! -----");
    }

    // DELETE-NODE :
    public void delete_node(int value) {
        /* TEMPORARY-NODE (CURRENT-NODE) : */
        Doubly_Linked_List_NODE current_doublyLinkedListNODE = head;
        /* TEMPORARY-NODE (PREVIOUS-NODE) : */
        Doubly_Linked_List_NODE previous_doublyLinkedListNODE = head;
        /* STORE, DELETED-NODE : */
        Doubly_Linked_List_NODE deleted_doublyLinkedListNODE = null;
        /* STORE, RESULT : */
        String result = null;

        /* CHECK, WEATHER HEAD-NODE (DATA) == VALUE : */
        if (head.data == value) {
            // STORE, DELETED-NODE, TO DISPLAY :
            deleted_doublyLinkedListNODE = head;

            // DELETE & UPDATE => HEAD-NODE :
            head = head.next_pointer;

            /* CHECK, WEATHER HEAD-NODE IS, NULL OR NOT : */
            if (head != null) {
                head.previous_pointer = null;
            }
            // DECREMENT-LENGTH :
            length--;

            /* HERE, WE WILL CHECK WEATHER LINKED-LIST (LENGTH) => ZERO (0) OR NOT :
            *  IF, 'YES' THEN => SET HEAD & TAIL (NODE) => NULL : */
            if (length == 0) {
                head = null;
                tail = null;
            }
            /* UPDATE, RESULT : */
            deleted_doublyLinkedListNODE.next_pointer = null;
            deleted_doublyLinkedListNODE.previous_pointer = null;
            result = ">>> ----- YA, HEAD-NODE (DELETED) - SUCCESSFULLY ! ----- \n\n" +
                    "\t>>> DELETED-NODE : " + deleted_doublyLinkedListNODE.data + "\n" +
                    "\t>>> DELETED-NODE (NEXT-POINTER) : " + deleted_doublyLinkedListNODE.next_pointer + "\n" +
                    "\t>>> DELETED-NODE (PREVIOUS-POINTER) : " + deleted_doublyLinkedListNODE.previous_pointer
            ;
        }
        /* CHECK, WEATHER TAIL-NODE (DATA) == VALUE : */
        else if (tail.data == value) {
            // STORE, DELETED-NODE, TO DISPLAY :
            deleted_doublyLinkedListNODE = tail;

            // DELETE & UPDATE => TAIL-NODE :
            tail = tail.previous_pointer;
            tail.next_pointer = null;
            // DECREMENT-LENGTH :
            length--;

            /* HERE, WE WILL CHECK WEATHER LINKED-LIST (LENGTH) => ZERO (0) OR NOT :
             *  IF, 'YES' THEN => SET TAIL (NODE) => NULL : */
            if (length == 0) {
                tail = null;
            }
            /* UPDATE, RESULT : */
            deleted_doublyLinkedListNODE.next_pointer = null;
            deleted_doublyLinkedListNODE.previous_pointer = null;
            result = ">>> ----- YA, TAIL-NODE (DELETED) - SUCCESSFULLY ! ----- \n\n" +
                    "\t>>> DELETED-NODE : " + deleted_doublyLinkedListNODE.data + "\n" +
                    "\t>>> DELETED-NODE (NEXT-POINTER) : " + deleted_doublyLinkedListNODE.next_pointer + "\n" +
                    "\t>>> DELETED-NODE (PREVIOUS-POINTER) : " + deleted_doublyLinkedListNODE.previous_pointer
            ;
        }
        /* DELETE-NODE, IN BETWEEN : */
        else {
            for (int i = 0; i < length; i++) {
                if (current_doublyLinkedListNODE.data == value) {
                    /* SO, NOW WE WILL DELETE-NODE, IN BETWEEN LINKED-LIST
                       => FIRST-STEP,
                       WE WILL, UPDATE PREVIOUS-NODE (NEXT-POINTER) ==> CURRENT-NODE (NEXT-POINTER)
                       => SECOND-STEP,
                       WE WILL, UPDATE CURRENT-NODE.NEXT-POINTER (PREVIOUS-POINTER) ==> PREVIOUS-NODE,
                    */
                    previous_doublyLinkedListNODE.next_pointer = current_doublyLinkedListNODE.next_pointer;
                    current_doublyLinkedListNODE.next_pointer.previous_pointer = previous_doublyLinkedListNODE;

                    /* HERE, WILL SET DELETED-NODE (NEXT & PREVIOUS)-POINTER ==> NULL : */
                    current_doublyLinkedListNODE.next_pointer = null;
                    current_doublyLinkedListNODE.previous_pointer = null;

                    /* UPDATE, RESULT : */
                    result = ">>> ----- YA, NODE (DELETED) - SUCCESSFULLY ! ----- \n\n" +
                             "\t>>> DELETED-NODE : " + current_doublyLinkedListNODE.data + "\n" +
                             "\t>>> DELETED-NODE (NEXT-POINTER) : " + current_doublyLinkedListNODE.next_pointer + "\n" +
                             "\t>>> DELETED-NODE (PREVIOUS-POINTER) : " + current_doublyLinkedListNODE.previous_pointer
                    ;
                    // DECREMENT-LENGTH :
                    length--;
                    // STOP, FOR-LOOP :
                    break;
                }
                else {
                    /* UPDATE, RESULT : */
                    result = ">>> ----- SORRY, NODE WAS 'NOT-FOUND', IT CAN'T BE DELETED ! -----";
                }
                // UPDATE, PREVIOUS FROM 'CURRENT-NODE' :
                previous_doublyLinkedListNODE = current_doublyLinkedListNODE;
                // INCREMENT : NEXT-NODE (POINTER) :
                current_doublyLinkedListNODE = current_doublyLinkedListNODE.next_pointer;
            }
        }
        System.out.println("\n\t" + result);
    }

    // UPDATE-NODE :
    public void update_node(int old_value, int new_value) {
        /* TEMPORARY-NODE : */
        Doubly_Linked_List_NODE current_doublyLinkedListNODE = head;
        /* STORE, RESULT : */
        String result = null;

        /* CHECK, WEATHER HEAD-NODE (DATA) == OLD-DATA : */
        if (head.data == old_value) {
            /* UPDATE, HEAD-NODE (DATA) => NEW-DATA : */
            head.data = new_value;
            result = ">>> ----- YA, HEAD-NODE (UPDATED) - SUCCESSFULLY ! -----";
        }
        /* CHECK, WEATHER TAIL-NODE (DATA) == OLD-DATA : */
        else if (tail.data == old_value) {
            /* UPDATE, TAIL-NODE (DATA) => NEW-DATA : */
            tail.data = new_value;
            result = ">>> ----- YA, TAIL-NODE (UPDATED) - SUCCESSFULLY ! -----";
        }
        else {
            for (int i = 0; i < length; i++) {
                /* CHECK, WEATHER CURRENT-NODE (DATA) == OLD-VALUE : */
                if (current_doublyLinkedListNODE.data == old_value) {
                    /* UPDATE, CURRENT-NODE (DATA) => NEW-VALUE : */
                    current_doublyLinkedListNODE.data = new_value;
                    /* RESULT =>, NODE (UPDATED) : */
                    result = ">>> ----- YA, NODE (UPDATED) - SUCCESSFULLY ! -----";
                    break;
                }
                else {
                    /* RESULT =>, NODE (NOT-UPDATED) : */
                    result = ">>> ----- SORRY, CAN'T UPDATE 'NODE' ! -----";
                }
                /* INCREMENT, NODE-NEXT (POINTER) : */
                current_doublyLinkedListNODE = current_doublyLinkedListNODE.next_pointer;
            }
        }
        /* DISPLAY, RESULT : */
        System.out.println("\n\t" + result);
    }

    // INSERT-NODE :
    public void insert_node(int index, int value) {
        /* TEMPORARY-NODE (CURRENT-NODE) : */
        Doubly_Linked_List_NODE current_doublyLinkedListNODE = head;
        /* TEMPORARY-NODE (PREVIOUS-NODE) : */
        Doubly_Linked_List_NODE previous_doublyLinkedListNODE = head;
        /* STORE, RESULT : */
        String result = null;

        /* CHECK, WEATHER (INDEX) ARE OUT OF BOND OR NOT : */
        if (index < 0 || index >= length) {
            result = ">>> ----- OOPS, SEEMS LIKE 'INDEX', IS OUT OF BOUND - TRY AGAIN ! -----";
        }
        // PRE-PEND NODE :
        else if (index == 0) {
            /* INSERT-NODE AT, HEAD-POSITION : */

            // GENERATE, NEW-NODE :
            Doubly_Linked_List_NODE prepend_doublyLinkedListNODE = new Doubly_Linked_List_NODE(value);
            /* HERE,
               WE WILL, PASS (HEAD-NODE => NEXT.POINTER) TO 'NEW-NODE',

               THEN,
               WE WILL, UPDATE (HEAD-NODE => PREVIOUS.POINTER) TO 'NEW-NODE',

               THEN,
               UPDATE, HEAD-NODE (POINTER) TO 'NEW-NODE';
            */
            prepend_doublyLinkedListNODE.next_pointer = head;
            head.previous_pointer = previous_doublyLinkedListNODE;
            head = prepend_doublyLinkedListNODE;
            // INCREMENT-LENGTH :
            length++;
            // UPDATE-RESULT :
            result = ">>> ----- YA, NODE (INSERTED) AT HEAD (POSITION) - SUCCESSFULLY ! -----";
        }
        // ADD-NODE :
        else if (index == length - 1) {
            /* INSERT-NODE AT, TAIL-POSITION : */

            // GENERATE, NEW-NODE :
            Doubly_Linked_List_NODE add_doublyLinkedListNODE = new Doubly_Linked_List_NODE(value);
            /* HERE,
               WE WILL, PASS (TAIL-NODE => NEXT.POINTER) TO 'NEW-NODE',

               THEN,
               WE WILL, SET (NEW-NODE => PREVIOUS.POINTER) TO 'TAIL-NODE',

               THEN,
               UPDATE, TAIL-NODE (POINTER) TO 'NEW-NODE';
            */
            tail.next_pointer = add_doublyLinkedListNODE;
            add_doublyLinkedListNODE.previous_pointer = tail;
            tail = add_doublyLinkedListNODE;
            // INCREMENT-LENGTH :
            length++;
            // UPDATE-RESULT :
            result = ">>> ----- YA, NODE (INSERTED) AT TAIL (POSITION) - SUCCESSFULLY ! -----";
        }
        else {
            /* INSERT-NODE, IN BETWEEN : */

            // GENERATE, NEW-NODE :
            Doubly_Linked_List_NODE insert_new_doublyLinkedListNODE = new Doubly_Linked_List_NODE(value);

            /* HERE, WE WILL ITERATE TO, (INDEX-NODE) : */
            for (int i = 0; i < index; i++) {
                /* STORE, PREVIOUS-NODE, FROM CURRENT-NODE : */
                previous_doublyLinkedListNODE = current_doublyLinkedListNODE;
                /* INCREMENT : NEXT-NODE (POINTER) : */
                current_doublyLinkedListNODE = current_doublyLinkedListNODE.next_pointer;
            }
            /* => NOW,
                  HERE, WE WILL UPDATE (PREVIOUS-NODE) => NEXT.POINTER TO 'NEW-NODE'
               => THEN,
                  WE WILL, SET (NEW-NODE) => PREVIOUS.POINTER TO 'PREVIOUS-NODE'

               => THEN,
                  SET (NEW-NODE) => NEXT.POINTER TO 'CURRENT-NODE'
               => AT LAST,
                  UPDATE CURRENT-NODE => PREVIOUS.POINTER TO 'NEW-NODE'
            */
            previous_doublyLinkedListNODE.next_pointer = insert_new_doublyLinkedListNODE;
            insert_new_doublyLinkedListNODE.previous_pointer = previous_doublyLinkedListNODE;

            insert_new_doublyLinkedListNODE.next_pointer = current_doublyLinkedListNODE;
            current_doublyLinkedListNODE.previous_pointer = insert_new_doublyLinkedListNODE;
            // INCREMENT-LENGTH :
            length++;
            // UPDATE-RESULT :
            result = ">>> ----- YA, NODE (INSERTED) - SUCCESSFULLY ! -----";
        }
        /* DISPLAY, RESULT : */
        System.out.println("\n\t" + result);
    }

    // SEARCH-NODE :
    public void search_node(int value) {
        /* TEMPORARY-NODE : */
        Doubly_Linked_List_NODE current_doublyLinkedListNODE = head;
        /* STORE, RESULT : */
        String result = null;
        /* COUNTER : */
        int count = 0;

        /* CHECK, WEATHER HEAD-NODE (DATA) == VALUE : */
        if (head.data == value) {
            result = ">>> NODE FOUND AT : 'OTH' POSITION IN, DOUBLY-LINKED-LIST";
        }
        /* CHECK, WEATHER TAIL-NODE (DATA) == VALUE : */
        else if (tail.data == value) {
            result = ">>> NODE FOUND AT : " + "'" + length + "TH" + "'" + " POSITION IN, DOUBLY-LINKED-LIST";
        }
        else {
            for (int i = 0; i < length; i++) {
                /* CHECK, HERE NODE-DATA (VALUE) == VALUE : */
                if (current_doublyLinkedListNODE.data == value) {
                    /* NODE-FOUND : */
                    result = ">>> NODE FOUND AT : " + "'" + (count + 1) + "TH" + "'" + " POSITION IN, DOUBLY-LINKED-LIST";
                    break;
                }
                else {
                    /* NODE, NOT-FOUND : */
                    result = ">>> ----- SORRY, NODE 'NOT-FOUND' ! -----";
                }
                /* INCREMENT, NODE-NEXT (POINTER) : */
                current_doublyLinkedListNODE = current_doublyLinkedListNODE.next_pointer;
                /* COUNTER-INCREMENT : */
                count++;
            }
        }
        /* DISPLAY, RESULT : */
        System.out.println("\n\t" + result);
    }

    // REVERSE-LINKED-LIST :
    public void reverse_node() {
        /* CHECK, WEATHER HEAD-NODE ==> 'EMPTY' OR 'NOT' : */
        if (length == 0 || head == null) {
            System.out.println("\n\t>>> ----- SORRY, DOUBLY-LINKED-LIST IS : 'EMPTY' ! -----");
        }
        else {
            /* TEMPORARY-NODE (CURRENT-NODE) : */
            Doubly_Linked_List_NODE current_doublyLinkedListNODE = head;
            /* TEMPORARY-NODE (PREVIOUS-NODE) : */
            Doubly_Linked_List_NODE previous_doublyLinkedListNODE = null;

            for (int i = 0; i < length; i++) {
                // SET, PREV-NODE TO, CURRENT-NODE (PREVIOUS-POINTER) :
                previous_doublyLinkedListNODE = current_doublyLinkedListNODE.previous_pointer;
                // SET, CURRENT-NODE (PREVIOUS-POINTER) TO, CURRENT-NODE (NEXT-POINTER) :
                current_doublyLinkedListNODE.previous_pointer = current_doublyLinkedListNODE.next_pointer;
                // SET, CURRENT-NODE (NEXT-POINTER) TO, PREVIOUS-NODE :
                current_doublyLinkedListNODE.next_pointer = previous_doublyLinkedListNODE;
                // NODE-INCREMENT : UPDATE, TO NEW-NODE :
                current_doublyLinkedListNODE = current_doublyLinkedListNODE.previous_pointer;
            }

            /* SWAP : HEAD & TAIL (NODE) : */
            current_doublyLinkedListNODE = head; // HERE, WE WILL SET CURRENT-NODE TO, 'HEAD-NODE' -> POINTER;
            head = tail; // HERE, WE WILL SET 'HEAD-NODE' TO, 'TAIL-NODE' -> POINTER;
            tail = current_doublyLinkedListNODE; // HERE, WE WILL SET 'TAIL-NODE' TO, 'CURRENT-NODE' -> POINTER;

            /* DISPLAY, RESULT : */
            System.out.println("\n\t>>> ----- YA, DOUBLY-LINKED-LIST IS, 'REVERSE' - SUCCESSFULLY ! -----");
        }
    }

    // DISPLAY-LINKED-LIST :
    public void print_linked_list() {
        /* TEMPORARY-NODE : */
        Doubly_Linked_List_NODE temp_doublyLinkedListNODE = head;

        /* CHECK, WEATHER HEAD-NODE ==> NULL OR NOT : */
        if (length == 0 || head == null) {
            System.out.println("\n\t>>> SORRY, DOUBLY-LINKED-LIST IS 'EMPTY' !");
        }
        else {
            System.out.print("\n\t>>> DOUBLY-LINKED-LIST : ");

            while (temp_doublyLinkedListNODE != null) {
                System.out.print(temp_doublyLinkedListNODE.data + " <--> ");
                /* INCREMENT : NEXT-NODE (POINTER) */
                temp_doublyLinkedListNODE = temp_doublyLinkedListNODE.next_pointer;
            }
        }

        if (head == null || length == 0) {
            /* HEAD-NODE : */
            System.out.println("\n\t>>> HEAD-NODE : " + head);
            /* TAIL-NODE : */
            System.out.println("\t>>> TAIL-NODE : " + tail);
            /* LENGTH-LINKED-LIST : */
            System.out.println("\t>>> LENGTH : " + length);
        }
        else {
            /* HEAD-NODE : */
            System.out.println("\n\n\t>>> HEAD-NODE : " + head.data);
            /* TAIL-NODE : */
            System.out.println("\t>>> TAIL-NODE : " + tail.data);
            /* LENGTH-LINKED-LIST : */
            System.out.println("\t>>> LENGTH : " + length);
        }
    }

    /* >>> CONSTRUCTOR : */
    public Doubly_Linked_List() {
        /* >>> SCANNER => USER-INPUT : */
        Scanner scan = new Scanner(System.in);

        /* INFINITY-LOOP */
        while (true) {
            System.out.println("\n\t----- DOUBLY-LINKED-LIST (MENU) -----\n");
            System.out.println("\t>>> PRESS (1) : ADD-NODE");
            System.out.println("\t>>> PRESS (2) : DELETE-NODE");
            System.out.println("\t>>> PRESS (3) : UPDATE-NODE");
            System.out.println("\t>>> PRESS (4) : INSERT-NODE");
            System.out.println("\t>>> PRESS (5) : SEARCH-NODE");
            System.out.println("\t>>> PRESS (6) : REVERSE-LINKED-LIST");
            System.out.println("\t>>> PRESS (7) : DISPLAY-LINKED-LIST");

            System.out.print("\n\t>>> ENTER, YOUR CHOICE : ");
            String choice = scan.next();

            try {
                int user_choice = Integer.parseInt(choice);

                // ADD-NODE :
                if (user_choice == 1) {
                    System.out.print("\n\t>>> ENTER, DATA U WANT TO ADD : ");
                    String data = scan.next();

                    try {
                        int value = Integer.parseInt(data);
                        append_node(value);
                    }
                    catch (NumberFormatException e) {
                        System.out.println("\n\t>>> ----- SORRY, WRONG DATA OR VALUE, TRY AGAIN ! -----");
                    }
                }
                // DELETE-NODE :
                else if (user_choice == 2) {
                    /* CHECK, WEATHER HEAD-NODE => NULL OR NOT : */
                    if (length == 0 || head == null) {
                        System.out.println("\n\t>>> ----- SORRY, DOUBLY-LINKED-LIST IS 'EMPTY' ! -----");
                    }
                    else {
                        /* DISPLAY-DOUBLY-LINKED-LIST : */
                        print_linked_list();

                        System.out.print("\n\t>>> ENTER, DATA U WANT TO DELETE : ");
                        String data = scan.next();

                        try {
                            int value = Integer.parseInt(data);
                            delete_node(value);
                        }
                        catch (NumberFormatException e) {
                            System.out.println("\n\t>>> ----- SORRY, WRONG DATA OR VALUE, TRY AGAIN ! -----");
                        }
                    }
                }
                // UPDATE-NODE :
                else if (user_choice == 3) {
                    /* CHECK, WEATHER HEAD-NODE => NULL OR NOT : */
                    if (length == 0 || head == null) {
                        System.out.println("\n\t>>> ----- SORRY, DOUBLY-LINKED-LIST IS 'EMPTY' ! -----");
                    }
                    else {
                        /* DISPLAY-DOUBLY-LINKED-LIST : */
                        print_linked_list();

                        System.out.print("\n\t>>> ENTER, OLD-DATA : ");
                        String old_data = scan.next();

                        System.out.print("\n\t>>> ENTER, NEW-DATA : ");
                        String new_data = scan.next();

                        try {
                            int old_value = Integer.parseInt(old_data);
                            int new_value = Integer.parseInt(new_data);
                            update_node(old_value, new_value);
                        }
                        catch (NumberFormatException e) {
                            System.out.println("\n\t>>> ----- SORRY, WRONG DATA OR VALUE, TRY AGAIN ! -----");
                        }
                    }
                }
                // INSERT-NODE :
                else if (user_choice == 4) {
                    /* CHECK, WEATHER HEAD-NODE => NULL OR NOT : */
                    if (length == 0 || head == null) {
                        System.out.print("\n\t>>> ENTER, DATA U WANT TO ADD : ");
                        String data = scan.next();

                        try {
                            int value = Integer.parseInt(data);
                            append_node(value);
                        }
                        catch (NumberFormatException e) {
                            System.out.println("\n\t>>> ----- SORRY, WRONG DATA OR VALUE, TRY AGAIN ! -----");
                        }
                    }
                    else {
                        /* DISPLAY-DOUBLY-LINKED-LIST : */
                        print_linked_list();

                        System.out.print("\n\t>>> ENTER, INDEX : ");
                        String index = scan.next();

                        System.out.print("\n\t>>> ENTER, DATA U WANT TO INSERT : ");
                        String data = scan.next();

                        try {
                            int node_index = Integer.parseInt(index);
                            int node_value = Integer.parseInt(data);
                            insert_node(node_index, node_value);
                        }
                        catch (NumberFormatException e) {
                            System.out.println("\n\t>>> ----- SORRY, WRONG DATA OR VALUE, TRY AGAIN ! -----");
                        }
                    }
                }
                // SEARCH-NODE :
                else if (user_choice == 5) {
                    /* CHECK, WEATHER HEAD-NODE => NULL OR NOT : */
                    if (length == 0 || head == null) {
                        System.out.println("\n\t>>> ----- SORRY, DOUBLY-LINKED-LIST IS 'EMPTY' ! -----");
                    }
                    else {
                        /* DISPLAY-DOUBLY-LINKED-LIST : */
                        print_linked_list();

                        System.out.print("\n\t>>> ENTER, DATA U WANT TO SEARCH : ");
                        String data = scan.next();

                        try {
                            int value = Integer.parseInt(data);
                            search_node(value);
                        }
                        catch (NumberFormatException e) {
                            System.out.println("\n\t>>> ----- SORRY, WRONG DATA OR VALUE, TRY AGAIN ! -----");
                        }
                    }
                }
                // REVERSE-NODE :
                else if (user_choice == 6) {
                    /* REVERSE-DOUBLY-LINKED-LIST : */
                    reverse_node();
                }
                // DISPLAY-LINKED-LIST :
                else if (user_choice == 7) {
                    /* DOUBLY-LINKED-LIST : */
                    print_linked_list();
                }
                else {
                    // WRONG, OPTION :
                    System.out.println("\n\t----- SORRY, IN-VALID CHOICE, TRY AGAIN ! -----");
                }
            }
            catch (NumberFormatException e) {
                // INVALID, DATA :
                System.out.println("\n\t----- OOPS ! SOME-THING WENT WRONG, TRY AGAIN...! -----");
            }
        }
    }
}
