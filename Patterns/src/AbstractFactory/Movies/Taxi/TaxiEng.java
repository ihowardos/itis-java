package AbstractFactory.Movies.Taxi;

import AbstractFactory.Languages.Language;
import AbstractFactory.Languages.TaxiEngLang;
import AbstractFactory.Movies.FilmFactory;
import AbstractFactory.Subtitles.Subtitles;
import AbstractFactory.Subtitles.TaxiEngSub;

/**
 * Created by Сергей on 09.03.2017.
 */
public class TaxiEng implements FilmFactory {
    @Override
    public Language getLanguage() {
        return new TaxiEngLang();
    }

    @Override
    public Subtitles getSubtitles() {
        return new TaxiEngSub();
    }
}
