import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.core.os.bundleOf
import androidx.navigation.Navigation
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.practicasharrypotter.R
import com.example.practicasharrypotter.data.model.Characters

class HomeAdapter(private val context: Context, private val charactersList: List<Characters>) : RecyclerView.Adapter<HomeAdapter.HomeViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HomeViewHolder {
        val inflater = LayoutInflater.from(context)
        val view = inflater.inflate(R.layout.item_characters, parent, false)
        return HomeViewHolder(view)
    }

    override fun onBindViewHolder(holder: HomeViewHolder, position: Int) {
        val character = charactersList[position]
        holder.bind(character)
    }

    override fun getItemCount(): Int {
        return charactersList.size
    }

    inner class HomeViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val nameTextView: TextView = itemView.findViewById(R.id.name)
        private val nicknameTextView: TextView = itemView.findViewById(R.id.apodo)
        private val houseTextView: TextView = itemView.findViewById(R.id.house)
        private val img: ImageView = itemView.findViewById(R.id.img)

        init {
            itemView.setOnClickListener {
                val position = adapterPosition.takeIf { it != RecyclerView.NO_POSITION } ?: return@setOnClickListener
                val character = charactersList[position]

                val bundle = bundleOf("character" to character)
                val navController = Navigation.findNavController(itemView)

                navController.navigate(R.id.action_navigation_home_to_navigation_home_detalles2, bundle)
            }
        }




        fun bind(character: Characters) {
            nameTextView.text = character.fullName
            nicknameTextView.text = character.nickname
            houseTextView.text = character.hogwartsHouse
            Glide.with(itemView)
                .load(character.image)
                .into(img)
        }
    }
}
