type Side = Float
type Apothem = Float
type Radius = Float
type Height = Float
type Volume = Float

data Pentagon = Pentagon Side Apothem
data Circle = Circle Radius 

class (Eq a, Show a) => Shape a where
  perimeter :: a -> Float 
  area :: a -> Float
  volumePrism :: (Shape a) => a -> Height -> Volume
  volumePrism  base height = (area base) * height
  surfacePrism :: (Shape a) => a -> Height -> Float
  surfacePrism base height = 2 * (area base) + (perimeter base) * height

-- Subclase Pentagon
-- No hace falta poner (Eq a) => Eq (Pentagon a) porque pentagon es una instancia de Shape y en shape ya está puesto
instance Eq Pentagon where
  Pentagon side apothem == Pentagon side2 apothem2 = side == side2 && apothem == apothem2
  
instance Show Pentagon where 
  show (Pentagon side apothem) = ("Pentagon\n" ++ "Side: " ++ (show side) ++ "\n" ++ "Apothem: " ++ (show apothem))

instance Shape Pentagon where 
  perimeter (Pentagon side apothem) = 5 * side

  area (Pentagon side apothem) = (perimeter (Pentagon side apothem) * apothem) / 2


--Subclase Circle
instance Eq Circle where
  Circle radius == Circle radius2 = radius == radius2

instance Show Circle where
  show (Circle radius) = ("Circle\n" ++ "Radius: " ++ (show radius))

instance Shape Circle where 
  perimeter (Circle radius) = 2 * pi * radius

  area (Circle radius) = pi * radius**2




