import java.util.*;

class PrimeFactors
{
    public static void main(String[] args)
    {
        Map<Integer, List<Integer>> primeFactorsMap = new HashMap<>();
        Map<Integer, Integer> primeFactorsSize = new TreeMap<>();
        Map<Integer, Integer> primeNumberMap = new TreeMap<>();
        Map<Integer, Integer> primeNumberCountMap = new TreeMap<>();

        for (int i = 2; i < 100000; i++) {
            List<Integer> primeFactors = primeFactors(i);
            primeFactorsMap.put(i, primeFactors);

            if(!primeFactorsSize.containsKey(primeFactors.size()))
                primeFactorsSize.put(primeFactors.size(),0);

            primeFactorsSize.put(primeFactors.size(),primeFactorsSize.get(primeFactors.size())+1);

            for (int factor : primeFactors) {
                primeNumberMap.put(factor, primeNumberMap.getOrDefault(factor, 0) + 1);
            }
        }

        primeFactorsMap.forEach((a,b) -> {
            System.out.println(a + " --> " + b);
        });

        System.out.println();System.out.println("=============================================================");System.out.println();

        primeFactorsSize.forEach((a,b) -> {
            System.out.println("Prime Factors of size " + a + " --> " + b);
        });

        System.out.println();System.out.println("=============================================================");System.out.println();

        System.out.println("Few Numbers that has more Prime Factors");
        primeFactorsMap.forEach((a,b) -> {
            if(b.size()>(primeFactorsSize.size()-4))
                System.out.println(a + " --> " + b + " --> size = " +b.size());
        });

        System.out.println();System.out.println("=============================================================");System.out.println();

        System.out.println("Total Numbers --> " + (primeFactorsMap.size()+2));

        System.out.println();System.out.println("=============================================================");System.out.println();

        primeNumberMap.forEach((a,b) -> {
            System.out.println("Prime Number " + a + " repeated --> " + b + " times in Prime Factors List");
        });

        System.out.println();System.out.println("=============================================================");System.out.println();

        int primeNumberCount = 0;
        for (int count : primeNumberMap.values()) {
            primeNumberCount += count;
            primeNumberCountMap.put(count, primeNumberCountMap.getOrDefault(count, 0) + 1);
        }

        System.out.println("Prime Numbers Map Size --> " + primeNumberMap.size());
        System.out.println("Adding all Prime Number Count --> " + primeNumberCount);

        System.out.println();System.out.println("=============================================================");System.out.println();

        primeNumberCountMap.forEach((a,b) -> {
            System.out.println("Prime Number that repeated " + a + " time --> " + b);
        });

        System.out.println();System.out.println("=============================================================");System.out.println();

        int addPrimeNumberCount = 0;
        int multiplyPrimeNumberCount = 0;
        for (Map.Entry<Integer, Integer> entry : primeNumberCountMap.entrySet()) {
            int count = entry.getKey();
            int frequency = entry.getValue();
            addPrimeNumberCount += frequency;
            multiplyPrimeNumberCount += count * frequency;

        }

        System.out.println("Prime Number Count Map Size --> " + primeNumberCountMap.size());
        System.out.println("Number of prime numbers --> " + addPrimeNumberCount);
        System.out.println("Adding all Prime Number Count --> " + multiplyPrimeNumberCount);

        System.out.println();System.out.println("=============================================================");System.out.println();

    }

    public static List<Integer> primeFactors(int n)
    {
        List<Integer> factors = new ArrayList<>();

        while (n % 2 == 0) {
            factors.add(2);
            n /= 2;
        }

        for (int i = 3; i <= Math.sqrt(n); i += 2) {
            while (n % i == 0) {
                factors.add(i);
                n /= i;
            }
        }

        if (n > 2) {
            factors.add(n);
        }

        return factors;
    }
}
