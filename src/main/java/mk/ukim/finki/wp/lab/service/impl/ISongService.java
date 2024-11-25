package mk.ukim.finki.wp.lab.service.impl;

import mk.ukim.finki.wp.lab.model.Album;
import org.springframework.stereotype.Service;

import mk.ukim.finki.wp.lab.model.Artist;
import mk.ukim.finki.wp.lab.model.Song;
import mk.ukim.finki.wp.lab.repository.ArtistRepository;
import mk.ukim.finki.wp.lab.repository.SongRepository;
import mk.ukim.finki.wp.lab.service.SongService;

import java.util.List;
import java.util.Optional;

@Service
public class ISongService implements SongService {
    private final SongRepository songRepository;
    private final ArtistRepository artistRepository;

    public ISongService(SongRepository songRepository, ArtistRepository artistRepository) {
        this.songRepository = songRepository;
        this.artistRepository = artistRepository;
    }

    @Override
    public List<Song> listSongs() {
        return songRepository.findAll();
    }

    @Override
    public void assignArtistToSong(Long artistId, Long trackId) {
        Artist artist = artistRepository.findById(artistId)
                .orElseThrow(() -> new RuntimeException("Artist not found with ID: " + artistId));
        Song song = songRepository.findByTrackId(trackId)
                .orElseThrow(() -> new RuntimeException("Song not found with track ID: " + trackId));

        this.AddArtistToSong(artist, song);
    }

    public void AddArtistToSong(Artist artist, Song song) {
        songRepository.addArtistToSong(artist, song);
    }

    @Override
    public Song findByTrackId(Long trackId) {
        return songRepository.findByTrackId(trackId);
    }

    Override
    public Optional<Song> save(String title, String genre, Integer releaseYear, Album album) {
        return songRepository.save(title, genre, releaseYear, album);
    }

    @Override
    public void deleteById(Long id) {
        this.songRepository.deleteById(id);
    }
}