package aplicattion;
 
import java.util.InputMismatchException;
import java.util.Scanner;

import xadrez.PartidaDeXadrez;
import xadrez.PecaDeXadrez;
import xadrez.PosicaoXadrez;
import xadrez.XadrezException;

public class Programa {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		PartidaDeXadrez partida = new PartidaDeXadrez();
		
		while(true) {
			try {
				UI.limparTela();
				UI.printTabuleiro(partida.pegaPecas());
				System.out.println();
				System.out.println("origem: ");
				PosicaoXadrez origem = UI.lerPosicaoXadrez(sc);
				
				boolean[][] possiveisMovimentos = partida.possiveisMovimentos(origem);
				UI.limparTela();
				UI.printTabuleiro(partida.pegaPecas(), possiveisMovimentos);
				System.out.println();
				System.out.println("destino: ");
				PosicaoXadrez destino = UI.lerPosicaoXadrez(sc);
				
				PecaDeXadrez PecaCapiturada = partida.PerformaseDoMovimento(origem, destino);
			
			}
			catch(XadrezException e) {
				System.out.println(e.getMessage());
				sc.nextLine();
			}
			catch(InputMismatchException e) {
				System.out.println(e.getMessage());
				sc.nextLine();
			}
		}
	}

}
