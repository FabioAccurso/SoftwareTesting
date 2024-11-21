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
				
	//Test -------------------------------------------------------------------------------------------------------------------------------------------------------------------
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
	
	//Test 23: Set e Get AttributeQuoteCharacter -> \
	@Test
	public void testSet_get_AttributeQuoteCharacter_1(){
 		o = new OutputFormat();
 		o.setAttributeQuoteCharacter('\'');
 		assertEquals('\'',o.getAttributeQuoteCharacter());
	}
	
	//Test 24: Set e Get AttributeQuoteCharacter -> "
	@Test
	public void testSet_get_AttributeQuoteCharacter_2(){
 		o = new OutputFormat();
 		o.setAttributeQuoteCharacter('"');
 		assertEquals('"',o.getAttributeQuoteCharacter());
	}
	
	//Test 25: Set e Get AttributeQuoteCharacter -> IllegalArgumentException causata da carattere non valido
	@Test
	public void testSet_get_AttributeQuoteCharacter_3(){
 		o = new OutputFormat();
 		assertThrows(IllegalArgumentException.class, ()->o.setAttributeQuoteCharacter('a'));
	}
		
	//Test 26: parseOptions -> array di stringhe per entrare ad ogni iterazione in un differente ramo if/else if/else, fino a visitarli tutti. Tutte le funzioni che verranno chiamate nei vari rami if sono gia' state testate.
	//Avrei potenzialmente potuto coprire tantissime linee di codice di set e get soltanto con questo caso di test, ma ho preferito testare singolarmente ciascun metodo.
	@Test
	public void testparseOptions_allIf(){
 		o = new OutputFormat();
 		String[] args = {"-suppressDeclaration","-omitEncoding","-indent","  ","-indentSize","2","-expandEmpty","-encoding","UTF-8","-newlines","-lineSeparator","\n","-trimText","-padText","-xhtml","else"};
 		int returnValue = o.parseOptions(args, 0);
 		assertTrue(o.isSuppressDeclaration());
 		assertTrue(o.isOmitEncoding());
 		assertEquals("  ",o.getIndent());
 		assertTrue(o.isExpandEmptyElements());
 		assertEquals("UTF-8", o.getEncoding());
 		assertTrue(o.isNewlines());
 		assertEquals("\n", o.getLineSeparator());
 		assertTrue(o.isTrimText());
 		assertTrue(o.isPadText());
 		assertTrue(o.isXHTML());	
 		
 		//ovvero controllo che l'indice del for del metodo parseOptions ritornato corrisponda alla dimensione dell'array passato -1 (ovvero la posizione della stringa non riconosciuta dagli if nel ciclo for)
 		assertEquals(15,returnValue);
	}
	
	//Test 27: parseOptions -> i > size dell'array, in questo modo non si entra nel for e viene direttamente eseguita la return della i passata per parametro
	@Test
	public void testparseOptions_2(){
		o = new OutputFormat();
		String[] args = {"a","b","c"};
		int returnValue = o.parseOptions(args, 5);
		
		assertEquals(5, returnValue);
	}
	
	//Test 28: createPrettyPrint -> restituisce un nuovo oggetto OutputFormat con determinate opzioni di default
	@Test
	public void testCreatePrettyPrint(){
 		o = new OutputFormat();
 		OutputFormat nuovo = o.createPrettyPrint();
 		assertEquals("  ", nuovo.getIndent());
 		assertTrue(nuovo.isNewlines());
 		assertTrue(nuovo.isTrimText());
 		assertTrue(nuovo.isPadText());
	}
	
	//Test 29: createCompactFormat -> restituisce un nuovo oggetto OutputFormat con determinate opzioni di default
	@Test
	public void testCreateCompactFormat(){
 		o = new OutputFormat();
 		OutputFormat nuovo = o.createCompactFormat();
 		assertEquals(null, nuovo.getIndent());
 		assertFalse(nuovo.isNewlines());
 		assertTrue(nuovo.isTrimText());
	}
	
}