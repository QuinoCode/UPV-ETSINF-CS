module Leapyear where 
  leapyear :: Int -> Bool 
  leapyear año = if año `mod` 400 == 0 then True else if año `mod` 100 == 0 then False else año `mod` 4 == 0 
