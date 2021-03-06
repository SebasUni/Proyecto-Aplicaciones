package unipiloto.edu.co;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import unipiloto.edu.co.utilidades.Utilidades;

public class ConexionSQLiteHelper extends SQLiteOpenHelper {


    public ConexionSQLiteHelper(@Nullable Context context, @Nullable String name, @Nullable SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
    db.execSQL(Utilidades.CREAR_TABLA_USUARIO);
    db.execSQL(Utilidades.CREAR_TABLA_SOLICITUDES);
    db.execSQL(Utilidades.CREAR_TABLA_CARROS);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int versionAntigua, int versionNueva) {
        db.execSQL("DROP TABLE IF EXISTS usuarios");
        db.execSQL("DROP TABLE IF EXISTS solicitud");
        db.execSQL("DROP TABLE IF EXISTS carros");
        onCreate(db);
    }
}
