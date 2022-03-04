package learn.cupcake;

import learn.cupcake.data.Repository;
import learn.cupcake.models.Entry;

import java.time.Month;
import java.time.YearMonth;
import java.util.*;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class App {
    public static void main(String[] args) {
        /*

        Cupcake

        https://trends.google.com/trends/explore?date=all&q=%2Fm%2F03p1r4

        Numbers represent search interest relative to the highest point on the chart for the given region and time.
        A value of 100 is the peak popularity for the term. A value of 50 means that the term is half as popular.
        A score of 0 means there was not enough data for this term.

        1) Use manual looping to answer the following questions:

        a) Display the rankings for 2010
        b) Which month/year has the highest ranking?
        c) Which month was the first month to have a ranking of 50 or greater?
        d) Which year has the highest average ranking?

        2) Use the Streams API to answer the same questions.

         */

        Repository repository = new Repository("./data/google-trends-data.csv");

        List<Entry> entries = repository.getEntries();

        //  System.out.println(entries.size());

        Map<Integer, List<Entry>> yearEntryMapping = new HashMap<>();

        for(Entry toBucket : entries){
            if(!yearEntryMapping.containsKey(toBucket.getYearMonth().getYear())){

                yearEntryMapping.put(toBucket.getYearMonth().getYear(), new ArrayList<>());
            }


            yearEntryMapping.get(toBucket.getYearMonth().getYear()).add(toBucket);
        }



        Map<Integer, Double> avgRankingByYear = new HashMap<>();

        for(Integer year : yearEntryMapping.keySet()){
            double sum = 0.0;

            for(Entry monthlyData : yearEntryMapping.get(year)){
                sum += monthlyData.getScore();
            }

            double average = sum / yearEntryMapping.get(year).size();

            avgRankingByYear.put(year, average);
        }

        Map<Integer, List<Entry>> streamEntryMap =
                entries.stream().collect(
                        Collectors.groupingBy(e -> e.getYearMonth().getYear()));


        Map<Integer, Double> streamAvgRankingByYear =
                entries.stream().
                        collect(
                        Collectors.groupingBy(
                                e -> e.getYearMonth().getYear(),
                                Collectors.averagingDouble(e -> e.getScore())));


        for(Integer year : avgRankingByYear.keySet().stream().sorted().collect(Collectors.toList())){
            System.out.println(year + " " + avgRankingByYear.get(year) + " " + streamAvgRankingByYear.get(year));
        }

       List<Entry> sorted = entries.stream().sorted(
               (a, b) -> a.getScore() - b.getScore()
       ).collect(Collectors.toList());

        List<Entry> sortedByDate = entries.stream().sorted(
                (a, b) -> b.getYearMonth().compareTo(a.getYearMonth())
        ).collect(Collectors.toList());


        List<Entry> marchEntries = ourFilter(entries, e -> e.getYearMonth().getMonth() == Month.MARCH);


        ourSort(entries, (a, b) ->
               // a.getYearMonth().getMonth().compareTo(b.getYearMonth().getMonth())
        b.getScore() - a.getScore());


        System.out.println(entries.size());

        //1a)
//        for(Entry e : entries){
//            YearMonth date = e.getYearMonth();
//            int year = date.getYear();
//            if(year == 2010) {
//                System.out.println(date + ", " + e.getScore());
//            }
//        }
//
//        System.out.println();
//        System.out.println();
//
//
//        //1b)
//        Entry highestRanking = null;
//        for(Entry e : entries){
//            if(highestRanking == null){
//                highestRanking = e;
//            }
//            else if(highestRanking.getScore() < e.getScore()){
//                highestRanking = e;
//
//            }
//        }
//        System.out.println(highestRanking.getYearMonth());
//
//
//        System.out.println();
//        System.out.println();
//
//        //1c)
//        int scoreOfFifty = 50;
//        Entry firstToFifty = null;
//        for(Entry e : entries){
//            if(e.getScore() == scoreOfFifty && firstToFifty == null){
//
//                firstToFifty = e;
//                System.out.println(e.getYearMonth());
//            }
//
//        }
//
//        System.out.println();
//        System.out.println();
//
//        //1d)
//        HashMap<Integer, List<Integer>> scores = new HashMap<Integer, List<Integer>>();
//        for(Entry e: entries){
//            int year = e.getYearMonth().getYear();
//            if(scores.get(year) == null){
//                scores.put(year, new ArrayList<Integer>());
//            }
//            List<Integer> currentYearScores = scores.get(year);
//            currentYearScores.add(e.getScore());
//            scores.put(year, currentYearScores);
//        }
//        HashMap<Integer, Integer> averages = new HashMap<Integer, Integer>();
//        for(Integer i : scores.keySet()){
//            List<Integer> currentYearScores = scores.get(i);
//            int sum = 0;
//            for(Integer j : currentYearScores){
//               sum += j;
//            }
//            int average = sum / currentYearScores.size();
//
//            averages.put(i, average);
//        }
//
//
//    }
}

    public static List<Entry> ourFilter(List<Entry> collection, Predicate<Entry> decider){
            List<Entry> toReturn = new ArrayList<>();

            for(Entry toCheck : collection){
                if(decider.test(toCheck)){
                    toReturn.add(toCheck);
                }
            }
            return toReturn;
    }

    public static void ourSort(List<Entry> collection, Comparator<Entry> decider){
        boolean sorted = true;

        do {
            sorted = true;
            for (int i = 0; i < collection.size() - 1; i++) {
                Entry a = collection.get(i);
                Entry b = collection.get(i + 1);

                int compareResult = decider.compare(a, b);

                if(compareResult > 0){
                    collection.set(i + 1, a);
                    collection.set(i, b);
                    sorted = false;
                }

            }
        }while(!sorted);
    }

}
