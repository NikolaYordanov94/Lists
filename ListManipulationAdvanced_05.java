package Lists;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class ListManipulationAdvanced_05 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Integer> numList = Arrays.stream(scanner.nextLine().split(" "))
                .map(Integer::parseInt)
                .collect(Collectors.toList());

        String commands = scanner.nextLine();

        while(!commands.equals("end")){

            if(commands.contains("Contains")){

                int numToContain = Integer.parseInt(commands.split(" ")[1]);
                if(numList.contains(numToContain)){
                    System.out.println("Yes");
                }else{
                    System.out.println("No such number");
                }
            }else if(commands.contains("even")){

                for (int i = 0; i < numList.size(); i++) {
                    int currentEvenNumber = 0;

                    if(numList.get(i) % 2 == 0){
                        currentEvenNumber = numList.get(i);
                        System.out.print(currentEvenNumber + " ");
                    }
                }
                System.out.println();



            }else if(commands.contains(("odd"))){
                for (int i = 0; i < numList.size(); i++) {
                    int currentOddNumber = 0;

                    if(numList.get(i) % 2 != 0){
                        currentOddNumber = numList.get(i);
                        System.out.print(currentOddNumber + " ");
                    }
                }
                System.out.println();
            }else if (commands.contains("Get")){
                int sumAllElements = 0;
                for (int i = 0; i < numList.size(); i++) {

                    sumAllElements += numList.get(i);
                }
                System.out.println(sumAllElements);
            }else if(commands.contains("Filter")){

                String condition = commands.split(" ")[1];
                int conditionNumToCompare = Integer.parseInt(commands.split(" ")[2]);
                int currentElement = 0;
                switch (condition){

                    case"<":
                        for (int i = 0; i < numList.size(); i++) {
                            currentElement = numList.get(i);

                            if (currentElement < conditionNumToCompare){
                                System.out.print(currentElement + " ");
                            }
                        }
                        System.out.println();
                        break;

                    case">":
                        for (int i = 0; i < numList.size(); i++) {
                            currentElement = numList.get(i);

                            if (currentElement > conditionNumToCompare){
                                System.out.print(currentElement + " ");
                            }
                        }
                        System.out.println();
                        break;

                    case">=":
                        for (int i = 0; i < numList.size(); i++) {
                            currentElement = numList.get(i);

                            if (currentElement >= conditionNumToCompare){
                                System.out.print(currentElement + " ");
                            }
                        }
                        System.out.println();
                        break;

                    case"<=":
                        for (int i = 0; i < numList.size(); i++) {
                            currentElement = numList.get(i);

                            if (currentElement <= conditionNumToCompare){
                                System.out.print(currentElement + " ");
                            }
                        }
                        break;
                }
            }
            commands = scanner.nextLine();
        }
    }
}
