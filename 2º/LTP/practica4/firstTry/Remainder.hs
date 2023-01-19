module Remainder where 
remainder :: Int -> Int -> Int
remainder dividendo divisor
  | dividendo < divisor = dividendo 
  | dividendo > divisor = remainder (dividendo - divisor) divisor 
