package kr.ac.kumoh.s20260000.w26w11_thymeleaf.service

import kr.ac.kumoh.s20260000.w26w11_thymeleaf.repository.SongRepository
import org.springframework.stereotype.Service

@Service
class SongService(
    private val repository: SongRepository
) {
    fun findAllSongs() = repository.findAll()
    fun findSongById(id: Int) = repository.findById(id)
    fun getRandomSong() = repository.findAll().randomOrNull()
}