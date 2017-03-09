package AbstractFactory.Movies.Taxi;

import AbstractFactory.Languages.Language;
import AbstractFactory.Languages.TaxiRuLang;
import AbstractFactory.Movies.FilmFactory;
import AbstractFactory.Subtitles.Subtitles;
import AbstractFactory.Subtitles.TaxiRuSub;

/**
 * Created by Сергей on 09.03.2017.
 */
public class TaxiRu implements FilmFactory {

    @Override
    public Language getLanguage() {
        return new TaxiRuLang();
    }

    @Override
    public Subtitles getSubtitles() {
        return new TaxiRuSub();
    }
}
