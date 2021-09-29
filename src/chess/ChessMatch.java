package chess;

import boardgame.Board;
import boardgame.Position;
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

	private void initialSetup() {
		board.placePiece(new Rook(board, Colour.WHITE), new Position(2, 1));
		board.placePiece(new King(board, Colour.BLACK), new Position(0, 4));
		board.placePiece(new King(board, Colour.WHITE), new Position(7, 4));
		
	}
}
