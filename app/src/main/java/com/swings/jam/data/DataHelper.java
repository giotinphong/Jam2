package com.swings.jam.data;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.swings.jam.R;

import java.util.ArrayList;

/**
 * Created by sonnguyen on 6/28/17.
 */

public class DataHelper extends SQLiteOpenHelper {
    private static String DB_NAME = "DB";
    private static int VERSION = 1;
    private static String TB_BACKINGTRACK = "BACKING_TRACK";
    private static String TB_TYPESON = "TYPESON";
    private static String TB_TYPE  = "TYPE";
    private static String TB_JAM = "JAM";


    private static String BACKING_ID = "ID_BACKING";
    private static String BACKING_NAME = "NAME";
    private static String BACKING_COMPOSSER = "COMPOSSER";
    private static String BACKING_CHORD = "CHORD";
    private static String BACKING_ID_TYPESON = "ID_TYPESON";
    private static String BACKING_COUNT = "COUNT";
    private static String BACKING_IS_FAVORITE = "IS_FAVORITE";
    private static String BACKING_TONE = "TONE";
    private static String BACKING_LINK = "LINK_MP3";
    private static String BACKING_PURCHASE_LINK = "LINK_PURCHASE";
    private static String BACKING_TEMPO = "TEMPO";
    private static String BACKING_LOCATION = "LOCATION";

    private static String TYPESON_ID = "ID_TYPESON";
    private static String TYPESON_NAME = "NAME";
    private static String TYPESON_ID_TYPE = "ID_TYPE";
    private static String TYPESON_IMAGE = "IMAGE";

    private static String TYPE_ID = "ID_TYPE";
    private static String TYPE_NAME = "NAME";
    private static String TYPE_IMAGE = "IMAGE";

    private static String JAM_ID ="ID_JAM";
    private static String JAM_NAME ="NAME";
    private static String JAM_DATE ="DATE";
    private static String JAM_ID_BACKINGTRACK ="ID_BACKING";
    private static String JAM_LINK ="FILE_LINK";

