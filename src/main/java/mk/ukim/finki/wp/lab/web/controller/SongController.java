package mk.ukim.finki.wp.lab.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import mk.ukim.finki.wp.lab.model.Song;
import mk.ukim.finki.wp.lab.service.SongService;

@Controller
@RequestMapping("/")
public class SongController {
    private final SongService songService;

    public SongController(SongService songService) {
        this.songService = songService;
    }

    @GetMapping
    public String redirectToListSongs() {
        return "redirect:/listSongs";
    }

    @GetMapping("/listSongs")
    public String getSongs(Model model) {
        model.addAttribute("songs", songService.listSongs());
        return "listSongs";
    }

    @GetMapping("/songDetails")
    public String getSongDetails(@RequestParam String trackId, Model model) {
        Song song = songService.findByTrackId(trackId).orElseThrow(() -> new IllegalArgumentException("Invalid track ID"));
        model.addAttribute("song", song);
        return "songDetails";
    }
}
