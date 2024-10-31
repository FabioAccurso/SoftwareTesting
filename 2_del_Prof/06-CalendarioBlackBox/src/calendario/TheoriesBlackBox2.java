package calendario;

import org.junit.experimental.theories.DataPoints;
import org.junit.experimental.theories.FromDataPoints;
import org.junit.experimental.theories.Theories;
import org.junit.experimental.theories.Theory;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import static org.junit.Assume.assumeFalse;
import static org.junit.Assume.assumeThat;
import static org.junit.Assume.assumeTrue;
 
@RunWith(Theories.class)
public class TheoriesBlackBox2 {
 
  @DataPoints("giorni")
  public static int[] giorni() {
       return new int[]{
    		   -1,0,1,14,15,16,28,29,30,31,32};
  }
 
  @DataPoints("mesi")
  public static String[] mesi() {
       return new String[]{
           "gennaio", "febbraio", "marzo", "aprile", "maggio", "giugno", "luglio", "agosto", "settembre", "ottobre", "novembre", "dicembre","brumaio"};
  }
  

  @DataPoints("anni")
  public static int[] anni() {
       return new int[]{
    		   -100,1492,1582,1583,1900,2000,2020};
  }
 
  
  @Theory
  public void allDays(@FromDataPoints("giorni") Integer a, @FromDataPoints("mesi") String b, @FromDataPoints("anni") Integer c) {
	  System.out.println(a+"/"+b+"/"+c+" : "+Calendario.calend(a,b,c)+" - "+Calendario.calend(a, b, c).contentEquals("Errore"));
	  //assertFalse(Calendario.calend(a, b, c).contentEquals("Errore"));
  }

  @Test
  public void testClasse() {
	  Calendario c=new Calendario();
	  assertNotNull(c);
  }

private boolean bisestile(Integer c) {
	return ((c%4==0 && !(c%100==0)) || (c%400==0));
}
}
