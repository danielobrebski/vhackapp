package pl.pw.vhacks.utils.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import pl.pw.vhacks.utils.repositories.MediaRepository;

import java.sql.SQLException;

@RestController
@RequiredArgsConstructor
class MediaController {

    private final MediaRepository mediaRepository;

    @RequestMapping(value = "/media/", method = RequestMethod.GET)
    byte[] getMedia(@RequestParam Long mediaId) throws SQLException {
        return mediaRepository.findMediaById(mediaId).getMediaFile();
    }

}
