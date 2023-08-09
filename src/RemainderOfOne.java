import java.math.BigInteger;

public class RemainderOfOne
{
    public static void main(String[] args)
    {
        BigInteger base = BigInteger.valueOf(13);
        BigInteger prime = BigInteger.valueOf(77);

        BigInteger result;
        BigInteger remainder;

        for(int i = 1; i  <= 1000; i++)
        {
            result = base.pow(i);
            remainder = result.mod(prime);
            System.out.println(base + " pow " + i  + " = " + result + " ==> remainder = " + remainder);
        }

    }
}
