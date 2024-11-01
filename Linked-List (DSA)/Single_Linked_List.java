/* SINGLE-LINKED-LIST (PROGRAM) - JAVA : */

import java.util.*;

/* NODE (CLASS) : */
class Single_Linked_List_NODE {
    int data;
    Single_Linked_List_NODE next;

    /* GENERATE-NODE : */
    public Single_Linked_List_NODE(int value) {
        // CONSTRUCTOR :
        this.data = value;
        this.next = null;
    }
}

public class Single_Linked_List {
    /* SINGLE-LINKED-LIST (PARA-METER) : */
    private Single_Linked_List_NODE head;
    private Single_Linked_List_NODE tail;
    private int length;

    /* => SINGLE-LINKED-LIST (METHOD'S) :
    * >>> ADD-NODE
    * >>> DELETE-NODE
    * >>> UPDATE-NODE
    * >>> INSERT-NODE
    * >>> SEARCH-NODE
    * >>> DISPLAY-LINKED-LIST
    * */

    // ADD-NODE :
    public void add_node(int value) {
        /* NEW-NODE : (GENERATE) : */
        Single_Linked_List_NODE add_new_doublyLinkedListNODE = new Single_Linked_List_NODE(value);

        /* CHECK, WEATHER (HEAD & TAIL = NULL) : */
        if (head == null || length == 0) {
            head = add_new_doublyLinkedListNODE;
            tail = add_new_doublyLinkedListNODE;
        }
        else {
            tail.next = add_new_doublyLinkedListNODE; // ADD-NEW-NODE : FROM OLD-NODE;
            tail = add_new_doublyLinkedListNODE; // UPDATE-NEW-NODE (TAIL);
        }
        // INCREMENT-LENGTH :
        length++;
        System.out.println("\n\t----- YA ! NODE (ADDED) - SUCCESSFULLY -----\n");
    }

    // DELETE-NODE :
    public void delete_node(int value) {
        /* => TEMPORARY-NODE
        *  => PREVIOUS-NODE
        *  => STORE-NODE
        *  */
        Single_Linked_List_NODE temporary_doublyLinkedListNODE = head;
        Single_Linked_List_NODE previous_doublyLinkedListNODE = head;

        Single_Linked_List_NODE next_doublyLinkedListNODE;
        Single_Linked_List_NODE store_delete_doublyLinkedListNODE;

        /* CHECK, WEATHER (HEAD-NODE) => CURRENT-NODE TO, (DELETE) */
        if (head.data == value) {
            /* SAVE, DELETED-NODE : */
            store_delete_doublyLinkedListNODE = head;
            store_delete_doublyLinkedListNODE.next = null;

            /* CHANGE, HEAD-NODE TO, NEXT-POINTER OF HEAD-NODE : */
            head = head.next;
            length--;

            /* NOW, CHECK WEATHER HEAD => NULL OR NOT : */
            if (head == null) {
                /* CHANGE, HEAD & TAIL (NODE) => NULL : */
                head = null;
                tail = null;
            }

            System.out.println("\n\t>>> DELETED-NODE : " + store_delete_doublyLinkedListNODE.data);
            System.out.println("\n\t----- YA ! NODE (DELETED) - SUCCESSFULLY -----\n");
            System.out.println("\n\t----- YA ! NODE (DELETED) - SUCCESSFULLY -----\n");
        }
        else {
            while (temporary_doublyLinkedListNODE != null) {
                /* CHECK, WEATHER (DELETE-NODE) -> DATA => FOUND OR NOT : */
                if (temporary_doublyLinkedListNODE.data == value) {
                    /* NOW, CHECK WEATHER TAIL-NODE => NULL :
                    *  THEN,
                    *  IN -> PREVIOUS-NODE : UPDATE TO TAIL-NODE
                    *
                    *  AND,
                    *  TAIL-NODE => NEW-PREVIOUS-NODE
                    * */
                    if (temporary_doublyLinkedListNODE == tail) {
                        previous_doublyLinkedListNODE.next = temporary_doublyLinkedListNODE.next;
                        tail = previous_doublyLinkedListNODE;

                        /* CHECK, WEATHER TAIL => NULL OR NOT : */
                        if (tail == null) {
                            tail = null;
                        }
                    }
                    else {
                        /* SO, HERE WE WILL PASS (DELETE-NODE) => POINTER TO NEXT-NODE
                         *  THEN, :-
                         *  PREVIOUS-NODE.NEXT (POINTER) STORE NEXT-NODE
                         *
                         *  THEN, :-
                         *  STORE-DELETED-NODE => FROM, TEMPORARY-NODE
                         *
                         *  THEN, LATER :
                         *  MAKE : STORE-DELETE-NODE = NULL;
                         *  DECREMENT : LENGTH - 1
                         * */
                        next_doublyLinkedListNODE = temporary_doublyLinkedListNODE.next;
                        previous_doublyLinkedListNODE.next = next_doublyLinkedListNODE;
                    }
                    /* NOW,
                    *  WE, WILL STORE DELETED-NODE */
                    store_delete_doublyLinkedListNODE = temporary_doublyLinkedListNODE;
                    store_delete_doublyLinkedListNODE.next = null;
                    length--;

                    System.out.println("\n\t>>> DELETED-NODE : " + store_delete_doublyLinkedListNODE.data);
                    System.out.println("\n\t----- YA ! NODE (DELETED) - SUCCESSFULLY -----\n");
                }
                else {
                    System.out.print("");
                }
                // INCREMENT : NODE-POINTER
                previous_doublyLinkedListNODE = temporary_doublyLinkedListNODE;
                temporary_doublyLinkedListNODE = temporary_doublyLinkedListNODE.next;
            }
        }
    }

