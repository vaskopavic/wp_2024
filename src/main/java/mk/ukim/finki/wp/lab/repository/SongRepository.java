package mk.ukim.finki.wp.lab.repository;

import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Repository;

import mk.ukim.finki.wp.lab.model.Artist;
import mk.ukim.finki.wp.lab.model.Song;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
public class SongRepository {
    private final List<Song> songs;

    public SongRepository() {
        this.songs = new ArrayList<>();
    }

    @PostConstruct
    public void init(){
        songs.add(new Song("1", "SICKO MODE", "Hip-Hop", 2018, new ArrayList<>()));
        songs.add(new Song("2", "Stronger", "Hip-Hop", 2007, new ArrayList<>()));
        songs.add(new Song("3", "Day 'n' Nite", "Hip-Hop", 2008, new ArrayList<>()));
        songs.add(new Song("4", "HUMBLE.", "Hip-Hop", 2017, new ArrayList<>()));
        songs.add(new Song("5", "God's Plan", "Hip-Hop", 2018, new ArrayList<>()));
    }

    public List<Song> findAll(){
        return songs;
    }
    public Optional<Song> findByTrackId(String trackId){
        return songs.stream()
                .filter(s->s.getTrackId().equals(trackId))
                .findFirst();
    }
    public void addArtistToSong(Artist artist, Song song){
        song.getPerformers().removeIf(a->a.getId().equals(artist.getId()));
        song.getPerformers().add(artist);
    }
}