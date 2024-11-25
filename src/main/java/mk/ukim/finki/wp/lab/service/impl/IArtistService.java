package mk.ukim.finki.wp.lab.service.impl;

import org.springframework.stereotype.Service;

import mk.ukim.finki.wp.lab.model.Artist;
import mk.ukim.finki.wp.lab.repository.ArtistRepository;
import mk.ukim.finki.wp.lab.service.ArtistService;

import java.util.List;
import java.util.Optional;

@Service
public class IArtistService implements ArtistService {
    private final ArtistRepository repository;

    public IArtistService(ArtistRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<Artist> listArtists() {
        return repository.findAll();
    }

    @Override
    public Optional<Artist> ArtistFindById(Long id) {
        return repository.findById(id);
    }
}