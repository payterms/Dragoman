package payts.ru.repository

interface Repository<T> {

    suspend fun getData(word: String): T
}
