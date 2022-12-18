module Functions where 
  
  --Obtiene los divisores del número introducido
  divisors:: Int -> [Int]
  divisors x = [ div | div <- [1..x], x `mod` div == 0]

  --Dice si un elemento esta en una lista proporcionada
  member :: Int -> [Int] -> Bool
  member x lista = length[ True | num <- lista, x == num] > 0

  --Dice si un número es primo o no 
  isPrime :: Int -> Bool
  isPrime num = length (divisors num) < 3

  --Da la lista de los 'x' primeros números primos 
  primes :: Int -> [Int]
  primes num = take num [ x | x <- [1..], isPrime x]
  
  -- Devuelve una lista con solo los números pares de una lista dada 
  selectEven :: [Int] -> [Int]
  selectEven lista = [ x | x <- lista, even x]

  -- Da los enteros que estén en posiciones pares, empezando por el 0
  selectEvenPos :: [Int] -> [Int]
  selectEvenPos lista = [lista !! x | x <- [0,2..length lista - 1]]

  -- Inserta un elemento en su posición correcta dada una lista ascendente 
  ins :: Int -> [Int] -> [Int]
  ins elem [] = [elem]
  ins elem (x:xs) 
    | elem < x = (elem:x:xs)
    | otherwise = (x:ins elem xs)

  -- Ordena una lista ascendentemente 
  iSort :: [Int] -> [Int]
  iSort [elem] = [elem]
  iSort (elem1:elem2:xs)
    | elem1 > elem2 = ins elem1 (iSort (elem2:xs))
    | otherwise =(elem1:iSort (elem2:xs))

  -- Devuelve una lista con el doble de los enteros de una lista dada
  doubleAll :: [Int] -> [Int]
  doubleAll lista = map (*2) lista

  -- Función 'map' implementada con una lista intensional 
  map' :: (a -> b) -> [a] -> [b]
  map' function list = [ function x | x <- list]

  -- Función 'filter' implementada con una lista intensional 
  filter' :: (a -> Bool) -> [a] -> [a]
  filter' boolean list = [ x | x <- list, boolean x ]
