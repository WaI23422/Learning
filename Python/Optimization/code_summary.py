"""
Restricted license - for non-production use only - expires 2023-10-25
Gurobi Optimizer version 9.5.2 build v9.5.2rc0 (linux64)
Thread count: 4 physical cores, 8 logical processors, using up to 8 threads
Optimize a model with 0 rows, 0 columns and 0 nonzeros
Model fingerprint: 0xf9715da1
Coefficient statistics:
  Matrix range     [0e+00, 0e+00]
  Objective range  [0e+00, 0e+00]
  Bounds range     [0e+00, 0e+00]
  RHS range        [0e+00, 0e+00]
Presolve time: 0.02s
Presolve: All rows and columns removed
Iteration    Objective       Primal Inf.    Dual Inf.      Time
       0    0.0000000e+00   0.000000e+00   0.000000e+00      0s
Solved in 0 iterations and 0.02 seconds (0.00 work units)
Optimal objective  0.000000000e+00
"""
import gurobipy as gp

m = gp.Model()

x = m.addVars(3,vtype= gp.GRB.CONTINUOUS, name="x", lb = 0)

m.setObjective(3*x[0]+3*x[1]+2*x[2],gp.GRB.MAXIMIZE)

m.addConstr(x.sum(1, '+') <= 19 for i in range(0,3))

m.addConstr(x[0] <= 2)
m.addConstr(x[1] <= 4)
m.addConstr(x[2] <= 4)


m.optimize()

print(f"Optimal objective value: {m.objVal}")
print(f"Solution values: x={x[0].X}, y={x[1].X}, z={x[2].X}")