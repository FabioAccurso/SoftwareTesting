package ClassTesting;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertThrows;
import static org.junit.Assert.assertTrue;
import static org.junit.Assume.*;

import java.util.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class IteratorTest {
    
   private List<String> list;          // test fixture
   private Iterator<String> itr;       // test fixture

   @Before
   public void setUp()         // set up test fixture
   {
       list = new ArrayList<String>();
       
       list.add("cat");
       list.add("dog");

       itr = list.iterator();

       //assume
       assumeNotNull(list);
       assumeNotNull(itr);
   }

   @After
   public void tearDown()
   {      
       list=null;
       itr=null;
       
       //assume
       assumeTrue(list==null);
       assumeTrue(itr==null);   
   }
  
   //---------------------------------------------------------------------------------
   //								hasNext()
   //---------------------------------------------------------------------------------
   
// Test 1 hasNext: verifica l'esistenza di un prossimo elemento
   @Test 
   public void hasNext_test1_exist(){
       assertTrue("Non c'e' il prossimo elemento",itr.hasNext());
   }
   
   // Test 2 hasNext: verifica che non c'è un prossimo elemento
   @Test
   public void hasNext_test2_notExist(){
       itr.next();
       itr.next();
       assertFalse("C'è il prossimo elemento", itr.hasNext());
   }
   
   // Test 3 hasNext: verifica che l'iterator sia nullo
   @Test
   public void hasNext_test3_nullIterator(){
       itr=null;
       assertThrows(NullPointerException.class, () -> itr.hasNext());
   }
   
   // Test 4 hasNext: verifica che chiamate ripetute ad hasNext(), senza chiamare next(), restituiscano sempre True
   @Test
   public void hasNext_test4_repeatedCall(){
	   for(int i=0;i<4;i++) {
		   assertTrue("Non c'e' il prossimo elemento",itr.hasNext());
	   }
   }
   
   
   //---------------------------------------------------------------------------------
   //									next()
   //---------------------------------------------------------------------------------
   
   // Test 1 next: legge il primo elemento della lista
   @Test
   public void next_test1_readFirst(){
	   assertEquals("cat",itr.next());
   }
   
   // Test 2 next: legge oltre l'ultimo elemento
   @Test
   public void next_test2_readBeyond(){
	   itr.next();
	   itr.next();
	   assertThrows(NoSuchElementException.class,()->itr.next());
   }
   
   // Test 3 next: iteratore nullo
   @Test
   public void next_test3_nullIterator(){
	   itr=null;
	   assertThrows(NullPointerException.class, () -> itr.next());
   }
   
   //---------------------------------------------------------------------------------
   //									remove()
   //---------------------------------------------------------------------------------
   
   // Test 1 remove: rimuove il primo elemento dalla lista
   @Test
   public void remove_test1_removeFirst(){
	   String first = itr.next();   //first="cat";
	   itr.remove();	//rimuove l'elemento selezionato dalla next precedente
	   
	   //verifichiamo che il primo elemento della lista, a seguito della rimozione, non corrisponde a quello che era il primo elemento della lista prima della rimozione
	   assertNotEquals("Elemento non rimosso", first, list.get(0));
	   assertEquals("Ci sono ancora 2 elementi nella lista", 1 , list.size());
   }
   
   // Test 2 remove: rimuove l'ultimo elemento
   @Test
   public void remove_test2_removeLast(){
	   itr.next();
	   String last = itr.next();	//last="dog";
	   itr.remove();
	   
	   //verifichiamo che l'ultimo elemento della lista, a seguito della rimozione, non corrisponde a quello che era l'ultimo elemento della lista prima della rimozione
	   assertNotEquals("Elemento non rimosso", last, list.get(list.size()-1));
	   assertEquals("Ci sono ancora 2 elementi nella lista", 1 , list.size());
   }
   
   // Test 3 remove: cerca di rimuovere un elemento senza pero' selezionarlo
   @Test
   public void remove_test3_removeWithoutSelecting(){
	   assertThrows(IllegalStateException.class, ()->itr.remove());
   }
   
   // Test 4 remove: iteratore nullo
   @Test
   public void remove_test4_nullIterator(){
	   itr=null;
	   assertThrows(NullPointerException.class, () -> itr.remove());
   }
   
   // Test 5 remove: verifica la corretta rimozione di tutti gli elementi da una lista
   @Test
   public void remove_test5_removeAll(){
	   itr.next();
	   itr.remove();
	   itr.next();
	   itr.remove();
	   assertEquals("Ci sono ancora elementi nella lista", 0 , list.size());
   }
   
   // Test 6 remove: cerca di rimuovere due volte lo stesso elemento
   @Test
   public void remove_test6_removeAgain(){
	   itr.next();
	   itr.remove();
	   assertThrows(IllegalStateException.class, ()->itr.remove());
   }
   
   // Test 7 remove: cerca di rimuovere da una lista posta come unmodifiable
   @Test
   public void remove_test7_unmodifiableList(){
	   // Rendo la lista non modificabile (creando una vista non modificabile di essa)
       List<String> unmodifiableList = Collections.unmodifiableList(list);
       itr = unmodifiableList.iterator();
	   itr.next();
	   assertThrows(UnsupportedOperationException.class, ()->itr.remove());	   
   }

   // Test 8 remove: controlla il corretto funzionamento di hasNext() e next() dopo aver eseguito una remove()
   @Test
   public void remove_test8_checkOtherFunctions(){
	   itr.next();
	   itr.remove();
	   assertTrue("Prossimo elemento non trovato",itr.hasNext());
	   assertEquals("Prossimo elemento sbagliato","dog",itr.next());
   }

   // Test 9 remove: controlla che la dimensione della lista, dopo una rimozione, sia diminuita di 1
   @Test
   public void remove_test9_checkSize(){
	   int sizeBefore=list.size();
	   itr.next();
	   itr.remove();
	   assertEquals("Dimensione della lista non diminuita",sizeBefore-1,list.size());
   }
   
   
   
}