package chess;

import boardgame.Board;

public class ChessMatch {
	
	private Board board;
	
	public ChessMatch() {
		board = new Board(8, 8); //Dimens�o do tamanho do tabuleiro
	}
	
	public ChessPiece[][] getPieces(){
		ChessPiece[][] mat = new ChessPiece[board.getRows()][board.getColumns()]; //Pega a quantidade de linhas e colunas do tabuleiro
		for (int i=0; i<board.getRows();i++)
		{
			for (int j=0; j<board.getColumns(); j++)
			{
				mat[i][j] = (ChessPiece) board.piece(i, j); //Downcasting para pe�a de xadrez e n�o pe�a comum
			}
		}
		return mat;
	}
}
