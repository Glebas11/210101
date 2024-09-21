fun isPrime(n: Int): Boolean {
    if (n <= 1) return false
    if (n <= 3) return true
    if (n % 2 == 0 || n % 3 == 0) return false
    var i = 5
    while (i * i <= n) {
        if (n % i == 0 || n % (i + 2) == 0) return false
        i += 6
    }
    return true
}

fun primeFactors(n: Int): List<Int> {
    val factors = mutableListOf<Int>()
    var num = n
    // Проверка делимости на 2
    while (num % 2 == 0) {
        factors.add(2)
        num /= 2
    }
    // Проверка делимости на нечётные числа
    var i = 3
    while (i * i <= num) {
        while (num % i == 0) {
            factors.add(i)
            num /= i
        }
        i += 2
    }
    // Если num стал простым числом больше 2
    if (num > 2) factors.add(num)
    return factors
}

fun main() {
    while (true) {
        println("Введите число для разложения на простые множители (или 'exit' для выхода):")
        val input = readLine()

        // Проверка на выход из программы
        if (input.equals("exit", ignoreCase = true)) {
            println("Выход из программы.")
            break
        }

        try {
            // Проверка, что ввод — это целое число
            val number = input?.toInt() ?: throw NumberFormatException()

            // Проверка на положительное число
            if (number < 1) {
                println("Введите положительное целое число.")
                continue
            }

            // Проверка на простое число и разложение на множители
            if (isPrime(number)) {
                println("$number является простым числом.")
            } else {
                val factors = primeFactors(number)
                println("Простые множители числа $number: ${factors.joinToString(", ")}")
            }
        } catch (e: NumberFormatException) {
            println("Пожалуйста, введите корректное целое число.")
        }
    }
}
