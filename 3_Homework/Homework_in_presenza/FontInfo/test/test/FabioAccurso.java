package test;

import static org.junit.Assert.fail;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertThrows;
import static org.junit.Assert.assertTrue;

import java.awt.Font;
import ClassUnderTest.FontInfo;


public class FabioAccurso {

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	//---------------------------------------------------------------------------------
	
	//Test 1: verifica il corretto funzionamento del costruttore
	@Test
	public void testFontInfo() {
		Font font = new Font("Arial", Font.PLAIN, 10);
		FontInfo testFont = new FontInfo(font);
		assertNotNull(testFont);
	}
	
	
	//Test 2: Caso di test con font non specificato e chiamata a setFont() dandogli un font nullo
	@Test
	public void test() {
		FontInfo testFont = new FontInfo();
		assertThrows(IllegalArgumentException.class, ()-> testFont.setFont(null));
	}
	
	//Test 3: Test del costruttore con font nullo
	@Test
	public void testNullHashCode() {
		try{
			FontInfo testFont = new FontInfo(null);
		}catch(Exception e) {
			assertEquals(IllegalArgumentException.class, e.getClass());
		}
	}
	
	//Test 4: verifica il corretto funzionamento dell' override del metodo hashCode
	@Test
	public void testHashCode() {
		Font font = new Font("Arial", Font.PLAIN, 10);
		FontInfo testFont = new FontInfo(font);
		int hash = testFont.hashCode();
		//System.out.println(hash);
		assertEquals(-1484230232, hash);
	}
		
	//Test 5: per completare la copertura del codice di hashCode utilizzo font differenti -> Caso BOLD
	@Test
	public void testHashCode_Bold() {
		Font font = new Font("Arial",Font.BOLD, 11);
		FontInfo testFont = new FontInfo(font);
		int hash = testFont.hashCode();
		//System.out.println(hash);
		assertEquals(-1484235997, hash);
	}
	
	//Test 6: per completare la copertura del codice di hashCode utilizzo font differenti -> Caso ITALIC
	@Test
	public void testHashCode_Italic() {
		Font font = new Font("Arial",Font.ITALIC, 9);
		FontInfo testFont = new FontInfo(font);
		int hash = testFont.hashCode();
		//System.out.println(hash);
		assertEquals(-1484230419, hash);
	}
	
	//Test 7: verifica il corretto funzionamento di getFamily
	@Test
	public void testGetFamily() {
		Font font = new Font("Arial", Font.PLAIN, 10);
		FontInfo testFont = new FontInfo(font);
		assertEquals("Arial",testFont.getFamily());
	}
	

	//Test 8: verifica il corretto funzionamento di setFamily nel caso in cui venga passato null come valore da inserire
	@Test
	public void testSetFamily_nullFamilyName() {
		Font font = new Font("Arial",Font.PLAIN, 9);
		FontInfo testFont = new FontInfo(font);
		testFont.setFamily(null);
		assertEquals("Monospaced", testFont.getFamily());
	}
	
	//Test 9: verifica il corretto funzionamento del metodo clone
	@Test
	public void testClone() {
		Font font = new Font("Arial",Font.PLAIN, 9);
		FontInfo testFont = new FontInfo(font);
		assertEquals(testFont, testFont.clone());
	}
	
	//Test 10: verifica il corretto funzionamento di isBold ovvero nel caso di font Bold verifica se restituisce true
	@Test
	public void testIsBold() {
		Font font = new Font("Arial", Font.BOLD, 9);
		FontInfo testFont = new FontInfo(font);
		assertTrue(testFont.isBold());
	}
	
	//Test 11: verifica se setIsBold(true) imposta correttamente il font come Bold
	@Test
	public void testSetIsBold() {
		Font font = new Font("Arial", Font.ITALIC, 9);
		FontInfo testFont = new FontInfo(font);
		testFont.setIsBold(true);
		assertTrue(testFont.isBold());
	}

