package chess;

import boardgame.Board;
import chess.pieces.King;
import chess.pieces.Rook;

public class ChessMatch {

	private Board board;

	public ChessMatch() {
		board = new Board(8, 8); // Dimensão do tamanho do tabuleiro
		initialSetup();
	}

	public ChessPiece[][] getPieces() {
		ChessPiece[][] mat = new ChessPiece[board.getRows()][board.getColumns()]; // Pega a quantidade de linhas e
																					// colunas do tabuleiro
		for (int i = 0; i < board.getRows(); i++) {
			for (int j = 0; j < board.getColumns(); j++) {
				mat[i][j] = (ChessPiece) board.piece(i, j); // Downcasting para peça de xadrez e não peça comum
			}
		}
		return mat;
	}

	private void placeNewPiece(char column, int row, ChessPiece piece)
	{
		board.placePiece(piece, new ChessPosition(column, row).toPosition());
	}
	private void initialSetup() {
		placeNewPiece('b', 6, new Rook(board, Colour.WHITE));
		placeNewPiece('e', 8, new King(board, Colour.BLACK));
		placeNewPiece('e', 1, new King(board, Colour.WHITE));
		
	}
}
