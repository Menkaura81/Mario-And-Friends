package dam.aguadulce.aal.marioandfriends;

import androidx.recyclerview.widget.RecyclerView;

import dam.aguadulce.aal.marioandfriends.databinding.CardviewBinding;

public class CharViewHolder extends RecyclerView.ViewHolder{

    private final CardviewBinding binding;

    public CharViewHolder(CardviewBinding binding){
        super(binding.getRoot());
        this.binding = binding;
    }

    public void bind (Character character){
        binding.name.setText(character.getName());
        binding.image.setImageResource(character.getImage());
        binding.executePendingBindings();
    }
}
