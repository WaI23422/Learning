import numpy as np
import matplotlib.pyplot as plt

# Define the function for the solution
def x(t, a, C):
    return C * np.exp(a * t)

def add_arrow(line, position=None, direction='right', size=50, color=None):
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

# Generate time values
t_values = np.linspace(-2, 2, 100)

# Plot the solution with arrows indicating direction
a_value = 0

for c in np.arange(-1, 1.5, 0.5):
    # Plot the first curve
    C_value = c
    x_values = x(t_values, a_value, C_value)
    line1, = plt.plot(t_values, x_values, label=f'a={a_value}, C={C_value}', color='blue')

    # Add arrow to the first curve
    add_arrow(line1)

# Set larger bounds for x and y axes
plt.ylim(-1.5, 1.5)

plt.title('x\'(t) = ax(t)')
plt.xlabel('Time (t)')
plt.ylabel('x(t)')
plt.yticks([0])
plt.xticks([0])
plt.grid(True)

# Turn off the plot box
plt.box(False)

# Set the face color of the plot to be transparent
plt.gca().set_facecolor('none')

# Adjust the margins
plt.margins(0)

plt.show()
