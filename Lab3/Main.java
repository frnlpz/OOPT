package Lab3;

import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) {

        ArrayList<Item> itemList = new ArrayList();

        while (true) {
            int choose = showMenu();
            switch (choose) {
                case (1):
                    itemList.add(addItem());
                    break;
                case (2):
                    printListOfObjects(itemList);
                    break;
                case (3):
                    saveObjectToFile(itemList);
                    break;
                case (4):
                    System.out.println("Bye bye.");
                    System.exit(0);
            }
        }
    }

    //Showing the main menu
    private static int showMenu() {
        Scanner sc = new Scanner(System.in);
        int in;

        System.out.println("What do you want to do? (choose 1, 2, 3 or 4):");
        System.out.println("\t1. Add new object.");
        System.out.println("\t2. Print the list of objects.");
        System.out.println("\t3. Save object to file.");
        System.out.println("\t4. Close.");

        try {
            in = sc.nextInt();
            if (in >= 1 && in <= 4)
                return in;
        } catch (InputMismatchException e) {
            LaboratoryThree.printException(e);
            System.out.println("- - - - - - PLEASE WRITE A CORRECT NUMBER. - - - - - -");
            showMenu();
        }

        System.out.println("- - - - - - PLEASE CHOOSE 1, 2, 3 OR 4. - - - - - -");
        showMenu();
        sc.close();
        return 0;
    }

    //1st option: adding a new Item
    private static Item addItem() {
        Scanner sc = new Scanner(System.in);
        int in;

        System.out.println("Do you want to add a new object or to import it? (choose 1, 2 or 3):");
        System.out.println("\t1. Add a new object.");
        System.out.println("\t2. Import an object from a file.");
        System.out.println("\t3. Go back.");

        try {
            in = sc.nextInt();

            if (in == 1) {
                return scanItem();
            } else if (in == 2) {
                return importItem();
            } else if (in == 3) {
                showMenu();
            } else {
                System.out.println("- - - - - - PLEASE CHOOSE 1, 2 OR 3. - - - - - -");
                addItem();
            }
        } catch (Exception e) {
            LaboratoryThree.printException(e);
            System.out.println("- - - - - - PLEASE WRITE A CORRECT NUMBER. - - - - - -");
            addItem();
        }
        return null;
    }

    //Scanning a new Item from keyboard
    private static Item scanItem() {
        Scanner sc = new Scanner(System.in);
        try {
            System.out.print("Enter the title of the item: ");
            String title = sc.nextLine();

            System.out.print("Enter the producer of the item: ");
            String producer = sc.nextLine();

            System.out.print("Enter the country of origin of the item: ");
            String country = sc.nextLine();

            System.out.print("Enter the production year of the item: ");
            int year = sc.nextInt();

            System.out.print("Enter the price of the item: ");
            double price = sc.nextDouble();

            Item item = new Item(title, producer, country, year, price);
            System.out.println("Item registered!\n");

            showMenu();
            return item;
        } catch (Exception e) {
            System.out.println("\nError. Item not registered :(");
            LaboratoryThree.printException(e);
            scanItem();
        }

        return null;
    }

    //Importing a new Item from a file.
    private static Item importItem() {

        String title = "?";

        Scanner sc = new Scanner(System.in);
        System.out.print("Write the file name: ");
        String fileName = sc.nextLine();

        try {
            Scanner scanner = new Scanner(new File(fileName + ".txt"));

            while (scanner.hasNext()) {
                String lineOfText = scanner.nextLine();

                if (lineOfText.contains(":"))
                    title = lineOfText.substring(5).replaceAll(":", "");
                else {
                    String[] partsOfLine = lineOfText.split(";");
                    String producer = partsOfLine[0].trim();
                    String country = partsOfLine[1].trim();
                    int year = Integer.parseInt(partsOfLine[2].trim());
                    double price = Double.parseDouble(partsOfLine[3].trim());
                    Item item = new Item("", producer, country, year, price);
                    item.setTitle(title);
                    System.out.println("Item registered!\n");
                    return item;
                }
            }
        } catch (FileNotFoundException e) {
            System.out.print("Error. ");
            LaboratoryThree.printException(e);
            importItem();
        }
        return null;
    }

    private static void printListOfObjects(ArrayList<Item> list) {
        int i = 0;
        Collections.sort(list, new Comparator<Item>() {
            @Override
            public int compare(Item o1, Item o2) {
                return o1.compareTo(o2);
            }
        });

        for (Item itm : list) {
            i++;
            System.out.println("Item #" + i + ": " + itm);
        }
    }

    private static void saveObjectToFile(ArrayList<Item> list) {
        Scanner sc = new Scanner(System.in);

        String fileName;
        System.out.println("Choose one item from the list for being saved in a file:");
        int index = sc.nextInt();
        System.out.println("Choose a file name to save the item: ");
        fileName = sc.nextLine();
        Item item = list.get(index);

        BufferedWriter outputStream = null;
            try {
            outputStream = new BufferedWriter(
                    new FileWriter(fileName+".txt"));

            outputStream.append("Item " + item.getTitle() + ":\n");
            outputStream.append(item.getProducer() + ';' + item.getCountry() + ';' + item.getYear() + ';' + item.getPrice() + "\n");
            outputStream.close();
            System.out.println("Item saved.");
            showMenu();
        } catch (IOException e) {
            LaboratoryThree.printException(e);
        }
    }
}