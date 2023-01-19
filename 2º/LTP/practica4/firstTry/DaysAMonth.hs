module DaysAMonth where 
  import Leapyear
  daysAmonth :: Int -> Int -> Int 
  daysAmonth mes año 
    | leapyear año && mes == 2 = 29
    | mes == 2 = 28
    | mes `mod` 2 == 0 && mes < 8 = 30 
    | mes `mod` 2 == 0 = 31
    | mes < 8 = 31
    | mes > 8 = 30 
