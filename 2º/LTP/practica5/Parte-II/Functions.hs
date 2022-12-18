type Person = String
type Book = String
type Database  = [(Person, Book)]
exampleBase :: Database 
exampleBase = [("Alicia","El nombre de la rosa"),("Juan","La hija del canibal"),("Pepe","Odesa"),("Alicia","La ciudad de las bestias")]

obtain :: Database -> Person -> [Book]
obtain dBase thisPerson = [ book | (person,book) <- dBase, person == thisPerson]

borrow :: Database -> Book -> Person -> Database
borrow dBase paper human = ((human, paper): dBase)

return' :: Database -> (Person, Book) -> Database 
return' dBase (thisPerson, thisBook) = [ (person, book) | (person, book) <- dBase, (person, book) /= (thisPerson, thisBook)]

data Tree a = Leaf a | Branch (Tree a) (Tree a) deriving Show
symmetric :: Tree a -> Tree a
symmetric (Leaf x) = (Leaf x) 
symmetric (Branch a b) = Branch (symmetric b) (symmetric a)

-- Convierte una lista no vacía en un árbol 
--(es una manera de hacerlo pero no sé exactamente la que pide)
listToTree :: [a] -> Tree a
listToTree [x] = Leaf x
listToTree (x:xs) = Branch (Leaf x) (listToTree xs)
-- Convierte un árbol no vacío  en una lista 
treeToList :: Tree a -> [a]
treeToList (Leaf x) = [x]
treeToList (Branch a b) = treeToList (a) ++ treeToList (b)

data BinTreeInt  = Void | Node Int BinTreeInt BinTreeInt deriving Show
-- Inserta un entero en un árbol binario ordenado 
-- Aqui vienen curvas xDDDDDDDDDDDDDD
-- Voy a intentar explicarlo lo más nitido posible porque esto es con diferencia lo más difícil
-- Para empezar un árbol binario de enteros ordenado consiste en un árbol para el que el nodo de la izquierda
-- es siempre menor que el de arriba y el de la derecha es siempre mayor que el de arriba. E.g. ->
--             4
--            / \
--           2   5
--          / \
--         1   3
-- El problema es que tenemos que tener en consideración el árbol completo todo el rato a la hora de insertar un elemento
-- una vez tengamos la funcion de insertar la reutilizaremos para crear un árbol ordenado (Si no CREO que es imposible -lo he intentado como un cerdo-)

-- Hay que contemplar 3 casos, el numero que queremos insertar ya esta en el árbol -> no modificamos el árbol
-- El número no está y es más pequeño -> lo insertamos EN EL ÁRBOL de la parte izquierda
-- El número no está y es más grande -> lo insertamos EN EL ÁRBOL de la parte derecha
-- Por supuesto el caso base es insertar un entero en un árbol vacío

insTree :: Int -> BinTreeInt -> BinTreeInt
insTree int Void = Node int Void Void
insTree int (Node num binTreeIzq binTreeDer)
  | int == num = Node num binTreeIzq binTreeDer
  | int < num = Node num (insTree int binTreeIzq) binTreeDer
  | int > num = Node num binTreeIzq (insTree int binTreeDer)
-- Traza de ejemplo con el árbol de arriba:
-- Queremos insertar el 3:
--             4
--            / \
--           2   5
--          /     \
--         1      Void
-- insTree 3 (Node 4 binTreeIzq binTreeDer)

-- binTreeIzq     binTreeDer
--     2               5
--    / \             / \
--   1  Void       Void Void

-- como 3 es más pequeño que 3 tendremos que insertarlo en el árbol de la izquierda
-- insTree 3 (Node 2 binTreeIzq binTreeDer)
-- binTreeIzq    binTreeDer
--     1            Void
--    / \            
-- Void Void

-- como 3 es más grande que 2 lo insertamos en el árbol de la derecha
-- En este caso el árbol de la derecha está vacío, así que podemos insertarlo 
--     1
--    / \
-- Void  3
--
-- Ahora que entendemos como insertar un entero en un árbol ordenado podemos crear uno a partir de una lista
--
-- Dada una lista no ordenada de enteros construye un árbol binario ordenado
createTree :: [Int] -> BinTreeInt 
createTree [] = Void 
createTree (x:xs) = insTree x (createTree xs)
-- Es importante hacer la equivalencia de que la lista vacía es un árbol vacío, ahora veremos por qué con una traza
-- En concreto vamos a hacer la traza con la lista que resulta en el árbol de arriba, por consistencia
-- Esa lista es esta: [1,3,2,5,4] (otra lista daría otro árbol ordenado, también estaría bien, pero por seguir con el mismo)
--
-- createTree (1:[3,2,5,4]) = insertar 1 en el árbol que crearía la lista [3,2,5,4]
-- createTree (3:[2,5,4]) = insertar 3 en el árbol que crearía la lista [2,5,4]
-- createTree (2:[5,4]) = insertar 2 en el árbol que crearía la lista [5,4]
-- createTree (5:[4]) = insertar 5 en el árbol que crearía la lista [4]
-- createTree (4:[]) = insertar 4 en el árbol que crearía la lista vacía, es decir, el árbol vacío ;) 

--      4
--     / \
--  Void Void

-- ahora que finalmente tenemos un árbol podemos ir recorriendo los createTree de arriba insertando los valores
-- Como ha sido una ejecución recursiva sabemos que se insertan en este orden 5 -> 2 -> 3 -> 1
-- 
--      4
--     / \
--  Void  5
--       / \
--    Void Void
--
-- ahora el 2:
--
--        4
--      /   \
--     2     5
--    /  \   / \
-- Void VoidVoid Void
--
-- ahora el 3:
--
--        4
--      /   \
--     2     5
--    / \   / \
-- Void  3VoidVoid
--
-- ahora el 3:
--
--        4
--      /   \
--     2      5
--    / \    / \
--   1   3  Void Void
--
-- 1 y 3 también tendrían dos ramas vacías debajo cada uno, por economía no las voy a poner 
-- Espero que se entienda chicxs, a mi me costó, seguro que con esta explicación es más fácil.
--
--
--
-- Determina si un valor entero pertenece o no a un árbol binario ordenado
treeElem :: Int -> BinTreeInt -> Bool
treeElem int Void = False
treeElem int (Node num binTreeIzq binTreeDer) 
  | int == num = True
  | int < num = treeElem int binTreeIzq
  | int > num = treeElem int binTreeDer
--La misma manera de explorar de antes pero devolviendo True si encuentra un nodo con el entero
-- si no lo encuentra llegará a una rama vacía y devolverá False
