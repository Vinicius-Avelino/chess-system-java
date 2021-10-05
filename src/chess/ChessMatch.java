package chess;

import boardgame.Board;
import chess.pieces.King;
import chess.pieces.Rook;

public class ChessMatch {

	private Board board;

	public ChessMatch() {
		board = new Board(8, 8); // Dimens�o do tamanho do tabuleiro
		initialSetup();
	}

	public ChessPiece[][] getPieces() {
		ChessPiece[][] mat = new ChessPiece[board.getRows()][board.getColumns()]; // Pega a quantidade de linhas e
																					// colunas do tabuleiro
		for (int i = 0; i < board.getRows(); i++) {
			for (int j = 0; j < board.getColumns(); j++) {
				mat[i][j] = (ChessPiece) board.piece(i, j); // Downcasting para pe�a de xadrez e n�o pe�a comum
			}
		}
		return mat;
	}

	private void placeNewPiece(char column, int row, ChessPiece piece)
	{
		board.placePiece(piece, new ChessPosition(column, row).toPosition());
	}
	private void initialSetup() {
		placeNewPiece('c', 1, new Rook(board, Colour.WHITE));
        placeNewPiece('c', 2, new Rook(board, Colour.WHITE));
        placeNewPiece('d', 2, new Rook(board, Colour.WHITE));
        placeNewPiece('e', 2, new Rook(board, Colour.WHITE));
        placeNewPiece('e', 1, new Rook(board, Colour.WHITE));
        placeNewPiece('d', 1, new King(board, Colour.WHITE));

        placeNewPiece('c', 7, new Rook(board, Colour.BLACK));
        placeNewPiece('c', 8, new Rook(board, Colour.BLACK));
        placeNewPiece('d', 7, new Rook(board, Colour.BLACK));
        placeNewPiece('e', 7, new Rook(board, Colour.BLACK));
        placeNewPiece('e', 8, new Rook(board, Colour.BLACK));
        placeNewPiece('d', 8, new King(board, Colour.BLACK));
		
	}
}
