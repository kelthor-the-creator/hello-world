package solutions.lab2;

import java.math.BigInteger;
import java.util.HashMap;
import java.util.Map;

public class FindProbablePrimes {

	/* Calculate next probable primes sequentially */

	public static Map<BigInteger,BigInteger >sequential(Iterable<BigInteger> arguments) {
		Map<BigInteger,BigInteger> result = new HashMap<>(); 
		for (BigInteger argument : arguments) {
			result.put(argument,argument.nextProbablePrime());
		}
		return result;
	}

	/* Calculate next probable primes using several worker threads */

	public static  Map<BigInteger,BigInteger> parallel(Iterable<BigInteger> arguments) {
		return  solutions.lab2.Parallel.parallelMapFun(
				BigInteger::nextProbablePrime, arguments);
	}

}