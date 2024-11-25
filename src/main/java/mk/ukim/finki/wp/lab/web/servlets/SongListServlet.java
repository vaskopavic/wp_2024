package mk.ukim.finki.wp.lab.web.servlets;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.thymeleaf.context.WebContext;
import org.thymeleaf.spring6.SpringTemplateEngine;
import org.thymeleaf.web.IWebExchange;
import org.thymeleaf.web.servlet.JakartaServletWebApplication;

import mk.ukim.finki.wp.lab.model.Song;
import mk.ukim.finki.wp.lab.service.SongService;

import java.io.IOException;
import java.util.List;

@WebServlet( name = "song-list-servlet", urlPatterns = "/listSongs")
public class SongListServlet extends HttpServlet {
    private final SongService songService;
    private final SpringTemplateEngine springTemplateEngine;


    public SongListServlet(SongService songService, SpringTemplateEngine springTemplateEngine) {
        this.songService = songService;
        this.springTemplateEngine = springTemplateEngine;
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        IWebExchange webExchange = JakartaServletWebApplication
                .buildApplication(getServletContext())
                .buildExchange(req, resp);

        WebContext context = new WebContext(webExchange);
        List<Song> songs = songService.listSongs();
        context.setVariable("songs",songs);
        springTemplateEngine.process("listSongs.html", context, resp.getWriter());

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Long trackId = Long.parseLong(req.getParameter("trackId"));
        Long artistId = Long.parseLong(req.getParameter("artistId"));
        songService.assignArtistToSong(artistId, trackId);
        resp.sendRedirect("/songDetails?trackId=" + trackId);
    }
}