package mk.ukim.finki.wp.lab.service.impl;

import mk.ukim.finki.wp.lab.service.ArtistService;
import org.springframework.stereotype.Service;

import mk.ukim.finki.wp.lab.model.Album;
import mk.ukim.finki.wp.lab.repository.AlbumRepository;
import mk.ukim.finki.wp.lab.service.AlbumService;

import java.util.List;
import java.util.Optional;

@Service
public class IAlbumService implements AlbumService {
    private final AlbumRepository repository;

    public IAlbumService(AlbumRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<Album> findAll() {
        return repository.findAll();
    }

    @Override
    public Optional<Album> findById(Long id) {
        return repository.findAlbumById(id);
    }
}
