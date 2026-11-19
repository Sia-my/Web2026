package kr.ac.kumoh.s20231274.w26w12_carddealer.repository

import kr.ac.kumoh.s20231274.w26w12_carddealer.repository.CardRepository
import kr.ac.kumoh.s20231274.w26w12_carddealer.model.Card
import org.springframework.stereotype.Repository
import kotlin.collections.toList

@Repository
class InMemoryCardRepository : CardRepository {
    private val _cards: MutableList<Card> = mutableListOf()
    // 방법 1. reference가 노출되어 안됨
    //override val cards = _cards

    // 방법 2. 처음에 실행된 이후에 save() 반영하지 못함
    // override val cards = _cards.toList()

    // 방법 3. 바람직함
    override val cards
        get() = _cards.toList()

    override fun save(card: Card) {
        if (!_cards.contains(card)) {
            _cards.add(card)
        }
    }

    override fun deleteAll() {
        _cards.clear()
    }
}