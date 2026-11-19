package kr.ac.kumoh.s20231274.w26w12_carddealer.service

import kr.ac.kumoh.s20231274.w26w12_carddealer.model.Card
import kr.ac.kumoh.s20231274.w26w12_carddealer.repository.CardRepository
import org.springframework.stereotype.Service

@Service
class CardService(
    private val repository: CardRepository
) {
    fun getCards(): List<Card> = repository.cards

    fun dealCards(count: Int = 5) {
        val suits = arrayOf("spades", "diamonds", "hearts", "clubs")
        val ranks = arrayOf("2", "3", "4", "5", "6", "7", "8", "9", "10", "jack", "queen", "king", "ace")

        repository.deleteAll()

        // 0~51 숫자를 섞은 뒤
        // count개만 뽑아서
        // 오름차순 정렬
        val cards = (0 until 52)
            .shuffled()
            .take(count)
            .sorted()

        // 뽑힌 숫자(0~51)를 무늬(suit)와 숫자(suit) 계산해서 저장
        cards.forEach { number ->
            val suit = suits[number / ranks.size]
            val rank = ranks[number % ranks.size]
            repository.save(Card(rank, suit))
        }
    }
}