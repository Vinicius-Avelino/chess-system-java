package chess;

import boardgame.Board;
import boardgame.BoardException;
import boardgame.Piece;
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
	public ChessPiece performChessMove(ChessPosition sourcePosition, ChessPosition targetPosition)
	{
		Position source = sourcePosition.toPosition();
		Position target = targetPosition.toPosition();
		validateSourcePosition(source);
		Piece capturedPiece = makeMove(source, target);
		return (ChessPiece)capturedPiece;
	}
	
	private Piece makeMove (Position source, Position target)
	{
		Piece p = board.removePiece(source); //Remove a peça na posição de origem
		Piece capturedPiece = board.removePiece(target); //Remove a possivel peça em posicção de destino (peça capturada)
		board.placePiece(p, target);
		return capturedPiece;
	}
	
	private void validateSourcePosition (Position position)
	{
		if (!board.thereIsAPiece(position))
		{
			throw new ChessException("There is no piece on source position");
		}
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
