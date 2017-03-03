package AbstractFactory;

import AbstractFactory.Languages.Language;
import AbstractFactory.Languages.RuLan;
import AbstractFactory.Subtitles.RuSub;
import AbstractFactory.Subtitles.Subtitles;

/**
 * Created by Сергей on 03.03.2017.
 */
public abstract class FilmFactory {
    abstract Language getLanguage();
    abstract Subtitles getSubtitles();
}
