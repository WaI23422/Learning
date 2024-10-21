# Thông tin nhóm 10:
# Bùi Thu Hiền, 20000476, K65A1 Toán Học.
# Nguyễn Thị Khánh Linh, 20000488, K65A1 Toán Học.
# Bùi Tiến Thành, 20000509, K65A1 Toán Học. 

# Xây dựng mô hình tối ưu sử dụng Gurobi để tìm cách tô màu cho bài toán Color(8, 2) (xem định nghĩa của bài toán tổng quát Color(N, k) trong phiếu bài tập lần 4).
# Thực thi chương trình, sau đó đặt toàn bộ output ở terminal vào trong phần docstring của file code như đoạn code mẫu này (chú ý đổi tên file phù hợp).

"""
Gurobi Optimizer version 10.0.1 build v10.0.1rc0 (win64)

CPU model: 11th Gen Intel(R) Core(TM) i3-1115G4 @ 3.00GHz, instruction set [SSE2|AVX|AVX2|AVX512]
Thread count: 2 physical cores, 4 logical processors, using up to 4 threads

Optimize a model with 24 rows, 8 columns and 48 nonzeros
Model fingerprint: 0x9ea71e01
Coefficient statistics:
  Matrix range     [1e+00, 2e+00]
  Objective range  [0e+00, 0e+00]
  Bounds range     [0e+00, 0e+00]
  RHS range        [2e+00, 2e+00]
Presolve removed 24 rows and 8 columns
Presolve time: 0.00s
Presolve: All rows and columns removed
Iteration    Objective       Primal Inf.    Dual Inf.      Time
       0   -1.0000000e+00   0.000000e+00   0.000000e+00      0s

Solved in 0 iterations and 0.00 seconds (0.00 work units)
Optimal objective -1.000000000e+00
"""
# Import:
import gurobipy as gp

def Color(N:int,k:int=2):
    
    PCS = [] # Possible Combination Sum of a + b = c with a,b,c in range 1 to 8 as set (a,b,c) | set (a,b,c) and these permutations are the same so we don't care about it. 
    for i in range(1,N+1):
        for j in range(i+1,N-i+1):
            if i + j <= N :
                PCS.append([i-1,j-1,i+j-1])

    m = gp.Model()

    x = m.addVars(8,vtype= gp.GRB.CONTINUOUS, name="x", lb = 0) # lb for lower bound of the variable.
    
    m.setObjective(gp.GRB.MAXIMIZE)
    m.addConstrs((x[PCS[i][1]] + x[PCS[i][1]] + x[PCS[i][2]] <= k for i in range(0,len(PCS))))
    m.addConstrs((x[PCS[i][1]] + x[PCS[i][1]] + x[PCS[i][2]] >= 0 for i in range(0,len(PCS))))

    return m.optimize()

Color(8,2)