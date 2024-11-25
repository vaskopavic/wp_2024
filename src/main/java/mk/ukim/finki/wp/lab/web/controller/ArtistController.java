package mk.ukim.finki.wp.lab.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import mk.ukim.finki.wp.lab.model.Song;
import mk.ukim.finki.wp.lab.service.ArtistService;
import mk.ukim.finki.wp.lab.service.SongService;

@Controller
@RequestMapping("/artist")
public class ArtistController {
    private final ArtistService artistService;
    private final SongService songService;

    public ArtistController(ArtistService artistService, SongService songService) {
        this.artistService = artistService;
        this.songService = songService;
    }

    @PostMapping
    public String getArtistsForSong(@RequestParam String trackId, Model model) {
        Song song = songService.findByTrackId(trackId).orElseThrow(() -> new IllegalArgumentException("Invalid track ID"));
        model.addAttribute("trackId", trackId);
        model.addAttribute("artists", artistService.listArtists());
        return "artistsList";
    }

    @PostMapping("/add")
    public String addArtistToSong(@RequestParam Long artistId, @RequestParam String trackId) {
        songService.findByTrackId(trackId)
                .ifPresent(song -> artistService.ArtistFindById(artistId)
                        .ifPresent(artist -> songService.assignArtistToSong(artist.getId(), song.getTrackId())));
        return "redirect:/songDetails?trackId=" + trackId;
    }
}
