package AbstractFactory;


import AbstractFactory.Movies.FilmFactory;

/**
 * Created by Сергей on 09.03.2017.
 */
public class Test {
    public static void main(String[] args) {
        Client test = new Client();

        FilmFactory film = test.findMovieWithLang("Taxi", "RU");
        System.out.println(film.getLanguage().getLanguage());

    }
}
