package AbstractFactory.Movies;

import AbstractFactory.Languages.Language;
import AbstractFactory.Subtitles.Subtitles;

/**
 * Created by Сергей on 09.03.2017.
 */
public interface FilmFactory {
    Language getLanguage();
    Subtitles getSubtitles();

}
