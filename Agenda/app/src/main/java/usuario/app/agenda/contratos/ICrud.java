package usuario.app.agenda.contratos;

import java.util.ArrayList;
import java.util.List;

import usuario.app.agenda.model.Contatos;

/**
 * Created by Administrador on 27/06/2016.
 */
public interface ICrud {
    public Contatos Insert(Contatos contatos) ;
    public void update(Contatos contatos) ;
    public void excluir(Integer id) ;
    public List<Contatos> all() ;
    public Contatos porID(Integer id);
    public ArrayList<Contatos> pelo(String Criterio);

}
