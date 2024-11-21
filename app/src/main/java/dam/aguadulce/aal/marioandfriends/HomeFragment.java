package dam.aguadulce.aal.marioandfriends;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import com.google.android.material.snackbar.Snackbar;
import java.util.ArrayList;
import java.util.Arrays;
import dam.aguadulce.aal.marioandfriends.databinding.FragmentHomeBinding;


/**
 * Clase que implementa el recyclerview del fragmento home
 */
public class HomeFragment extends Fragment {

    private FragmentHomeBinding binding; // No es necesario lateinit en Java, solo declaración
    private ArrayList<Character> characters;
    private CharRecyclerViewAdapter adapter;


    /**
     * Método que sobreescrive onCreateView para crear al mismo tiempo la lista de personajes a mostrar. También configura el recyclerview
     * @param inflater The LayoutInflater object that can be used to inflate
     * any views in the fragment,
     * @param container If non-null, this is the parent view that the fragment's
     * UI should be attached to.  The fragment should not add the view itself,
     * but this can be used to generate the LayoutParams of the view.
     * @param savedInstanceState If non-null, this fragment is being re-constructed
     * from a previous saved state as given here.
     *
     * @return View
     */
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inicializar binding
        binding = FragmentHomeBinding.inflate(inflater, container, false);

        binding = FragmentHomeBinding.inflate(getLayoutInflater());

        // Crear la lista de personajes
        characters = new ArrayList<>(Arrays.asList (
                new Character(R.drawable.mario, getString(R.string.mario_name), getString(R.string.mario_description), getString(R.string.mario_skills)),
                new Character(R.drawable.luigi, getString(R.string.luigi_name), getString(R.string.luigi_description), getString(R.string.luigi_skills)),
                new Character(R.drawable.peach, getString(R.string.peach_name), getString(R.string.peach_description), getString(R.string.peach_skills)),
                new Character(R.drawable.toad, getString(R.string.toad_name), getString(R.string.toad_description), getString(R.string.toad_skills)),
                new Character(R.drawable.lakitu, getString(R.string.lakitu_name), getString(R.string.lakitu_description), getString(R.string.lakitu_skills)),
                new Character(R.drawable.dkong, getString(R.string.kong_name), getString(R.string.dk_description), getString(R.string.dk_skills)),
                new Character(R.drawable.yoshi, getString(R.string.yoshi_name), getString(R.string.yoshi_description), getString(R.string.yoshi_skills)),
                new Character(R.drawable.paratroopa, getString(R.string.paratroopa_name), getString(R.string.paratroopa_description), getString(R.string.paratroopa_skills)),
                new Character(R.drawable.bowser, getString(R.string.bowser_name), getString(R.string.bowser_description), getString(R.string.bowser_skills)),
                new Character(R.drawable.planta, getString(R.string.plant_name), getString(R.string.planta_description), getString(R.string.planta_skills)),
                new Character(R.drawable.bullet, getString(R.string.bullet_name), getString(R.string.bullet_description), getString(R.string.bullet_skills)),
                new Character(R.drawable.star, getString(R.string.star_name), getString(R.string.star_description), getString(R.string.star_skills) ),
                new Character(R.drawable.mushroom, getString(R.string.mushroom_name), getString(R.string.mushroom_description), getString(R.string.mushroom_skills))
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
