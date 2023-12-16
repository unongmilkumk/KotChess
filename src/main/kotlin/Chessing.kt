fun chessCodeToMove() : ChessCode {
    val chesscode = arrayListOf("e4")
    chesscode.forEach {
        // PieceType Setting
        when (it.length) {
            2 -> {
                return Pawn(Location(it[0].toString(), it[1].digitToInt()), isEating = false, isPromotion = false)
            }
            3 -> {
                if (it[0].isUpperCase()) {

                }
            }
        }
    }
}

fun chessTypeToMove(pieceType : PieceType, goingTo : Location, isEating : Boolean, moveCode : String) : ChessCode {
    when (pieceType) {
        PieceType.KING -> {
            return King(goingTo, isEating)
        }
        PieceType.QUEEN -> {
            return Queen(goingTo, isEating)
        }
        PieceType.ROOK -> {
            return Rook(goingTo, isEating, moveCode)
        }
        PieceType.BISHOP -> {
            return Bishop(goingTo, isEating, moveCode)
        }
        PieceType.KNIGHT -> {
            return Knight(goingTo, isEating, moveCode)
        }
        else -> {
            return Error(ErrorType.NOT_REGULAR_CHESS_CODE)
        }
    }
}