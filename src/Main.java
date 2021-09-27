import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.Scanner;

/* Lê N depois cria um array de times de tamanho N+1 para poder acessar de 1 a N
 * 
 * Lê (N*(N-1))/2 linhas, cada uma contendo 4 inteiros X, Y, Z e W
 * 
 * X e Z vão para um array de números de inscrição e Y e W vão para um array de pontos
 * 
 * Usando os dados dos arrays de pontos, adiciona os pontos marcados e recebidos por cada
 * time e os pontos de vitória ou derrota, de acordo com qual time pontuou mais durante a partida
 * 
 * Ordena os times usando um comparador customizado e imprime os números de inscrição
 */

public class Main {
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = 1;
		int[] insc = new int[2], pontos = new int[2];
		boolean valido = false;
		Time[] times;
		
		while (!valido) {
			try {
				N = sc.nextInt();
				valido = true;
			} catch (InputMismatchException e) {
				System.out.println("Valor inválido para N (insira apenas números inteiros)");
				sc.next();
			}
		}
		
		valido = false;
		times = new Time[N+1];
		
		for (int i = 0; i <= N; i++) {
			times[i] = new Time(i);
		}
		
		for (int i = 0; i < (N*(N-1))/2; i++) {
			while (!valido) {
				try {
					insc[0] = sc.nextInt();
					valido = true;
				} catch (InputMismatchException e) {
					System.out.println("Valor inválido (insira apenas números inteiros)");
					sc.next();
				}
			}
			
			valido = false;
			
			while (!valido) {
				try {
					pontos[0] = sc.nextInt();
					valido = true;
				} catch (InputMismatchException e) {
					System.out.println("Valor inválido (insira apenas números inteiros)");
					sc.next();
				}
			}
			
			valido = false;
			
			while (!valido) {
				try {
					insc[1] = sc.nextInt();
					valido = true;
				} catch (InputMismatchException e) {
					System.out.println("Valor inválido (insira apenas números inteiros)");
					sc.next();
				}
			}
			
			valido = false;

			while (!valido) {
				try {
					pontos[1] = sc.nextInt();
					valido = true;
				} catch (InputMismatchException e) {
					System.out.println("Valor inválido (insira apenas números inteiros)");
					sc.next();
				}
			}
			
			valido = false;
			
			times[insc[0]].addPontosMarcados(pontos[0]);
			times[insc[0]].addPontosRecebidos(pontos[1]);
			times[insc[1]].addPontosMarcados(pontos[1]);
			times[insc[1]].addPontosRecebidos(pontos[0]);
			
			if (pontos[0] > pontos[1]) {
				times[insc[0]].addVitoria();
				times[insc[1]].addDerrota();
			} else {
				times[insc[1]].addVitoria();
				times[insc[0]].addDerrota();
			}
		}
		
		Arrays.sort(times, Time.TimeComparator);
		
		for (int i = 0; i < N; i++) {
			System.out.print(times[i].getInscricao() + " ");
		}
	}
}