fun chessCodeToMove() : ArrayList<ChessCode> {
    val chesscode = arrayListOf("e4")
    val codeList = arrayListOf<ChessCode>()
    chesscode.forEach { ita ->
        var takes = false
        val itc = ita.replace("=", "")
        if (itc.contains("x")) {
            takes = true
        }
        val it = itc.replace("x", "")
        if (it == "0-0" || it == "O-O") {
            codeList.add(KingSideCastling())
        }
        else if (it == "0-0-0" || it == "O-O-O") {
            codeList.add( QueenSideCastling())
        }

        val pieceType = when (it[0]) {
            'K' -> {
                PieceType.KING
            }
            'Q' -> {
                PieceType.QUEEN
            }
            'B' -> {
                PieceType.BISHOP
            }
            'N' -> {
                PieceType.KNIGHT
            }
            'R' -> {
                PieceType.ROOK
            }
            else -> {
                null
            }
        }
        when (it.length) {
            2 -> {
                codeList.add( Pawn(Location(it[0].toString(), it[1].digitToInt()), takes, ""))
            }
            3 -> {
                if (it[0].isUpperCase()) {
                    codeList.add( chessTypeToMove(pieceType!!, Location(it[0].toString(), it[1].digitToInt()), takes, ""))
                }
                else if (it[2].isLowerCase()) {
                    codeList.add( Pawn(Location(it[1].toString(), it[2].digitToInt()), takes, ""))
                }
                else {
                    codeList.add( PromotionPawn(it[0].toString(), false, "", when (it[2]) {
                        'Q' -> {
                            PieceType.QUEEN
                        }
                        'B' -> {
                            PieceType.BISHOP
                        }
                        'N' -> {
                            PieceType.KNIGHT
                        }
                        'R' -> {
                            PieceType.ROOK
                        }
                        else -> {
                            PieceType.ERROR
                        }
                    }))
                }
            }
            4 -> {
                if (it[0].isLowerCase()) {
                    codeList.add( PromotionPawn(it[1].toString(), false, it[0].toString(), when (it[3]) {
                        'Q' -> {
                            PieceType.QUEEN
                        }
                        'B' -> {
                            PieceType.BISHOP
                        }
                        'N' -> {
                            PieceType.KNIGHT
                        }
                        'R' -> {
                            PieceType.ROOK
                        }
                        else -> {
                            PieceType.ERROR
                        }
                    }))
                }

                chessTypeToMove(pieceType!!, Location(it[2].toString(), it[3].digitToInt()), takes, it[1].toString())
            }
            else -> {
                codeList.add( Error(ErrorType.NOT_REGULAR_CHESS_CODE))
            }
        }
    }
    return codeList
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