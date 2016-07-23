package usuario.app.agenda.dao;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;
import java.util.List;

import usuario.app.agenda.contratos.ICrud;
import usuario.app.agenda.model.Contatos;

/**
 * Created by Administrador on 24/06/2016.
 */
public class ContatosDAO implements ICrud  {

    SQLiteDatabase banco;
    sqllitehelper help;

    public ContatosDAO (String nomedb, Context ctx){
        help = new sqllitehelper(nomedb,ctx);
        banco =help.criaouabredb();
    }

    @Override
    public Contatos Insert( Contatos contatos) {
        ContentValues valores = new ContentValues();
        valores.put("Nome",contatos.getNome());
        valores.put("Fone",contatos.getFone());
        valores.put("Email",contatos.getEmail());
        valores.put("Observacao",contatos.getObservacao());

        banco.insert("Contatos",null,valores);
        return null;
    }


    @Override
    public void update(Contatos contatos) {
      int retorno;
      ContentValues valores = new ContentValues();

      valores.put("Nome",contatos.getNome());
      valores.put("Fone", contatos.getFone());
      valores.put("Email", contatos.getEmail());
      valores.put("Observacao", contatos.getObservacao());

      retorno =  banco.update("Contatos", valores, "id=" + String.valueOf(contatos.getId()), null);

    }

    @Override
    public void excluir(Integer id) {

    }

    @Override
    public ArrayList<Contatos> all() {
        Cursor c = banco.query("Contatos", new String[]{"Id","Nome", "Fone", "Email", "Observacao"},null, null, null, null, null, null);
        ArrayList<Contatos> lista = new ArrayList<Contatos>();
        c.moveToFirst();
        while (!c.isAfterLast()){
            Contatos ct = new Contatos();
            ct.setId(c.getInt(0));
            ct.setNome(c.getString(1));
            ct.setFone(c.getString(2));
            ct.setEmail(c.getString(3));
            ct.setObservacao(c.getString(4));
            lista.add(ct);
            c.moveToNext();
        }

        c.close();
        return lista;

    }

    @Override
    public ArrayList<Contatos> pelo(String Criterio) {
        String campo;

        if (isNumeric(Criterio))
            campo = "Fone";
       else
         campo = "Nome";


      Cursor  c =   banco.query(true, "Contatos", new String[] { "Id",
                        "Nome", "Fone","Email","Observacao" }, campo + " LIKE ?",
                new String[] {"%"+ Criterio+ "%" }, null, null, null,
                null);

        ArrayList<Contatos> lista = new ArrayList<Contatos>();
        c.moveToFirst();
        while (!c.isAfterLast()){
            Contatos ct = new Contatos();
            ct.setId(c.getInt(0));
            ct.setNome(c.getString(1));
            ct.setFone(c.getString(2));
            ct.setEmail(c.getString(3));
            ct.setObservacao(c.getString(4));
            lista.add(ct);
            c.moveToNext();
        }
        // fechando a conexão
        c.close();
        return lista;
    }

    private boolean isNumeric(String criterio) {
        int valor;
        try{
            valor = Integer.valueOf(criterio);
            return true;
        }catch (Exception ex){
            return false;
        }

    }

    @Override
    public Contatos porID(Integer id) {

        Cursor c = banco.query(false, "Contatos", new String[]{"Id","Nome", "Fone", "Email", "Observacao"}, "Id=" + String.valueOf(id).toString(), null, null, null, null, null);

        ArrayList<Contatos> lista = new ArrayList<Contatos>();
        c.moveToFirst();
        Contatos ct = new Contatos();

        ct.setId(c.getInt(0));
        ct.setNome(c.getString(1));
        ct.setFone(c.getString(2));
        ct.setEmail(c.getString(3));
        ct.setObservacao(c.getString(4));

        c.close();
        return ct;
    }


}
