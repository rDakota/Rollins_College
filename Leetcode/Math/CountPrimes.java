public class CountPrimes {
	
    public static int countPrimes(int n) {
        boolean isComposite[] = new boolean[n];// isComposite[i]: If i is a composite number
        int primeCount = 0;
        // 2 and 3 are already prime
        for (int i = 2; i < n; i++) { 
            if (!isComposite[i]) { // if isComposite[i] false it means its a prime thus 
                primeCount++; 
                // sieves formula for finding composites
                if (i < Math.sqrt(n))
                    for (int j = i * i; j < n; j += i)  
                        isComposite[j] = true;// Mark j as a composite number
            }
        }
        return primeCount;
    }

	public static void main(String[] args) {
		System.out.println(countPrimes(10));   

	}

}
