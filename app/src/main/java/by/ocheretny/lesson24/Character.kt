package by.ocheretny.lesson24

data class Character(
    val name: String,
    var photoURL: String,
    var countGames: Int = 1,
    var countKills: Int = 0,
    var countWins: Int = 0
) {
    val winReit: Double
        get() {
            if (countGames <= 0) return 0.0
            if (countWins.toDouble() >= countGames) return 100.0
            return (countWins.toDouble() * 100) / countGames
        }
    val kD: Double
        get() {
            if ((countGames - countWins) <= 0) return countKills.toDouble()
            return countKills.toDouble() / (countGames - countWins)
        }
}


