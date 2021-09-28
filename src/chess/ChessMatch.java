package chess;

import boardgame.Board;

public class ChessMatch {
	
	private Board board;
	
	public ChessMatch() {
		board = new Board(8, 8); //Dimensão do tamanho do tabuleiro
	}
	
	public ChessPiece[][] getPieces(){
		ChessPiece[][] mat = new ChessPiece[board.getRows()][board.getColumns()]; //Pega a quantidade de linhas e colunas do tabuleiro
		for (int i=0; i<board.getRows();i++)
		{
			for (int j=0; j<board.getColumns(); j++)
			{
				mat[i][j] = (ChessPiece) board.piece(i, j); //Downcasting para peça de xadrez e não peça comum
			}
		}
		return mat;
	}
}
