package kr.ac.kumoh.s20231274.w26w12_carddealer.repository

import kr.ac.kumoh.s20231274.w26w12_carddealer.model.Card

interface CardRepository {
    val cards: List<Card>
    fun save(card: Card)
    fun deleteAll()
}

