package mk.ukim.finki.wp.lab.web.controller;

import mk.ukim.finki.wp.lab.model.Album;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import mk.ukim.finki.wp.lab.model.Song;
import mk.ukim.finki.wp.lab.model.exceptions.InvalidAlbumIdException;
import mk.ukim.finki.wp.lab.service.SongService;
import mk.ukim.finki.wp.lab.service.ArtistService;
import mk.ukim.finki.wp.lab.service.AlbumService;

import java.util.Optional;

@Controller
@RequestMapping("/")
public class SongController {

    private final SongService songService;
    private final ArtistService artistService;
    private final AlbumService albumService;

    public SongController(SongService songService, AlbumService albumService, ArtistService artistService) {
        this.songService = songService;
        this.albumService = albumService;
        this.artistService = artistService;
    }

    @GetMapping
    public String redirectToListSongs() {
        return "redirect:/listSongs";
    }

    @GetMapping("/songs")
    public String getSongsPage(@RequestParam(required = false) String error, Model model) {
        model.addAttribute("songs", songService.listSongs());
        model.addAttribute("error", error);
        return "listSongs";
    }

    @PostMapping("/songs/add")
    public String saveSong(@RequestParam String title, @RequestParam Long trackId, @RequestParam String genre, @RequestParam Integer releaseYear, @RequestParam Album album) {
            this.songService.save(title, trackId, genre, releaseYear, album);
            return "redirect:/songs";
    }

    @GetMapping("/songs/edit/{songId}")
    public String editSong(@PathVariable Long songId, @RequestParam(required = false) String title, @RequestParam(required = false) String genre, @RequestParam(required = false) Integer releaseYear, @RequestParam(required = false) Long albumId) {
        Song song = this.songService.findByTrackId(songId);
        song.setTitle(title);
        song.setGenre(genre);
        song.setReleaseYear(releaseYear);
        song.setAlbum(albumService.findById(albumId).orElseThrow(() -> new InvalidAlbumIdException(albumId)));
        return "redirect:/songs";
    }

    @GetMapping("/songs/delete/{id}")
    public String deleteSong(@PathVariable Long id) {
        songService.deleteById(id);
        return "redirect:/songs";
    }

    @GetMapping("/listSongs")
    public String getSongs(Model model) {
        model.addAttribute("songs", songService.listSongs());
        return "listSongs";
    }

    @GetMapping("/songDetails")
    public String getSongDetails(@RequestParam Long trackId, Model model) {
        Song song = songService.findByTrackId(trackId);
        model.addAttribute("song", song);
        return "songDetails";
    }
}
