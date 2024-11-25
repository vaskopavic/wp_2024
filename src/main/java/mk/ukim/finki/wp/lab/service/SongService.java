package mk.ukim.finki.wp.lab.service;

import mk.ukim.finki.wp.lab.model.Album;
import mk.ukim.finki.wp.lab.model.Song;

import java.util.List;
import java.util.Optional;

public interface SongService{
    List<Song> listSongs();

    void addSong(String title, Long trackId, String genre, int releaseYear, Long albumId);

    void assignArtistToSong(Long artistId, Long trackId);

    Song findByTrackId(Long trackId);

    Optional<Song> save(String title, Long trackId, String genre, Integer releaseYear, Album album);

    void deleteById(Long id);
}