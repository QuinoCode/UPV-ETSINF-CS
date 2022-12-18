module BinDec where 
  binDec :: [Int] -> Int
  binDec (x:[]) = x
  binDec (x:xs) = x + (binDec xs) * 2 
