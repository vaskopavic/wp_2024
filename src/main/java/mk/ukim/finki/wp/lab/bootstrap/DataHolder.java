package mk.ukim.finki.wp.lab.bootstrap;

import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Component;

import mk.ukim.finki.wp.lab.model.Artist;
import mk.ukim.finki.wp.lab.model.Song;
import mk.ukim.finki.wp.lab.model.Album;

import java.util.ArrayList;
import java.util.List;

@Component
public class DataHolder {

    public static List<Artist> artists = null;
    public static List<Song> songs = null;
    public static List<Album> albums = null;

    @PostConstruct
    public void init(){
        artists = new ArrayList<>();
        artists.add(new Artist(1L, "Travis", "Scott", "American rapper, singer, songwriter, and record producer."));
        artists.add(new Artist(2L, "Kanye", "West", "American rapper, producer, and fashion designer."));
        artists.add(new Artist(3L, "Kid", "Cudi", "American rapper, singer, songwriter, and actor."));
        artists.add(new Artist(4L, "Kendrick", "Lamar", "American rapper, songwriter, and record producer."));
        artists.add(new Artist(5L, "Drake", "Graham", "Canadian rapper, singer, and songwriter."));

        albums = new ArrayList<>();
        albums.add(new Album(11L, "Astroworld", "Hip-Hop", "2018"));
        albums.add(new Album(12L, "Graduation", "Hip-Hop", "2007"));
        albums.add(new Album(13L, "Man on the Moon: The End of Day", "Hip-Hop", "2009"));
        albums.add(new Album(14L, "DAMN.", "Hip-Hop", "2017"));
        albums.add(new Album(15L, "Scorpion", "Hip-Hop", "2018"));

        songs = new ArrayList<>();
        songs.add(new Song("SICKO MODE", "Hip-Hop", 2018, albums.get(0)));
        songs.add(new Song("Stronger", "Hip-Hop", 2007, albums.get(1)));
        songs.add(new Song("Day 'n' Nite", "Hip-Hop", 2008, albums.get(2)));
        songs.add(new Song("HUMBLE.", "Hip-Hop", 2017, albums.get(3)));
        songs.add(new Song("God's Plan", "Hip-Hop", 2018, albums.get(4)));
    }
}