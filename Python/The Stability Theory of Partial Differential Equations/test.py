import math
import numpy as np
import matplotlib.pyplot as plt
from mpl_toolkits.mplot3d import Axes3D
from scipy.integrate import odeint

def add_arrow(ax, line, position=None, direction='right', size=50, color=None):
    if color is None:
        color = line.get_color()

    xdata, ydata, zdata = line._verts3d

    if position is None:
        position = xdata.mean()

    start_ind = np.argmin(np.absolute(xdata - position))
    if direction == 'right':
        end_ind = start_ind + 1
    else:
        end_ind = start_ind - 1

    ax.quiver(xdata[start_ind], ydata[start_ind], zdata[start_ind],
              xdata[end_ind] - xdata[start_ind],
              ydata[end_ind] - ydata[start_ind],
              zdata[end_ind] - zdata[start_ind],
              color=color, arrow_length_ratio=0.3)

# Define the system of differential equations
def system(X, t):
    x, y, z = X
    dxdt = 2*y +y*z - x**3
    dydt = x - x*z - y**3
    dzdt = x*y - z**3
    return [dxdt, dydt, dzdt]

# Set up a grid of (x, y, z) values
x_values = np.linspace(-math.sqrt(2), math.sqrt(2), 20)
y_values = np.linspace(-math.sqrt(2), math.sqrt(2), 20)
z_values = np.linspace(-math.sqrt(2), math.sqrt(2), 20)
X, Y, Z = np.meshgrid(x_values, y_values, z_values)

# Calculate the derivatives at each point in the grid
U, V, W = np.array(system([X, Y, Z], 0))

# Create a quiver plot in 3D
fig = plt.figure(figsize=(20,20 ))
ax = fig.add_subplot(111, projection='3d')
# ax.quiver(X, Y, Z, U, V, W, length=0.05, normalize=True, color='blue')

# Set axis labels
ax.set_xlabel('x')
ax.set_ylabel('y')
ax.set_zlabel('z')

# Solve the system of differential equations for different initial conditions
initial_conditions = [[1, 0, 0], [0, 1, 0], [-1, 0, 0], [0, -1, 0], [-1, 1, 0], [1, -1, 0], [-1, -1, 0], [1, 1, 0]]
time = np.linspace(0, 10, 100)

for ic in initial_conditions:
    trajectory = odeint(system, ic, time)
    traj, = ax.plot(trajectory[:, 0], trajectory[:, 1], trajectory[:, 2], color='red', label='Trajectories')

    add_arrow(ax, traj)


# Set the title
plt.title('3D Phase Portrait of $x\' = x^2 - x - y$, $y\' = x$, $z\' = z$ with Trajectories')

# Show the plot
plt.grid(True)
plt.show()
