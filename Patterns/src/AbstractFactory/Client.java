package AbstractFactory;


import AbstractFactory.Movies.FilmFactory;
import AbstractFactory.Movies.Taxi.TaxiEng;
import AbstractFactory.Movies.Taxi.TaxiRu;

/**
 * Created by Сергей on 09.03.2017.
 */
public class Client {
    public FilmFactory findMovieWithLang(String name, String language) {
        FilmFactory film = null;

        /*
        * Проверяем, есть ли в списке такой фильм
        * Если есть, то выполняем следующий кусок кода
        * */

        if (language.equals("RU")) {
            film = new TaxiRu();
        } else if (language.equals("ENG")) {
            film = new TaxiEng();
        }

        if (film != null) {
            return film;
        } else {
            System.out.println("This movie not found!");
            return null;
        }
    }

    public FilmFactory findMovieWithSub(String name, String subtitles) {
        FilmFactory film = null;

        /*
        * Проверяем, есть ли в списке такой фильм
        * Если есть, то выполняем следующий кусок кода
        * */

        if (subtitles.equals("RU")) {
            film = new TaxiRu();
        } else if (subtitles.equals("ENG")) {
            film = new TaxiEng();
        }

        if (film != null) {
            return film;
        } else {
            System.out.println("This movie not found!");
            return null;
        }
    }
}
