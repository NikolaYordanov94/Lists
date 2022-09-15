package ListsExercises;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.Arrays;

public class CardsGame_06 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Integer> firstPlayerCards = Arrays.stream(scanner.nextLine().split(" "))
                .map(Integer::parseInt).collect(Collectors.toList());

        List<Integer> secondPlayerCards = Arrays.stream(scanner.nextLine().split(" "))
                .map(Integer::parseInt).collect(Collectors.toList());

        int sumOfWinner = 0;


        while (firstPlayerCards.size() != 0 && secondPlayerCards.size() != 0){

            int firstPlayerPlayedCard = firstPlayerCards.get(0);
            int secondPlayerPlayedCard = secondPlayerCards.get(0);
            firstPlayerCards.remove(0);
            secondPlayerCards.remove(0);

            if(firstPlayerPlayedCard > secondPlayerPlayedCard){
                firstPlayerCards.add(firstPlayerPlayedCard);
                firstPlayerCards.add(secondPlayerPlayedCard);
            }else if(secondPlayerPlayedCard > firstPlayerPlayedCard){
                secondPlayerCards.add(secondPlayerPlayedCard);
                secondPlayerCards.add(firstPlayerPlayedCard);
            }

        }

        if(firstPlayerCards.size() == 0){
            for(int card : secondPlayerCards){
                sumOfWinner += card;
            }
            System.out.printf("Second player wins! Sum: %d", sumOfWinner);
        }else if (secondPlayerCards.size() == 0){
            for(int card : firstPlayerCards){
                sumOfWinner += card;
            }
            System.out.printf("First player wins! Sum: %d", sumOfWinner);

        }
    }
}
