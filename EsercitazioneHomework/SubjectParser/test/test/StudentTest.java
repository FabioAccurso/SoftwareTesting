package test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertThrows;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import ClassUnderTest.SubjectParser;

public class StudentTest {

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}
	
	//------------------------------------------------------------------------
	//Test base
	//------------------------------------------------------------------------
	
	//Esempio di test
	@Test
	public void testGetId() {
		// Caso di test 0: Stringa valida con identificatore numerico
        SubjectParser subjectParser = new SubjectParser("2023 sw testing (2/10)");
        // mi prendo l'identificatore numerico (sarà di tipo long)
        long id = subjectParser.getId();
        assertEquals(2023L, id);
	}
	
	@Test
	public void testSubjectParser() {
		SubjectParser subjectParser = new SubjectParser("2024 test valido (3/7)");
		assertNotNull(subjectParser);
	}

	@Test
	public void testGetThisRange() {
		SubjectParser subjectParser = new SubjectParser("2024 test valido (3/7)");
		int lower = subjectParser.getThisRange();
		assertEquals(3,lower);
	}

	@Test
	public void testGetUpperRange() {
		SubjectParser subjectParser = new SubjectParser("2024 test valido (3/7)");
		int upper = subjectParser.getUpperRange();
		assertEquals(7, upper);
	}

	@Test
	public void testGetRangeString() {
		SubjectParser subjectParser = new SubjectParser("2024 test valido (3/7)");
		String range = subjectParser.getRangeString();
		assertEquals("(3/7)", range);
	}

	@Test
	public void testGetTitle() {
		SubjectParser subjectParser = new SubjectParser("2024 test valido (3/7)");
		String titolo=subjectParser.getTitle();
		assertEquals("test valido ", titolo);
	}

	
	//-------------------------------------------------------
	// Focus su metodo getId
	//-------------------------------------------------------
	@Test
	public void testGetId_Catch() {
        SubjectParser subjectParser = new SubjectParser("One Invalid test (2/3)");
        long id=subjectParser.getId();
        assertEquals(-1, id);
	}
	
	//-------------------------------------------------------
	// Focus su metodo getThisRange
	//-------------------------------------------------------
	
	//In assenza di range alla fine della stringa mi aspetto la restituzione di 1, valore di default assegnato a LowerRange.
	@Test
	public void testGetThisRange_Null() {
		SubjectParser subjectParser = new SubjectParser("22 Invalid test (/)");
		int lower=subjectParser.getThisRange();
		assertEquals(1, lower);
	}
	
	//-------------------------------------------------------
	// Focus su metodo getUpperRange
	//-------------------------------------------------------
	
	//In assenza di range alla fine della stringa mi aspetto la restituzione di 1, valore di default assegnato a UpperRange.
	@Test
	public void testGetUpperRange_Null() {
		SubjectParser subjectParser = new SubjectParser("22 Invalid test (/)");
		int upper=subjectParser.getUpperRange();
		assertEquals(1, upper);
	}
	
	@Test
	public void testGetUpperRange_sq() {
		SubjectParser subjectParser = new SubjectParser("37 test [3/9]");
		int upper=subjectParser.getUpperRange();
		assertEquals(9, upper);
	}
	
	
	//-------------------------------------------------------
	// Focus su metodo getRangeString
	//-------------------------------------------------------
	@Test
	public void testGetRangeString_NotNull() {
		SubjectParser subjectParser = new SubjectParser("2024 test valido (3/7)");
		subjectParser.getRangeString();
		String range=subjectParser.getRangeString();
		assertEquals("(3/7)", range);
	}
	
	//-------------------------------------------------------
	// Focus su getTitle
	//-------------------------------------------------------
	@Test
	public void testGetTitle_sq() {
		SubjectParser subjectParser = new SubjectParser("2024 test [3/5");
		String title=subjectParser.getTitle();
		assertEquals("test ", title);
	}
	
	
	
//	SUPPONGO CI SIA UN ECCEZIONE NON TESTABILE	SIA IN getUpperRange che in getThisRange
	
	
}
