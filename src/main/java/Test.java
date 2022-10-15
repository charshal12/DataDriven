import com.google.common.collect.Streams;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class Test {

    public static void main(String[] args) {
//        String[] alphaArray = {"a","b","a","c","d","g","h", "j","k","d","p","q","f"};
//        Map<String, Integer> alphaCountMap = new HashMap<>();
//
//        for(int i = 0; i < alphaArray.length; i++ ){
//                if(alphaCountMap.containsKey(alphaArray[i])){
//                    int value = alphaCountMap.get(alphaArray[i]).intValue();
//                    alphaCountMap.put(alphaArray[i],++value);
//                }
//                else{
//                    alphaCountMap.put(alphaArray[i],1);
//                }
//        }
//       alphaCountMap.entrySet()
//               .stream()
//               .forEach(stringIntegerEntry -> System.out.println(stringIntegerEntry.getKey() + "->" + stringIntegerEntry.getValue()));

        // Duplicate Alphabets
        // How get vowels

        String alphaArray = "interview assignment experiment";
        Map<Character, Integer> alphaCountMap = new HashMap<>();
        ArrayList<Character> vowels =  new ArrayList<>();
        vowels.add('a');
        vowels.add('e');
        vowels.add('i');
        vowels.add('o');
        vowels.add('u');
        for(int i = 0; i < alphaArray.length(); i++){
                if(alphaCountMap.containsKey(alphaArray.charAt(i))){
                    System.out.println("Duplicate Character -> " + alphaArray.charAt(i));
                }
                else{
                    alphaCountMap.put(alphaArray.charAt(i),1);
                    if (vowels.contains(alphaArray.charAt(i))) {
                        System.out.println("Vowel Character -> " + alphaArray.charAt(i));
                    }
                }
        }


    }

}
//v1 , v2

//                                            Schema Registry
//
//Fintech --> Stock Topic A --> Micorservic A --> Apply Sume Rules On the Event -- > Topic A ---> MS B ---> Topic B

