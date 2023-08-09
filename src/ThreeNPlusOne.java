public class ThreeNPlusOne
{
    public static void main(String[] args)
    {
        int count;
        int number;

        for (int i = 1; i < 1000; i++)
        {
            count = 0;
            number = i;
            while(number!=1)
            {
                if (number%2 == 1)
                {
                    number = (3*number) + 1;
                    System.out.print(number + " ");
                }
                else
                {
                    number = number/2;
                    System.out.print(number + " ");
                }
                count++;
            }
            System.out.println();
            System.out.println(i + " --> " + count);
            System.out.println();
        }
    }
}
