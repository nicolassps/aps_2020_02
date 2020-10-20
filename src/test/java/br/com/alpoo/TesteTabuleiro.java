package br.com.alpoo;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.util.Arrays;
import org.junit.Test;

import br.com.alpoo.engine.TabuleiroUtils;
import br.com.alpoo.engine.enums.Movimento;
import br.com.alpoo.engine.exception.MovimentoException;

public class TesteTabuleiro {
	
	@Test
	public void gerarTabuleiro() {
		Integer [][] tabuleiro = TabuleiroUtils.initTabuleiro();
		
		assertNotNull(tabuleiro);
	}
	
	@Test
	public void jogoNaoEncerrado() {
		Integer [][] tabuleiroTeste = {{1,0,3},{4,6,7},{5,8,2}};
		
		assertFalse(TabuleiroUtils.jogoEncerrado(tabuleiroTeste));
	}
	
	@Test
	public void jogoEncerrado() {
		Integer [][] tabuleiroTeste = {{1,2,3},{4,5,6},{7,8,0}};
		
		assertTrue(TabuleiroUtils.jogoEncerrado(tabuleiroTeste));
	}
	
	@Test
	public void movimentoDireitaSucesso() throws MovimentoException {
		Integer [][] tabuleiroTeste = {{1,0,3},{4,6,7},{5,8,2}};
		
		Integer [][] tabuleiroMovimento = TabuleiroUtils.movimentoTabuleiro(tabuleiroTeste, Movimento.DIREITA);
	
		Integer [][] expTabuleiro = {{1,3,0},{4,6,7},{5,8,2}};
		
		assertArrayEquals(expTabuleiro, tabuleiroMovimento);
	}
	
	@Test(expected = MovimentoException.class)
	public void movimentoDireitaErro() throws MovimentoException {
		Integer [][] tabuleiroTeste = {{1,3,0},{4,6,7},{5,8,2}};
		
		TabuleiroUtils.movimentoTabuleiro(tabuleiroTeste, Movimento.DIREITA);
	}
	
	@Test
	public void movimentoEsquerdaSucesso() throws MovimentoException {
		Integer [][] tabuleiroTeste = {{1,0,3},{4,6,7},{5,8,2}};
		
		Integer [][] tabuleiroMovimento = TabuleiroUtils.movimentoTabuleiro(tabuleiroTeste, Movimento.ESQUERDA);
	
		Integer [][] expTabuleiro = {{0,1,3},{4,6,7},{5,8,2}};
		
		assertArrayEquals(expTabuleiro, tabuleiroMovimento);
	}
	
	@Test(expected = MovimentoException.class)
	public void movimentoEsquerdaErro() throws MovimentoException {
		Integer [][] tabuleiroTeste = {{0,1,3},{4,6,7},{5,8,2}};
		
		TabuleiroUtils.movimentoTabuleiro(tabuleiroTeste, Movimento.ESQUERDA);
	}
	
	
	@Test
	public void movimentoCimaSucesso() throws MovimentoException {
		Integer [][] tabuleiroTeste = {{1,6,3},{4,0,7},{5,8,2}};
		
		Integer [][] tabuleiroMovimento = TabuleiroUtils.movimentoTabuleiro(tabuleiroTeste, Movimento.CIMA);
	
		Integer [][] expTabuleiro = {{1,0,3},{4,6,7},{5,8,2}};
		
		assertArrayEquals(expTabuleiro, tabuleiroMovimento);
	}
	
	@Test(expected = MovimentoException.class)
	public void movimentoCimaErro() throws MovimentoException {
		Integer [][] tabuleiroTeste = {{1,3,0},{4,6,7},{5,8,2}};
		
		TabuleiroUtils.movimentoTabuleiro(tabuleiroTeste, Movimento.CIMA);
	}
	
	@Test
	public void movimentoBaixoSucesso() throws MovimentoException {
		Integer [][] tabuleiroTeste = {{1,0,3},{4,6,7},{5,8,2}};
		
		Integer [][] tabuleiroMovimento = TabuleiroUtils.movimentoTabuleiro(tabuleiroTeste, Movimento.BAIXO);
	
		Integer [][] expTabuleiro = {{1,6,3},{4,0,7},{5,8,2}};
		
		assertArrayEquals(expTabuleiro, tabuleiroMovimento);
	}
	
