import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;


/**
 * Created by Harsha Kosala on 2/22/2017.
 As a first command line argument name of the .txt file and letters you need to consider shuold given.
 ex:- java SampleFilter sample.txt aelp
 */
public class SampleFilter {
    public static HashMap<String,ArrayList<String>> hashMap = new HashMap<>();
    public static void main(String[] args) {
        try {
            String fileName = args[0];
            try {
                String letters = args[1];
                String[] letterArray = letters.split("");
                ArrayList<String> letterArryAL = new ArrayList<>();
                try {
                    BufferedReader bufferedReader = new BufferedReader(new FileReader(fileName));
                    String line;
                    while ((line = bufferedReader.readLine()) != null) {
                        String first = line.split("")[0];
                        ArrayList<String> arrayList = new ArrayList<>();
                        if (hashMap.containsKey(first)){
                            arrayList = hashMap.get(first);
                            arrayList.add(line);
                            hashMap.put(first,arrayList);
                        }else {
                            arrayList.add(line);
                            hashMap.put(first,arrayList);
                        }
                    }

                    for (String s: letterArray
                         ) {
                        if (!letterArryAL.contains(s)){
                            letterArryAL.add(s);
                        }
                    }
                    for (int i = 0; i < letterArryAL.size() ; i++) {
                        if (hashMap.containsKey(letterArryAL.get(i))){
                            ArrayList<String> arrayList = hashMap.get(letterArray[i]);
                            for (String word: arrayList
                                  ) {
                                String[] wordArray = word.split("");

                                boolean result = true;

                                for (int j = 0; j < wordArray.length; j++) {
                                    if (!letterArryAL.contains(wordArray[j])){
                                        result = false;
                                    }
                                }
                                if (result==true){
                                    System.out.println(word);
                                }

                            }
                        }
                    }

                } catch (FileNotFoundException e) {
                    System.out.println("Sorry File not Found");
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }catch (ArrayIndexOutOfBoundsException e){
                System.out.println("Please Enter Letters");
            }
        }catch (ArrayIndexOutOfBoundsException e){
            System.out.println("Please Enter the File Name.");
        }
    }
	
	/*run timecomplexity of the programme is O(n^2). */

}

