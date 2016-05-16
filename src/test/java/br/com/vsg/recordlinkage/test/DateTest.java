package br.com.vsg.recordlinkage.test;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashSet;

import javax.validation.constraints.AssertFalse;

import org.junit.Test;

import junitx.framework.Assert;

public class DateTest {

	@Test
	public void getDate()  {

		String date = "2000-02-02T19:00:00.000-05:00";
		DateFormat df1 = new SimpleDateFormat("yyyy-MM-dd");
//		Date result1 = df1.parse(date);
//		System.out.println(result1);
		Assert.assertFalse(true);
	}

}
