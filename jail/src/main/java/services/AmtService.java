package services;

import java.sql.SQLException;

/**
 * Created by Сергей on 14.12.2016.
 */
public interface AmtService {
    int getAmt(int idPrison) throws SQLException;
}
