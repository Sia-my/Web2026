package kr.ac.kumoh.s20231274.w26w12_carddealer.controller

import kr.ac.kumoh.s20231274.w26w12_carddealer.service.CardService
import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.web.bind.annotation.GetMapping

@Controller
class CardController(
    private val service: CardService
) {
    @GetMapping("/cards/random")
    fun getRandomCards(model: Model): String {
        service.dealCards()

        val cards = service.getCards()

        model.addAttribute(
            "cards",
            cards.map { it.imageName }
        )
        return "cards"
    }
}