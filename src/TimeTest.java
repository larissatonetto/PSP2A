import static org.junit.Assert.*;

import java.util.Arrays;

import org.junit.Before;
import org.junit.Test;

public class TimeTest {
	Time time = new Time(1);
	Time time2 = new Time(2);
	Time time3 = new Time(3);
	Time[] times = new Time[3];
	
	@Before
	public void setUp() {
		times[0] = time;
		times[1] = time2;
		times[2] = time3;
	}
	
	@Test
	public void testConstrutor() {
		assertEquals(time.getInscricao(), 1);
		assertEquals(time2.getInscricao(), 2);
	}
	
	@Test
	public void testVitoria() {
		assertEquals(time.getPontuacao(), 0);

		time.addVitoria();

		assertEquals(time.getPontuacao(), 2);

		time.addVitoria();

		assertEquals(time.getPontuacao(), 4);
	}
	
	@Test
	public void testDerrota() {
		assertEquals(time.getPontuacao(), 0);

		time.addDerrota();

		assertEquals(time.getPontuacao(), 1);

		time.addDerrota();

		assertEquals(time.getPontuacao(), 2);
	}
	
	@Test
	public void testPontosMarcadosCestaAv() {
		assertEquals(time.getPontosMarcados(), 0);

		time.addPontosMarcados(10);

		assertEquals(time.getPontosMarcados(), 10);
		assertEquals(time.getCestaAv(), 10, 0.001);

		time.addPontosMarcados(50);

		assertEquals(time.getPontosMarcados(), 60);
		assertEquals(time.getCestaAv(), 60, 0.001);
	}
	
	@Test
	public void testPontosRecebidosCestaAv() {
		assertEquals(time.getPontosMarcados(), 0);

		time.addPontosRecebidos(10);

		assertEquals(time.getPontosRecebidos(), 10);
		assertEquals(time.getCestaAv(), 0, 0.001);

		time.addPontosRecebidos(50);

		assertEquals(time.getPontosRecebidos(), 60);
		assertEquals(time.getCestaAv(), 0, 0.001);
	}
	
	@Test
	public void testCestaAverage() {
		assertEquals(time.getCestaAv(), 0, 0.001);

		time.addPontosMarcados(10);
		time.addPontosRecebidos(5);
		
		assertEquals(time.getCestaAv(), 2, 0.001);

		time.addPontosMarcados(40);
		time.addPontosRecebidos(11);

		assertEquals(time.getCestaAv(), 3.125, 0.001);
	}
	
	@Test
	public void testSortPontuacao() {
		time2.addVitoria();
		
		time.addDerrota();
		
		Arrays.sort(times, Time.TimeComparator);
		
		int[] classificacao = {times[0].getInscricao(), times[1].getInscricao(), times[2].getInscricao()};
		int[] resultado = {2,1,3};

		assertArrayEquals(classificacao, resultado);
	}
	
	@Test
	public void testSortCestaAverage() {
		time.addPontosMarcados(10);
		time2.addPontosMarcados(20);
		time3.addPontosMarcados(30);
		
		time2.addPontosRecebidos(18);
		time3.addPontosRecebidos(20);
		
		Arrays.sort(times, Time.TimeComparator);
		
		int[] classificacao = {times[0].getInscricao(), times[1].getInscricao(), times[2].getInscricao()};
		int[] resultado = {1,3,2};

		assertArrayEquals(classificacao, resultado);
	}
	
	@Test
	public void testSortPontosMarcados() {
		time.addPontosMarcados(10);
		time2.addPontosMarcados(30);
		time3.addPontosMarcados(20);
		
		Arrays.sort(times, Time.TimeComparator);
		
		int[] classificacao = {times[0].getInscricao(), times[1].getInscricao(), times[2].getInscricao()};
		int[] resultado = {2,3,1};

		assertArrayEquals(classificacao, resultado);
	}
	
	@Test
	public void testSortInscricao() {
		Arrays.sort(times, Time.TimeComparator);
		
		int[] classificacao = {times[0].getInscricao(), times[1].getInscricao(), times[2].getInscricao()};
		int[] resultado = {1,2,3};

		assertArrayEquals(classificacao, resultado);
	}
}
