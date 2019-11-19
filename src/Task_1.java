import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Task_1 {
    public static void main(String[] args) throws FileNotFoundException {
        int sum=0;
        for (int i=1; i<=10; i++){
            sum+=i;
        }
//        System.out.println(sum);

        //stream pipeline - ciąg metod, które będą ten strumień przetwarzały (potok strumienia)
        sum= IntStream.rangeClosed(1,10)
                      .sum(); //sum dokonuuje redukcji strumienia (zamienia strumień na jedną liczbę), jest metodą terminalną - kończy przetwarzanie strumienia

        //zsumuj liczy parzyste od 2 do 20
        int evenSum=IntStream.rangeClosed(1,10)
                             .map((x)->{return 2*x;})
                           //.map((x)->2*x)
                             .sum();

        //zsumuj liczby niepparzyste od 1 do 10
        //filter
        int oddSum=IntStream.rangeClosed(1,10)
                            .filter((x)->x%2 !=0)
                            .sum();

        //przykład referencji do metody
        IntStream.rangeClosed(1,10)
                .filter((x)->x%2 !=0)
                .forEach(System.out::println);

        //filter,distinct-zwraca unikatowe elementy strumienia, limit-zwraca liczbę początkowych elementów strumienia
        //map-odwzorowanie modyfikacji elementów, sorted-sortowanie elementów, forEach

        //metody redukujące: average, count, max, min, reduce-własna metoda, którą definiujemy my, by zredukować strumień tak jak chcemy

        List<Integer> oddNumbersList =IntStream.rangeClosed(1,10)
                .boxed()//tworzy strumień Intergera
                .filter((x)->x%2 !=0).collect(Collectors.toList());

        //coś w poprzednim było źle więc taki przykład
        Integer[] values ={2,3,4,5,1};
        List<Integer> greaterThan2= Arrays.stream(values)
                                          .filter((x)->x>2)
                                          .collect(Collectors.toList());
        System.out.println(greaterThan2);

        //utworzenie strumienia z listy tablicowej
        List<Integer> data= new ArrayList<>(Arrays.asList(values));
        data.stream().distinct().forEach(System.out::println);
//        data.stream().distinct().forEach((x)-> System.out.println(x));

        //obliczenie średniej elementów tablicy z listy values
        //to operuje na tablicach prostych a nie tablicach opakowujących Interger
        int[] dane2={1,2,3,4};
        double average=Arrays.stream(dane2).average().getAsDouble();

        //przykład programowania deklaratywnego- co ma być zrobione, ale nie jak

        Student[] students={
                new Student("Richard","Feynman",4.5),
                new Student("Rudyard","Kipling",3.5),
                new Student("Marie","Curie",3.7)
        };

        Arrays.stream(students).filter(s->(s.getGpa()>3 && s.getGpa()<4))
                               .sorted(Comparator.comparing(Student::getLastName).reversed())
                               .forEach(System.out::println);

        //korzystając ze strumieni wyświetlić tenisitów z top 30 (21-30) i posortować ze względu na kraj

//        ArrayList<Integer> playerPosition = new ArrayList<>();
//        ArrayList<String> playerName = new ArrayList<>();
//        ArrayList<String> playerNationality = new ArrayList<>();
//        ArrayList<Integer> playerAge = new ArrayList<>();
//        ArrayList<Integer> playerPoints = new ArrayList<>();
//        ArrayList<String> player=new ArrayList<>();
//
//
//
//        File file=new File("C:\\Users\\Student.DESKTOP-VNR47RU\\ZPO_Lab7\\src\\File.txt");
//        Scanner scanner= new Scanner(file);
//
//
//        while (scanner.hasNext()){
//            String line=scanner.nextLine().replaceAll(" ","\t");
//            String[] fileDivision=line.split("\t");
//
//            String position = fileDivision[0];
//            int tempPosition = Integer.valueOf(position);
//            playerPosition.add(tempPosition);
//            playerNationality.add(fileDivision[1]);
//            playerName.add(fileDivision[2]);
//            String age = fileDivision[3];
//            int tempAge = Integer.valueOf(age);
//            playerAge.add(tempAge);
//            String points = fileDivision[4];
//            int tempPoints = Integer.valueOf(points);
//            playerPoints.add(tempPoints);
//
//        }

    }//end of main
}//end of class
