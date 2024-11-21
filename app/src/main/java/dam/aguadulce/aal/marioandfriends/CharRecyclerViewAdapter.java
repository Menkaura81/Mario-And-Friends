package dam.aguadulce.aal.marioandfriends;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView.Adapter;
import dam.aguadulce.aal.marioandfriends.databinding.CardviewBinding;
import java.util.ArrayList;


/**
 * Clase que implementa el adaptador para el recyclerview
 */
public class CharRecyclerViewAdapter extends Adapter<CharViewHolder> {

    private final ArrayList<Character> characters;
    private final Fragment fragment;


    /**
     * Método constructor
     * @param characters ArrayList Lista de personajes
     * @param fragment Fragmento en el que se crea el recyclerview
     */
    public CharRecyclerViewAdapter(ArrayList<Character> characters, Fragment fragment) {
        this.characters = characters;
        this.fragment = fragment;
    }


    /**
     * Método que crea el viewholder del recyclerview
     * @param parent   The ViewGroup into which the new View will be added after it is bound to
     *                 an adapter position.
     * @param viewType The view type of the new View.
     * @return viewholder
     */
    @NonNull
    //@Override
    public CharViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType){
        CardviewBinding binding = CardviewBinding.inflate(
                LayoutInflater.from(parent.getContext()), parent, false
        );
        return new CharViewHolder(binding);
    }


    /**
     * Método que actualiza el viewholder con los datos del personaje seleccionado en el recyclerview
     * @param holder   The ViewHolder which should be updated to represent the contents of the
     *                 item at the given position in the data set.
     * @param position The position of the item within the adapter's data set.
     */
    @Override
    public void onBindViewHolder(@NonNull CharViewHolder holder, int position) {
        Character currentChar = this.characters.get(position);
        holder.bind(currentChar);

        holder.itemView.setOnClickListener(view -> {
            // Crear un Bundle con los datos del personaje
            Bundle result = new Bundle();
            result.putString("characterName", currentChar.getName());
            result.putString("characterDetails", currentChar.getDescription());
            result.putInt("characterImage", currentChar.getImage());
            result.putString("characterSkills", currentChar.getSkills());

            // Enviar el resultado al FragmentManager
            fragment.requireActivity()
                    .getSupportFragmentManager()
                    .setFragmentResult("cardClick", result);
        });
    }


    /**
     * Método que cuenta la cantidad de personajes que hay en la lista
     * @return int Numero de personajes
     */
    @Override
    public int getItemCount(){
        return characters.size();
    }

}
