import java.util.Scanner;

public class PakuriProgram
{

    public static void main(String[] args)
    {
        // variable dump
        int pakudexCapacity = -1;
        int menuInput;


        // scanner
        Scanner scanny = new Scanner(System.in);


        // display welcome message
        System.out.print("Welcome to Pakudex: Tracker Extraordinaire!\n");


        // prompt for capacity
        while (true)
            {
                System.out.print("Enter max capacity of the Pakudex: ");

                if (scanny.hasNextInt())
                {
                        pakudexCapacity = scanny.nextInt();
                }
                else
                {
                    pakudexCapacity = -1;
                    scanny.next();
                }

                if (pakudexCapacity > 0)
                {
                    break;
                }
                else
                {
                    System.out.println("Please enter a valid size.");
                }

            }

            System.out.println("The Pakudex can hold " + pakudexCapacity + " species of Pakuri.\n");


            // IMPORTANT
            Pakudex pakudex = new Pakudex(pakudexCapacity);


            while(true)
            {


                System.out.print("Pakudex Main Menu\n" +
                        "-----------------\n" +
                        "1. List Pakuri\n" +
                        "2. Show Pakuri\n" +
                        "3. Add Pakuri\n" +
                        "4. Evolve Pakuri\n" +
                        "5. Sort Pakuri\n" +
                        "6. Exit\n\n" +
                        "What would you like to do? ");

                try
                {
                    menuInput = scanny.nextInt();
                }
                catch (Exception e)
                {
                    menuInput = -1;
                    scanny.next();
                }

                switch (menuInput)
                {

                    default:
                        System.out.println("Unrecognized menu selection!\n");
                        break;

                    case 1: // List Pakuri

                        String[] currentCollection = pakudex.getSpeciesArray();

                        if (currentCollection == null)
                        {
                            System.out.println("No Pakuri in Pakudex yet!\n");
                        }
                        else
                        {
                            System.out.println("Pakuri In Pakudex:");

                            for (int i = 0; i < currentCollection.length; i++)
                            {
                                System.out.println((i + 1) + ". " + currentCollection[i]);
                            }

                            System.out.println("");
                        }

                        break;

                    case 2: // Show Pakuri

                        System.out.print("Enter the name of the species to display: ");
                        String pakuriName = scanny.next();

                        int[] currentStats = pakudex.getStats(pakuriName);

                        if (currentStats == null)
                        {
                            System.out.println("Error: No such Pakuri!\n");
                            break;
                        }

                        System.out.println("\nSpecies: " + pakuriName + "\n" +
                                           "Attack: " + currentStats[0] + "\n" +
                                           "Defense: " + currentStats[1] + "\n" +
                                           "Speed: " + currentStats[2] + "\n");
                        break;

                    case 3: // Add Pakuri

                        if (pakudex.getCapacity() == pakudex.getSize())
                        {
                            System.out.println("Error: Pakudex is full!\n");
                            break;
                        }

                        System.out.print("Enter the name of the species to add: ");
                        String addedPakuri = scanny.next();

                        if (pakudex.addPakuri(addedPakuri))
                        {
                            System.out.println("Pakuri species " + addedPakuri + " successfully added!\n");
                        }
                        else
                        {
                            System.out.println("Error: Pakudex already contains this species!\n");
                        }

                        break;

                    case 4: // Evolve Pakuri

                        System.out.print("Enter the name of the species to evolve: ");
                        String speciesToEvolve = scanny.next();


                        if (pakudex.evolveSpecies(speciesToEvolve))
                        {
                            System.out.println(speciesToEvolve + " has evolved!\n");
                        }
                        else
                        {
                            System.out.println("Error: No such Pakuri!\n");
                        }

                        break;

                    case 5: // Sort Pakuri

                        pakudex.sortPakuri();
                        System.out.println("Pakuri have been sorted!\n");

                        break;

                    case 6:
                        System.out.print("Thanks for using Pakudex! Bye!");
                        return;
                }


            }













    }






}
