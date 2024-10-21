from sympy import symbols, Poly, resultant, solve
from itertools import product

# Define the parameter and coefficient symbols
x,y= symbols('x y')

# Define the curve with y:
X1 = Poly(x**2+y**2-2, y)
Y1 = Poly(y-x**2, y)
# Define the curve with x:
X2 = Poly(x**2+y**2-2, x)
Y2 = Poly(y-x**2, x)

# Compute the resultant of the polynomials
res = resultant(X1,Y1)
print(f"Res(X,Y,x) = {res}")

# Solve for the parameter values where the curves intersect
intersection_Xpoints = solve(res)

# Print the x points
for x_value in intersection_Xpoints:
    X1_value = X1.subs(x, x_value)
    Y1_value = Y1.subs(x, x_value)
    print(f"x = {x_value}")

# Compute the resultant of the polynomials
res = resultant(X2, Y2)
print(f"Res(X,Y,y) = {res}")

# Solve for the parameter values where the curves intersect
intersection_Ypoints = solve(res)

# Print the y points
for y_value in intersection_Ypoints:
    X2_value = X2.subs(x, y_value)
    Y2_value = Y2.subs(x, y_value)
    print(f"x = {y_value}")

#  Print the intersection points:
combinations = list(product(intersection_Xpoints, intersection_Ypoints))
for combination in combinations:
    print(combination, end=' ')