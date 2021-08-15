package no.uia.ikt205.mybooks

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import no.uia.ikt205.mybooks.books.Book
import no.uia.ikt205.mybooks.books.BookCollectionAdapter
import no.uia.ikt205.mybooks.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding // fås pga kotlin extensions + viewBinding i gradle

    private var bookCollection: MutableList<Book> = mutableListOf(
        Book("Martha Wells", "All Systems Red", 2017),
        Book(title = "American Gods", author = "Neil Gaiman", published = 2011), // alternativ rekkefølge
        Book("Terry Pratchett", "The wee free men", 2003)
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater) // (this.layoutInfalte)
        setContentView(binding.root) // setContentView(R.layout.activity_main) = default if not using binding

        // hvordan putter vi data i binding.bookListing? annerledes enn linear layout. Android
        // bruker kun minne på å elementer som vises i recycler viewet.
        // Vi oppretter en adapter for å pushe data inn i recycler viewet.
        binding.bookListing.layoutManager = LinearLayoutManager(this) // Fikset 'No layout manager attached' feilmelding
        binding.bookListing.adapter = BookCollectionAdapter(bookCollection)// husk at bookListing er et recycler view
    }
}