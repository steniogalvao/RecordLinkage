package br.com.vsg.recordlinkage.utils;

import java.io.File;
import java.io.FileNotFoundException;
import java.lang.reflect.Method;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

import javax.transaction.Synchronization;

import org.springframework.util.StringUtils;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import info.debatty.java.stringsimilarity.NGram;

public class utils {

	/**
	 * @author steniogalvao
	 * 
	 *         This method receive a list of objects and the field name and
	 *         create a map grouping all object that have the same value in the
	 *         specified field
	 * 
	 * @param objects
	 *            List of objects
	 * @param field
	 *            name of the object field
	 * @return map with value of field and a list of objects who have the same
	 *         value in the field
	 **/

	public static Map<String, List<Object>> makeBlocks(List<Object> objects, String field) {
		try {
			Map<String, List<Object>> fieldMaps = new HashMap<String, List<Object>>();
			Method method;
			for (Object o : objects) {
				method = o.getClass().getMethod("get" + StringUtils.capitalize(field));
				List<Object> itens = new ArrayList<>();
				if (!fieldMaps.containsKey(method.invoke(o))) {
					itens.add(o);
					fieldMaps.put((String) method.invoke(o), itens);
				} else {
					itens.addAll(fieldMaps.get(method.invoke(o)));
					itens.add(o);
					fieldMaps.put((String) method.invoke(o), itens);
				}
			}
			return fieldMaps;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	/**
	 * @author steniogalvao
	 * 
	 *         This method search if a given word is present in a given text, it
	 *         breake the text in words and analyse word by word
	 * 
	 * @param word
	 *            word to be found
	 * @param text
	 *            text to search for word
	 * @param method
	 *            1 = Contains(Deterministic method) 2 = N-Gram(3)(Probabilistic
	 *            method)
	 * 
	 * @return don't know yet
	 **/
	public static boolean searchWord(String text1, String text2, int method) {
		text1 = text1.toLowerCase();
		text2 = text2.toLowerCase();
		HashSet<String> t1 = splitToHashSet(text1);
		HashSet<String> t2 = splitToHashSet(text2);
		double threshold = 0.95;
		double sumThreshold = 0;
		if (method == 1) {
			for (String word : t1) {
				/**
				 * deterministic method, if contain at least one word will be
				 * considerate match
				 */
				if (text2.contains(word))
					return true;
			}
			return false;
		}
		/** Probabilistic method **/
		if (method == 2) {
			for (String wordT1 : t1) {
				NGram nGram = new NGram(wordT1.length());
				for (String wordT2 : t2) {
					double result = nGram.distance(wordT1, wordT2);
					if (threshold <= result) {
						sumThreshold = sumThreshold + result;
						break;
					}
				}

			}
			if ((sumThreshold / t1.size()) >= threshold)
				return true;
			return false;
		}
		return false;

	}

	/**
	 * @author steniogalvao
	 * 
	 *         This method split a string in each space (" ") and return the
	 *         words in a hashset
	 * 
	 * @param string
	 *            the string to split
	 * @return HashSet string with the words splited, will not be repeated words
	 **/
	public static HashSet<String> splitToHashSet(String string) {
		String[] splited = string.split("[ -]");
		HashSet<String> result = new HashSet<String>();
		for (String s : splited) {
			result.add(s);
		}
		return result;

	}

	/**
	 * @author steniogalvao
	 * 
	 *         Method to read a file and extract Json objects present in each
	 *         line
	 * 
	 * @param file
	 *            The file to be read
	 * @param objectClass
	 *            The class of objects in the file
	 * @return Returns a list of objects
	 */
	public static <T> List<Object> readFile(File file, Class<T> objectClass) throws FileNotFoundException, Exception {
		List<Object> list = new ArrayList<>();
		GsonBuilder gsonBuilder = new GsonBuilder();
		Gson gson = gsonBuilder.create();
		Scanner sc = new Scanner(file);
		while (sc.hasNext()) {
			String line = sc.nextLine();
			Object it = gson.fromJson(line, objectClass);
			list.add(it);
		}
		sc.close();
		return list;

	}
}
