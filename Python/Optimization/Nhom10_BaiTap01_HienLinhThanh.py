# Thông tin nhóm 10:
# Bùi Thu Hiền, 20000476, K65A1 Toán Học.
# Nguyễn Khánh Linh,20000488 , K65A1 Toán Học.
# Bùi Tiến Thành, 20000509, K65A1 Toán Học. 

#Viết hàm liệt kê tất cả ước nguyên dương của một số nguyên cho trước.
# C1
print("Nhập số nguyên dương n: ")
n = int(input())

def Divisor(n):
    divisor_n = [n]
    for number in range(1,int(n/2)+1): # Use int(n/2)+1 because n/1 = n, n/(n/2) = and n/n = 1 so between n/2 and n, quotient is between 1 and 2 is not an integer.
        if n % number == 0:
            divisor_n.append(number) # divisor_n.sort() | print(divisor_n) 
    print(sorted(divisor_n)) 

Divisor(n)

# Mistake: print(divisor_n.sort) return "none" as result because divisor_n.sort() operates on the list and not return a value. So when use print it return "none".
# print() return the value in the bracket. But ".sort" here don't give any value back after it operates on the list.

# C2 (Presentation):
print("Nhập số nguyên dương n: ")
n = int(input())

def Divisor_2(n):
    divisor_n = [number for number in range(1,int(n)+1) if n%number ==0]
    print(divisor_n)

Divisor_2(n)