    // UPDATE-NODE :
    public void update_node(int old_value, int new_value) {
        /* UPDATE-NODE : DATA */
        Single_Linked_List_NODE temp_doublyLinkedListNODE = head; // TEMPORARY-NODE (TEMP);

        while (temp_doublyLinkedListNODE != null) {
            if (temp_doublyLinkedListNODE.data == old_value) {
                /* UPDATE, NODE-DATA : */
                temp_doublyLinkedListNODE.data = new_value;
                System.out.println("\n\t----- YA ! NODE (UPDATED) - SUCCESSFULLY ! -----\n");
            }
            else {
                System.out.println("\n\t----- SORRY, NOT DATA-FOUND ! -----\n");
            }
            // INCREMENT : POINTER (TO NEXT-NODE);
            temp_doublyLinkedListNODE = temp_doublyLinkedListNODE.next;
        }
    }

    // INSERT-NODE :
    public void insert_node(int index, int value) {
        /* CHECK, WEATHER INDEX : OUT OF LENGTH OR NOT */
        if (index < 0 || index > length) {
            System.out.println("\n\t----- INVALID ! INDEX-LENGTH -----\n");
        }
        else if (index == 0) {
            /* INSERT-NODE @ HEAD-INDEX : */

            /* GENERATE NEW-NODE : */
            Single_Linked_List_NODE prepend_doublyLinkedListNODE = new Single_Linked_List_NODE(value);

            if (length == 0) {
                head = prepend_doublyLinkedListNODE;
                tail = prepend_doublyLinkedListNODE;
            }
            else {
                prepend_doublyLinkedListNODE.next = head;
                head = prepend_doublyLinkedListNODE;
            }
            /* INCREMENT-LENGTH : */
            length++;

            System.out.println("\n\t----- YA ! NODE (INSERTED) - SUCCESSFULLY -----\n");
        }
        else if (index == length) {
            /* INSERT-NODE @ TAIL-INDEX : */

            // ADD-NODE (METHOD) :
            add_node(value);
            System.out.println("\n\t----- YA ! NODE (INSERTED) - SUCCESSFULLY -----\n");
        }
        else {
            /* GENERATE NEW-NODE : */
            Single_Linked_List_NODE insert_doublyLinkedListNODE = new Single_Linked_List_NODE(value);

            /* TEMPORARY-NODE : */
            Single_Linked_List_NODE temp_doublyLinkedListNODE = head;
            Single_Linked_List_NODE current_doublyLinkedListNODE = head;

            for (int i = 0; i < index; i++) {
                /* HERE, WE WILL INCREMENT-NODE (POINTER) & STORE PREVIOUS-NODE (DATA) */
                current_doublyLinkedListNODE = temp_doublyLinkedListNODE;
                temp_doublyLinkedListNODE = temp_doublyLinkedListNODE.next;
            }

            /* INSERT-NODE : IN BETWEEN (LINKED-LIST) : */
            current_doublyLinkedListNODE.next = insert_doublyLinkedListNODE;
            insert_doublyLinkedListNODE.next = temp_doublyLinkedListNODE;
            length++;

            System.out.println("\n\t----- YA ! NODE (INSERTED) - SUCCESSFULLY -----\n");
        }
    }

