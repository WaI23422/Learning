import math
import numpy as np
import matplotlib.pyplot as plt
from scipy.integrate import odeint

def add_arrow(line, position=None, direction='right', size=25, color=None):
    if color is None:
        color = line.get_color()

    xdata = line.get_xdata()
    ydata = line.get_ydata()

    if position is None:
        position = xdata.mean()

    start_ind = np.argmin(np.absolute(xdata - position))
    if direction == 'right':
        end_ind = start_ind + 1
    else:
        end_ind = start_ind - 1

    line.axes.annotate('',
        xytext=(xdata[start_ind], ydata[start_ind]),
        xy=(xdata[end_ind], ydata[end_ind]),
        arrowprops=dict(arrowstyle="->", color=color),
        size=size
    )

# Define the system of differential equations
def system(X, t):
    x, y = X
    dxdt = x**2 - x -y
    dydt = x 
    return [dxdt, dydt]

# Set up a grid of (x, y) values
x_values = np.linspace(-math.sqrt(2), math.sqrt(2), 20)
y_values = np.linspace(-math.sqrt(2), math.sqrt(2), 20)
X, Y = np.meshgrid(x_values, y_values)

# Calculate the derivatives at each point in the grid
U, V = system([X, Y], 0)

# Create a quiver plot
fig, ax = plt.subplots(figsize=(8, 8))
ax.quiver(X, Y, U, V, scale=20, scale_units='xy', color='blue')

# Set axis labels
ax.set_xlabel('x')
ax.set_ylabel('y')
plt.yticks([0])
plt.xticks([0])

# Solve the system of differential equations for different initial conditions
initial_conditions = [[1, 0], [0, 1], [-1, 0], [0, -1],[-1,1],[1,-1],[-1,-1],[1,1]]
time = np.linspace(0, 10, 100)

# Plot trajectories with a single color
# for ic in initial_conditions:
#    trajectory = odeint(system, ic, time)
#    traj, = plt.plot(trajectory[:, 0], trajectory[:, 1], color='red', label='Trajectories')
#
#    add_arrow(traj)

# Show the plot
plt.grid(True)

plt.box(False)
plt.show()