	//Test 12: verifica se il metodo isItalic, nel caso di font Italic, restituisca true
	@Test
	public void testIsItalic() {
		Font font = new Font("Arial", Font.ITALIC, 9);
		FontInfo testFont = new FontInfo(font);
		assertTrue(testFont.isItalic());
	}

	//Test 13: verifica se setIsItalic(true) imposta correttamente il font come Italic
	@Test
	public void testSetIsItalic() {
		Font font = new Font("Arial", Font.PLAIN, 9);
		FontInfo testFont = new FontInfo(font);
		testFont.setIsItalic(true);
		assertTrue(testFont.isItalic());
	}

	//Test 14: verifica il corretto funzionamento di getSize()
	@Test
	public void testGetSize() {
		Font font = new Font("Arial", Font.PLAIN, 9);
		FontInfo testFont = new FontInfo(font);
		assertEquals(9, testFont.getSize());
	}
	
	//Test 15: verifica se setSize imposta correttamente la dimensione del font
	@Test
	public void testSetSize() {
		Font font = new Font("Arial", Font.PLAIN, 9);
		FontInfo testFont = new FontInfo(font);
		testFont.setSize(10);
		assertEquals(10, testFont.getSize());
	}
	
	//Test 16:verifica se dato un font uguale il metodo riconosca l'uguaglianza del font
	@Test
	public void testDoesFontMatch() {
		Font font = new Font("Arial", Font.PLAIN, 9);
		FontInfo testFont = new FontInfo(font);
		Font font_2= new Font("Arial", Font.PLAIN, 9);
		assertTrue(testFont.doesFontMatch(font_2));
	}
	
	//Test 17:verifica se dato un font con familyName diverso il metodo riconosca la diseguaglianza
	@Test
	public void testDoesFontMatch_notSameFamily() {
		Font font = new Font("Arial", Font.PLAIN, 9);
		FontInfo testFont = new FontInfo(font);
		Font font_2= new Font("SansSerif", Font.PLAIN, 9);
		assertFalse(testFont.doesFontMatch(font_2));
	}
	
	//Test 18: verifica se dato un font con size diversa il metodo riconosca la diseguaglianza
	@Test
	public void testDoesFontMatch_notSameSize() {
		Font font = new Font("Arial", Font.PLAIN, 9);
		FontInfo testFont = new FontInfo(font);
		Font font_2= new Font("Arial", Font.PLAIN, 10);
		assertFalse(testFont.doesFontMatch(font_2));
	}
	
	//Test 19: verifica se dato un font con stile diverso il metodo riconosca la diseguaglianza
	@Test
	public void testDoesFontMatch_notSameStyle() {
		Font font = new Font("Arial", Font.PLAIN, 10);
		FontInfo testFont = new FontInfo(font);
		Font font_2= new Font("Arial", Font.ITALIC, 10);
		assertFalse(testFont.doesFontMatch(font_2));
	}
	
	//Test 20:verifica se dato un font uguale il metodo riconosca l'uguaglianza del font
	@Test
	public void testDoesFontMatch_nullFont() {
		Font font = new Font("Arial", Font.PLAIN, 9);
		FontInfo testFont = new FontInfo(font);
		assertFalse(testFont.doesFontMatch(null));
	}

	//Test 21: verifica se generate style restituisce l'intero corrispondente allo stile ( 0 -> Plain )
	@Test
	public void testGenerateStyle_Plain() {
		Font font = new Font("Arial", Font.PLAIN, 10);
		FontInfo testFont = new FontInfo(font);
		assertEquals(0, testFont.generateStyle());
	}
	
	//Test 22: verifica se generate style restituisce l'intero corrispondente allo stile ( 1 -> Bold )
	@Test
	public void testGenerateStyle_Bold() {
		Font font = new Font("Arial", Font.BOLD, 10);
		FontInfo testFont = new FontInfo(font);
		assertEquals(1, testFont.generateStyle());
	}
	
	//Test 23: verifica se generate style restituisce l'intero corrispondente allo stile ( 2 -> Italic )
	@Test
	public void testGenerateStyle_Italic() {
		Font font = new Font("Arial", Font.ITALIC, 10);
		FontInfo testFont = new FontInfo(font);
		assertEquals(2, testFont.generateStyle());
	}
	
