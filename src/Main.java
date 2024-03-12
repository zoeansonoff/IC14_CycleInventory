import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.text.NumberFormat;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws InterruptedException {
        NumberFormat currency = NumberFormat.getCurrencyInstance();
        Scanner keyboard = new Scanner(System.in);
        Cycle[] cycleInventory = new Cycle[10];
        int frameSize;
        String manufacturer;
        double price;
        int cranks;
        int displacement;
        double fuelCapacity;
        int choice, count = 0;
        File BINARYFILE = new File("CycleInventory.dat");

        do {
            System.out.print(
                    "\n********************************************************************\n"
                            + "**                                                                **\n"
                            + "**             WELCOME TO THE CYCLE INVENTORY                     **\n"
                            + "**                                                                **\n"
                            + "********************************************************************\n"
                            + "** Please select from the following choices:                      **\n"
                            + "** 1) Enter new Bicycle                                           **\n"
                            + "** 2) Enter new Motorcycle                                        **\n"
                            + "** 3) Display entire inventory                                    **\n"
                            + "** 4) Exit                                                        **\n"
                            + "********************************************************************\n"
                            + ">> ");

            choice = keyboard.nextInt();
            switch (choice) {
                case 1:
                    try {
                        System.out.println("Enter manufacturer: ");
                        keyboard.nextLine();
                        manufacturer = keyboard.nextLine();
                        System.out.println("Enter price       $ ");
                        price = keyboard.nextDouble();
                        System.out.println("Enter frame size  : ");
                        keyboard.nextLine();
                        String fs = keyboard.nextLine();
                        if ("small".equals(fs))
                            frameSize = 15;
                        else if ("medium".equals(fs))
                            frameSize = 17;
                        else if ("large".equals(fs))
                            frameSize = 19;
                        else
                            throw new InvalidFrameException();
                        System.out.print("Enter cranks      : ");
                        cranks = keyboard.nextInt();
                    } catch(InvalidFrameException e) {
                        System.err.println(e.getMessage());
                    }
                    break;

                case 2:
                    System.out.println("Enter manufacturer : ");
                    keyboard.nextLine();
                    manufacturer = keyboard.nextLine();
                    System.out.println("Enter price        $ ");
                    price = keyboard.nextDouble();
                    System.out.println("Enter displacement : ");
                    displacement = keyboard.nextInt();
                    System.out.print("Enter fuel capacity: ");
                    fuelCapacity = keyboard.nextDouble();

                    cycleInventory[count++] = new Motorcycle(manufacturer, price, displacement, fuelCapacity);
                    System.out.println(cycleInventory[count-1]);
                    break;

                case 3:
                    System.out.println("~~~Cycles in Inventory~~~");
                    for (int i = 0; i < count; i++) {
                        System.out.println(cycleInventory[i]);

                    }
                    System.out.println();
                    System.out.println("Average price of all items in inventory: " + currency.format(findAveragePrice(cycleInventory, count)));
                    System.out.println("Motorcycle with largest engine: " + findMaxDisplacement(cycleInventory, count));
                    break;

                case 4:
                    try{
                        ObjectOutputStream fileWriter = new ObjectOutputStream(new FileOutputStream(BINARYFILE));
                        fileWriter.writeObject(cycleInventory);
                        fileWriter.close();
                    } catch (IOException e) {
                        System.err.println(e.getMessage());
                    }
                    break;
            }

        } while (choice != 4);

        keyboard.close();
    }
    public static double findAveragePrice(Cycle[] inventory, int count){
        double total = 0.0;
        for (int i = 0; i < count; i++) {
            total += inventory[i].getPrice();

        }

        return total/count;
    }

    public static Motorcycle findMaxDisplacement(Cycle[] inventory, int count)
    {
        int maxDisplacement = Integer.MIN_VALUE;
        Motorcycle maxMoto = null;
        for (int i = 0; i < count; i++) {
            //check to see if this object in the array is a motorcycle
            if (inventory[i] instanceof Motorcycle m) {
                //check if m has max displacement
                if (m.getDisplacement() > maxDisplacement) {
                    maxDisplacement = m.getDisplacement();
                    maxMoto = m;
                }

            }

        }
        return maxMoto;
    }

}