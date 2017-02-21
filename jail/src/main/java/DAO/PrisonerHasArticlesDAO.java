package DAO;

import java.sql.SQLException;

/**
 * Created by Сергей on 15.12.2016.
 */
public interface PrisonerHasArticlesDAO {
    void create(int idPrisoner, int idArticle) throws SQLException;

}
