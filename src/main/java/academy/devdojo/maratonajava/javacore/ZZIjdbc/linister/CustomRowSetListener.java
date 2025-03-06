package academy.devdojo.maratonajava.javacore.ZZIjdbc.linister;

import lombok.extern.log4j.Log4j2;

import javax.sql.RowSet;
import javax.sql.RowSetEvent;
import javax.sql.RowSetListener;
import java.sql.SQLException;

@Log4j2
public class CustomRowSetListener implements RowSetListener {
    @Override
    public void rowSetChanged(RowSetEvent event) {
        log.info("Comando execute acionado");
    }

    @Override
    public void rowChanged(RowSetEvent event) {
log.info("Linha inserida, atualizada ou deletada");
        if (event.getSource() instanceof RowSet){
            try {
                ((RowSet) event.getSource()).execute();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public void cursorMoved(RowSetEvent event) {
        log.info("Cursor movido");
    }
}
