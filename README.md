# UMT-Rectagles
 UMT Software Internship Fest 2023 - testarea tehnica

Given some points in cartesian coordinate, (X, Y) find the number of rectangles that can be created 
by those points. 
Take into consideration only the rectangles that are parallel with the X, Y axes. 

## The algorithm is based on the following idea:
1. We save the points in a map where the key is the x coordinate and the value is a list of y coordinates.
2. For each 2 entries in the map we find the number of equal y coordinates (EQUALS).
3. The number of rectangles that can be formed from the 2 entries is equal to - EQUALS * (EQUALS - 1) / 2 - the number of pairs that can be formed from EQUALS elements.

## Assumptions
- Points are integers
