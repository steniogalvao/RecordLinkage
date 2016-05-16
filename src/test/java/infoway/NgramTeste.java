package infoway;

import org.junit.Test;

import info.debatty.java.stringsimilarity.NGram;
import junitx.framework.Assert;

public class NgramTeste {

	@Test
	public void ngramTest() {
		NGram nGram = new NGram(3);
		double result = nGram.distance("DSC-T77", "DSC-D700");
		System.out.println(result);
		if (result > 0.85) {
			Assert.assertFalse(false);
		} else {
			Assert.assertFalse(true);

		}
	}

	@Test
	public void ngramSplitTest() {
		
		
		String a = "ES70";
		String b = "ES75";
		String[] splitA = a.split("[ -]");
		String[] splitB = b.split("[ -]");
		double result = 0;
		for (String stringA : splitA) {
			NGram nGram = new NGram(stringA.length());
			for (String stringB : splitB) {
				if(nGram.distance(stringA, stringB)>0.9){
				result = result + nGram.distance(stringA, stringB);
				break;
				}
			}
		}
		System.out.println("result: " + result);
		System.out.println("result/size: " + result / splitA.length);

		if (result / splitA.length > 0.85) {
			Assert.assertFalse(false);
		} else {
			Assert.assertFalse(true);

		}
	}

}
