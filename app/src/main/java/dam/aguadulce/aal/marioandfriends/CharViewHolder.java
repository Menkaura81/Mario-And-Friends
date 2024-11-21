package dam.aguadulce.aal.marioandfriends;

import androidx.recyclerview.widget.RecyclerView;
import dam.aguadulce.aal.marioandfriends.databinding.CardviewBinding;


/**
 * Clase que implementa el viewholder para las tarjetas de personajes que se usan en el recyclerview
 */
public class CharViewHolder extends RecyclerView.ViewHolder{

    private final CardviewBinding binding;


    /**
     * Método constructor del viewholder que luego usará el adaptador
     * @param binding Origen de los datos
     */
    public CharViewHolder(CardviewBinding binding){
        super(binding.getRoot());
        this.binding = binding;
    }


    /**
     * Método que asocia los datos al viewholder
     * @param character Character Personaje del que se toman los datos
     */
    public void bind (Character character){
        binding.name.setText(character.getName());
        binding.image.setImageResource(character.getImage());
        binding.executePendingBindings();
    }
}
