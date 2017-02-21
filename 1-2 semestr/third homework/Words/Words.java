package Words;

/**
 * Created by ihowardos on 24.11.2015.
 */
public class Words {
    public String[] words;

    public Words(String[] a){
        words = a;
        for(int i=0; i < words.length; i++){
            boolean found = false;
            String word = words[i];

            char first = word.charAt(0);
            if('A'<=first && first<='Z'){
                boolean allLower = true;

                for(int j=1; j<word.length() && allLower; j++ ){
                    char c = word.charAt(j);
                    allLower = ('a'<=c && c<='z');
                }
                found = allLower;
            }
            System.out.println(words[i] + " - " + found);
        }
    }
    }

