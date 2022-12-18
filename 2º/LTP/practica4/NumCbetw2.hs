module NumCbetw2 where 
  import Data.Char
  numCbetw2 :: Char -> Char -> Int 
  numCbetw2 charI charF = if charI == charF then 0 
  else if charI > charF then ord charI - ord charF - 1 else ord charF - ord charI - 1
  
  
