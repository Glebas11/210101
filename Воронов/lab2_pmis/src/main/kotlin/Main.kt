fun bubbleSort(arr: IntArray) {
    var n = arr.size
    var swapped: Boolean

    // Внешний цикл для итераций по массиву
    for (i in 0 until n - 1) {
        swapped = false

        // Внутренний цикл для сравнения соседних элементов
        for (j in 0 until n - i - 1) {
            if (arr[j] > arr[j + 1]) {
                val temp = arr[j]
                arr[j] = arr[j + 1]
                arr[j + 1] = temp
                swapped = true
            }
        }

        if (!swapped) break
    }
}

fun main() {
    while (true) {
        println("Введите числа для сортировки, разделённые пробелом (или 'exit' для выхода):")
        val input = readLine()

        if (input.equals("exit", ignoreCase = true)) {
            println("Выход из программы.")
            break
        }

        // Преобразуем строку ввода в массив чисел
        val arr = input
            ?.split(" ")
            ?.mapNotNull { it.toIntOrNull() }
            ?.toIntArray()

        if (arr == null || arr.isEmpty()) {
            println("Массив пустой или введены некорректные данные. Попробуйте снова.")
            continue
        }

        println("Исходный массив: ${arr.joinToString(", ")}")

        bubbleSort(arr)

        println("Отсортированный массив: ${arr.joinToString(", ")}\n")
    }
}
