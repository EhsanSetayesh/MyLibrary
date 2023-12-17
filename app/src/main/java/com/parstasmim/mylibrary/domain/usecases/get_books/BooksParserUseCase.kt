package com.parstasmim.mylibrary.domain.usecases.get_books

import com.parstasmim.mylibrary.datasource.db.book.BookDao
import com.parstasmim.mylibrary.datasource.db.book.BookEntity
import com.parstasmim.mylibrary.datasource.db.book.toDomain
import com.parstasmim.mylibrary.datasource.network.models.BookDto
import com.parstasmim.mylibrary.domain.models.BookBean
import com.parstasmim.mylibrary.utils.message.ErrorHandling

class BooksParserUseCase(
    private val booksListApi: List<BookDto>,
    private val bookDao: BookDao
) {
    suspend fun execute(): List<BookBean> {
        val booksListDomain = mutableListOf<BookBean>()
        val booksListDb = bookDao.getBooks()

        booksListApi.forEach { bookApi ->
            try {
                var isBookFound = false
                if (booksListDb != null) {
                    for (bookEntity in booksListDb) {
                        if (bookEntity.id == bookApi.id) {
                            isBookFound = true
                            bookEntity.apply {
                                title = bookApi.title
                                author = bookApi.author
                                genre = bookApi.genre
                                yearPublished = bookApi.yearPublished
                                checkedOut = bookApi.checkedOut
                                bookDao.update(this)
                                booksListDomain.add(toDomain())
                            }

                            break
                        }
                    }
                }
                if (!isBookFound) {
                    BookEntity(
                        title = bookApi.title,
                        author = bookApi.author,
                        id = bookApi.id,
                        genre = bookApi.genre,
                        yearPublished = bookApi.yearPublished,
                        checkedOut = bookApi.checkedOut
                    ).apply {
                        bookDao.insert(this)
                        booksListDomain.add(toDomain())
                    }
                }
            } catch (e: Exception) {
                throw Exception(ErrorHandling.ERROR_READ_WRITE_IN_DB)
            }
        }
        return booksListDomain
    }
}














