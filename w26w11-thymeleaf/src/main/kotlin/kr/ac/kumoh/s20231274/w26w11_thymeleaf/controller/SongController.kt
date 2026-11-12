package kr.ac.kumoh.s20260000.w26w11_thymeleaf.controller

import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.web.bind.annotation.GetMapping

@Controller
class SongController {
    @GetMapping("/songs/random")
    fun getRandomSong(model: Model): String {
        model.addAttribute("songTitle", "Cosmic Echo")
        return "random"
    }
}