    // SEARCH-NODE :
    public void search_node(int value) {
        /* GENERATE-NODE : */
        Single_Linked_List_NODE current_doublyLinkedListNODE = head;
        int count = 0;

        while (current_doublyLinkedListNODE != null) {
            if (current_doublyLinkedListNODE.data == value) {
                System.out.println("\n\t>>> NODE FOUND AT : " + (count + 1) + " POSITION, IN SINGLE-LINKED-LIST \n");
            }
            else {
                System.out.print("");
            }
            /* INCREMENT => POINTER (NODE) : */
            current_doublyLinkedListNODE = current_doublyLinkedListNODE.next;
            count++;
        }
    }

    // DISPLAY-LINKED-LIST :
    public void display_linked_list() {
        /* CHECK, WEATHER (HEAD = NULL OR NOT) : */
        if (head == null || length == 0) {
            System.out.println("\n\t---- OOPS ! LINKED-LIST => EMPTY -----\n");
        }
        else {
            System.out.print("\n\t>>> SINGLE-LINKED-LIST : ");

            int count = 0;
            Single_Linked_List_NODE temp_doublyLinkedListNODE = head;

            while (temp_doublyLinkedListNODE != null) {
                System.out.print(temp_doublyLinkedListNODE.data + "-> "); // DISPLAY-NODE'S;
                temp_doublyLinkedListNODE = temp_doublyLinkedListNODE.next; // INCREMENT : POINTER TO NEXT => NODE;
            }

            /* HEAD-NODE : */
            System.out.println("\n\n\t>>> HEAD : " + head.data);
            /* TAIL-NODE : */
            System.out.println("\t>>> TAIL : " + tail.data);
            /* LENGTH-LINKED-LIST : */
            System.out.println("\t>>> LENGTH : " + length);
        }
    }

