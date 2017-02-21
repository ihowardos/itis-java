package services;

import java.sql.SQLException;

/**
 * Created by Сергей on 15.12.2016.
 */
public interface PrisonerHasArticlesService {
    void create(int idPrisoner, int idArticle) throws SQLException;
}
