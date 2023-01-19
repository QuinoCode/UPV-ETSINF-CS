module SumFacts where 
  import Factorial
  sumFacts :: Int -> Int
  sumFacts 0 = 0
  sumFacts a = fact a + sumFacts (a-1)
