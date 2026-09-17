import './App.css'
import { useState } from 'react'

function App() {
  const [count, setCount] = useState(0)

  // 1 ~ 10 사이의 랜덤 숫자 생성 함수
  const getRandomNumber = () => Math.floor(Math.random() * 10) + 1

  return (
    <>
      <h1>{count}</h1>
      
      {/* 기존 1씩 증가 버튼 */}
      <button onClick={() => setCount(prev => prev + 1)}>
        증가
      </button>

      {/* 랜덤 증가 버튼 */}
      <button onClick={() => setCount(prev => prev + getRandomNumber())}>
        랜덤 증가
      </button>

      {/* 랜덤 감소 버튼 */}
      <button onClick={() => setCount(prev => prev - getRandomNumber())}>
        랜덤 감소
      </button>
    </>
  )
}

export default App