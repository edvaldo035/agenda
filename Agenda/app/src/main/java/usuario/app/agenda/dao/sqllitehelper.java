package usuario.app.agenda.dao;

import android.content.Context;
import android.database.*;
import android.database.sqlite.SQLiteDatabase;

import java.sql.SQLData;
import java.sql.SQLException;

import static android.database.sqlite.SQLiteDatabase.openOrCreateDatabase;


/**
 * Created by Administrador on 24/06/2016.
 */
public class sqllitehelper {
    Context contexot_usado;
    String nome_Banco;
    SQLiteDatabase db    ;

    public  sqllitehelper (String nome, Context ctx){
        this.contexot_usado = ctx;
        this.nome_Banco = nome;
    }
    public  SQLiteDatabase criaouabredb()  {
       db = contexot_usado.openOrCreateDatabase(nome_Banco,contexot_usado.MODE_PRIVATE,null);
       db.execSQL("create table if not exists Contatos( Id integer primary key autoincrement, " +
               "Nome text not null,Fone text not null, Email text," +
               "Observacao text)");
       return db;
    }

}
