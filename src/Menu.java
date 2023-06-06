import java.util.*;
//record G
import static java.lang.System.exit;
import static java.lang.System.setOut;

import java.util.Collections;

/*record GroceryItem (String name,String type, int count) {
    public GroceryItem (String name) {
        this(name, "Dairy", 1);
    }
    public String toString () {
        return String.format("%d %s in %s", count, name.toUpperCase(), type);
    }
}*/
public class Menu {

    private static Scanner scanner = new Scanner(System.in);

    private static void printMenu(String[] options){


        for (String option : options){
            System.out.println(option);

        }
        System.out.println("");
        System.out.print("Enter a number for which action you want to do: ");
        System.out.println("");
    }
    public static void menu(){
        ArrayList<String> groceries = new ArrayList<>();
        String menuArray[] = {
                "",
                "0 - to shut down",
                "1 - to add item(s) to list (comma delimited list)",
                "2 - to remove any items (comma delimited list)",
                "3 - printAll"
        };

        boolean flag = true;
        while (flag) {
            printMenu(menuArray);
            try {switch (Integer.parseInt(scanner.nextLine())){
                    case 1: addItem(groceries); break;
                    case 2: removeItem(groceries); break;
                    case 3: printAll(groceries); break;
                    case 0: exit(0);
                }
            }
            catch (InputMismatchException ex){
                System.out.println("Please enter an integer value between 0 and 3");
                scanner.next();
            }
            catch (Exception ex){
                System.out.println("An unexpected error happened. Please try again");
                scanner.next();


            }
        }


    }
    private static void printAll (ArrayList<String> groceries) {
        groceries.sort(Comparator.naturalOrder());
        System.out.println(groceries);
    }
    private static void addItem (ArrayList<String> groceries) {
        System.out.println("Add item(s) [separate items by comma]:");
        String[] items = scanner.nextLine().split(",");
        groceries.addAll(List.of(items));
        System.out.println("Such an item has already been added");
        System.out.println();
        groceries.sort(Comparator.naturalOrder());
        System.out.println(groceries);
        }

    private static void removeItem (ArrayList<String> groceries) {
        System.out.println("Remove item(s) [separate items by comma]:");
        String[] items = scanner.nextLine().split(",");
        groceries.removeAll(List.of(items));
        System.out.println("Item has been removed");
        System.out.println();
        System.out.println(groceries);
    }



}
