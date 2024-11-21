/*Compila i campi "Nome" e "Cognome" con le informazioni richieste
Nome: Fabio
Cognome: Accurso
Username: fa.accurso@studenti.unina.it
UserID: 12
Date: 21/11/2024
*/

import org.junit.Before;
import org.junit.After;
import org.junit.BeforeClass;
import org.junit.AfterClass;
import org.junit.Test;
import static org.junit.Assert.*;

import java.io.DataInputStream;
import java.security.Timestamp;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.TimeZone;
import javax.xml.crypto.Data;


public class TimeStampFabioAccursoRandoopEasy {
	private static long nowMillis;
	private static TimeStamp today, yesterday;



	@BeforeClass
	public static void setUpClass() {
		// Eseguito una volta prima dell'inizio dei test nella classe
		// Inizializza risorse condivise 
		// o esegui altre operazioni di setup
	}
				
	@AfterClass
	public static void tearDownClass() {
		// Eseguito una volta alla fine di tutti i test nella classe
		// Effettua la pulizia delle risorse condivise 
		// o esegui altre operazioni di teardown
	}
				
	@Before
	public void setUp() throws Exception {
		nowMillis = System.currentTimeMillis();		
		today = TimeStamp.getNtpTime(nowMillis);
		yesterday = TimeStamp.getNtpTime(nowMillis - 60 * 60 * 24 * 1000);
	}

				
	@After
	public void tearDown() {
		// Eseguito dopo ogni metodo di test
		// Pulizia delle risorse o ripristino dello stato iniziale
	}
			
	
	//Test -------------------------------------------------------------------------------------------------------------------------------------------------------------------
	//Test 1: test that checks that a given timestamp is correctly transformed in a String 
	@Test
	public void testToDateString() {
		TimeStamp timeStamp = new TimeStamp(904521000000L);
		String dateString = timeStamp.toDateString();
		assertEquals("Thu, Feb 07 2036 07:31:46.600", dateString);
	}		
	
	//Test 2: Utilizza il costruttore che prende in ingresso una stringa in formato esadecimale
	@Test
	public void testToDateString_2() {
		TimeStamp timeStamp = new TimeStamp("c1a089bd.fc904f6d");
		String dateString = timeStamp.toDateString();
		assertEquals("Tue, Dec 10 2002 16:41:49.987", dateString);
	}
	
	//Test 3: Utilizza il costruttore che prende in ingresso un oggetto della classe Data
	@Test
	public void testToDateString_3() {
		Date d = new Date(0); // 1 Gennaio 1970
		TimeStamp timeStamp = new TimeStamp(d);
		String dateString = timeStamp.toDateString();
		assertEquals("Thu, Jan 01 1970 01:00:00.000", dateString);
	}
		
	//Test 4: Costruttore con argomento data null -> verifica che venga di default impostata la data al 7 febbraio 2036
	@Test
	public void testToDateString_4() {
		Date d = new Date();
		d=null;
		TimeStamp timeStamp = new TimeStamp(d);
		String dateString = timeStamp.toDateString();
		assertEquals("Thu, Feb 07 2036 07:28:16.000", dateString);
	}
	
	//Test 5: Il metodo to string restituisce una stringa che contiene la rappresentazione esadecimale della data a cui e' impostato il timestamp
	@Test
	public void testToString() {
		TimeStamp timeStamp = new TimeStamp("c1a089bd.fc904f6d");
		String hex = timeStamp.toString();
		assertEquals("c1a089bd.fc904f6d",hex);
	}
	
	//Test 6: Metodo Equals con timeStamp uguali -> crea due timeStamp uguali e verifica che ne venga rilevata l'uguaglianza dal metodo 
	@Test
	public void testEquals_true() {
		assertTrue(today.equals(today));
	}
	
	//Test 7: Metodo Equals con timeStamp differenti ->  crea due timeStamp differenti e verifica che venga restituito false dal metodo equals
	@Test
	public void testEquals_false() {
		assertFalse(today.equals(yesterday));
	}
	
	//Test 8: Metodo Equals con oggetto differente 
	@Test
	public void testEquals_differentObj() {
		String k = "test";
		assertFalse(today.equals(k));
	}
	
