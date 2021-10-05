package xadrez.pecas;

import tabuleiroDoJogo.Posicao;
import tabuleiroDoJogo.Tabuleiro;
import xadrez.Cor;
import xadrez.PecaDeXadrez;

public class Torre extends PecaDeXadrez{

	public Torre(Tabuleiro tabuleiro, Cor cor) {
		super(tabuleiro, cor);
	}

	@Override
	public String toString() {
		return "T";
	}
	
	@Override
	public boolean[][] possiveisMovimentos() {
		boolean[][] mat = new boolean[getTabuleiro().getLinhas()][getTabuleiro().getColunas()];
		
		Posicao p = new Posicao(0,0);
		
		//acima
		p.setValues(posicao.getLinha() - 1, posicao.getColuna());
		while(getTabuleiro().existeAPosicao(p) && !getTabuleiro().temUmaPeca(p)) {
			mat[p.getLinha()][p.getColuna()] = true;
			p.setLinha(p.getLinha() - 1);
		}
		if(getTabuleiro().existeAPosicao(p) && temUmaPecaAdversaria(p)) {
			mat[p.getLinha()][p.getColuna()] = true;
		}
		
		//esquerda
		p.setValues(posicao.getLinha(), posicao.getColuna() - 1);
		while(getTabuleiro().existeAPosicao(p) && !getTabuleiro().temUmaPeca(p)) {
			mat[p.getLinha()][p.getColuna()] = true;
			p.setColuna(p.getColuna() - 1);
		}
		if(getTabuleiro().existeAPosicao(p) && temUmaPecaAdversaria(p)) {
			mat[p.getLinha()][p.getColuna()] = true;
		}

		//direita
		p.setValues(posicao.getLinha(), posicao.getColuna() + 1);
		while(getTabuleiro().existeAPosicao(p) && !getTabuleiro().temUmaPeca(p)) {
			mat[p.getLinha()][p.getColuna()] = true;
			p.setColuna(p.getColuna() + 1);
		}
		if(getTabuleiro().existeAPosicao(p) && temUmaPecaAdversaria(p)) {
			mat[p.getLinha()][p.getColuna()] = true;
		}

		//acima
		p.setValues(posicao.getLinha() + 1, posicao.getColuna());
		while(getTabuleiro().existeAPosicao(p) && !getTabuleiro().temUmaPeca(p)) {
			mat[p.getLinha()][p.getColuna()] = true;
			p.setLinha(p.getLinha() + 1);
		}
		if(getTabuleiro().existeAPosicao(p) && temUmaPecaAdversaria(p)) {
			mat[p.getLinha()][p.getColuna()] = true;
		}
		return mat;
	}
}
