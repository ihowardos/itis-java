package services;

import models.Prisoner;

import java.sql.SQLException;
import java.util.List;

/**
 * Created by Сергей on 06.12.2016.
 */
public interface PrisonerService {
    void create(Prisoner prisoner) throws SQLException;
    List<Prisoner> getAllPrisoners(int idPrison) throws SQLException;
    int getIdPrisoner() throws SQLException;
}
