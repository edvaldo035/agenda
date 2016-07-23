package usuario.app.agenda.controller;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;
import java.util.List;

import usuario.app.agenda.contratos.ICrud;
import usuario.app.agenda.dao.ContatosDAO;
import usuario.app.agenda.dao.sqllitehelper;
import usuario.app.agenda.model.Contatos;


/**
 * Created by Administrador on 24/06/2016.
 */

public class contatosctrl implements ICrud {
    ContatosDAO dao;

    public contatosctrl(Context ctx){
        dao = new ContatosDAO("dbAgenda",ctx);
    }
    @Override
    public Contatos Insert(Contatos contatos) {
        return dao.Insert(contatos);
    }

    @Override
    public void update(Contatos contatos) {
        dao.update(contatos);
    }

    @Override
    public void excluir(Integer id) {
            dao.excluir(id);
    }

    @Override
    public ArrayList<Contatos> all() {
        return dao.all();
    }

    @Override
    public Contatos porID(Integer id) {
        return dao.porID(id);
    }

    @Override
    public ArrayList<Contatos> pelo(String Criterio) {
        return dao.pelo(Criterio);
    }
}
