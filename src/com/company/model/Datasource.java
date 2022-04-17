package com.company.model;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class Datasource {
      public static final String CONNECTION_URL = "jdbc:sqlite:/Users/mac/Documents/Sankore Repo/WorkingWithJDBCDriver/music.db";

      public static final String TABLE_ALBUMS = "albums";
      public static final String COLUMN_ALBUMS_ID = "_id";
      public static final String COLUMN_ALBUMS_NAME = "name";
      public static final String COLUMN_ALBUMS_ARTIST = "artist";
      public static final int INDEX_ALBUMS_ID = 1;
      public static final int INDEX_ALBUMS_NAME = 2;
      public static final int INDEX_ALBUMS_ARTIST = 3;

      public static final String TABLE_ARTISTS= "artists";
      public static final String COLUMN_ARTISTS_ID = "_id";
      public static final String COLUMN_ARTISTS_NAME = "name";
      public static final int INDEX_ARTISTS_ID = 1;
      public static final int INDEX_ARTISTS_NAME = 2;


      public static final String TABLE_SONG = "songs";
      public static final String COLUMN_SONG_ID = "_id";
      public static final String COLUMN_SONG_TRACK = "track";
      public static final String COLUMN_SONG_TITLE = "title";
      public static final String COLUMN_SONG_ALBUM = "album";
      public static final int INDEX_SONG_ID = 1;
      public static final int INDEX_SONG_TRACK = 2;
      public static final int INDEX_SONG_TITLE = 3;
      public static final int INDEX_SONG_ALBUM = 4;


      private Connection connection;   // here we try to open and close the database


      public boolean open() {
            try {
                  connection = java.sql.DriverManager.getConnection(CONNECTION_URL);
                System.out.println("Connection opened");
                return true;
            } catch (SQLException e) {
                System.out.println("hold on can't see db");
                  e.printStackTrace();
                  return false;
            }
      }

     // close the connection
      public void close() {
            try {
                if (connection != null) {
                  connection.close();
                  System.out.println("Connection closed");
                }

            } catch (SQLException e) {
                  e.printStackTrace();
                System.out.println("hold on can't see db to close my mans" + e.getMessage());
            }
      }

    //query the artist table and return the list of artists
      public List<Artist> getArtists() {

          try {
              Statement statement = connection.createStatement();
              ResultSet result = statement.executeQuery("SELECT * FROM " + TABLE_ARTISTS);

              List<Artist> artists = new ArrayList<>();
              while (result.next()) {
                  //delclare a list of artists
                    Artist artist = new Artist();
                    artist.setId(result.getInt(COLUMN_ARTISTS_ID));
                    artist.setName(result.getString(COLUMN_ARTISTS_NAME));
                    artists.add(artist);
              }
              return artists;
          } catch (SQLException e) {
              System.out.println("Query failed" + e.getMessage());
                return  null;

          }
      }

      //print all artists

}

