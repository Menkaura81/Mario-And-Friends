package dam.aguadulce.aal.marioandfriends;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView.Adapter;

import dam.aguadulce.aal.marioandfriends.databinding.CardviewBinding;

import java.util.ArrayList;



public class CharRecyclerViewAdapter extends Adapter<CharViewHolder> {

    private final ArrayList<Character> characters;
    private final Fragment fragment;


    // Agregar una interfaz para manejar los clics
    public interface OnItemClickListener {
        void onItemClick(Character character);
    }

    public CharRecyclerViewAdapter(ArrayList<Character> characters, Fragment fragment) {
        this.characters = characters;
        this.fragment = fragment;
    }
    @NonNull
    //@Override
    public CharViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType){
        CardviewBinding binding = CardviewBinding.inflate(
                LayoutInflater.from(parent.getContext()), parent, false
        );
        return new CharViewHolder(binding);
    }



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

    //@Override
    public int getItemCount(){
        return characters.size();
    }

}
