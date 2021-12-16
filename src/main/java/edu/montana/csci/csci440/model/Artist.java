package edu.montana.csci.csci440.model;

import edu.montana.csci.csci440.util.DB;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Collection;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class Artist extends Model {

    Long artistId;
    String name;
    String original_Name;

    public Artist() {
    }

    private Artist(ResultSet results) throws SQLException {
        name = results.getString("Name");
        artistId = results.getLong("ArtistId");
        original_Name = name;
    }

    @Override
    public boolean verify() {
        _errors.clear(); // clear any existing errors
        if( name == null || name.trim().equals("")) {
            addError("Name cant be empty.");
        }
        return !hasErrors();
    }

    @Override
    public boolean create() {
        if (!verify()) {
            return false;
        }
        String q = "INSERT INTO artists (Name) VALUES (?)";
        try(Connection conn = DB.connect(); PreparedStatement stmt = conn.prepareStatement(q)) {
            stmt.setString(1, getName());

            int result = stmt.executeUpdate();
            this.artistId = DB.getLastID(conn);

            return result == 1;
        } catch (SQLException sqlException){
            throw new RuntimeException(sqlException);
        }
    }

    @Override
    public boolean update() {
        // validate data
        if (!verify()) {
            // not valid
            return false;
        }

        String q = "UPDATE artists SET Name=? WHERE ArtistId=? AND NAME=?";

        try(Connection conn = DB.connect(); PreparedStatement stmt = conn.prepareStatement(q)) {
            stmt.setString(1, getName());
            stmt.setLong(2, getArtistId());
            stmt.setString(3, original_Name);

            int result = stmt.executeUpdate();

            return result == 1;
        } catch (SQLException sqlException){
            throw new RuntimeException(sqlException);
        }
    }

    @Override
    public void delete() {

        List<Album> albums = this.getAlbums();
        for (Album a : albums) {
            a.delete();
        }

        String query = "DELETE FROM artists WHERE ArtistId=?";
        try(Connection conn = DB.connect(); PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setLong(1, getArtistId());
            int result = stmt.executeUpdate();
        } catch (SQLException sqlException){
            throw new RuntimeException(sqlException);
        }
    }

    public List<Album> getAlbums(){
        return Album.getForArtist(artistId);
    }

    public Long getArtistId() {
        return artistId;
    }

    public void setArtist(Artist artist) {
        this.artistId = artist.getArtistId();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public static List<Artist> all() {
        return all(0, Integer.MAX_VALUE);
    }

    public static List<Artist> all(int page, int count) {
        String query = "SELECT * FROM artists LIMIT ? OFFSET ?";
        return _all(page, count, query);
    }

    public static List<Artist> all(int page, int count, String orderBy, String sort) {
        String query = "SELECT * FROM artists ORDER BY "+orderBy+" "+sort+" LIMIT ? OFFSET ?";
        return _all(page, count, query);
    }

    private static List<Artist> _all(int page, int count, String q) {
        try (Connection conn = DB.connect(); PreparedStatement stmt = conn.prepareStatement(q)) {
            stmt.setInt(1, count);
            stmt.setInt(2, count * (page - 1));

            ResultSet results = stmt.executeQuery();
            List<Artist> resultList = new LinkedList<>();
            while (results.next()) {
                resultList.add(new Artist(results));
            }
            return resultList;
        } catch (SQLException sqlException) {
            throw new RuntimeException(sqlException);
        }
    }

    public static Artist find(long i) {
        String q = "SELECT * FROM artists WHERE ArtistId=?";

        try (Connection conn = DB.connect(); PreparedStatement stmt = conn.prepareStatement(q)) {
            stmt.setLong(1, i);
            ResultSet results = stmt.executeQuery();
            if (results.next()) {
                return new Artist(results);
            } else {
                return null;
            }
        } catch (SQLException sqlException) {
            throw new RuntimeException(sqlException);
        }
    }

}