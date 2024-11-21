package dam.aguadulce.aal.marioandfriends;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;

import com.google.android.material.snackbar.Snackbar;

import java.util.ArrayList;
import java.util.Arrays;

import dam.aguadulce.aal.marioandfriends.databinding.CardviewBinding;
import dam.aguadulce.aal.marioandfriends.databinding.FragmentHomeBinding;

public class HomeFragment extends Fragment {

    private FragmentHomeBinding binding; // No es necesario lateinit en Java, solo declaración
    private ArrayList<Character> characters;
    private CharRecyclerViewAdapter adapter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inicializar binding
        binding = FragmentHomeBinding.inflate(inflater, container, false);

        binding = FragmentHomeBinding.inflate(getLayoutInflater());

        // Crear la lista de personajes
        characters = new ArrayList<>(Arrays.asList (
                new Character(R.drawable.mario, "Mario", getString(R.string.mario_description), getString(R.string.mario_skills)),
                new Character(R.drawable.luigi, "Luigi", getString(R.string.luigi_description), getString(R.string.luigi_skills)),
                new Character(R.drawable.peach, "Peach", getString(R.string.peach_description), getString(R.string.peach_skills)),
                new Character(R.drawable.toad, "Toad", getString(R.string.toad_description), getString(R.string.toad_skills)),
                new Character(R.drawable.lakitu, "Lakitu", getString(R.string.lakitu_description), getString(R.string.lakitu_skills)),
                new Character(R.drawable.dkong, "Donkey Kong", getString(R.string.dk_description), getString(R.string.dk_skills)),
                new Character(R.drawable.bowser, "Bowser", getString(R.string.bowser_description), getString(R.string.bowser_skills)),
                new Character(R.drawable.yoshi, "Yoshi", getString(R.string.yoshi_description), getString(R.string.yoshi_skills)),
                new Character(R.drawable.planta, "Planta Piraña", getString(R.string.planta_description), getString(R.string.planta_skills))
        ));

        // Configurar el adaptador con el listener
        adapter = new CharRecyclerViewAdapter(characters, this);
        binding.recyclerView.setLayoutManager(new LinearLayoutManager(requireContext()));
        binding.recyclerView.setAdapter(adapter);

        // Nos aseguramos de usar la vista raíz para el Snackbar
        View rootView = binding.getRoot();

        // Mostrar el Snackbar al abrir
        rootView.post(() -> Snackbar.make(rootView, R.string.snack_bar, Snackbar.LENGTH_SHORT).show());

        // Retornar la vista raíz
        return rootView;
    }
}
