package no.uia.ikt205.mybooks.books

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import no.uia.ikt205.mybooks.databinding.BookLayoutBinding

// Dette er en Recycler adapter
class BookCollectionAdapter(private val books: MutableList<Book>): RecyclerView.Adapter<BookCollectionAdapter.ViewHolder>()  {
    /* Prøver å gjøre tilsvarende som  setContentView(binding.root) på en måte.
    // Obs. Books har ingen binding "ennå". For å få denne bindingen, opprettet vi book_layout.xml.
    // Deretter brukte vi BookLayoutBinding på binding i ViewHolderen, og fikk dermed importert
    // BookLayoutBinding, og dette fikset binding.root for oss.*/

    // class ViewHolder er en hjelpeklasse, for å si at dette er den type view, som vi har lyst til å ha.
    class ViewHolder(val binding: BookLayoutBinding): RecyclerView.ViewHolder(binding.root){
        /* fun bind - har med selve book viewet å gjøre og ikke selve Recycleren, så det bli mere
           ryddig å gjøre det på denne måten:   */
        fun bind(book: Book) {
            binding.author.text = book.author
            binding.title.text = book.title
            binding.published.text = book.published.toString()
        }
    } // Etter å ha opprettet ViewHolderen, kan vi bruke den i RecyclerViewet for BookCollectionAdapter.


    // Må overskrive  3 funksjoner
    /*override fun getItemCount(): Int {
        return books.size
    }*/
    override fun getItemCount(): Int = books.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        // knytte view til data
        val book = books[position]

        //holder.itemView.author.text = // legger til bind funksjon i ViewHolder, for å kunne bruke holder.bin(book) i stedet
        holder.bind(book)
    }
        // denne får med seg et nytt book layer binding view / lager view
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(BookLayoutBinding.inflate(LayoutInflater.from(parent.context),parent, false))
    }
}