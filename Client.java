package Client;

import java.io.PrintWriter;
import java.net.Socket;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Client {

    private static String id;
    private static Set<String> Traders;
    private static String holder;
    private static boolean choosing = false;

    public static void main(String[] args) {
        try (Socket socket = new Socket("localhost", 59898)) {

            Scanner in = new Scanner(socket.getInputStream());
            PrintWriter out = new PrintWriter(socket.getOutputStream(), true);

            while (true) {

                updateState(in);

                System.out.println("-------------------------------------------");
                System.out.println("Your id: "+id);
                System.out.println("Traders Connected:");

                for (String s: Traders) {
                    System.out.println("    "+s);
                }

                if (holder.equals(id)) {

                    System.out.println("You have the stcok, Type the id of the player you wish to pass the ball to:");

                    if (!choosing) {
                        choosing = true;
                        new Thread(new ClientWriter(out)).start();
                    }

                } else {
                    System.out.println("Currently, "+holder+" has the stock.");
                    System.out.println("-------------------------------------------");
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void updateState(Scanner in) {
        id = in.nextLine();
        holder = in.nextLine();
        int size = Integer.parseInt(in.nextLine());
        Traders = new HashSet<>();
        for(int i=0; i < size; i++) {
            Traders.add(in.nextLine());
        }
    }

    public static void setChoosing(boolean choosing) {
        Client.choosing = choosing;
    }

    public static Set<String> getTraders() {
        return Traders;
    }
}