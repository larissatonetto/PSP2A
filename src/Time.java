import java.util.Comparator;

/*
 * A classe Time guarda todos os dados relevantes para o cálculo da classificação
 * de cada time (número de inscrição, número de pontos marcados e recebidos,
 * "cesta average" e total de pontos
 */

public class Time {
	
	private int inscricao, pontosMarc, pontosRec, pontuacao;
	private double cestaAv;
	
	public Time(int i) {
		this.inscricao = i;
	}
	
	public void addPontosMarcados(int pontos) {
		this.pontosMarc+= pontos;
		this.cestaAv = this.pontosRec == 0 ? this.pontosMarc : (double)this.pontosMarc/this.pontosRec;
	}
	
	public void addPontosRecebidos(int pontos) {
		this.pontosRec+= pontos;
		this.cestaAv = (double)this.pontosMarc/this.pontosRec;
	}
	
	public void addVitoria() {
		this.pontuacao+= 2;
	}
	
	public void addDerrota() {
		this.pontuacao++;
	}
	
	public int getInscricao() {
		return this.inscricao;
	}
	
	public int getPontuacao() {
		return this.pontuacao;
	}
	
	public double getCestaAv() {
		return this.cestaAv;
	}
	
	public int getPontosMarcados() {
		return this.pontosMarc;
	}
	
	public int getPontosRecebidos() {
		return this.pontosRec;
	}

	public static Comparator<Time> TimeComparator = new Comparator<Time>() {
		public int compare(Time time1, Time time2) {
			if (time1.pontuacao != time2.pontuacao) {
				return time1.pontuacao > time2.pontuacao ? -1 : 1;
			} else {
				if (time1.cestaAv != time2.cestaAv) {
					return time1.cestaAv > time2.cestaAv ? -1 : 1;
				} else {
					if (time1.pontosMarc != time2.pontosMarc) {
						return time1.pontosMarc > time2.pontosMarc ? -1 : 1;
					} else {
						return time1.inscricao < time2.inscricao ? -1 : 1;
					}
				}
			}
		}
	};
}
