package Source;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SplitProblem 
{
	
	 private int calculateSum(int[] array) //aceasta metoda calculeaza suma elementelor unui vector
	 {
		 // se initializeza o variabila in care se va stoca suma
	        int sum = 0;
	        // se parcurge sirul de elemente
	        for (int i : array) 
	        {
	        	// se parcurge fiecare element al sirului si se adauga la sum
	            sum += i;
	        }
	        // se returneaza suma calculata, adica suna elementelor din sirul array
	        return sum;
	 }
	 
	 // metoda verifyEqualLists verifica daca doua multimi au media aritmetica egala (mai precis, verifica daca doua fractii sunt egale)
	 private boolean verifyEqualLists(int sumA, int countA, int sumB, int countB) 
	 {
		 // se verifica daca numarul elementelor celor doua multimi este mai mare ca 0 si daca exista egalitate intre countA * sumB si countB * sumA
	     if ((countA != 0 && countB != 0) && (countA * sumB == countB * sumA))
	     {
	    	 // se returneaza true in cazul in care au aceeasi medie aritmetica
	    	 return true;
	     }
	     // se returneaza false in cazul in care au medii aritmetice diferite
		 return false;
	 }
	 
	public boolean splitArray(int[] array) 
	{
		// se stocheaza intr-o variabila suma elementelor vectorului trimis ca parametru 
        int sum = calculateSum(array);
        
        // se declara un map cu ajutorul caruia se va imparti vectorul trimis ca parametru
        Map<Integer, List<Integer>> splitMap = new HashMap<Integer, List<Integer>>();
        
        // se initializeaza o lista care reprezinta valoarea map-ului
        List<Integer> list = new ArrayList<Integer>();
        
        // se adauga 0 in lista 
        list.add(0);
        
        // se pune in map la cheia 0, lista 
        splitMap.put(0, list);
        
        // se parcurge sirul dat ca parametru
        for (int i = 0; i < array.length; i++) 
        {
        	// parcurgere de la suma totala a elementelor pana cand contorul este mai mare sau egal decat elementele vectorului
            for (int j = sum; j >= array[i]; j--) 
            {    
            	// se verifica daca cheia "j- array[i]" exista in map sau nu
                if (!splitMap.containsKey(j - array[i])) 
                {
                	// in caz afirmativ, se continua executia
                    continue;
                }
                
                // se verifica daca cheia "j" exista in map sau nu
                if (!splitMap.containsKey(j)) 
                {
                	// in caz afirmativ, se adauga in map la cheia j, o lista noua de Integer
                    splitMap.put(j, new ArrayList<Integer>());
                }
                
                // se declara o lista de Integer auxiliara
                List<Integer> auxList = new ArrayList<Integer>();
                
                // se parcuge map-ul in functie de valorile cu cheia "j - array[i]"
                for (int k : splitMap.get(j - array[i])) 
                {
                	// se verifica daca elementul de la indexul k + 1 este diferit de lungimea sirului dat ca parametru
                    if (k + 1 != array.length) 
                    {
                    	// in caz afirmativ, se adauga listei auxiliare
                        auxList.add(k + 1);
                    }
                }
                
                // se adauga in map la pozitia j, lista auxiliara
                splitMap.get(j).addAll(auxList);
                
                // se parcurg elementele map-ului a carora valori au cheia j 
                for (int count : splitMap.get(j)) 
                {
                	// se verifica daca media aritmetica a celor doua liste este egala
                    if (verifyEqualLists(j, count, sum, array.length)) 
                    {
                       // in caz afirmativ, se returneaza valoarea true
                    	return true;
                    }
                }
            }
        }
        
        // in caz negativ, se returneaza valoarea false
        return false;
    }
   
}
