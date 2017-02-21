import java.math.*;

public class main {
    public static void main(String[] args){
        BigInteger fact = BigInteger.valueOf(1);
        for(int i = -100;i<=100;i+=20){
            fact = BigInteger.valueOf(0);
            if(i>=0){
                fact = BigInteger.valueOf(1);
                for(int j=2;j<=i;j++){
                    fact = fact.multiply(BigInteger.valueOf(j));
                    //System.out.println(fact);
                }
            }
            System.out.println(i+": "+fact);    
        }
    }
}
