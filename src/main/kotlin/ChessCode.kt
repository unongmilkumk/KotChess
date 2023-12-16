interface ChessCode

class KingSideCastling : ChessCode

class QueenSideCastling : ChessCode

class Pawn(goingTo : Location, isEating : Boolean, moveCode : String, isPromotion : Boolean) : ChessCode

class Bishop(goingTo: Location, isEating: Boolean, moveCode : String) : ChessCode

class Knight(goingTo: Location, isEating: Boolean, moveCode : String) : ChessCode

class Rook(goingTo: Location, isEating: Boolean, moveCode : String) : ChessCode

class Queen(goingTo: Location, isEating: Boolean) : ChessCode

class King(goingTo: Location, isEating: Boolean) : ChessCode

class Error(errorType: ErrorType) : ChessCode