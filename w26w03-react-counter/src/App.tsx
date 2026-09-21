import { useState } from 'react'
import './App.css'

export default App

function App() {
  // 1개의 당첨과 9개의 PASS 배열 초기화 함수
  const createNewGame = () => {
    const list = ['당첨 🎉', ...Array(9).fill('PASS ❌')]
    // 배열 랜덤 섞기 (Fisher-Yates 알고리즘)
    return list.sort(() => Math.random() - 0.5)
  }

  const [cards, setCards] = useState<string[]>(createNewGame)
  const [flipped, setFlipped] = useState<boolean[]>(Array(10).fill(false))

  // 카드 클릭 핸들러
  const handleCardClick = (index: number) => {
    if (flipped[index]) return // 이미 뒤집힌 카드는 무시
    const newFlipped = [...flipped]
    newFlipped[index] = true
    setFlipped(newFlipped)
  }

  // 게임 리셋
  const handleReset = () => {
    setCards(createNewGame())
    setFlipped(Array(10).fill(false))
  }

  return (
    <div style={{ padding: '20px', textAlign: 'center' }}>
      <h1>🎰 1/10 제비뽑기</h1>
      <p>10개의 카드 중 단 1개의 당첨을 찾아보세요!</p>

      {/* 10개 카드 그리드 배치 */}
      <div style={{
        display: 'grid',
        gridTemplateColumns: 'repeat(5, 1fr)',
        gap: '12px',
        maxWidth: '500px',
        margin: '20px auto'
      }}>
        {cards.map((result, idx) => (
          <button
            key={idx}
            onClick={() => handleCardClick(idx)}
            style={{
              height: '90px',
              fontSize: '18px',
              fontWeight: 'bold',
              cursor: flipped[idx] ? 'default' : 'pointer',
              backgroundColor: flipped[idx] 
                ? (result.includes('당첨') ? '#4CAF50' : '#E0E0E0') 
                : '#2196F3',
              color: flipped[idx] ? '#ffffff' : '#ffffff',
              border: 'none',
              borderRadius: '8px',
              transition: 'all 0.2s'
            }}
          >
            {flipped[idx] ? result : `?`}
          </button>
        ))}
      </div>

      <button 
        onClick={handleReset}
        style={{
          marginTop: '20px',
          padding: '10px 20px',
          fontSize: '16px',
          cursor: 'pointer'
        }}
      >
        🔄 다시 섞기
      </button>
    </div>
  )
}