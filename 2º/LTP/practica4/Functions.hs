module Functions where 
import Data.Char
 -- Devuelve cuántos caracteres hay entre dos caracteres dados sin incluirlos
numCbetw2 :: Char -> Char -> Int 
numCbetw2 char1 char2 
 | char1 == char2 = 0
 | char1 > char2 = ord char1 - ord char2 - 1
 | char1 < char2 = ord char2 - ord char1 - 1
 
 -- AddRange: Devuelve el sumatorio desde un valor entero hasta otro, ambos incluídos 
addRange :: Int -> Int -> Int
addRange num1 num2 
 | num1 == num2 = num2
 | num1 < num2 = num1 + addRange (num1 + 1) num2
 | num1 > num2 = num2 + addRange num1 (num2 + 1)

-- Escribir una función con dos argumentos que devuelva el mayor de ambos

max' :: Int -> Int -> Int
max' num1 num2 
  | num1 > num2 = num1
  | num1 < num2 = num2
  | num1 == num2 = num2

-- leapYear: Determina si un año es bisiesto
-- Intrucciones: Un año es bisiesto si es multiplo de 4
--               No lo es si es múltiplo de 100
--               A no ser que sea múltiplo de 400
leapYear :: Int -> Bool
leapYear year 
 | year `mod` 400 == 0 = True
 | year `mod` 100 == 0 = False
 | otherwise = year `mod` 4 == 0

-- daysAMonth: calcule el número de días de un mes dado usando como datos dicho  mes y su año

daysAMonth :: Int -> Int -> Int
daysAMonth mes año 
  | leapYear año == True && mes == 2 = 29
  | leapYear año == False && mes == 2 = 28
  | mes `mod` 2 == 0 && mes < 7 = 30 
  | mes `mod` 2 /= 0 && mes <= 7 = 31 
  | mes `mod` 2 /= 0 && mes > 7 = 30 
  | mes `mod` 2 == 0 && mes > 7 = 31 

-- remainder: devuelve el resto de una división sin usar 'div', 'mod' o 'rem'
remainder :: Int -> Int -> Int
remainder dividendo divisor 
  | dividendo > divisor = remainder (dividendo - divisor) divisor
  | dividendo < divisor = dividendo
  | dividendo == divisor = 0


--sumFacts: dado un int 'n' calcular la suma de los factoriales desde 1 hasta llegar a 'n'

--Para esto nos definimos primero factorial: (lo dan)
fact :: Int -> Int
fact 0 = 1
fact n = n * fact (n - 1)


sumFacts :: Int -> Int
sumFacts 0 = 0
sumFacts n = fact n + sumFacts (n-1)

 
