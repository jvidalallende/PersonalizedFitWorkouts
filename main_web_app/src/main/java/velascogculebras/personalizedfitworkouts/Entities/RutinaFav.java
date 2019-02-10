package velascogculebras.personalizedfitworkouts.Entities;

public class RutinaFav extends Rutina {
    private boolean fav;

    public RutinaFav(Rutina rutina, boolean fav) {
        super(rutina);
        this.fav = fav;
    }
}