	@Test(expected = MovimentoException.class)
	public void movimentoBaixoErro() throws MovimentoException {
		Integer [][] tabuleiroTeste = {{2,1,3},{4,6,7},{5,8,0}};
		
		TabuleiroUtils.movimentoTabuleiro(tabuleiroTeste, Movimento.BAIXO);
	}
	
	@Test
	public void verificaJogadaTodosLados() {
		Integer [][] tabuleiroTeste = {{2,1,3},{4,0,7},{5,8,6}};
		
		Object[] expMovimentos = Movimento.values();
		
		Object[] movimentosPossiveis = TabuleiroUtils.movimentosPermitidos(tabuleiroTeste).toArray();
		
		assertArrayEquals(expMovimentos, movimentosPossiveis);
	}
	
	@Test
	public void verificaJogadaLadosEsquerdaDireitaCima() {
		Integer [][] tabuleiroTeste = {{2,1,3},{4,8,7},{5,0,6}};
		
		Object[] expMovimentos = Arrays.asList(Movimento.DIREITA, Movimento.ESQUERDA, Movimento.CIMA).toArray();
		
		Object[] movimentosPossiveis = TabuleiroUtils.movimentosPermitidos(tabuleiroTeste).toArray();
		
		assertArrayEquals(expMovimentos, movimentosPossiveis);
	}
	
	@Test
	public void verificaJogadaLadosEsquerdaDireitaBaixo() {
		Integer [][] tabuleiroTeste = {{2,0,3},{4,8,7},{5,1,6}};
		
		Object[] expMovimentos = Arrays.asList(Movimento.DIREITA, Movimento.ESQUERDA, Movimento.BAIXO).toArray();
		
		Object[] movimentosPossiveis = TabuleiroUtils.movimentosPermitidos(tabuleiroTeste).toArray();
		
		assertArrayEquals(expMovimentos, movimentosPossiveis);
	}
	
	@Test
	public void verificaJogadaLadosDireitaBaixo() {
		Integer [][] tabuleiroTeste = {{0,2,3},{4,8,7},{5,1,6}};
		
		Object[] expMovimentos = Arrays.asList(Movimento.DIREITA, Movimento.BAIXO).toArray();
		
		Object[] movimentosPossiveis = TabuleiroUtils.movimentosPermitidos(tabuleiroTeste).toArray();
		
		assertArrayEquals(expMovimentos, movimentosPossiveis);
	}
	
	@Test
	public void verificaJogadaLadosEsquerdaBaixo() {
		Integer [][] tabuleiroTeste = {{3,2,0},{4,8,7},{5,1,6}};
		
		Object[] expMovimentos = Arrays.asList(Movimento.ESQUERDA, Movimento.BAIXO).toArray();
		
		Object[] movimentosPossiveis = TabuleiroUtils.movimentosPermitidos(tabuleiroTeste).toArray();
		
		assertArrayEquals(expMovimentos, movimentosPossiveis);
	}
	
	@Test
	public void verificaJogadaLadosDireitaCima() {
		Integer [][] tabuleiroTeste = {{3,2,5},{4,8,7},{0,1,6}};
		
		Object[] expMovimentos = Arrays.asList(Movimento.DIREITA, Movimento.CIMA).toArray();
		
		Object[] movimentosPossiveis = TabuleiroUtils.movimentosPermitidos(tabuleiroTeste).toArray();
		
		assertArrayEquals(expMovimentos, movimentosPossiveis);
	}
	
	@Test
	public void verificaJogadaLadosEsquerdaCima() {
		Integer [][] tabuleiroTeste = {{3,2,5},{4,8,7},{6,1,0}};
		
		Object[] expMovimentos = Arrays.asList(Movimento.ESQUERDA, Movimento.CIMA).toArray();
		
		Object[] movimentosPossiveis = TabuleiroUtils.movimentosPermitidos(tabuleiroTeste).toArray();
		
		assertArrayEquals(expMovimentos, movimentosPossiveis);
	}
}
