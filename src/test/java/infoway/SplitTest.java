package infoway;

import java.util.HashSet;

import javax.validation.constraints.AssertFalse;

import org.junit.Test;

import junitx.framework.Assert;

public class SplitTest {

	@Test
	public void splitToHashSet() {
		String string = "Sony Cybershot DSC-T700 10MP Digital Camera with 4x Optical Zoom with Super Steady Shot Image Stabilization (Pink)";
		String[] splited = string.split("[ -]");
		HashSet<String> result = new HashSet<String>();
		for (String string2 : splited) {
			result.add(string2);
		}

		for (String string2 : result) {
			if (string2.contains("-"))
				Assert.assertFalse(true);
		}
	}

}
