-- Ampliación de la práctica 

-- Función 'repeated' Determina cuantas veces aparece un entero repetido en una lista de enteros dada.
repeated :: Int -> [Int] -> Int
repeated int [] = 0
repeated int (x:xs)
  | int == x = 1 + repeated int xs
  | int /= x = 0 + repeated int xs

-- Función 'concat'' que concatena una lista de listas
concat' :: [[a]] -> [a]
concat' [[x]] = [x]
concat' ((x:xs):ys) =  [x] ++ (concat' (xs:ys))
concat' ([]:ys) = concat' ys

-- EJ19
-- Pide (sum (map square) (filter even)) [1..10]
-- es decir, el resultado de sumar todos los elementos de la lista
-- resultante al aplicar la función square a la lista resultante
-- de filtrar la lista que va desde el 1 hasta el 10 por pares
-- 4 + 16 + 36 + 64 + 100 = 220

data Tree a = Leaf a | Branch (Tree a) (Tree a)

numLeaves (Leaf x) = 1
numLeaves (Branch a b) = numLeaves a + numLeaves b

data BinTreeInt = Void | Node Int BinTreeInt BinTreeInt deriving Show

-- Devuelve la misma estructura pero con los valores duplicados (lo que creo que rompe el BinTree, pero bueno, yo soy un mandado)
dupElem Void = Void
dupElem (Node int binTree1 binTree2) = (Node (int*2) (dupElem binTree1)(dupElem binTree2))

-- Devolver el númro de elementos de un árbol que cumplan con la propiedad.

data Tree a = Branch a (Tree a) (Tree a) | Void deriving Show

countProperty :: (a -> Bool) -> (Tree a) -> Int
countProperty function (Leaf a)  
  | function a == True = 1
  | otherwise = 0
countProperty function (Branch a b) = countProperty function a + countProperty function b