	//Test 24: Verifica se viene restituito il font corretto con i valori di default
	@Test
	public void testCreateFont() {
		FontInfo testFont = new FontInfo();
		Font font = new Font("Monospaced", Font.PLAIN, 12);
		assertEquals(font, testFont.createFont());
	}
	
	//Test 25: verifica il corretto funzionamento del metodo toString, con font Bold
	@Test
	public void testToString_Bold() {
		Font font = new Font("Arial", Font.BOLD, 10);
		FontInfo testFont = new FontInfo(font);
		assertEquals("Arial, 10, bold", testFont.toString());
	}
	
	//Test 26: verifica il corretto funzionamento del metodo toString, con font Italic
	@Test
	public void testToString_Italic() {
		Font font = new Font("Arial", Font.ITALIC, 10);
		FontInfo testFont = new FontInfo(font);
		assertEquals("Arial, 10, italic", testFont.toString());
	}
	
	//Test 27: verifica il metodo equals chiamato con se stesso
	@Test
	public void testEqualsObject() {
		Font font = new Font("Arial", Font.PLAIN, 10);
		FontInfo testFont = new FontInfo(font);
		assertTrue(testFont.equals(testFont));
	}
	
	//Test 28: verifica il metodo equals e la restituzione di false quando il metodo è chiamato con null
	@Test
	public void testEqualsObject_null() {
		Font font = new Font("Arial", Font.PLAIN, 10);
		FontInfo testFont = new FontInfo(font);
		assertFalse(testFont.equals(null));
	}
	
	//Test 29: verifica il metodo equals e la restituzione di false quando il metodo è chiamato con un oggetto differente
	@Test
	public void testEqualsObject_differentObj() {
		Font font = new Font("Arial", Font.PLAIN, 10);
		FontInfo testFont = new FontInfo(font);
		String prova = "test";
		assertFalse(testFont.equals(prova));
	}
	
	//Test 30: verifica il metodo equals e la restituzione di false quando il metodo è chiamato con un altro FontInfo ma con Font differente
	@Test
	public void testEqualsObject_differentFamily() {
		Font font = new Font("Arial", Font.PLAIN, 10);
		FontInfo testFont = new FontInfo(font);
		Font font_2 = new Font("SansSerif", Font.PLAIN, 10);
		FontInfo testFont_2 = new FontInfo(font_2);
		
		assertFalse(testFont.equals(testFont_2));
	}
	
	//Test 31: verifica il metodo equals e la restituzione di false quando il metodo è chiamato con un altro FontInfo ma con Font differente
	@Test
	public void testEqualsObject_differentStyle_Bold() {
		Font font = new Font("Arial", Font.PLAIN, 10);
		FontInfo testFont = new FontInfo(font);
		Font font_2 = new Font("Arial", Font.BOLD, 10);
		FontInfo testFont_2 = new FontInfo(font_2);
		
		assertFalse(testFont.equals(testFont_2));
	}
	
	//Test 32: verifica il metodo equals e la restituzione di false quando il metodo è chiamato con un altro FontInfo ma con Font differente
	@Test
	public void testEqualsObject_differentStyle_Italic() {
		Font font = new Font("Arial", Font.PLAIN, 10);
		FontInfo testFont = new FontInfo(font);
		Font font_2 = new Font("Arial", Font.ITALIC, 10);
		FontInfo testFont_2 = new FontInfo(font_2);
		
		assertFalse(testFont.equals(testFont_2));
	}
	
	//Test 33: verifica il metodo equals e la restituzione di false quando il metodo è chiamato con un altro FontInfo ma con Font differente
	@Test
	public void testEqualsObject_differentSize() {
		Font font = new Font("Arial", Font.PLAIN, 10);
		FontInfo testFont = new FontInfo(font);
		Font font_2 = new Font("Arial", Font.PLAIN, 7);
		FontInfo testFont_2 = new FontInfo(font_2);
		
		assertFalse(testFont.equals(testFont_2));
	}
	
	
}
