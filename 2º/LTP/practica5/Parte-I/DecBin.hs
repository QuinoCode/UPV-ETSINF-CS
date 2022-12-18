module DecBin where 
decBin :: Int -> [Int]
decBin x 
  | x < 2 = [x]
  |otherwise = x `mod` 2 : decBin (x `div` 2)
  
