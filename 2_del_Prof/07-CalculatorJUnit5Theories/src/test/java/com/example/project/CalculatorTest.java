package com.example.project;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.After;
import org.junit.Before;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import org.junit.experimental.theories.DataPoints;
import org.junit.experimental.theories.FromDataPoints;
import org.junit.experimental.theories.Theories;
import org.junit.experimental.theories.Theory;
import org.junit.runner.RunWith;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.junit.Assume.assumeFalse;
import static org.junit.Assume.assumeNotNull;
import static org.junit.Assume.assumeThat;
import static org.junit.Assume.assumeTrue;
 
@RunWith(Theories.class)
public class CalculatorTest {

	private Calculator c=null;

	@Before
	public void setUp(){
		c=new Calculator();
		assumeNotNull(c);
	}

	@After
	public void tearDown(){
		c=null;		
		assumeTrue(c==null);
	}

  @DataPoints("num")
  public static int[] numeratore() {
       return new int[]{
                        -100,12,17,-3,-15,88};
  }
 
  @DataPoints("den")
  public static int[] denominatore() {
      return new int[]{
              4,-9,-12,123,88,1};
  }
  

  @Theory
  public void naturali(@FromDataPoints("num") Integer n, @FromDataPoints("den") Integer d) {
	  assumeTrue(n>0 && d>0);
	  
	  //System.out.println("Test of "+n+" / "+d);
	  double res=(double)n/d;
	  assertEquals(res,c.division(n, d),0.001);
	  assertTrue(res>0);
  }

  @Theory
  public void segniAlternati(@FromDataPoints("num") Integer n, @FromDataPoints("den") Integer d) {
	  assumeTrue(n>0 && d<0 || n<0 && d>0);
	  
	  System.out.println("Test of "+n+" / "+d);
	  double res=(double)n/d;
	  assertEquals(res,c.division(n, d),0.001);
	  assertTrue(res<0);
  }

}
  
