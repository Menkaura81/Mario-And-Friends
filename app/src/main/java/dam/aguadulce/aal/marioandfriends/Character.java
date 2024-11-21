package dam.aguadulce.aal.marioandfriends;

/**
 * Clase que implementa el concepto de personaje del mundo Mario
 */
public class Character {

    private final int image;
    private final String name;
    private final String description;
    private final String skills;


    /**
     * Metodo constructor
     * @param image int Indice de la imagen del personaje
     * @param name String Nombre del personaje
     * @param description String Breve descripcion del personaje
     * @param skills String Habilidades del personaje
     */
    public Character(int image, String name, String description, String skills){
        this.image = image;
        this.name = name;
        this.description = description;
        this.skills = skills;
    }


    /**
     * Método getter para el valor de la imagen de personaje
     * @return int valor de la imagen
     */
    public int getImage(){
        return image;
    }


    /**
     * Método getter para la cadena del nombre del personaje
     * @return String Nombre del personaje
     */
    public String getName(){
        return name;
    }


    /**
     * Método getter para la cadena de la descripción del personaje
     * @return String Breve descripción del personaje
     */
    public String getDescription(){
        return description;
    }


    /**
     * Método getter para la cadena de las habilidades del personaje
     * @return String Habilidades del personaje
     */
    public String getSkills(){
        return skills;
    }
}