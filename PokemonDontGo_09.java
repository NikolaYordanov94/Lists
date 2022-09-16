package ListsExercises;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class PokemonDontGo_09 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Integer> distances = Arrays.stream(scanner.nextLine()
                        .split(" "))
                .map(Integer::parseInt)
                .collect(Collectors.toList());

            int sumRemoved = 0;

        while(distances.size() > 0){
            int index = Integer.parseInt(scanner.nextLine());
            // <0
            if(index < 0){
                int firstElement = distances.get(0);
                sumRemoved += firstElement;
                int lastElement = distances.get(distances.size() - 1);
                distances.set(0, lastElement);
                modifyList(distances, firstElement);
                //модификация на списъка

                // > последния
            }else if(index > distances.size() - 1){
                int firstElement = distances.get(0);
                int lastElement = distances.get(distances.size() - 1);
                sumRemoved += lastElement;
                distances.set(0, firstElement);
                distances.set(distances.size() - 1, firstElement);
                modifyList(distances, lastElement);
                //модификация на списъка
                // между 0 и последния


            }else if(index >= 0 && index <= distances.size() - 1){
                int removedElement = distances.get(index);
                sumRemoved += removedElement;
                distances.remove(index);
                modifyList(distances, removedElement);
                //модификация на списъка

            }

        }

        System.out.println(sumRemoved);
    }

    public static void modifyList (List<Integer> list, int removedElement){

        for (int index = 0; index <= list.size() - 1; index++) {

            int currentElement = list.get(index);
            if(currentElement <= removedElement){
                currentElement += removedElement;
            }else{
                currentElement -= removedElement;
            }

            //замествам старата стойност на елемента с променената
            list.set(index, currentElement);
        }
    }
}