	//Test 9: prova a restituire un oggetto timeStamp generato da una stringa nulla
	@Test
	public void testParseNtpString_Exception() {
		String s = null;
		assertThrows(NumberFormatException.class, ()-> today.parseNtpString(s));
	}
	
	//Test 10: restituisce un oggetto timeStamp da una stringa esadecimale senza il carattere '.'
	@Test
	public void testParseNtpString_noPoint() {
		TimeStamp timeStamp = today.parseNtpString("ff");
		String dateString = timeStamp.toDateString();
		assertEquals("Thu, Feb 07 2036 07:32:31.000", dateString);
	}
	
	//Test 11: restituisce un oggetto timeStamp da una stringa vuota
		@Test
		public void testParseNtpString_voidString() {
			TimeStamp timeStamp = today.parseNtpString("");
			String dateString = timeStamp.toDateString();
			assertEquals("Thu, Feb 07 2036 07:28:16.000", dateString);
		}
	
	
	//Test 12: verifica che CurrentTime restituisce il timeStamp della data attuale
	@Test
	public void testGetCurrentTime() {
		TimeStamp oggi = yesterday.getCurrentTime();
		assertTrue(today.equals(oggi));
	}
		
	//Test 13: Attraverso il costruttore chiama toNtpTime passandogli un oggetto Date > Feb-2036. 
	@Test
	public void testToNtpTime() {
		long milliseconds = 2096323200000L; //millisecondi dal 1 Gennaio 1970 al 1 marzo 2036
        Date data = new Date(milliseconds);
        TimeStamp t = new TimeStamp(data);	
        
        String s = t.toDateString();
        assertEquals("Fri, Jun 06 2036 02:00:00.000", s);
	}
	
	//Test 14: Utilizza il metodo toString ma con una stringa che permette di accedere al ciclo for del metodo privato appendHexString
	@Test
	public void testToString_small() {
		TimeStamp timeStamp = new TimeStamp("c1a089bd");
		String hex = timeStamp.toString();
		assertEquals("c1a089bd.00000000",hex);
	}
	
	//Test 15: HashCode
	@Test
	public void testHashCode() {
		TimeStamp timeStamp = new TimeStamp("c1a089bd.fc904f6d");
		int hash = timeStamp.hashCode();
		assertEquals(1026606800, hash);
	}
	
	//Test 16: ToUTCString
	@Test
	public void testToUTCString() {
		TimeStamp timeStamp = new TimeStamp("c1a089bd.fc904f6d");
		assertEquals("Tue, Dec 10 2002 15:41:49.987 UTC", timeStamp.toUTCString());
	}
	
	//Test 17: Per coprire condizioni if diverso da null in toDateString e toUTCString
	@Test
	public void testCoverNotNullinTo_UTC_Date_String() {
		TimeStamp timeStamp = new TimeStamp("c1a089bd.fc904f6d");
		timeStamp.toUTCString();
		timeStamp.toDateString();
		assertEquals("Tue, Dec 10 2002 15:41:49.987 UTC", timeStamp.toUTCString());
		assertEquals("Tue, Dec 10 2002 16:41:49.987", timeStamp.toDateString());
	}
	
	//Test 18: compareTo -> viene testata la comparazione prima di oggi con se stesso, poi di oggi con ieri e infine di ieri con oggi
	@Test
	public void testCompareTo() {
		assertEquals(0,today.compareTo(today)); 
		assertEquals(1,today.compareTo(yesterday));  
		assertEquals(-1,yesterday.compareTo(today));   
	}
	
	//Test 19: getSecond
	@Test
	public void testGetSecond() {
		TimeStamp timeStamp = new TimeStamp("c1a089bd.fc904f6d");
		assertEquals(3248523709L,timeStamp.getSeconds());
	}
	
	//Test 20: getFraction
	@Test
	public void testGetFraction() {
		TimeStamp timeStamp = new TimeStamp("c1a089bd.fc904f6d");
		assertEquals(4237315949L,timeStamp.getFraction());
	}
	
	//Test 21: getTime
	@Test
	public void testGetTime() {
		TimeStamp timeStamp = new TimeStamp("c1a089bd.fc904f6d");
		assertEquals(1039534909987L,timeStamp.getTime());
	}

}