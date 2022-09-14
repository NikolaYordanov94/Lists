package ListsExercises;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Train_Lists_01 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Integer> wagons = Arrays.stream(scanner.nextLine()
                        .split(" "))
                .map(Integer::parseInt)
                .collect(Collectors.toList());

        int maxCapacityOfEachWagon = Integer.parseInt(scanner.nextLine());

        String command = scanner.nextLine();

        while (!command.equals("end")){

            if (command.contains("Add")){

                int addWagonWithPassengers = Integer.parseInt(command.split(" ")[1]);
                wagons.add(addWagonWithPassengers);

            }else{

                int addPassengersToWagon = Integer.parseInt(command);

                for (int index = 0; index <= wagons.size() - 1; index++) {

                    int currentIndex = wagons.get(index);

                    if((currentIndex + addPassengersToWagon) <= maxCapacityOfEachWagon){

                        currentIndex = currentIndex + addPassengersToWagon;
                        wagons.set(index, currentIndex);
                        break;
                    }
                    }

                }
            command = scanner.nextLine();

        }
        for (int wagon : wagons) {
            System.out.print(wagon + " ");
        }

        }
    }

