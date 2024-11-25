package mk.ukim.finki.wp.lab.service;

import mk.ukim.finki.wp.lab.model.Song;

import java.util.List;
import java.util.Optional;

public interface SongService{
    List<Song> listSongs();
    void assignArtistToSong(Long artistId, String songId);

    Optional<Song> findByTrackId(String trackId);
}