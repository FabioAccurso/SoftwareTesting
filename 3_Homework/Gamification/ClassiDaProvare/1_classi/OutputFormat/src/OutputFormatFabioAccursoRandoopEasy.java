/*Compila i campi "Nome" e "Cognome" con le informazioni richieste
Nome: Fabio
Cognome: Accurso
Username: fa.accurso@studenti.unina.it
UserID: 12
Date: 21/11/2024
*/
import static org.junit.Assert.*;

import java.util.Calendar;
import java.util.concurrent.ThreadPoolExecutor.DiscardOldestPolicy;

import org.junit.Before;
import org.junit.After;
import org.junit.BeforeClass;
import org.junit.AfterClass;
import org.junit.Test;
import static org.junit.Assert.*;


public class OutputFormatFabioAccursoRandoopEasy {
	public static OutputFormat o;


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
	public void setUp() {
		// Eseguito prima di ogni metodo di test
		// Preparazione dei dati di input specifici per il test
      	
	}
				
	@After
	public void tearDown() {
		// Eseguito dopo ogni metodo di test
		// Pulizia delle risorse o ripristino dello stato iniziale
	}
				
	//Test -------------------------------------------------------------------------------------------------------------------------------
	//Test 1: Primo costruttore vuoto
	@Test
	public void testConstructor_1(){
		o = new OutputFormat();
		assertNotNull(o);
	}
	
	
	//Test 2: Secondo costruttore che prende in ingresso soltanto gli spazi di indentazione
	@Test
	public void testConstructor_2(){
		o = new OutputFormat("   ");
		assertNotNull(o);
	}
	
	//Test 3: Terzo costruttore che prende in ingresso spazi di indentazione e booleano per nuove righe
	@Test
	public void testConstructor_3(){
		o = new OutputFormat("   ", true);
		assertNotNull(o);
	}
	
	//Test 4: Quarto costruttore che prende in ingresso spazi di indentazione , booleano per nuove righe e codifica da utilizzare
	@Test
	public void testConstructor_4(){
		o = new OutputFormat("   ", true,"UTF-8");
		assertNotNull(o);
	}
	
	//Test 5: Set e Get lineSeparator
	@Test
	public void testSet_get_lineSeparator(){
		o = new OutputFormat();
		o.setLineSeparator("\n\n");
		assertEquals("\n\n",o.getLineSeparator());
	}
	
	//Test 6: Set e is newlines
	@Test
	public void testSet_is_newlines(){
		o = new OutputFormat();
		o.setNewlines(true);
		assertEquals(true,o.isNewlines());
	}
	
	//Test 7: Set e Get encoding
	@Test
	public void testSet_get_encoding(){
		o = new OutputFormat();
		o.setEncoding("ASCII");
		assertEquals("ASCII",o.getEncoding());
	}
	
	//Test 8: Set e Get encoding con set null e get che ritorna valore default (UTF-8) (not null)
	@Test
	public void testSet_get_encoding_2(){
		o = new OutputFormat();
		o.setEncoding(null);
		assertNotNull(o.getEncoding());
	}
	
	//Test 9: Set e Is OmitEncoding
	@Test
	public void testSet_is_omitEncoding(){
 		o = new OutputFormat();
 		o.setOmitEncoding(true);
 		assertEquals(true,o.isOmitEncoding());
	}
	
	//Test 10: Set e Is SuppressDeclaration
	@Test
	public void testSet_is_suppressDeclaration(){
 		o = new OutputFormat();
 		o.setSuppressDeclaration(true);
 		assertEquals(true,o.isSuppressDeclaration());
	}
	
	//Test 11: Set e Is NewLineAfterDeclaration
	@Test
	public void testSet_is_newLineAfterDeclaration(){
 		o = new OutputFormat();
 		o.setNewLineAfterDeclaration(false);
 		assertEquals(false,o.isNewLineAfterDeclaration());
	}
		
		
	//Test 12: Set e Is ExpandEmptyElements
	@Test
	public void testSet_is_ExpandEmptyElements(){
 		o = new OutputFormat();
 		o.setExpandEmptyElements(true);
 		assertEquals(true,o.isExpandEmptyElements());
	}

	//Test 13: Set e Is TrimText
	@Test
	public void testSet_is_TrimText(){
 		o = new OutputFormat();
 		o.setTrimText(true);
 		assertEquals(true,o.isTrimText());
	}
	
	//Test 14: Set e Is PadText
	@Test
	public void testSet_is_PadText(){
 		o = new OutputFormat();
 		o.setPadText(true);
 		assertEquals(true,o.isPadText());
	}
	
	//Test 15: Set e Get Indent -> String
	@Test
	public void testSet_get_Indent(){
 		o = new OutputFormat();
 		o.setIndent("   ");
 		assertEquals("   ",o.getIndent());
	}
	
	//Test 16: Set e Get Indent -> void indent
	@Test
	public void testSet_get_Indent_void(){
 		o = new OutputFormat();
 		o.setIndent("");
 		assertEquals(null,o.getIndent());
	}
	
	//Test 17: Set e Get Indent -> null indent
	@Test
	public void testSet_get_Indent_null(){
 		o = new OutputFormat();
 		o.setIndent(null);
 		assertEquals(null,o.getIndent());
	}
	
	
	//Test 18: Set e Get Indent -> True
	@Test
	public void testSet_get_Indent_boolTrue(){
 		o = new OutputFormat();
 		o.setIndent(true);
 		assertEquals(OutputFormat.STANDARD_INDENT,o.getIndent());
	}
	
	//Test 19: Set e Get Indent -> False
	@Test
	public void testSet_get_Indent_boolFalse(){
 		o = new OutputFormat();
 		o.setIndent(false);
 		assertEquals(null,o.getIndent());
	}
	
	//Test 20: Set e Get IndentSize -> Int
	@Test
	public void testSet_get_Indent_Int(){
 		o = new OutputFormat();
 		o.setIndentSize(2);
 		assertEquals("  ",o.getIndent());
	}
	
	//Test 21: Set e Is XHTML
	@Test
	public void testSet_is_XHTML(){
 		o = new OutputFormat();
 		o.setXHTML(true);
 		assertEquals(true,o.isXHTML());
	}
	
	//Test 22: Set e Get NewLineAfterNTags
	@Test
	public void testSet_get_NewLineAfterNTags(){
 		o = new OutputFormat();
 		o.setNewLineAfterNTags(4);
 		assertEquals(4,o.getNewLineAfterNTags());
	}
	
	
	
	/*
	//Test :
	@Test
	public void test(){
 		o = new OutputFormat();
	}
	  
	  
	 
	 */
	
	
	
	
	
}