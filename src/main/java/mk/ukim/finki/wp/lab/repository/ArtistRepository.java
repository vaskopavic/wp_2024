package mk.ukim.finki.wp.lab.repository;

import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Repository;

import mk.ukim.finki.wp.lab.model.Artist;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Repository
public class ArtistRepository {
    private final List<Artist> artists;

    public ArtistRepository() {
        artists = new ArrayList<>();
    }

    @PostConstruct
    public void init(){
        artists.add(new Artist(1L, "Travis", "Scott", "American rapper, singer, songwriter, and record producer, known for his unique style and albums like 'Astroworld'."));
        artists.add(new Artist(2L, "Kanye", "West", "American rapper, producer, and fashion designer, renowned for his influence on hip-hop and albums like 'The College Dropout' and 'My Beautiful Dark Twisted Fantasy'."));
        artists.add(new Artist(3L, "Kid", "Cudi", "American rapper, singer, songwriter, and actor, known for pioneering a new wave of introspective hip-hop and albums like 'Man on the Moon: The End of Day'."));
        artists.add(new Artist(4L, "Kendrick", "Lamar", "American rapper, songwriter, and record producer, acclaimed for his storytelling and albums like 'To Pimp a Butterfly' and 'DAMN.'."));
        artists.add(new Artist(5L, "Drake", "Graham", "Canadian rapper, singer, and songwriter, one of the world's best-selling music artists, known for hits like 'Take Care' and 'Scorpion'."));
    }

    public List<Artist> findAll(){
        return artists;
    }
    public Optional<Artist> findById(Long id){
        return artists.stream()
                .filter(a-> Objects.equals(a.getId(), id))
                .findFirst();
    }
}