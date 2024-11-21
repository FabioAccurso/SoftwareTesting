package ClassUnderTest;

/*Compila i campi "Nome" e "Cognome" con le informazioni richieste
Nome: Fabio
Cognome: Accurso
Username: fa.accurso@studenti.unina.it
UserID: 12
Date: 20/11/2024
*/


import org.junit.Before;
import org.junit.After;
import org.junit.BeforeClass;
import org.junit.AfterClass;
import org.junit.Test;
import static org.junit.Assert.*;


public class HSLColorFabioAccursoRandoopEasy {
	public static HSLColor c; 	
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
		c = new HSLColor(); 
	}
				
	@After
	public void tearDown() {
		// Eseguito dopo ogni metodo di test
		// Pulizia delle risorse o ripristino dello stato iniziale
	}
				
	
	///Test ------------------------------------------------------------------------------
	//Test 1:
	// color is set perfectly to red, thus Hue is 0,
    // saturation is maximum(255) and luminescence is intermediate(128)
    // as computed by the constructor HSLColor()
	@Test
	public void testInitHSLbyRGB() {
		c.initHSLbyRGB(255, 0, 0);
		assertEquals(255, c.getRed());
	    assertEquals(0, c.getGreen());
	    assertEquals(0, c.getBlue());
	    assertEquals(0, c.getHue());
	    assertEquals(255, c.getSaturation());
	    assertEquals(128, c.getLuminence());
	}
  
	//Test 2:
	// percent is negative, thus blend operate as a set for values of
	// red, green, blue
	@Test
	public void testBlend() {
		int valueOfRed = 10;
		int valueOfGreen = 10;
		int valueOfBlue = 10;
		float percent = -2f;
			
		c.blend(valueOfRed, valueOfGreen, valueOfBlue, percent);		
		assertNotEquals(valueOfRed, c.getRed());
		assertNotEquals(valueOfGreen, c.getGreen());
		assertNotEquals(valueOfBlue, c.getBlue());
	}

	//---------------------------------------------------------------------------------------------------
	//Test 3: InitHSLbyRGB -> Cmax==Cmin , ovvero tutti i valori RGB uguali tra loro. Questo dovrebbe comportare che pHue=170 (valore di default Undefined)
	@Test
	public void testInitHSLbyRGB_pHueUndefined() {	
		c.initHSLbyRGB(125, 125, 125);
	    assertEquals(170, c.getHue());
	}
	
	//Test 4: InitHSLbyRGB -> pLum<(HSLMAX/2) , questo comporta il calcolo della saturazione usando pero come denominatore cPlus (ovvero la somma di cMax e cMin)
	@Test
	public void testInitHSLbyRGB_pSatDifferent() {
		c.initHSLbyRGB(1, 2, 3);
	    assertEquals(127, c.getSaturation());
	}
	
	//Test 5: InitHSLbyRGB -> CMax=G, ovvero cMax corrisponde al valore assegnato al green
	@Test
	public void testInitHSLbyRGB_CMaxG() {	
		c.initHSLbyRGB(1, 5, 3);
	    assertEquals(5, c.getGreen());
	}
	
	//Test 6:InitHSLbyRGB -> pHue < 0
	@Test
	public void testInitHSLbyRGB_pHueNegative() {
		c.initHSLbyRGB(250, 5, 150);
		assertEquals(230,c.getHue());//ovvero [pHue = -25+255=230]
	}
	
	//Test 7:InitRGBbyHSL -> S=0 , ciò comporta che cRed=L
	@Test
	public void testInitRGBbyHSL_Szero() {	
		c.initRGBbyHSL(120, 0, 100);
		assertEquals(100, c.getRed());
	}
	
	//Test 8:InitRGBbyHSL -> S!=0
	@Test
	public void testInitRGBbyHSL_SNotZero() {
		c.initRGBbyHSL(3, 2, 1);
		assertEquals(1, c.getRed());
	}
	
	//Test 9:InitRGBbyHSL -> OutOfRange 1
	@Test
	public void testInitRGBbyHSL_OutOfRange_1() {
		c.initRGBbyHSL(400, 400, 400);
		assertEquals(255, c.getRed());
	}
	
	//Test 10:InitRGBbyHSL -> OutOfRange 2
	@Test
	public void testInitRGBbyHSL_testInitRGBbyHSL_OutOfRange_2() {
		c.initRGBbyHSL(256, 256, 400);
		assertEquals(255, c.getBlue());
	}
	
	//Test 11: SetHue -> valore negativo
	@Test
	public void testSetHue() {	
		c.setHue(-1);
		assertEquals(254,c.getHue());
	}
	
	//Test 12: SetHue -> valore maggiore
	@Test
	public void testSetHue_2() {
		c.setHue(256);
		assertEquals(1,c.getHue());
	}
	
	//Test 13: SetSaturation -> valore negativo
	@Test
	public void testSetSaturation_1() {	
		c.setSaturation(300);
		assertEquals(255,c.getSaturation());
	}
	
	//Test 14: SetSaturation -> valore maggiore
	@Test
	public void testSetSaturation_2() {	
		c.setSaturation(-1);
		assertEquals(0,c.getSaturation());
	}
	
	//Test 15: SetSaturation -> valore accettabile
	@Test
	public void testSetSaturation_3() {
		c.setSaturation(10);
		assertEquals(10,c.getSaturation());
	}
	
	//Test 16: setLuminence -> valore negativo
		@Test
	public void testSetLuminence_1() {
		c.setLuminence(300);
		assertEquals(255,c.getLuminence());
	}
	
	//Test 17: setLuminence -> valore maggiore
	@Test
	public void testSetLuminence_2() {
		c.setLuminence(-1);
		assertEquals(0,c.getLuminence());
	}
	
	//Test 18: setLuminence -> valore accettabile
	@Test
	public void testSetLuminence_3() {
		c.setLuminence(10);
		assertEquals(10,c.getLuminence());
	}
	
	//Test 19: reverseColor -> Hue sarà pari a (pHue+255/2)
	@Test
	public void testReverseColor() {
		c.reverseColor();
		assertEquals(127,c.getHue());
	}
	
	//Test 20: brighten -> fPercent=0 , Luminence resta 0 (default)
	@Test
	public void testBrighten_zero() {
		c.brighten(0);
		assertEquals(0,c.getLuminence());
	}
	
	//Test 21: brighten -> fPercent<0 e L già impostata ad un valore diverso da quello di default
	@Test
	public void testBrighten_Lmin() {	
		c.setLuminence(10);
		c.brighten(-1);
		assertEquals(0,c.getLuminence());
	}
	
	//Test 21: brighten -> fPercent>255 e L già impostata ad un valore diverso da quello di default
	@Test
	public void testBrighten_Lmagg() {	
		c.setLuminence(10);
		c.brighten(300);
		assertEquals(255,c.getLuminence());
	}
		
	//Test 22: Blend -> fPercent>=1
	@Test
	public void testBlend_positivefPercent() {	
		c.blend(10, 20, 30, 2);		
		assertEquals(10, c.getRed());
		assertEquals(20, c.getGreen());
		assertEquals(30, c.getBlue());
	}
	
	//Test 23: Blend -> fPercent voglio che sia >=0 che <=1, ovvero 0.5-> RGB saranno la metà
	@Test
	public void testBlend_2() {	
		c.blend(10, 20, 30, 0.5f);		
		assertEquals(5, c.getRed());
		assertEquals(10, c.getGreen());
		assertEquals(15, c.getBlue());
	}
		
}

						