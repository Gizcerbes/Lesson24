package by.ocheretny.lesson24

data class Character(
    val name: String,
    var photoURL: String,
    var countGames: Int = 1,
    var countKills: Int = 0,
    var countWins: Int = 0
) {
    var winReit: Double = (countWins.toDouble() * 100) / countGames
    var kD: Double = countKills.toDouble() / countGames - countWins
}