    public DataHelper(Context context) {
        super(context, DB_NAME, null, VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        //create table type
        db.execSQL("CREATE TABLE TYPE (\n" +
                "    ID_TYPE INTEGER PRIMARY KEY AUTOINCREMENT\n" +
                "                    NOT NULL\n" +
                "                    ,\n" +
                "    NAME    VARCHAR NOT NULL,\n" +
                "    IMAGE   INTEGER DEFAULT (0)\n" +
                ");");
        //create table backing track
        db.execSQL("CREATE TABLE BACKING_TRACK (\n" +
                "    ID_BACKING  INTEGER PRIMARY KEY AUTOINCREMENT\n" +
                "                        NOT NULL\n" +
                "                        ,\n" +
                "    NAME        VARCHAR NOT NULL,\n" +
                "    COMPOSSER   VARCHAR,\n" +
                "    CHORD       VARCHAR ,\n" +
                "    ID_TYPESON  INTEGER NOT NULL\n" +
                "                        REFERENCES TYPESON (ID_TYPESON),\n" +
                "    COUNT       INTEGER DEFAULT (0),\n" +
                "    IS_FAVORITE BOOLEAN DEFAULT FALSE,\n" +
                "    TONE        VARCHAR NOT NULL,\n" +
                "    LINK_MP3        STRING  NOT NULL,\n" +
                "TEMPO  INTEGER DEFAULT (120),"+
                "LINK_PURCHASE STRING, "+
                BACKING_LOCATION+" STRING"+
                ");\n");
        //create table type son
        db.execSQL("CREATE TABLE TYPESON (\n" +
                "    ID_TYPESON INTEGER PRIMARY KEY AUTOINCREMENT\n" +
                "                       NOT NULL,\n" +
                "    NAME       VARCHAR NOT NULL,\n" +
                "    ID_TYPE    INTEGER NOT NULL,\n" +
                "    IMAGE      INTEGER DEFAULT (0));");
        //db.close();
        db.execSQL("CREATE TABLE "+TB_JAM+" (\n"+
                JAM_ID +" INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL,"+
                JAM_NAME+" VARCHAR NOT NULL,"+
                JAM_DATE+" LONG NOT NULL,"+
                JAM_ID_BACKINGTRACK+" INTEGER NOT NULL,"+
                JAM_LINK+" STRING NOT NULL);");
        initTypeData(db);
        initTypeSonData(db);
        initBackingTrack(db);
    }

    private void initBackingTrack(SQLiteDatabase db) {
            ArrayList<BackingTrack> backingTrackArrayList = new ArrayList<>();
        backingTrackArrayList.add(new BackingTrack("Rock Backing Track Jam in Bm","MyDarnJamTracks","Bm",6,"https://drive.google.com/open?id=0B_LvNdNrPBbyY3JpLWNmQ2F1d1k",120));
        backingTrackArrayList.add(new BackingTrack("Space Rock Backing Track Jam in Am","MyDarnJamTracks","Am",6,"https://drive.google.com/open?id=0B_LvNdNrPBbyZ3pLbmNSRUZDZTQ",120));
        backingTrackArrayList.add(new BackingTrack("Rock backing track in Am","masanoriutsumi","Am",6,"https://drive.google.com/open?id=0B_LvNdNrPBbySElmSWkybUJ5T00",120));
        backingTrackArrayList.get(0).setCount(10);
        backingTrackArrayList.get(1).setCount(8);
        backingTrackArrayList.get(2).setCount(9);
        //backingTrackArrayList.add(new BackingTrack("","","",6,"",120));
        for(BackingTrack backingTrack : backingTrackArrayList){
            ContentValues values = new ContentValues();
            values.put(BACKING_NAME,backingTrack.getName());
            values.put(BACKING_COMPOSSER,backingTrack.getComposser());
            values.put(BACKING_CHORD,backingTrack.getChord());
            values.put(BACKING_ID_TYPESON,backingTrack.getId_typeson());
            values.put(BACKING_LINK,backingTrack.getlinkMp3());
            values.put(BACKING_TEMPO,backingTrack.getTempo());
            values.put(BACKING_COUNT,backingTrack.getCount());
            values.put(BACKING_TONE,backingTrack.getTone());
            db.insert(TB_BACKINGTRACK,null,values);
        }


    }

    private void initTypeSonData(SQLiteDatabase db) {
        ArrayList<TypeSon> typeSonArrayList = new ArrayList<>();
        typeSonArrayList.add(new TypeSon(1,R.drawable.swingjazz,"Swing Jazz"));
        typeSonArrayList.add(new TypeSon(1,R.drawable.smooth_jazz,"Smooth Jazz"));
        typeSonArrayList.add(new TypeSon(1,R.drawable.gypsyjazz,"Gypsy Jazz"));
        typeSonArrayList.add(new TypeSon(1,R.drawable.cooljazz,"Cool Jazz"));
        typeSonArrayList.add(new TypeSon(1,R.drawable.bossa,"Bossa nova Jazz"));
        //rock
        typeSonArrayList.add(new TypeSon(2,R.drawable.rock,"Rock"));
        typeSonArrayList.add(new TypeSon(2,R.drawable.hardrock,"Hard Rock"));
        typeSonArrayList.add(new TypeSon(2,R.drawable.metal,"Metal"));
        //ballad
        typeSonArrayList.add(new TypeSon(3,R.drawable.ballad,"Ballad"));
        typeSonArrayList.add(new TypeSon(3,R.drawable.popballad,"Pop Ballad"));
        typeSonArrayList.add(new TypeSon(3,R.drawable.rockballad,"Rock Ballad"));
        //blue
        typeSonArrayList.add(new TypeSon(4,R.drawable.blues,"Blues"));
        typeSonArrayList.add(new TypeSon(4,R.drawable.slowblue,"Slow Blues"));
        typeSonArrayList.add(new TypeSon(4,R.drawable.funkyblue,"Funky Blues"));
        typeSonArrayList.add(new TypeSon(4,R.drawable.rockblue,"Rock Blues"));
        //pop
        typeSonArrayList.add(new TypeSon(5,R.drawable.pop,"Pop"));
        typeSonArrayList.add(new TypeSon(5,R.drawable.acoustic,"Acoustic Pop"));
        typeSonArrayList.add(new TypeSon(5,R.drawable.poprock,"Pop Rock"));
        //Other
        typeSonArrayList.add(new TypeSon(6,R.drawable.rnb,"RnB"));
        typeSonArrayList.add(new TypeSon(6,R.drawable.rocknroll,"Rock n Roll"));
        typeSonArrayList.add(new TypeSon(6,R.drawable.other,"Other"));

        for(TypeSon typeson : typeSonArrayList){
            ContentValues value = new ContentValues();
            value.put(TYPESON_ID_TYPE,typeson.getId_type());
            value.put(TYPESON_IMAGE,typeson.getImage());
            value.put(TYPESON_NAME,typeson.getName());
            db.insert(TB_TYPESON,null,value);
        }
    }

    private void initTypeData(SQLiteDatabase db) {
        ArrayList<Type> typeArrayList = new ArrayList<>();
        typeArrayList.add(new Type(R.drawable.jazz_thumbail,"JAZZ")); //1
        typeArrayList.add(new Type(R.drawable.rock_thumbail,"ROCK")); //2
        typeArrayList.add(new Type(R.drawable.ballad_thumbail,"BALLAD"));//3
        typeArrayList.add(new Type(R.drawable.blues_thumbail,"BLUES"));//4
        typeArrayList.add(new Type(R.drawable.pop_thumbail,"POP"));//5
        typeArrayList.add(new Type(R.drawable.other_thumbail,"Other"));//6
        for(Type type : typeArrayList){
            ContentValues value = new ContentValues();
            value.put(TYPE_NAME,type.getName());
            value.put(TYPE_IMAGE,type.getImage());
            db.insert(TB_TYPE,null,value);
        }

    }
    public void updateType(Type type){
        SQLiteDatabase db = this.getReadableDatabase();
        ContentValues value = new ContentValues();
        value.put(TYPE_NAME,type.getName());
        value.put(TYPE_IMAGE,type.getImage());
        db.update(TB_TYPE,value,TYPE_ID+" = ?",new String[]{type.getId()+""});
    }
    public ArrayList<Type> selectAllType(){
        ArrayList<Type> typeArrayList = new ArrayList<>();
        String query = "SELECT * FROM "+TB_TYPE;
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(query,null);
        if(cursor.moveToFirst()){
            do{
                Type type = new Type();
                type.setId(Integer.parseInt(cursor.getString(0)));
                type.setName(cursor.getString(1));
                type.setImage(Integer.parseInt(cursor.getString(2)));
                typeArrayList.add(type);
            }while (cursor.moveToNext());
        }
        return typeArrayList;
    }
    public Type selectType(int id){
        Type type = new Type();
        String query = "SELECT * FROM " + TB_TYPE+" WHERE ID = '" + id+"'";
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery(query,null);
        if(cursor !=null) {
            cursor.moveToFirst();
            type.setId(Integer.parseInt(cursor.getString(0)));
            type.setName(cursor.getString(1));
            type.setImage(Integer.parseInt(cursor.getString(2)));
        }
        return type;
    }
    public ArrayList<TypeSon> selectAllTypeSon(){
        ArrayList<TypeSon> typeArrayList = new ArrayList<>();
        String query = "SELECT * FROM "+TB_TYPESON;
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(query,null);
        if(cursor.moveToFirst()){
            do{
                TypeSon type = new TypeSon();
                type.setId(Integer.parseInt(cursor.getString(0)));

                type.setName(cursor.getString(1));
                type.setId_type(Integer.parseInt(cursor.getString(2)));
                type.setImage(Integer.parseInt(cursor.getString(2)));
                typeArrayList.add(type);
            }while (cursor.moveToNext());
        }
        return typeArrayList;
    }
    public ArrayList<TypeSon> selectAllTypeSonByIdType (int idType){
        ArrayList<TypeSon> typeArrayList = new ArrayList<>();
        String query = "SELECT * FROM "+TB_TYPESON+" where "+TYPESON_ID_TYPE+" = "+idType;
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(query,null);
        if(cursor.moveToFirst()){
            do{
                TypeSon type = new TypeSon();
                type.setId(Integer.parseInt(cursor.getString(0)));

                type.setName(cursor.getString(1));
                type.setId_type(Integer.parseInt(cursor.getString(2)));
                type.setImage(Integer.parseInt(cursor.getString(3)));
                typeArrayList.add(type);
            }while (cursor.moveToNext());
        }
        return typeArrayList;
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS "+TB_BACKINGTRACK);
        db.execSQL("DROP TABLE IF EXISTS "+TB_TYPE);
        db.execSQL("DROP TABLE IF EXISTS "+TB_TYPESON);
        db.execSQL("DROP TABLE IF EXISTS "+TB_JAM);
        onCreate(db);

    }

    public ArrayList<BackingTrack> getAllBackingtrack(){
        ArrayList<BackingTrack> backingTrackResultArraylist = new ArrayList<>();
        String query = "select * from " + TB_BACKINGTRACK;
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(query,null);
        if(cursor.moveToFirst()){
            do{
                BackingTrack backingTrack = new BackingTrack();
                backingTrack.setName(cursor.getString(cursor.getColumnIndex(BACKING_NAME)));
                backingTrack.setCount(Integer.parseInt(cursor.getString(cursor.getColumnIndex(BACKING_COUNT))));
                backingTrackResultArraylist.add(backingTrack);

            }while (cursor.moveToNext());
        }
        return backingTrackResultArraylist;
    }
    //get top most listen backingtrack, size is number of item display
    public ArrayList<BackingTrack> getTopListenBackingtrack(int size){
        ArrayList<BackingTrack> backingTrackResultArraylist = new ArrayList<>();
        String query = "select * from " + TB_BACKINGTRACK+ " where "+BACKING_COUNT+" >0 order by "+BACKING_COUNT+" DESC";
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(query,null);
        if(cursor.moveToFirst()){
            do{
               BackingTrack backingTrack = new BackingTrack();
                backingTrack.setName(cursor.getString(cursor.getColumnIndex(BACKING_NAME)));
                backingTrack.setCount(Integer.parseInt(cursor.getString(cursor.getColumnIndex(BACKING_COUNT))));
                backingTrackResultArraylist.add(backingTrack);
                size--;
            }while (cursor.moveToNext()&&size>0);
        }
        return backingTrackResultArraylist;
    }
    public BackingTrack getBackingTrackById(int id){
        BackingTrack backingTrackResult = new BackingTrack();
        String query = "select * from "+TB_BACKINGTRACK+" where id = "+id;
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(query,null);
        if(cursor!=null){
            cursor.moveToFirst();
            backingTrackResult.setId(Integer.parseInt(cursor.getString(cursor.getColumnIndex(BACKING_ID))));
            backingTrackResult.setCount(Integer.parseInt(cursor.getString(cursor.getColumnIndex(BACKING_COUNT))));
            backingTrackResult.setTempo(Integer.parseInt(cursor.getString(cursor.getColumnIndex(BACKING_TEMPO))));
            backingTrackResult.setId_typeson(Integer.parseInt(cursor.getString(cursor.getColumnIndex(BACKING_ID_TYPESON))));
            backingTrackResult.setFavorite(Boolean.parseBoolean(cursor.getString(cursor.getColumnIndex(BACKING_IS_FAVORITE))));
            backingTrackResult.setName(cursor.getString(cursor.getColumnIndex(BACKING_NAME)));
            backingTrackResult.setComposser(cursor.getString(cursor.getColumnIndex(BACKING_COMPOSSER)));
            backingTrackResult.setTone(cursor.getString(cursor.getColumnIndex(BACKING_TONE)));
            backingTrackResult.setChord(cursor.getString(cursor.getColumnIndex(BACKING_CHORD)));
            backingTrackResult.setLinkMp3(cursor.getString(cursor.getColumnIndex(BACKING_LINK)));
            backingTrackResult.setLinkPurchase(cursor.getString(cursor.getColumnIndex(BACKING_PURCHASE_LINK)));
            backingTrackResult.setLocationUri(cursor.getString(cursor.getColumnIndex(BACKING_LOCATION)));
            return backingTrackResult;
        }
        return null;
    }

    public TypeSon getTypeSonById(int id_typeson) {
        TypeSon typeSon = new TypeSon();
        String query = "select * from "+TB_TYPESON+ " where id = "+id_typeson;
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(query,null);
        if(cursor!=null) {
            cursor.moveToFirst();
            typeSon.setId_type(Integer.parseInt(cursor.getString(cursor.getColumnIndex(TYPESON_ID_TYPE))));
            typeSon.setImage(Integer.parseInt(cursor.getString(cursor.getColumnIndex(TYPESON_IMAGE))));
            typeSon.setId(id_typeson);
            typeSon.setName(cursor.getString(cursor.getColumnIndex(TYPE_NAME)));
            return typeSon;
        }
        return null;
    }

    public ArrayList<YourJam> getAllJam() {
        ArrayList<YourJam> jamArrayList = new ArrayList<>();
        String query = "select * from "+TB_JAM;
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery(query,null);
        if(cursor.moveToFirst()){
            do{
                YourJam jam = new YourJam();
                jam.setName(cursor.getString(cursor.getColumnIndex(JAM_NAME)));
                jam.setFileLink(cursor.getString(cursor.getColumnIndex(JAM_LINK)));
                jam.setIdBackingTrack(Integer.parseInt(cursor.getString(cursor.getColumnIndex(JAM_ID_BACKINGTRACK))));
                jam.setIdJam(Integer.parseInt(cursor.getString(cursor.getColumnIndex(JAM_ID))));
                jam.setTime(Long.parseLong(cursor.getString(cursor.getColumnIndex(JAM_DATE))));
                jamArrayList.add(jam);

            }while (cursor.moveToNext());
        }
        return jamArrayList;
    }

    public int countSongByTypeSonId(int id) {
        String query = "select count(*) from "+TB_BACKINGTRACK+ " where "+BACKING_ID_TYPESON+" = "+id;
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery(query,null);
        if(cursor!=null) {
            cursor.moveToFirst();
            return Integer.parseInt(cursor.getString(0));
        }
        return 0;
    }
}
