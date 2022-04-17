package com.company;

import com.company.model.Artist;
import com.company.model.Datasource;

import java.util.List;

public class Main {

    public static void main(String[] args) {
	// write your code here
        Datasource datasource = new Datasource();
        if (!datasource.open()) {
            System.out.println("Error opening database");
            return;
        }

        // query all artists in the database and print their names
        List<Artist> artists = datasource.getArtists();
            if (artists == null) {
                System.out.println("Error getting artists");
                return;
            }
        System.out.println("=========List of Artist we have got from database=========");
            for (Artist artist : artists) {
                System.out.println("ID=  " + artist.getId() + " Artist Name= " + artist.getName());
            }
        datasource.close();
    }
}
