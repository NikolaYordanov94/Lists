package ListsExercises;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class SoftUniCoursePlanning_10 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<String> softUniSchedule = Arrays.stream(scanner.nextLine().split(", ")).collect(Collectors.toList());

        String input = scanner.nextLine();

        while(!input.equals("course start")){


            if(input.contains("Add")){

                String forAddToSchedule = input.split(":")[1];
                if(!softUniSchedule.contains(forAddToSchedule)){
                    softUniSchedule.add(forAddToSchedule);
                }

            }else if(input.contains("Insert")){

                String forInsertToSchedule = input.split(":")[1];
                int indexForInsertionInSchedule = Integer.parseInt(input.split(":")[2]);

                if(!softUniSchedule.contains(forInsertToSchedule)){
                    softUniSchedule.add(indexForInsertionInSchedule, forInsertToSchedule);
                }

            }else if(input.contains("Remove")){

                String forRemovalFromSchedule = input.split(":")[1];

                if(softUniSchedule.contains(forRemovalFromSchedule)){
                    softUniSchedule.remove(forRemovalFromSchedule);
                }

            }else if (input.contains("Swap")){
                String firstPartForSwap = input.split(":")[1];
                String secondPartForSwap = input.split(":")[2];

                if (softUniSchedule.contains(firstPartForSwap) && softUniSchedule.contains(secondPartForSwap)) {

                    int indexOfFirstPart = softUniSchedule.indexOf(firstPartForSwap);
                    int indexOfSecondPart = softUniSchedule.indexOf(secondPartForSwap);

                    softUniSchedule.set(indexOfFirstPart, secondPartForSwap);
                    softUniSchedule.set(indexOfSecondPart, firstPartForSwap);

                    String exOne = firstPartForSwap + "-Exercise";
                    String exTwo = secondPartForSwap + "-Exercise";
                    if (softUniSchedule.contains(exOne)) {
                        softUniSchedule.remove(softUniSchedule.indexOf(exOne));
                        softUniSchedule.add(softUniSchedule.indexOf(firstPartForSwap + 1), exOne);
                    }
                    if (softUniSchedule.contains(exTwo)) {
                        softUniSchedule.remove(softUniSchedule.indexOf(exTwo));
                        softUniSchedule.add(softUniSchedule.indexOf(secondPartForSwap) + 1, exTwo);
                    }
                }

            }else if(input.contains("Exercise")){

                String titleOfExercise = input.split(":")[1];
                String containsExerciseCheck = titleOfExercise + "-" + "Exercise";
                int indexOfLesson = softUniSchedule.indexOf(titleOfExercise);
                if(softUniSchedule.contains(titleOfExercise)) {
                    //има ли упражнение
                    if(indexOfLesson == softUniSchedule.size() - 1) {
                        softUniSchedule.add(indexOfLesson + 1, containsExerciseCheck);
                    } else  if(!softUniSchedule.get(indexOfLesson + 1).equals(containsExerciseCheck)) {
                        softUniSchedule.add(indexOfLesson + 1, containsExerciseCheck);
                    }
                } else {
                    softUniSchedule.add(titleOfExercise);
                    softUniSchedule.add(containsExerciseCheck);
                }

            }
            input = scanner.nextLine();
        }

        for (int i = 0; i < softUniSchedule.size(); i++) {
            String title = softUniSchedule.get(i);

            System.out.println((i + 1) + "." + title);
        }
    }
}
