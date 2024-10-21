# Thông tin nhóm 10:
# Bùi Thu Hiền, 20000476, K65A1 Toán Học.
# Nguyễn Thị Khánh Linh, 20000488, K65A1 Toán Học.
# Bùi Tiến Thành, 20000509, K65A1 Toán Học. 

# Import:
import gurobipy as gp
from gurobipy import GRB
import matplotlib.pyplot as plt 

# Bài tập 2: Cho f(x, y) = 5x*x + y*y. Hãy lập trình thuật toán gradient descent với độ dài bước cố định và với độ dài bước sử dụng 
# thuật toán backtracking tìm cực tiểu của f.
def f(x, y):
    return 5 * x ** 2 + y ** 2

def gradient_descent(x0, y0, step_size, num):
    x = x0
    y = y0
    for i in range(num):
        gradient_x = 10 * x # derivative respect to x
        gradient_y = 2 * y # derivative respect to y
        x -= step_size * gradient_x # Step size permanent so x^+ = x − t∇f (x) for all step without shrink t to βt..
        y -= step_size * gradient_y
    return x, y

def gradient_descent_backtracking(x0, y0, alpha, beta, epsilon, max_iterations):
    x = x0
    y = y0
    iteration = 0
    while iteration < max_iterations: # Break loop condition when iteration reach to iteration expectation
        gradient_x = 10 * x
        gradient_y = 2 * y
        step_size = 1.0
        while f(x - step_size * gradient_x, y - step_size * gradient_y) > (f(x, y) - alpha * step_size * (gradient_x ** 2 + gradient_y ** 2)):
            step_size *= beta # shrink t = βt if condtion remain true.
        # else gradient descent update x^+ = x − t∇f (x).
        x -= step_size * gradient_x 
        y -= step_size * gradient_y
        if abs(gradient_x) < epsilon and abs(gradient_y) < epsilon:
            break
        iteration += 1 # loop counter .
    return x, y

x,y = gradient_descent_backtracking(-0.5, -0.5, 0.5, 0.5, 1e-6, 1000)
print(f"Minimum point: ({x}, {y})")

# Bài tập 3: Cho hàm số f(x1, x2) và hai điểm A, B. Đối với mỗi nhóm bài tập, hàm số f(x1, x2) và hai điểm A, B được xác định:
# Himmelblau's function. f(x_1,x_2) = (x_1^2 + x_2 - 11)^2 + (x_1 + x_2^2 - 7)^2.Points A(-2,-2) and B(1,1)
#   3.1 Lập trình thuật toán gradient descent với backtracking line search tìm điểm cực tiểu của f với các thông số sau
#       3.1.1: Giá trị bước ban đầu cho thuật toán backtracking line search α ̄ = 1.
#       3.1.2: Điểm xuất phát cho thuật toán gradient descent lần lượt là x^0 = A và x^0 = B.
#       3.1.3: Thuật toán dừng khi số bước lặp vượt quá 1000 hoặc ∥∇f(x^k)||≤10^-4 với x^k là tọa độ tại bước thứ k của thuật toán.
#   3.2 Hãy lập trình thuật toán Newton với backtracking tìm nghiệm cực tiểu của f dùng tiêu chuẩn dừng như trên.
#   3.3 So sánh tốc độ và chất lượng nghiệm của các thuật toán đã lập trình ở trên.

# 3.1
def himmelblau(x1, x2):
    return (x1 ** 2 + x2 - 11) ** 2 + (x1 + x2 ** 2 - 7) ** 2

def gradient(x1, x2):
    return [
        4 * x1 * (x1 ** 2 + x2 - 11) + 2 * (x1 + x2 ** 2 - 7), # derivative respect to x_1
        2 * (x1 ** 2 + x2 - 11) + 4 * x2 * (x1 + x2 ** 2 - 7) # derivative respect to x_2
    ]

def backtracking_line_search(x1, x2, alpha, beta):
    t = 1.0
    grad = gradient(x1, x2)
    while himmelblau(x1 - t * grad[0], x2 - t * grad[1]) > himmelblau(x1, x2) - alpha * t * (grad[0] ** 2 + grad[1] ** 2): #Gradient descent condtion f (x − t∇f (x)) > f (x) − αt ||∇f (x)||^2_2
        t *= beta 
    return t

