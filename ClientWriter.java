package Client;

import java.io.PrintWriter;
import java.util.Scanner;

public class ClientWriter implements Runnable{

    private PrintWriter out;

    public ClientWriter (PrintWriter out) {
        this.out = out;
    }

    @Override
    public void run() {

        Scanner scanner = new Scanner(System.in);
        String destination;

        while (true) {

            destination = scanner.nextLine();

            if (Client.getTraders().contains(destination)) {
                System.out.println("trading stock "+destination);
                out.println(destination);
                Client.setChoosing(false);
                return;
            } else {
                System.out.println("Type an id that exists in the list of current traders");
            }
        }


    }
}
