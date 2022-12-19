module Geometry2D (areaSquare, perimeterSquare) where

    areaRectangle base height = base * height
    areaRectangle :: Float -> Float -> Float

    perimeterRectangle :: Float -> Float -> Float
    perimeterRectangle base height = 2 * (base + height)
    
    areaSquare :: Float -> Float
    areaSquare side = areaRectangle side side

    perimeterSquare :: Float -> Float
    perimeterSquare side = perimeterRectangle side side
