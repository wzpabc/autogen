package com.tupperware.auto.commons.utils;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
/**
 * TestJavaDoc注释示例
 * @author upw023
 * @version v1
 */
public class TestJavaDoc {
	/**
	   * This method returns the square of num.
	   * This is a multiline description. You can use
	   * as many lines as you like.
	   * @param num The value to be squared.
	   * @return num squared.
	   */
	   public double square(double num) {
	      return num * num;
	   }
	   /**
	   * This method inputs a number from the user.
	   * @return The value input as a double.
	   * @exception IOException On input error.
	   * @see IOException
	   */
	   public double getNumber() throws IOException {
	      InputStreamReader isr = new InputStreamReader(System.in);
	      BufferedReader inData = new BufferedReader(isr);
	      String str;
	      str = inData.readLine();
	      return (new Double(str)).doubleValue();
	   }
	   /**
	   * This method demonstrates square().
	   * @param args Unused.
	   * @return Nothing.
	   * @exception IOException On input error.
	   * @see IOException
	   */
	public void get() throws IOException {
		System.out.println("Squared value is ");
	}
}
