def find_line_equation(x,y):
    x1,x2 = x
    y1,y2 = y
    
    m = (y2-y1)/(x2-x1)

    b = y1 -m * x1 

    return (m,-1,-b) 

print(find_line_equation(4, 2, 3, 4))

def plane_equation(A,B,C):

    x1,y1,z1 = A
    x2,y2,z2 = B
    x3,y3,z3 = C
    
    a = (y2-y1) * (z3-z1) - (y3 - y1) * (z2 - z1)
    b = (z2-z1) * (x3-x1) - (z3 - z1) * (x2 - x1)
    c = (x2-x1) * (y3-y1) - (x3 - x1) * (y2 - y1)
    d = -(a* x1 + b *y1 + c *z1)

    return f'{a}x+{b}y +{c}z + {d} = 0' ()

A=(1,5,3)
B=(7,2,3)
C=(4,1,4)
print(plane_equation(A, B, C))
