interface ChessCode

class KingSideCastling : ChessCode

class QueenSideCastling : ChessCode

class Pawn(val goingTo : Location, val isEating : Boolean, val moveCode : String) : ChessCode

class PromotionPawn(val goingTo : String, val isEating : Boolean, val moveCode : String, val pieceType: PieceType) : ChessCode

class Bishop(val goingTo: Location, val isEating: Boolean, val moveCode : String) : ChessCode

class Knight(val goingTo: Location, val isEating: Boolean, val moveCode : String) : ChessCode

class Rook(val goingTo: Location, val isEating: Boolean, val moveCode : String) : ChessCode

class Queen(val goingTo: Location, val isEating: Boolean) : ChessCode

class King(val goingTo: Location, val isEating: Boolean) : ChessCode

class Error(val errorType: ErrorType) : ChessCode