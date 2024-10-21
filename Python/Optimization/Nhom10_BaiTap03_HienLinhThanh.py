# Thông tin nhóm 10:
# Bùi Thu Hiền, 20000476, K65A1 Toán Học.
# Nguyễn Khánh Linh, 20000488, K65A1 Toán Học.
# Bùi Tiến Thành, 20000509, K65A1 Toán Học. 

# Import: 
import math
# Bài 2:
#  a) Viết một hàm xác định phương trình đường thẳng đi qua hai điểm phân biệt trong mặt phẳng Oxy.
#     Input : hai tuple biểu diễn toạ độ hai điểm trên mặt phẳng.
#     Output: một tuple gồm ba hệ số a, b, c của phương trình đường thẳng ax + by = c.

def Line_2points(Point_1:tuple,Point_2:tuple):
    Direction_Vector = (Point_2[0]-Point_1[0],Point_2[1]-Point_1[1])
    # Line equation: x - x_0/b = y -y_0/a (Direction Vector u(b,a)). Simplify the equation to a(x-x_0) - b(y-y_o) = 0 -> ax +(-b)y = ax_0-by_0.
    Coefficient_a = Direction_Vector[1] 
    Coefficient_b = -Direction_Vector[0]
    Coefficient_c = Direction_Vector[1]*Point_2[0] - Direction_Vector[0]*Point_2[1] # Or replace Point_2 with Point_1.

    if Coefficient_a == int(Coefficient_a) and Coefficient_b == int(Coefficient_b) and Coefficient_c == int(Coefficient_c):
        GCD = math.gcd(Coefficient_a,Coefficient_b,Coefficient_c) # Find the greatest common divisor from 3 Coefficient
        Coefficient_a /= GCD
        Coefficient_b /= GCD
        Coefficient_c /= GCD
        return (Coefficient_a,Coefficient_b,Coefficient_c)
    else:
        return (Coefficient_a,Coefficient_b,Coefficient_c)
    
print(Line_2points((2,1),(3,2)))

#  b) Viết một hàm xác định phương trình mặt phẳng đi qua ba điểm phân biệt không thẳng hàng trong không gian Oxyz.
#     Input : ba tuple biểu diễn toạ độ ba điểm không thẳng hàng trong không gian.
#     Output: một tuple gồm bốn hệ số a, b, c, d của phương trình mặt phẳng ax + by + cz = d.

def Plane_3points(Point_1:tuple,Point_2:tuple,Point_3:tuple):
    Vector_12 = (Point_2[0]-Point_1[0],Point_2[1]-Point_1[1],Point_2[2]-Point_1[2])
    Vector_23 = (Point_3[0]-Point_2[0],Point_3[1]-Point_2[1],Point_3[2]-Point_2[2])
    # Normal Vector in R^3 can be caculator by Vector Product (Cross Product) of two vectors Vector_12 and Vector_23.
    Normal_Vector  = (Vector_12[1]*Vector_23[2]-Vector_12[2]*Vector_23[1], Vector_12[2]*Vector_23[0] - Vector_12[0]*Vector_23[2], Vector_12[0]*Vector_23[1] - Vector_12[1]*Vector_23[0]) 
    # Plane equation: A(x-x_0) + B(y-y_0) + C(z-z_0) = 0 for Normal Vector u(A,B,C) and a point in plane P(x_0,y_0,z_0)
    Coefficient_a = Normal_Vector[0]
    Coefficient_b = Normal_Vector[1]
    Coefficient_c = Normal_Vector[2]
    Coefficient_d = Normal_Vector[0]*Point_3[0] + Normal_Vector[1]*Point_3[1] + Normal_Vector[2]*Point_3[2]

    if Coefficient_a == int(Coefficient_a) and Coefficient_b == int(Coefficient_b) and Coefficient_c == int(Coefficient_c):
        GCD = math.gcd(Coefficient_a,Coefficient_b,Coefficient_c) # Find the greatest common divisor from 3 Coefficient
        Coefficient_a /= GCD
        Coefficient_b /= GCD
        Coefficient_c /= GCD
        Coefficient_d /= GCD
        return (Coefficient_a,Coefficient_b,Coefficient_c,Coefficient_d)
    else:
        return (Coefficient_a,Coefficient_b,Coefficient_c,Coefficient_d)

print(Plane_3points((-2,3,1),(4,-1,2),(3,2,-9)))
#(Điểm thưởng) Viết hàm thỏa mãn những yêu cầu trên, đồng thời thỏa mãn thêm điều kiện: Nếu các điểm đầu vào là điểm nguyên thì các hệ số đầu ra là các số nguyên.
