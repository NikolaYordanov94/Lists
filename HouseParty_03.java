package ListsExercises;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class HouseParty_03 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int numOfCommands = Integer.parseInt(scanner.nextLine());
        List<String> guestList = new ArrayList<>();
        List<String> guestListInformation = new ArrayList<>();

        for (int i = 1; i <= numOfCommands; i++) {

            String command = scanner.nextLine();

            if(command.contains("is going!")){

                String addGuestToList = command.split(" ")[0];

                if(guestList.contains(addGuestToList)){
                    guestListInformation.add(addGuestToList + " is already in the list!");
                }else{
                    guestList.add(addGuestToList);
                }

            }else if (command.contains("is not going!")){

                String removeGuestFromList = command.split(" ")[0];

                if(guestList.contains(removeGuestFromList)){

                    guestList.remove(removeGuestFromList);
                }else{
                    guestListInformation.add(removeGuestFromList + " is not in the list!");
                }
            }
        }

        for(String guestInformation : guestListInformation){
            System.out.println(guestInformation);
        }
        for(String guest : guestList){
            System.out.println(guest);
        }

        }
    }