    /* GENERATE-SINGLE-LINKED-LIST : */
    public Single_Linked_List() {
        // CONSTRUCTOR :

        /* SCANNER (USER-INPUT) : */
        Scanner scan = new Scanner(System.in);

        while (true) {
            System.out.println("\n\t----- SINGLE-LINKED-LIST - (MENU) -----\n");
            System.out.println("\t>>> PRESS (0) : ADD-NODE");
            System.out.println("\t>>> PRESS (1) : DELETE-NODE");
            System.out.println("\t>>> PRESS (2) : UPDATE-NODE");
            System.out.println("\t>>> PRESS (3) : INSERT-NODE");
            System.out.println("\t>>> PRESS (4) : SEARCH-NODE");
            System.out.println("\t>>> PRESS (5) : DISPLAY-LINKED-LIST");

            System.out.print("\n\t>>> ENTER YOUR, CHOICE : ");
            int choice = scan.nextInt();

            // ADD-NODE :
            if (choice == 0) {
                System.out.print("\n\t>>> ENTER DATA : ");
                String data = scan.next();

                try {
                    int value = Integer.parseInt(data);
                    add_node(value);
                }
                catch (NumberFormatException e) {
                    System.out.println("\n\t----- INVALID, DATA ! -----\n");
                }
            }
            // DELETE-NODE :
            else if (choice == 1) {
                /* CHECK, WEATHER HEAD => NULL OR NOT : */
                if (head == null || length == 0) {
                    System.out.println("\n\t----- OOPS ! LINKED-LIST => EMPTY -----\n");
                }
                else {
                    System.out.println("\n\t>>> CHECK-OUT, LINKED-LIST : ");
                    display_linked_list();

                    System.out.print("\n\t>>> ENTER DATA, U WANT DELETE : ");
                    String data = scan.next();

                    try {
                        int value = Integer.parseInt(data);
                        delete_node(value);
                    }
                    catch (NumberFormatException e) {
                        System.out.println("\n\t----- INVALID, DATA ! -----\n");
                    }
                }
            }
            // UPDATE-NODE :
            else if (choice == 2) {
                /* CHECK, WEATHER HEAD => NULL OR NOT : */
                if (head == null || length == 0) {
                    System.out.println("\n\t----- OOPS ! LINKED-LIST => EMPTY -----\n");
                }
                else {
                    System.out.println("\n\t>>> CHECK-OUT, LINKED-LIST : ");
                    display_linked_list();

                    System.out.print("\n\t>>> ENTER OLD-DATA : ");
                    String old_data = scan.next();

                    System.out.print("\n\t>>> ENTER NEW-DATA : ");
                    String new_data = scan.next();

                    try {
                        int old_value = Integer.parseInt(old_data);
                        int new_value = Integer.parseInt(new_data);
                        update_node(old_value, new_value);
                    }
                    catch (NumberFormatException e) {
                        System.out.println("\n\t----- INVALID, DATA ! -----\n");
                    }
                }
            }
            // INSERT-NODE :
            else if (choice == 3) {
                /* DISPLAY-LINKED-LIST : */
                System.out.println("\n\t>>> CHECK-OUT, LINKED-LIST : ");
                display_linked_list();

                /* CHECK, WEATHER HEAD => NULL OR NOT : */
                if (head == null || length == 0 || length == 1) {
                    System.out.print("\n\t>>> ENTER DATA : ");
                    String data = scan.next();

                    try {
                        int value = Integer.parseInt(data);
                        add_node(value);
                    }
                    catch (NumberFormatException e) {
                        System.out.println("\n\t----- INVALID, DATA ! -----\n");
                    }
                }
                else {
                    System.out.print("\n\t>>> ENTER INDEX : ");
                    String index = scan.next();

                    System.out.print("\n\t>>> ENTER DATA : ");
                    String data = scan.next();

                    try {
                        int index_value = Integer.parseInt(index);
                        int value = Integer.parseInt(data);

                        insert_node(index_value, value);
                    }
                    catch (NumberFormatException e) {
                        System.out.println("\n\t----- INVALID, DATA ! -----\n");
                    }
                }
            }
            // SEARCH-NODE :
            else if (choice == 4) {
                /* CHECK, WEATHER HEAD => NULL OR NOT : */
                if (head == null || length == 0) {
                    System.out.println("\n\t----- OOPS, LINKED-LIST => EMPTY ! -----\n");
                }
                else {
                    /* DISPLAY-LINKED-LIST : */
                    System.out.println("\n\t>>> CHECK-OUT, LINKED-LIST : ");
                    display_linked_list();

                    System.out.print("\n\t>>>> ENTER DATA, U WANT TO SEARCH : ");
                    String data = scan.next();

                    try {
                        int value = Integer.parseInt(data);
                        search_node(value);
                    }
                    catch (NumberFormatException e) {
                        System.out.println("\n\t----- YA ! NODE (INSERTED) - SUCCESSFULLY -----\n");
                    }
                }
            }
            // DISPLAY-LINKED-LIST (NODE'S) :
            else if (choice == 5) {
                /* DISPLAY-LINKED-LIST : */
                display_linked_list();
            }
            else {
                /* NOW,
                *  USER-WRONG (INPUT OR CHOICE) : */
                System.out.println("\n\t----- SORRY ! WRONG-CHOICE, TRY AGAIN -----\n");
            }
        }
    }
}