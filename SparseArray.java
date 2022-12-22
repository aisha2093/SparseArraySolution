/*
There is a collection of input strings and a collection of query strings. For 
each query string, determine how many times it occurs in the list of input strings. 
Return an array of the results.
Example:
strings=['ab', 'ab', 'abc']
queries=['ab', 'abc', 'bc']

There are  instances of 'ab', 1 of 'abc' and 0 of 'bc'. For each query, add an element to the return array,
results=[2,1,0].

*/

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.function.*;
import java.util.regex.*;
import java.util.stream.*;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

class Result {

    /*
     * Complete the 'matchingStrings' function below.
     *
     * The function is expected to return an INTEGER_ARRAY.
     * The function accepts following parameters:
     *  1. STRING_ARRAY strings
     *  2. STRING_ARRAY queries
     */

    public static List<Integer> matchingStrings(List<String> strings, List<String> queries) {
     
     
     Map<String, Integer> map = new HashMap<String, Integer>();
     List<Integer> results = new ArrayList<>(queries.size());
     
     
     for (int i=0;i<strings.size();i++) {
         
         String inpuString = strings.get(i);
         if(map.containsKey(inpuString)){
             map.put(inpuString, map.get(inpuString) + 1);
         }else{
             map.put(inpuString, 1);
         }
     }
     
     for (int i=0; i<queries.size(); i++) {
         
         String queryString = queries.get(i);
         if(map.containsKey(queryString)){
            //map.get(queryString).add(results.get(i));
            results.add(map.get(queryString));
         }
     }
     return results;
    }

}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int stringsCount = Integer.parseInt(bufferedReader.readLine().trim());

        List<String> strings = IntStream.range(0, stringsCount).mapToObj(i -> {
            try {
                return bufferedReader.readLine();
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        })
            .collect(toList());

        int queriesCount = Integer.parseInt(bufferedReader.readLine().trim());

        List<String> queries = IntStream.range(0, queriesCount).mapToObj(i -> {
            try {
                return bufferedReader.readLine();
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        })
            .collect(toList());

        List<Integer> res = Result.matchingStrings(strings, queries);

        bufferedWriter.write(
            res.stream()
                .map(Object::toString)
                .collect(joining("\n"))
            + "\n"
        );

        bufferedReader.close();
        bufferedWriter.close();
    }
}