def gradient_descent_with_backtracking(x1, x2, alpha, beta, epsilon, max_iterations):
    for i in range(max_iterations):
        grad = gradient(x1, x2)
        if abs(grad[0]) < epsilon and abs(grad[1]) < epsilon:
            break
        t = backtracking_line_search(x1, x2, alpha, beta)
        # x^+ = x − t∇f (x).
        x1 -= t * grad[0] 
        x2 -= t * grad[1]
    return x1, x2

x1, x2 = gradient_descent_with_backtracking(-2, -2, 1, 0.5, 1e-4, 1000) # Initial Begian at A(-2,-2) with step < 1000 and ∥∇f(x^k)||≤10^-4 
print(f"Minimum point: ({x1}, {x2})")

x1, x2 = gradient_descent_with_backtracking(1, 1, 1, 0.5, 1e-4, 1000) # Initial Begian at B(1,1) with step < 1000 and ∥∇f(x^k)||≤10^-4
print(f"Minimum point: ({x1}, {x2})")

# 3.2
def himmelblau(x1, x2):
    return (x1 ** 2 + x2 - 11) ** 2 + (x1 + x2 ** 2 - 7) ** 2

def gradient(x1, x2):
    return [
        4 * x1 * (x1 ** 2 + x2 - 11) + 2 * (x1 + x2 ** 2 - 7), # derivative respect to x_1
        2 * (x1 ** 2 + x2 - 11) + 4 * x2 * (x1 + x2 ** 2 - 7) # derivative respect to x_2
    ]

def hessian(x1, x2):
    return [
        [12 * x1 ** 2 + 4 * x2 - 42, 4 * x1 + 4 * x2],
        [4 * x1 + 4 * x2, 12 * x2 ** 2 + 4 * x1 - 26]
    ]

def backtracking_line_search(x1, x2, alpha, beta, p):
    t = 1.0
    grad = gradient(x1, x2)
    while himmelblau(x1 - t * p[0], x2 - t * p[1]) > himmelblau(x1, x2) - alpha * t * (grad[0] * p[0] + grad[1] * p[1]):
        t *= beta
    return t

def newton_method_with_backtracking(x1, x2, alpha, beta, epsilon, max_iterations):
    for i in range(max_iterations):
        grad = gradient(x1, x2)
        if abs(grad[0]) < epsilon and abs(grad[1]) < epsilon:
            break
        hess = hessian(x1, x2)
        p = [-grad[0] / hess[0][0] - grad[1] / hess[0][1], -grad[0] / hess[1][0] - grad[1] / hess[1][1]]
        t = backtracking_line_search(x1, x2, alpha, beta, p)
        x1 += t * p[0]
        x2 += t * p[1]
    return x1, x2

x3, x4 = newton_method_with_backtracking(-2, -2, 1, 0.5, 1e-6, 100000)
print(f"Minimum point: ({x3}, {x4})")

# Bài tập 4: Xây dựng một mô hình quy hoạch phi tuyến và sử dụng Gurobi giải quyết bài toán sau:
# Cho n điểm dữ liệu (x1, y1),(x2, y2), . . . ,(xn, yn). Tìm tham số a, b làm cực tiểu hóa đại lượng
#                           S = sum_{i=1}^n(y_i-(ax_i+b))^2
# Vẽ hình minh họa cho kết quả của chương trình.

def Nonlinear_programming_model(x:list,y:list):    
    m = gp.Model()

    # Create variables with lower-bound at 0
    a = m.addVar(lb=0, name="a") 
    b = m.addVar(lb=0, name="b")

    # Set objective
    S = sum((y[i] - (a * x[i] + b))**2 for i in range(len(x)))
    m.setObjective(S, GRB.MINIMIZE)

    # Solve Model
    m.optimize()

    # Get optimal values for a and b
    opt_a = a.x # access a attribute of __init__ x
    opt_b = b.x # access b attribute of __init__ x

    # Print results
    print(f"Optimal a: {opt_a}")
    print(f"Optimal b: {opt_b}")

    # Plot data points
    plt.scatter(x, y)

    # Draw Plot
    x_vals = [min(x), max(x)]
    y_vals = [opt_a * x_vals[0] + opt_b, opt_a * x_vals[1] + opt_b]
    plt.plot(x_vals, y_vals)

    plt.show()

    return [a,b]

Nonlinear_programming_model( [1, 2, 3, 4, 5], [1, 3, 2, 5, 4])