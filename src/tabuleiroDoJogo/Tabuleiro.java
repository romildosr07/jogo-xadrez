package tabuleiroDoJogo;

public class Tabuleiro {

	private int linhas;
	private int colunas;
	private Peca[][] pecas;
	
	public Tabuleiro(int linhas, int colunas) {
		if(linhas < 1 || colunas < 1) {
			throw new TabuleiroException("Erro ao criar o tabuleiro: e necessario que haja pelo menos uma linha e uma coluna!");
		}
		this.linhas = linhas;
		this.colunas = colunas;
		pecas = new Peca[linhas][colunas];
	}

	public int getLinhas() {
		return linhas;
	}

	public int getColunas() {
		return colunas;
	}
	
	public Peca peca(int linha, int coluna) {
		if(!existeAPosicao(linha, coluna)) {
			throw new TabuleiroException("nao tem essa posicao no tabuleiro");
		}
		return pecas[linha][coluna];
	}
	
	public Peca peca(Posicao posicao) {
		if(!existeAPosicao(posicao)) {
			throw new TabuleiroException("nao tem essa posicao no tabuleiro");
		}
		return pecas[posicao.getLinha()][posicao.getColuna()];
	}
	
	public void colocarPeca(Peca peca , Posicao posicao) {
		if(temUmaPeca(posicao)) {
			throw new TabuleiroException("tem uma peça nesta posicao " + posicao);
		}
		pecas[posicao.getLinha()][posicao.getColuna()]=peca;
		peca.posicao = posicao;
	}
	
	public Peca removePeca(Posicao posicao) {
		if(!existeAPosicao(posicao)) {
			throw new TabuleiroException("nao tem essa posicao no tabuleiro");
		}
		if(peca(posicao) == null) {
			return null;
		}
		Peca aux = peca(posicao);
		aux.posicao = null;
		pecas[posicao.getLinha()][posicao.getColuna()] = null;
		
		return aux;
	}
	
	private boolean existeAPosicao(int linha, int coluna) {
		return linha >= 0 && linha < linhas && coluna >= 0 && coluna < colunas;
	}
	
	public boolean existeAPosicao(Posicao posicao) {
		return existeAPosicao(posicao.getLinha(), posicao.getColuna());
	}
	
	public boolean temUmaPeca(Posicao posicao) {
		if(!existeAPosicao(posicao)) {
			throw new TabuleiroException("nao tem essa posicao no tabuleiro");
		}
		return peca(posicao) != null;
	}
}
